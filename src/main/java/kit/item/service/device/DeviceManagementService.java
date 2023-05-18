package kit.item.service.device;

import kit.item.domain.it.Brand;
import kit.item.domain.it.Category;
import kit.item.domain.it.CategoryBrand;
import kit.item.dto.entity.device.BrandDto;
import kit.item.dto.entity.device.CategoryBrandDto;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.dto.entity.device.ProductDto;
import kit.item.repository.it.BrandRepository;
import kit.item.repository.it.CategoryBrandRepository;
import kit.item.repository.it.CategoryRepository;
import kit.item.repository.it.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeviceManagementService {
    private final CategoryRepository categoryRepository;
    private final CategoryBrandRepository categoryBrandRepository;
    private final ProductRepository productRepository;

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

    // my device list
//    public DeviceDto getMyDeviceList(Long memberId) {
//        log.info("DeviceManagementService.getMyDeviceList");
//        return productRepository.findProductByBrandId(categoryBrands.getBrandId());
//    }
}
