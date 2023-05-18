package kit.item.service.device;

import kit.item.domain.it.*;
import kit.item.domain.member.Member;
import kit.item.dto.entity.device.*;
import kit.item.dto.request.device.RequestCreateDeviceDto;
import kit.item.dto.request.device.RequestUpdateDeviceDto;
import kit.item.dto.response.device.ResponseGetMyDeviceInfo;
import kit.item.enums.ProductType;
import kit.item.repository.it.*;
import kit.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kit.item.util.prefix.ConstPrefix.IS_COMPONENT;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeviceManagementService {
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryBrandRepository categoryBrandRepository;
    private final BrandProductRepository brandProductRepository;
    private final ItDeviceRepository itDeviceRepository;
    private final MemberRepository memberRepository;

    // category
    public List<CategoryDto> getCategoryList() {
        log.info("DeviceManagementService.getCategoryList");
        return categoryRepository.findAllCategory();
    }

    // categoryId -> brand
    public List<BrandDto> getBrandList(Long categoryId) {
        log.info("DeviceManagementService.getBrandList");
        return categoryBrandRepository.findBrandByCategoryId(categoryId);
    }

    // brandId -> product
    public List<ProductDto> getProductList(Long categoryId, Long brandId) {
        log.info("DeviceManagementService.getProductList");
        CategoryBrandDto categoryBrands = categoryBrandRepository.findCategoryBrandByCategoryIdAndBrandId(categoryId, brandId);
        return brandProductRepository.findProductByCategoryIdAndBrandId(categoryBrands.getCategoryId(), categoryBrands.getBrandId());
    }

    // my device get list
    public ResponseGetMyDeviceInfo getMyDeviceList(Long memberId) {
        log.info("DeviceManagementService.getMyDeviceList");
        List<DeviceDto> computers = itDeviceRepository.findSelectDeviceByMemberId(memberId, 1L);
        for (DeviceDto computer : computers) {
            if (computer.getProductType().equals(ProductType.COMPONENT)) {
                List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, computer.getId());
                computer.setComponents(components);
            }
            computer.setComponents(new ArrayList<>());
        }
        List<DeviceDto> notebooks = itDeviceRepository.findSelectDeviceByMemberId(memberId, 2L);
        for (DeviceDto notebook : notebooks) {
            if (notebook.getProductType().equals(ProductType.COMPONENT)) {
                List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, notebook.getId());
                notebook.setComponents(components);
            }
            notebook.setComponents(new ArrayList<>());
        }
        List<DeviceDto> smartPhones = itDeviceRepository.findSelectDeviceByMemberId(memberId, 3L);
        for (DeviceDto smartPhone : smartPhones) {
            if(smartPhone.getProductType().equals(ProductType.COMPONENT)){
                List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, smartPhone.getId());
                smartPhone.setComponents(components);
            }
            smartPhone.setComponents(new ArrayList<>());
        }
        List<DeviceDto> tablets = itDeviceRepository.findSelectDeviceByMemberId(memberId, 4L);
        for (DeviceDto tablet : tablets) {
            if(tablet.getProductType().equals(ProductType.COMPONENT)){
                List<DeviceDto> components = itDeviceRepository.findSelectComponentByMemberIdAndComponentProductId(memberId, tablet.getId());
                tablet.setComponents(components);
            }
            tablet.setComponents(new ArrayList<>());
        }
        return ResponseGetMyDeviceInfo.builder()
                .computers(computers)
                .notebooks(notebooks)
                .smartPhones(smartPhones)
                .tablets(tablets)
                .build();
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
        if (requestCreateDeviceDto.getDirectlyRegisterProductName() != null) {
            itDevice.setDirectlyRegisteredName(requestCreateDeviceDto.getDirectlyRegisterProductName());
        }else{
            Optional<Product> product = productRepository.findById(requestCreateDeviceDto.getProductId());
            if (product.isEmpty()){
                return false;
            }
            itDevice.setProduct(product.get());
        }

        itDeviceRepository.save(itDevice);
        return true;
    }

    // my device update
    public boolean updateMyDevice(Long memberId, RequestUpdateDeviceDto requestUpdateDeviceDto) {
        log.info("DeviceManagementService.updateMyDevice");
        Optional<ItDevice> itDevice = itDeviceRepository.findById(requestUpdateDeviceDto.getDeviceId());
        if (itDevice.isEmpty()) {
            return false;
        }
        if (!itDevice.get().getMember().getId().equals(memberId)) {
            return false;
        }
        ItDevice device = itDevice.get();

        if(requestUpdateDeviceDto.getDirectlyRegisterProductName() != null) {
            device.setDirectlyRegisteredName(requestUpdateDeviceDto.getDirectlyRegisterProductName());
            device.setCategory(categoryRepository.findById(requestUpdateDeviceDto.getCategoryId()).get());
            device.setBrand(brandRepository.findById(requestUpdateDeviceDto.getBrandId()).get());
            device.setProduct(null);
        } else {
            device.setDirectlyRegisteredName(null);
            device.setCategory(categoryRepository.findById(requestUpdateDeviceDto.getCategoryId()).get());
            device.setBrand(brandRepository.findById(requestUpdateDeviceDto.getBrandId()).get());
            device.setProduct(productRepository.findById(requestUpdateDeviceDto.getProductId()).get());
        }
        itDeviceRepository.save(device);
        return true;
    }

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
        if (itDevice.get().getProduct().getProductType().equals(ProductType.COMPONENT)) {
            List<ItDevice> components = itDeviceRepository.findByComponentProductId(itDevice.get().getId());
            itDeviceRepository.deleteAll(components);
        }
        itDeviceRepository.delete(itDevice.get());
        return true;
    }
}
