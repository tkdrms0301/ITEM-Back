package kit.item.service.repairShop;

import kit.item.domain.member.RepairShop;
import kit.item.domain.repair.OfficialRepairShop;
import kit.item.domain.repair.RepairService;
import kit.item.dto.entity.repairShop.RepairServiceDto;
import kit.item.dto.response.repairShop.ResponsePrivateRepairShopDto;
import kit.item.dto.response.repairShop.ResponsePublicRepairShopDto;
import kit.item.dto.response.repairShop.ResponseServiceListDto;
import kit.item.enums.ServiceType;
import kit.item.repository.repairShop.OfficialRepairShopRepository;
import kit.item.repository.repairShop.RepairShopRepository;
import kit.item.repository.repairShop.RepairShopServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairShopService {
    private final RepairShopServiceRepository repairShopServiceRepository;
    private final RepairShopRepository repairShopRepository;
    private final OfficialRepairShopRepository officialRepairShopRepository;

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
                                .serviceType(String.valueOf(repairService.getServiceType()))
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

    public List<ResponseServiceListDto> getServiceListByShopID(Long shopId){

        List<RepairService> serviceList = repairShopServiceRepository.findByRepairShopId(shopId);

        List<ResponseServiceListDto> responseServiceListDtos = new ArrayList<>();

        serviceList.stream().forEach(repairService -> {
            responseServiceListDtos.add(ResponseServiceListDto.builder()
                    .serviceId(repairService.getId())
                    .serviceName(repairService.getServiceName())
                    .serviceType(String.valueOf(repairService.getServiceType()))
                    .description(repairService.getDescription())
                    .build());

        });
        return responseServiceListDtos;
    }

    public boolean deleteServiceByServiceId(Long memberId, Long serviceId){

        boolean isExist = repairShopServiceRepository.existsByMemberIdAndServiceId(memberId, serviceId);

        if(isExist){
            repairShopServiceRepository.deleteById(serviceId);
            return true;
        }
        return false;
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
}
