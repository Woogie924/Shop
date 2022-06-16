package com.shop;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExampleController {

    @GetMapping("/ex01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data","타임리프 테스트");
        return "thymeleafExample/ex01";
    }

    @GetMapping("/ex02")
    public String thymeleafExample02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemName("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setCreatedAt(LocalDateTime.now());


        model.addAttribute("item", itemDto);
        return "thymeleafExample/ex02";
    }

}
