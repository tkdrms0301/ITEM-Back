package kit.item.service.device;

import kit.item.domain.it.*;
import kit.item.domain.member.Member;
import kit.item.dto.entity.device.*;
import kit.item.dto.request.device.RequestCreateDeviceDto;
import kit.item.dto.request.device.RequestUpdateDeviceDto;
import kit.item.dto.response.device.ResponseGetMyDeviceInfo;
import kit.item.repository.it.*;
import kit.item.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return productRepository.findProductByBrandId(categoryBrands.getBrandId());
    }

    // my device get list
    public ResponseGetMyDeviceInfo getMyDeviceList(Long memberId) {
        log.info("DeviceManagementService.getMyDeviceList");
        List<DeviceDto> computers = itDeviceRepository.findSelectDeviceByMemberId(memberId, 1L);
        List<DeviceDto> notebooks = itDeviceRepository.findSelectDeviceByMemberId(memberId, 2L);
        List<DeviceDto> smartPhones = itDeviceRepository.findSelectDeviceByMemberId(memberId, 3L);
        List<DeviceDto> tablets = itDeviceRepository.findSelectDeviceByMemberId(memberId, 4L);
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
        ItDevice itDevice = null;
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()) {
            return false;
        }
        if(requestCreateDeviceDto.getDirectlyRegisterProductName() != null) {
            itDevice = ItDevice.builder()
                    .directlyRegisteredName(requestCreateDeviceDto.getDirectlyRegisterProductName())
                    .category(categoryRepository.findById(requestCreateDeviceDto.getCategoryId()).get())
                    .brand(brandRepository.findById(requestCreateDeviceDto.getBrandId()).get())
                    .product(null)
                    .member(member.get())
                    .build();
        }else {
            itDevice = ItDevice.builder()
                    .directlyRegisteredName(null)
                    .category(categoryRepository.findById(requestCreateDeviceDto.getCategoryId()).get())
                    .brand(brandRepository.findById(requestCreateDeviceDto.getBrandId()).get())
                    .product(productRepository.findById(requestCreateDeviceDto.getProductId()).get())
                    .member(member.get())
                    .build();
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
        if (itDevice.get().getMember().getId() != memberId) {
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
        if(itDevice.isEmpty()) {
            return false;
        }
        if(itDevice.get().getMember().getId() != memberId) {
            return false;
        }
        itDeviceRepository.delete(itDevice.get());
        return true;
    }
}
