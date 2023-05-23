package kit.item.service.repairShop;

import kit.item.domain.it.ItDevice;
import kit.item.domain.member.Member;
import kit.item.domain.member.RepairShop;
import kit.item.domain.point.PointHistory;
import kit.item.domain.repair.*;
import kit.item.dto.entity.device.DeviceDto;
import kit.item.dto.entity.repairShop.*;
import kit.item.dto.request.point.RequestCreatePointHistoryDto;
import kit.item.dto.request.repair.RequestReservationDto;
import kit.item.dto.request.repair.RequestReservationUpdateDto;
import kit.item.dto.request.repair.RequestServiceCreateInfo;
import kit.item.dto.request.repair.RequestServiceUpdateInfo;
import kit.item.dto.response.repairShop.*;
import kit.item.enums.PointUsageType;
import kit.item.enums.ReservationStateType;
import kit.item.repository.it.ItDeviceRepository;
import kit.item.repository.member.MemberRepository;
import kit.item.repository.repairShop.*;
import kit.item.service.device.DeviceManagementService;
import kit.item.service.file.AzureBlobService;
import kit.item.service.point.PointService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
    private final PointService pointService;

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
                    .shopType(repairShop.getRepairServiceType().name())
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
                    .servicePrice(repairService.get().getPrice())
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
                    .servicePrice(repairService.getPrice())
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
                || requestServiceUpdateInfo.getDescription() == null
                || requestServiceUpdateInfo.getServicePrice() == null)) {

            repairShopServiceRepository.updateServiceDetails(
                    requestServiceUpdateInfo.getServiceId(),
                    requestServiceUpdateInfo.getServiceType(),
                    requestServiceUpdateInfo.getServiceName(),
                    requestServiceUpdateInfo.getDescription(),
                    requestServiceUpdateInfo.getServicePrice()
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
                    .price(requestServiceCreateInfo.getServicePrice())
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
                            .id(deviceDto.getId())
                    .itName(
                            (deviceDto.getDirectlyRegisterProductName() == null || deviceDto.getDirectlyRegisterProductName().equals(""))
                                    ? deviceDto.getProductName() : deviceDto.getDirectlyRegisterProductName())
                    .itImg(deviceDto.getUrl())
                    .build());
        });

        List<ReservationServiceDto> repairServices = new ArrayList<>();
        List<RepairService> servicesByRepairShopId = repairShopServiceRepository.findByRepairShopId(repairShopId);
        servicesByRepairShopId.stream().forEach(repairService -> {
            repairServices.add(
                    ReservationServiceDto.builder()
                            .serviceName(repairService.getServiceName())
                            .price(repairService.getPrice())
                            .build()
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

        List<ReservationImage> reservationImages = saveReservationImages(requestReservationDto);

        List<RepairServiceReservation> repairServiceReservations = getRepairServiceReservations(requestReservationDto);

        LocalDate reservationDate = requestReservationDto.getDate();
        LocalDateTime reservationDateTime = reservationDate.atTime(LocalTime.parse(requestReservationDto.getTime()));

        Reservation reservation = Reservation.builder()
                .member(member.get())
                .state(String.valueOf(ReservationStateType.WAITING.getKrName()))
                .comment(requestReservationDto.getComment())
                .itDevice(userDevice)
                .reservationImages(reservationImages)
                .applicationDate(LocalDateTime.now().withSecond(0))
                .reservationDate(reservationDateTime)
                .repairServiceReservations(repairServiceReservations)
                .repairShop(repairShopRepository.findById(requestReservationDto.getRepairShopId()).get())
                .build();

        Reservation savedReservation = reservationRepository.save(reservation);

        if (reservationImages != null)
            saveReservationImgs(reservationImages, savedReservation);
        saveRepairServiceReservation(repairServiceReservations, savedReservation);

    }

    private void saveRepairServiceReservation(List<RepairServiceReservation> repairServiceReservations, Reservation savedReservation) {
        repairServiceReservations.stream().forEach(repairServiceReservation -> {
            RepairServiceReservation build = RepairServiceReservation.builder()
                    .reservation(savedReservation)
                    .repairService(repairServiceReservation.getRepairService())
                    .build();
            repairServiceReservationRepository.save(build);
        });
    }

    private void saveReservationImgs(List<ReservationImage> reservationImages, Reservation savedReservation) {
        reservationImages.stream().forEach(reservationImage -> {
            ReservationImage build = ReservationImage.builder()
                    .reservation(savedReservation)
                    .url(reservationImage.getUrl())
                    .build();
            reservationImageRepository.save(build);
        });
    }

    @NotNull
    private List<ReservationImage> saveReservationImages(RequestReservationDto requestReservationDto) {
        List<ReservationImage> reservationImages = new ArrayList<>();

        List<MultipartFile> rvRequestImgs = requestReservationDto.getRvRequestImgs();
        if (rvRequestImgs != null) {
            rvRequestImgs.stream().forEach(requestImg -> {
                try {
                    String fileUrl = azureBlobAdapter.upload(requestImg);

                    ReservationImage reservationImage = ReservationImage.builder()
                            .url(fileUrl)
                            .build();

                    reservationImages.add(reservationImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return reservationImages;
        }
        return null;
    }

    @NotNull
    private List<RepairServiceReservation> getRepairServiceReservations(RequestReservationDto requestReservationDto) {
        List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();

        System.out.println("requestReservationDto = " + requestReservationDto.getServices());

        requestReservationDto.getServices().stream().forEach(service -> {
            List<RepairService> byServiceNameAndRepairShopId = repairShopServiceRepository.findByServiceNameAndRepairShopId(service.getServiceName(), requestReservationDto.getRepairShopId());

            RepairServiceReservation repairServiceReservation = RepairServiceReservation.builder()
                    .repairService(byServiceNameAndRepairShopId.get(0))
                    .build();

            repairServiceReservations.add(repairServiceReservation);
        });
        return repairServiceReservations;
    }

    public List<ResponseReservaionHistoryDto> findReservationHistory(Long memberId){

        List<ResponseReservaionHistoryDto> responseReservaionHistoryDtoList = new ArrayList<>();

        List<Reservation> reservationList = reservationRepository.findByMemberId(memberId);
        reservationList.stream().forEach(
                reservation -> {
                    Optional<RepairShop> repairShopByReservationId = reservationRepository.findRepairShopByReservationId(reservation.getId());

                    Optional<Reservation> reservationById = reservationRepository.findById(reservation.getId());

                    if (reservationById.isPresent()){
                        if (repairShopByReservationId.isPresent()) {

                            List<RepairService> repairServicesByReservationId = reservationRepository.findRepairServicesByReservationId(reservationById.get().getId());
                            List<ReservationServiceDto> repairServices = new ArrayList<>();
                            repairServicesByReservationId.stream().forEach(repairService -> {
                                repairServices.add(
                                        ReservationServiceDto.builder()
                                                .serviceName(
                                                        repairService.getServiceName()
                                                ).price(
                                                        repairService.getPrice()
                                                ).build()
                                );
                            });

                            List<ReservationImage> reservationImages = reservationById.get().getReservationImages();
                            List<String> reservationImageUrls = new ArrayList<>();
                            reservationImages.stream().forEach(reservationImage -> {
                                reservationImageUrls.add(reservationImage.getUrl());
                            });

                            //LocalDateTime -> LocalTime
                            LocalTime reservationTime = reservationById.get().getReservationDate().toLocalTime();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            String reservationTimeStr = reservationTime.format(formatter);

                            responseReservaionHistoryDtoList.add(
                                    ResponseReservaionHistoryDto.builder()
                                            .id(reservation.getId())
                                            .repairShopId(repairShopByReservationId.get().getId())
                                            .shopName(repairShopByReservationId.get().getShopName())
                                            .productName((reservationById.get().getItDevice().getDirectlyRegisteredName() == null || reservationById.get().getItDevice().getDirectlyRegisteredName().length() == 0) ? reservationById.get().getItDevice().getProduct().getName() : reservationById.get().getItDevice().getDirectlyRegisteredName())
                                            .prodImg(reservationById.get().getItDevice().getCategory().getImageUrl())
                                            .requestServices(repairServices)
                                            .rvRequestImgs(reservationImageUrls)
                                            .requestComment(reservationById.get().getComment())
                                            .date(reservationById.get().getReservationDate().toLocalDate())
                                            .time(reservationTimeStr)
                                            .status(reservationById.get().getState())
                                            .build()
                            );
                        }
                    }
                }
        );
        return responseReservaionHistoryDtoList;
    }

    public List<ResponseReservaionHistoryDto> findReservationHistoryMechanic(Long memberId){

        List<ResponseReservaionHistoryDto> responseReservaionHistoryDtoList = new ArrayList<>();

        List<Reservation> reservationList = reservationRepository.findByRepairShopId(memberId);

        reservationList.stream().forEach(
                reservation -> {
                    Optional<RepairShop> repairShopByReservationId = reservationRepository.findRepairShopByReservationId(reservation.getId());

                    Optional<Reservation> reservationById = reservationRepository.findById(reservation.getId());

                    if (reservationById.isPresent()){
                        if (repairShopByReservationId.isPresent()) {

                            List<RepairService> repairServicesByReservationId = reservationRepository.findRepairServicesByReservationId(reservationById.get().getId());
                            List<ReservationServiceDto> repairServices = new ArrayList<>();
                            repairServicesByReservationId.stream().forEach(repairService -> {
                                repairServices.add(
                                        ReservationServiceDto.builder()
                                                .serviceName(
                                                        repairService.getServiceName()
                                                ).price(
                                                        repairService.getPrice()
                                                ).build()
                                );
                            });

                            List<ReservationImage> reservationImages = reservationById.get().getReservationImages();
                            List<String> reservationImageUrls = new ArrayList<>();
                            reservationImages.stream().forEach(reservationImage -> {
                                reservationImageUrls.add(reservationImage.getUrl());
                            });

                            //LocalDateTime -> LocalTime
                            LocalTime reservationTime = reservationById.get().getReservationDate().toLocalTime();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            String reservationTimeStr = reservationTime.format(formatter);

                            responseReservaionHistoryDtoList.add(
                                    ResponseReservaionHistoryDto.builder()
                                            .id(reservation.getId())
                                            .repairShopId(repairShopByReservationId.get().getId())
                                            .shopName(repairShopByReservationId.get().getShopName())
                                            .productName((reservationById.get().getItDevice().getDirectlyRegisteredName() == null || reservationById.get().getItDevice().getDirectlyRegisteredName().length() == 0) ? reservationById.get().getItDevice().getProduct().getName() : reservationById.get().getItDevice().getDirectlyRegisteredName())
                                            .prodImg(reservationById.get().getItDevice().getCategory().getImageUrl())
                                            .requestServices(repairServices)
                                            .rvRequestImgs(reservationImageUrls)
                                            .requestComment(reservationById.get().getComment())
                                            .date(reservationById.get().getReservationDate().toLocalDate())
                                            .time(reservationTimeStr)
                                            .status(reservationById.get().getState())
                                            .build()
                            );
                        }
                    }
                }
        );
        return responseReservaionHistoryDtoList;
    }

    public ResponseReservaionHistoryDto findReservationHistoryById(Long reservationId) {

        Optional<Reservation> reservaionById = reservationRepository.findById(reservationId);
        Optional<RepairShop> repairShopByReservationId = reservationRepository.findRepairShopByReservationId(reservationId);

        if (reservaionById.isPresent()){
            if (repairShopByReservationId.isPresent()) {

                List<RepairService> repairServicesByReservationId = reservationRepository.findRepairServicesByReservationId(reservaionById.get().getId());
                List<ReservationServiceDto> requestServices = new ArrayList<>();
                repairServicesByReservationId.stream().forEach(repairService -> {
                    requestServices.add(
                            ReservationServiceDto.builder()
                                    .serviceName(
                                            repairService.getServiceName()
                                    ).price(
                                            repairService.getPrice()
                                    ).build()
                    );
                });

                List<ReservationImage> reservationImages = reservaionById.get().getReservationImages();
                List<String> reservationImageUrls = new ArrayList<>();
                reservationImages.stream().forEach(reservationImage -> {
                    reservationImageUrls.add(reservationImage.getUrl());
                });

                //LocalDateTime -> LocalTime
                LocalTime reservationTime = reservaionById.get().getReservationDate().toLocalTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                String reservationTimeStr = reservationTime.format(formatter);


                //정비소 id로 정비소 서비스들 받기
                List<ReservationServiceDto> repairServices = new ArrayList<>();
                List<RepairService> servicesByRepairShopId = repairShopServiceRepository.findByRepairShopId(repairShopByReservationId.get().getId());
                servicesByRepairShopId.stream().forEach(repairService -> {
                    repairServices.add(
                            ReservationServiceDto.builder()
                                    .serviceName(
                                            repairService.getServiceName()
                                    ).price(
                                            repairService.getPrice()
                                    ).build()
                    );
                });

                return ResponseReservaionHistoryDto.builder()
                        .id(reservaionById.get().getId())
                        .repairShopId(repairShopByReservationId.get().getId())
                        .shopName(repairShopByReservationId.get().getShopName())
                        .productName((reservaionById.get().getItDevice().getDirectlyRegisteredName() == null || reservaionById.get().getItDevice().getDirectlyRegisteredName().length() == 0) ? reservaionById.get().getItDevice().getProduct().getName() : reservaionById.get().getItDevice().getDirectlyRegisteredName())
                        .prodImg(reservaionById.get().getItDevice().getCategory().getImageUrl())
                        .requestServices(requestServices)
                        .rvRequestImgs(reservationImageUrls)
                        .requestComment(reservaionById.get().getComment())
                        .date(reservaionById.get().getReservationDate().toLocalDate())
                        .time(reservationTimeStr)
                        .status(reservaionById.get().getState())
                        .services(repairServices)
                        .build();
            }
        }
        return null;
    }

    public void updateReservation(Long memberId, RequestReservationUpdateDto reservationUpdateDto) {
        Optional<Member> member = memberRepository.findById(memberId);


        Reservation reservation = reservationRepository.findById(reservationUpdateDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("예약 정보를 찾을 수 없습니다."));

        ItDevice deviceByMemberIdAndProductName = itDeviceRepository.findDeviceByMemberIdAndProductName(memberId, reservationUpdateDto.getProductName());
        // 예약 정보 업데이트
        reservation.setItDevice(deviceByMemberIdAndProductName);
        reservation.setComment(reservationUpdateDto.getComment());
        reservation.setReservationDate(LocalDateTime.of(reservationUpdateDto.getDate(), LocalTime.parse(reservationUpdateDto.getTime())));
        // 예약 이미지 업데이트
        if (reservationUpdateDto.getRvRequestImgs() != null) {
            // 기존 예약 이미지 삭제
            reservationImageRepository.deleteByReservation(reservation);

            // 새로운 예약 이미지 업로드 및 연결
            List<ReservationImage> reservationImages = new ArrayList<>();
            for (MultipartFile rvRequestImg : reservationUpdateDto.getRvRequestImgs()) {
                try {
                    String fileUrl = azureBlobAdapter.upload(rvRequestImg);

                    ReservationImage reservationImage = ReservationImage.builder()
                            .url(fileUrl)
                            .reservation(reservation)
                            .build();

                    reservationImages.add(reservationImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            reservation.setReservationImages(reservationImages);
            if (reservationImages.size() > 0)
                saveReservationImgs(reservationImages, reservation);
        }

        // 예약 서비스 업데이트
        if (reservationUpdateDto.getServices() != null) {
            // 기존 예약 서비스 삭제
            repairServiceReservationRepository.deleteByReservation(reservation);

            // 새로운 예약 서비스 생성 및 연결
            List<RepairServiceReservation> repairServiceReservations = new ArrayList<>();
            for (ReservationServiceDto service : reservationUpdateDto.getServices()) {
                List<RepairService> repairServices = repairShopServiceRepository.findByServiceNameAndRepairShopId(service.getServiceName(), reservationUpdateDto.getRepairShopId());

                if (!repairServices.isEmpty()) {
                    RepairServiceReservation repairServiceReservation = RepairServiceReservation.builder()
                            .reservation(reservation)
                            .repairService(repairServices.get(0))
                            .build();

                    repairServiceReservations.add(repairServiceReservation);
                }
            }

            saveRepairServiceReservation(repairServiceReservations, reservation);
        }

        reservationRepository.save(reservation);
    }

    public boolean acceptReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {

            //포인트 차감, 포인트 히스토리
            AtomicLong totalPrice = new AtomicLong(0);
            Member consumer = reservation.get().getMember();
            List<RepairServiceReservation> repairServiceReservations = reservation.get().getRepairServiceReservations();


            StringBuilder serviceNames = new StringBuilder();
            AtomicInteger count = new AtomicInteger(0);

            repairServiceReservations.stream().forEach(repairServiceReservation -> {
                        totalPrice.addAndGet(repairServiceReservation.getRepairService().getPrice());
                        count.incrementAndGet();
                        if (count.get() < 2)
                            serviceNames.append(repairServiceReservation.getRepairService().getServiceName());
                    }
            );

            String finalServiceNames = serviceNames.toString();

            if (consumer.getPoint() >= totalPrice.get()) {
                //소비자
                //포인트 차감
                consumer.setPoint(consumer.getPoint() - totalPrice.get());
                memberRepository.save(consumer);

                //포인트 히스토리
                RequestCreatePointHistoryDto consumerPointHistory = RequestCreatePointHistoryDto.builder()
                        .serviceName(finalServiceNames)
                        .serviceType(PointUsageType.REPAIR_SERVICE_USE.getKrName())
                        .point(-totalPrice.get())
                        .date(LocalDateTime.now()).build();
                pointService.createHistory(consumer.getId(), consumerPointHistory);

                //업체
                //포인트 얻음
                RepairShop repairShop = reservation.get().getRepairShop();
                repairShop.setPoint(repairShop.getPoint() + totalPrice.get());
                memberRepository.save(repairShop);

                //포인트 히스토리
                RequestCreatePointHistoryDto repairShopPointHistory = RequestCreatePointHistoryDto.builder()
                        .serviceName(finalServiceNames)
                        .serviceType(PointUsageType.REPAIR_SERVICE_PROVIDE.getKrName())
                        .point(totalPrice.get())
                        .date(LocalDateTime.now()).build();
                pointService.createHistory(reservation.get().getRepairShop().getId(), repairShopPointHistory);

                reservation.get().setState(ReservationStateType.ACCEPTED.getKrName());

                reservationRepository.save(reservation.get());
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean rejectReservation(Long reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            reservation.get().setState(ReservationStateType.REJECTED.getKrName());
            reservationRepository.save(reservation.get());
            return true;
        }
        return false;
    }
}
