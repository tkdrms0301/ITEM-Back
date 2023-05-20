package kit.item.service.repairShop;

import kit.item.domain.it.ItDevice;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.repair.*;
import kit.item.dto.entity.device.DeviceDto;
import kit.item.dto.entity.repairShop.EnableTimesDto;
import kit.item.dto.entity.repairShop.MyItDeviceDto;
import kit.item.dto.entity.repairShop.RepairServiceDto;
import kit.item.dto.entity.repairShop.ReservationEnableTimeDto;
import kit.item.dto.request.repair.RequestReservationDto;
import kit.item.dto.request.repair.RequestServiceCreateInfo;
import kit.item.dto.request.repair.RequestServiceUpdateInfo;
import kit.item.dto.response.repairShop.ResponsePrivateRepairShopDto;
import kit.item.dto.response.repairShop.ResponsePublicRepairShopDto;
import kit.item.dto.response.repairShop.ResponseReservationInitDto;
import kit.item.dto.response.repairShop.ResponseServiceDto;
import kit.item.enums.ReservationStateType;
import kit.item.repository.it.ItDeviceRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.*;
import kit.item.service.device.DeviceManagementService;
import kit.item.service.file.AzureBlobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RepairShopService {
    private final RepairShopServiceRepository repairShopServiceRepository;
    private final RepairShopRepository repairShopRepository;
    private final OfficialRepairShopRepository officialRepairShopRepository;
    private final DeviceManagementService deviceManagementService;
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final ItDeviceRepository itDeviceRepository;
    private final ReservationImageRepository reservationImageRepository;
    private final RepairServiceReservationRepository repairServiceReservationRepository;

    @Autowired
    private AzureBlobService azureBlobAdapter;


    public List<ResponsePrivateRepairShopDto> findAllPrivateRepairShops() {

        List<ResponsePrivateRepairShopDto> responsePrivateRepairShopDtos = new ArrayList<>();
        List<RepairShop> repairShops = repairShopRepository.findAll();

        repairShops.stream().forEach(repairShop -> {

            List<RepairServiceDto> repairServiceDtos = new ArrayList<>();
            List<RepairService> servicesByRepairShopId = repairShopServiceRepository.findByRepairShopId(repairShop.getId());
            servicesByRepairShopId.stream().forEach(repairService -> {
                repairServiceDtos.add(
                        RepairServiceDto.builder()
                                .serviceId(repairService.getId())
                                .serviceName(repairService.getServiceName())
                                .serviceType(repairService.getServiceType())
                                .description(repairService.getDescription())
                                .build());
            });

            responsePrivateRepairShopDtos.add(ResponsePrivateRepairShopDto.builder()
                    .repairShopId(repairShop.getId())
                    .shopName(repairShop.getShopName())
                    .shopAddress(repairShop.getAddress())
                    .shopPhoneNumber(repairShop.getShopPhoneNumber())
                    .description(repairShop.getDescription())
                    .services(repairServiceDtos)
                    .build());

        });
        return responsePrivateRepairShopDtos;
    }

    public List<ResponsePublicRepairShopDto> findAllPublicRepairShops() {

        List<ResponsePublicRepairShopDto> responsePublicRepairShopDtos = new ArrayList<>();
        List<OfficialRepairShop> officialRepairShops = officialRepairShopRepository.findAll();

        officialRepairShops.stream().forEach(officialRepairShop -> {

            responsePublicRepairShopDtos.add(
                    ResponsePublicRepairShopDto.builder()
                            .officeShopId(officialRepairShop.getId())
                            .shopName(officialRepairShop.getName())
                            .shopAddress(officialRepairShop.getAddress())
                            .shopPhoneNumber(officialRepairShop.getPhoneNumber())
                            .description(officialRepairShop.getDescription())
                            .build()
            );
        });

        return responsePublicRepairShopDtos;
    }

    public ResponseServiceDto getServiceInfo(Long serviceId) {
        Optional<RepairService> repairService = repairShopServiceRepository.findById(serviceId);
        ResponseServiceDto responseServiceDto = null;

        if (repairService.isPresent()) {
            responseServiceDto = ResponseServiceDto.builder()
                    .serviceId(repairService.get().getId())
                    .serviceType(String.valueOf(repairService.get().getServiceType()))
                    .serviceName(repairService.get().getServiceName())
                    .description(repairService.get().getDescription())
                    .build();
        }

        return responseServiceDto;
    }


    public List<ResponseServiceDto> getServiceListByShopID(Long shopId) {

        List<RepairService> serviceList = repairShopServiceRepository.findByRepairShopId(shopId);

        List<ResponseServiceDto> responseServiceListDtos = new ArrayList<>();

        serviceList.stream().forEach(repairService -> {
            responseServiceListDtos.add(ResponseServiceDto.builder()
                    .serviceId(repairService.getId())
                    .serviceName(repairService.getServiceName())
                    .serviceType(String.valueOf(repairService.getServiceType()))
                    .description(repairService.getDescription())
                    .build());

        });
        return responseServiceListDtos;
    }

    public boolean deleteServiceByServiceId(Long memberId, Long serviceId) {

        boolean isExist = repairShopServiceRepository.existsByMemberIdAndServiceId(memberId, serviceId);

        if (isExist) {
            repairShopServiceRepository.deleteById(serviceId);
            return true;
        }
        return false;
    }

    public boolean updateServiceByServiceId(Long memberId, RequestServiceUpdateInfo requestServiceUpdateInfo) {

        boolean isExist = repairShopServiceRepository.existsByMemberIdAndServiceId(memberId, requestServiceUpdateInfo.getServiceId());

        if (isExist && !(requestServiceUpdateInfo.getServiceName() == ""
                || requestServiceUpdateInfo.getServiceName() == null
                || requestServiceUpdateInfo.getDescription() == ""
                || requestServiceUpdateInfo.getDescription() == null)) {

            repairShopServiceRepository.updateServiceDetails(
                    requestServiceUpdateInfo.getServiceId(),
                    requestServiceUpdateInfo.getServiceType(),
                    requestServiceUpdateInfo.getServiceName(),
                    requestServiceUpdateInfo.getDescription()
            );
            return true;
        }
        return false;
    }

    public boolean createServiceList(Long memberId, RequestServiceCreateInfo requestServiceCreateInfo) {
        Optional<RepairShop> repairShop = repairShopRepository.findById(memberId);

        if (requestServiceCreateInfo.getServiceName() == ""
                || requestServiceCreateInfo.getServiceName() == null
                || requestServiceCreateInfo.getDescription() == ""
                || requestServiceCreateInfo.getDescription() == null)
            return false;

        if (repairShop.isPresent()) {
            RepairService repairService = RepairService.builder()
                    .serviceType(requestServiceCreateInfo.getServiceType())
                    .serviceName(requestServiceCreateInfo.getServiceName())
                    .description(requestServiceCreateInfo.getDescription())
                    .repairShop(repairShop.get()).build();

            repairShopServiceRepository.save(repairService);

            return true;

        } else
            return false;
    }

    //Reservation Init
    public ResponseReservationInitDto reservationInit(Long memberId, Long repairShopId) {

        List<DeviceDto> deviceListRegardlessCategory = deviceManagementService.getDeviceListRegardlessCategory(memberId);
        List<MyItDeviceDto> myItDeviceList = new ArrayList<>();

        deviceListRegardlessCategory.stream().forEach(deviceDto -> {
            myItDeviceList.add(MyItDeviceDto.builder()
                    .itName(
                            (deviceDto.getDirectlyRegisterProductName() == null || deviceDto.getDirectlyRegisterProductName().equals(""))
                                    ? deviceDto.getProductName() : deviceDto.getDirectlyRegisterProductName())
                    .itImg(deviceDto.getImageUrl())
                    .build());
        });

        List<String> repairServices = new ArrayList<>();
        List<RepairService> servicesByRepairShopId = repairShopServiceRepository.findByRepairShopId(repairShopId);
        servicesByRepairShopId.stream().forEach(repairService -> {
            repairServices.add(
                    repairService.getServiceName()
            );
        });


        ResponseReservationInitDto responseReservationInitDto = ResponseReservationInitDto.builder()
                .myItems(myItDeviceList)
                .services(repairServices)
                .build();


        return responseReservationInitDto;
    }

    private EnableTimesDto initReservationEnableTimeList(){
        List<ReservationEnableTimeDto> reservationEnableTimeDtoList = new ArrayList<>();

        for (int i = 9; i < 18; i++) {
            if (i != 13) {
                reservationEnableTimeDtoList.add(
                        ReservationEnableTimeDto.builder()
                                .time(String.format("%02d:00", i))
                                .isEnable(true)
                                .build()
                );

                reservationEnableTimeDtoList.add(
                        ReservationEnableTimeDto.builder()
                                .time(String.format("%02d:30", i))
                                .isEnable(true)
                                .build()
                );
            }
        }

        return  EnableTimesDto.builder()
                .reservationTimes(reservationEnableTimeDtoList)
                .build();
    }

    public EnableTimesDto getEnableReservationTime(Long repairShopId, String reservationDate) {
        LocalDate localDate = LocalDate.parse(reservationDate);
        List<Reservation> reservationList = reservationRepository.findUnableReservationByRepairShopId(repairShopId);
        List<ReservationEnableTimeDto> reservationEnableTimeDtoList = initReservationEnableTimeList().getReservationTimes();

        reservationList.forEach(reservation -> {
            reservationEnableTimeDtoList.forEach(reservationEnableTimeDto -> {
                LocalDateTime reservationDateTime = localDate.atTime(LocalTime.parse(reservationEnableTimeDto.getTime()));
                if (reservation.getReservationDate().equals(reservationDateTime)) {
                    reservationEnableTimeDto.setEnable(false);
                }
            });
        });

        return EnableTimesDto.builder()
                .reservationTimes(reservationEnableTimeDtoList)
                .build();
    }


    public void createReservation(Long memberId, RequestReservationDto requestReservationDto) {
        Optional<Member> member = memberRepository.findById(memberId);

        ItDevice userDevice = itDeviceRepository.findDeviceByMemberIdAndProductName(memberId, requestReservationDto.getProductName());

        List<ReservationImage> reservationImages = new ArrayList<>();

        requestReservationDto.getRvRequestImgs().stream().forEach(requestImg -> {

            try {
                String fileUrl = azureBlobAdapter.upload(requestImg);
//                //파일 url 출력

                System.out.println(fileUrl);

                ReservationImage reservationImage = ReservationImage.builder()
                        .url(fileUrl)
                        .build();

                reservationImages.add(reservationImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();

        requestReservationDto.getServices().stream().forEach(service -> {
            List<RepairService> byServiceNameAndRepairShopId = repairShopServiceRepository.findByServiceNameAndRepairShopId(service, requestReservationDto.getRepairShopId());

            RepairServiceReservation repairServiceReservation = RepairServiceReservation.builder()
                    .repairService(byServiceNameAndRepairShopId.get(0))
                    .build();

            repairServiceReservations.add(repairServiceReservation);
        });


        Reservation reservation = Reservation.builder()
                .member(member.get())
                .state(String.valueOf(ReservationStateType.WAITING))
                .comment(requestReservationDto.getComment())
                .itDevice(userDevice)
                .reservationImages(reservationImages)
                .reservationDate(LocalDateTime.now().withSecond(0))
                .repairServiceReservations(repairServiceReservations)
                .build();

        Reservation savedReservation = reservationRepository.save(reservation);

        reservationImages.stream().forEach(reservationImage -> {
            ReservationImage build = ReservationImage.builder()
                    .reservation(savedReservation)
                    .url(reservationImage.getUrl())
                    .build();
            reservationImageRepository.save(build);
        });

        repairServiceReservations.stream().forEach(repairServiceReservation -> {
            RepairServiceReservation build = RepairServiceReservation.builder()
                    .reservation(savedReservation)
                    .repairService(repairServiceReservation.getRepairService())
                    .build();
            repairServiceReservationRepository.save(build);
        });

    }
}
