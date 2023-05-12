package kit.item.controller;

import kit.item.domain.member.Member;
import kit.item.dto.response.repairShop.ResponsePrivateRepairShopDto;
import kit.item.service.repairShop.RepairShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/repair")
public class RepairShopController {
    private final RepairShopService repairShopService;

    @GetMapping("/privateShops")
    public List<ResponsePrivateRepairShopDto> findAllPrivateRepairShops() {
        return repairShopService.findAllPrivateRepairShops();
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

}
