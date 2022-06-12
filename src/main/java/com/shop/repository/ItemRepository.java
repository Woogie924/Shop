package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemName(String itemName);

    List<Item> findByItemOrItemDetail(String itemName, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("SELECT i " +
            "FROM Item i " +
            "WHERE i.itemDetail LIKE %:itemDetail% ORDER BY i.price DESC")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "SELECT *" +
            "FROM item i" +
            "WHERE i.item_detail LIKE %:itemDetail% " +
            "ORDER BY i.price DESC",
            nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
