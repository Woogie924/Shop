package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItem() {
        Item item = new Item();
        item.setItemName("테스트 상품");
        item.setPrice(1000);
        item.setItemDetail("테스트 상품 상세 설명입니다.");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockQuantity(10);
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());

        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }


    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemName() {
        int expectedResult = 1;
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemName("1번 테스트 상품");

        for(Item item : itemList) {
            System.out.println(item);
        }

        assertThat(itemList.size()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("상품명, 상품 상세설명 or 테스트")
    void findByItemOrItemDetail() {
        this.createItemList();
        List<Item> items = itemRepository.findByItemOrItemDetail("1번 테스트 상품", "1번째 테스트 상품 상세 설명");

        for(Item item : items) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    void findByPriceLessThan() {
        this.createItemList();
        List<Item> items = itemRepository.findByPriceLessThan(100000);

        for(Item item : items) {
            System.out.println(item);
        }
    }

    private void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemName(i + "번 테스트 상품");
            item.setPrice(10 * i);
            item.setItemDetail(i + "번째 테스트 상품 상세 설명");
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockQuantity(100);
            item.setCreatedAt(LocalDateTime.now());
            item.setUpdatedAt(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    void findByPriceLessThanOrderByPriceDesc() {
        this.createItemList();
        List<Item> items = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
        for(Item item : items) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("@Query 이용 - 상품 조회테스트")
    void findByItemDetail() {
        this.createItemList();
        List<Item> items = itemRepository.findByItemDetail("테스트 상품 상세 설명");

        for(Item item : items) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("nativeQuery 속성 이용 - 상품 조회 테스트")
    void findByItemDetailByNative() {
        this.createItemList();
        List<Item> items = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");

        for(Item item : items) {
            System.out.println(item);
        }
    }
}