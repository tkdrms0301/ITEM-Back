package kit.item.service.device;

import kit.item.domain.it.Category;
import kit.item.dto.entity.device.CategoryDto;
import kit.item.repository.it.BrandRepository;
import kit.item.repository.it.CategoryRepository;
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
    private final BrandRepository brandRepository;

    public List<CategoryDto> getCategoryList() {
        log.info("DeviceManagementService.getCategoryList");
        return categoryRepository.findAllCategory();
    }


}
