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
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/ex03")
    public String thymeleafExample03(Model model) {
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemName("테스트 상품"+i);
            itemDto.setPrice(1000*i);
            itemDto.setCreatedAt(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafExample/ex03";
    }

    @GetMapping("/ex04")
    public String thymeleafExample04() {
        return "thymeleafExample/ex04";
    }

    @GetMapping("/ex05")
    public String thymeleafExample05(String param1, String param2, Model model) {
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);
        return "thymeleafExample/ex05";
    }

    @GetMapping("/ex06")
    public String thymeleafExample06() {
        return "thymeleafExample/ex06";
    }

}
