package kit.item.service.device;

import kit.item.domain.it.*;
import kit.item.domain.member.Member;
import kit.item.dto.entity.device.*;
import kit.item.dto.request.device.RequestCreateDeviceDto;
import kit.item.dto.request.device.RequestCreatePartDto;
import kit.item.dto.request.device.RequestUpdateDeviceDto;
import kit.item.repository.it.*;
import kit.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeviceManagementService {
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryBrandRepository categoryBrandRepository;
    private final ItDeviceRepository itDeviceRepository;
    private final MemberRepository memberRepository;

    // category - completion 완제품(컴퓨터, 노트북, 스마트폰, 태블릿)
    public List<CategoryDto> getCompletionCategoryList() {
        log.info("DeviceManagementService.getCompletionCategoryList");
        return categoryRepository.findCompletionAllCategory();
    }

    // category - part 부품(그래픽 카드. 메인보드, CPU, RAM, SSD, HDD, 파워, 케이스, 쿨러 ...)
    public List<CategoryDto> getPartCategoryList() {
        log.info("DeviceManagementService.getPartCategoryList");
        return categoryRepository.findPartAllCategory();
    }

    // categoryId -> brand 완제품
    public List<BrandDto> getCompletionBrandList(Long categoryId) {
        log.info("DeviceManagementService.getCompletionBrandList");
        return categoryBrandRepository.findCompletionBrandByCategoryId(categoryId);
    }

    // categoryId -> brand 부품
    public List<BrandDto> getPartBrandList(Long categoryId) {
        log.info("DeviceManagementService.getPartBrandList");
        return categoryBrandRepository.findPartBrandByCategoryId(categoryId);
    }

    // brandId -> product 완제품
    public List<ProductDto> getCompletionProductList(Long categoryId, Long brandId) {
        log.info("DeviceManagementService.getCompletionProductList");
        return categoryBrandRepository.findCompletionProductByCategoryIdAndBrandId(categoryId, brandId);
    }

    // brandId -> product 부품
    public List<ProductDto> getPartProductList(Long categoryId, Long brandId) {
        log.info("DeviceManagementService.getPartProductList");
        return categoryBrandRepository.findPartProductByCategoryIdAndBrandId(categoryId, brandId);
    }

    private List<DeviceDto> getDeviceList(Long memberId, Long categoryId) {
        log.info("DeviceManagementService.getDeviceList");
        List<DeviceDto> selectDevices = itDeviceRepository.findSelectDeviceByMemberId(memberId, categoryId);
        for (DeviceDto selectDevice : selectDevices) {
            System.out.println("selectDevice.getId() = " + selectDevice.getId());
        }
        for (DeviceDto deviceDto : selectDevices) {
            List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, deviceDto.getId());
            if (components.isEmpty()) {
                deviceDto.setComponents(new ArrayList<DeviceDto>());
            }
            deviceDto.setComponents(components);
        }
        return selectDevices;
    }

    // my device get list
    public List<MyDeviceTypeDto> getMyDeviceList(Long memberId) {
        log.info("DeviceManagementService.getMyDeviceList");
        List<MyDeviceTypeDto> myDeviceTypeDtos = new ArrayList<>();
        myDeviceTypeDtos.add(MyDeviceTypeDto
                .builder()
                .summary("컴퓨터")
                .detail(getDeviceList(memberId, 1L))
                .build());
        myDeviceTypeDtos.add(MyDeviceTypeDto
                .builder()
                .summary("노트북")
                .detail(getDeviceList(memberId, 2L))
                .build());
        myDeviceTypeDtos.add(MyDeviceTypeDto
                .builder()
                .summary("스마트폰")
                .detail(getDeviceList(memberId, 3L))
                .build());
        myDeviceTypeDtos.add(MyDeviceTypeDto
                .builder()
                .summary("테블릿")
                .detail(getDeviceList(memberId, 4L))
                .build());
        return myDeviceTypeDtos;
    }

    // my device register
    public boolean createMyDevice(Long memberId, RequestCreateDeviceDto requestCreateDeviceDto) {
        log.info("DeviceManagementService.createMyDevice");
        ItDevice itDevice = new ItDevice();

        // member 설정
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) {
            return false;
        }
        itDevice.setMember(member.get());

        // category 설정
        Optional<Category> category = categoryRepository.findById(requestCreateDeviceDto.getCategoryId());
        if (category.isEmpty()){
            return false;
        }
        itDevice.setCategory(category.get());

        // brand 설정
        Optional<Brand> brand = brandRepository.findById(requestCreateDeviceDto.getBrandId());
        if (brand.isEmpty()){
            return false;
        }
        itDevice.setBrand(brand.get());

        // 제품이름 직접 등록 설정
        if (!requestCreateDeviceDto.getDirectlyRegisterProductName().equals("")) {
            itDevice.setDirectlyRegisteredName(requestCreateDeviceDto.getDirectlyRegisterProductName());
            itDevice.setProduct(null);
        }else{
            Optional<Product> product = productRepository.findById(requestCreateDeviceDto.getProductId());
            if (product.isEmpty()){
                return false;
            }
            itDevice.setDirectlyRegisteredName(null);
            itDevice.setProduct(product.get());
        }

        itDeviceRepository.save(itDevice);
        return true;
    }

    // my device update
//    public boolean updateMyDevice(Long memberId, RequestUpdateDeviceDto requestUpdateDeviceDto) {
//        log.info("DeviceManagementService.updateMyDevice");
//        Optional<ItDevice> itDevice = itDeviceRepository.findById(requestUpdateDeviceDto.getDeviceId());
//        if (itDevice.isEmpty()) {
//            return false;
//        }
//        if (!itDevice.get().getMember().getId().equals(memberId)) {
//            return false;
//        }
//        ItDevice device = itDevice.get();
//
//        if (itDevice.get().getFinishedProduct() != null) {
//            itDeviceRepository.deletePartProductsByFinishedProductId(memberId, itDevice.get().getId());
//            itDevice.get().setFinishedProduct(null);
//        }
//
//        if(requestUpdateDeviceDto.getDirectlyRegisterProductName() != null) {
//            device.setDirectlyRegisteredName(requestUpdateDeviceDto.getDirectlyRegisterProductName());
//            device.setCategory(categoryRepository.findById(requestUpdateDeviceDto.getCategoryId()).get());
//            device.setBrand(brandRepository.findById(requestUpdateDeviceDto.getBrandId()).get());
//            device.setProduct(null);
//        } else {
//            device.setDirectlyRegisteredName(null);
//            device.setCategory(categoryRepository.findById(requestUpdateDeviceDto.getCategoryId()).get());
//            device.setBrand(brandRepository.findById(requestUpdateDeviceDto.getBrandId()).get());
//            device.setProduct(productRepository.findById(requestUpdateDeviceDto.getProductId()).get());
//        }
//        itDeviceRepository.save(device);
//        return true;
//    }

    // my device delete
    public boolean deleteMyDevice(Long memberId, Long deviceId) {
        log.info("DeviceManagementService.deleteMyDevice");
        Optional<ItDevice> itDevice = itDeviceRepository.findById(deviceId);
        if (itDevice.isEmpty()) {
            return false;
        }
        if (!itDevice.get().getMember().getId().equals(memberId)) {
            return false;
        }
        if (itDevice.get().getFinishedProduct() != null) {
            itDeviceRepository.deletePartProductsByFinishedProductId(memberId, itDevice.get().getId());
        }
        itDeviceRepository.delete(itDevice.get());
        return true;
    }

    // my device register
    public boolean createMyPart(Long memberId, RequestCreatePartDto requestCreatePartDto) {
        log.info("DeviceManagementService.createMyDevice");
        ItDevice itDevice = new ItDevice();

        // member 설정
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) {
            return false;
        }
        itDevice.setMember(member.get());

        // category 설정
        Optional<Category> category = categoryRepository.findById(requestCreatePartDto.getCategoryId());
        if (category.isEmpty()){
            return false;
        }
        itDevice.setCategory(category.get());

        // brand 설정
        Optional<Brand> brand = brandRepository.findById(requestCreatePartDto.getBrandId());
        if (brand.isEmpty()){
            return false;
        }
        itDevice.setBrand(brand.get());

        // it Device 부품 설정
        Optional<ItDevice> itDevicePart = itDeviceRepository.findById(requestCreatePartDto.getFinishedDeviceId());
        if (itDevicePart.isEmpty()){
            return false;
        }
        itDevice.setFinishedProduct(itDevicePart.get());

        // 제품이름 직접 등록 설정
        if (!requestCreatePartDto.getDirectlyRegisterProductName().equals("")) {
            itDevice.setDirectlyRegisteredName(requestCreatePartDto.getDirectlyRegisterProductName());
            itDevice.setProduct(null);
        }else{
            Optional<Product> product = productRepository.findById(requestCreatePartDto.getProductId());
            if (product.isEmpty()){
                return false;
            }
            itDevice.setDirectlyRegisteredName(null);
            itDevice.setProduct(product.get());
        }

        itDeviceRepository.save(itDevice);
        return true;
    }

    public boolean deleteMyPart(Long memberId, Long deviceId) {
        log.info("DeviceManagementService.deleteMyDevice");
        Optional<ItDevice> itDevice = itDeviceRepository.findById(deviceId);
        if (itDevice.isEmpty()) {
            return false;
        }
        if (!itDevice.get().getMember().getId().equals(memberId)) {
            return false;
        }
        itDeviceRepository.delete(itDevice.get());
        return true;
    }

    // my device regardless of category
    public List<DeviceDto> getDeviceListRegardlessCategory(Long memberId) {
        log.info("DeviceManagementService.getDeviceList");
        List<DeviceDto> selectDevices = itDeviceRepository.findDeviceByMemberId(memberId);
        for (DeviceDto deviceDto : selectDevices) {
            if (deviceDto.getProductType().equals(ProductType.COMPONENT)) {
                List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, deviceDto.getId());
                deviceDto.setComponents(components);
            }
            deviceDto.setComponents(new ArrayList<>());
        }
        return selectDevices;
    }
}
