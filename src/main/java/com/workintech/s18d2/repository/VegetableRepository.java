package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM Vegetables v ORDER BY v.price DESC ", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM Vegetables v ORDER BY v.price Asc ", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query(value = "select v from Vegetables v v.name Like %:name%", nativeQuery = true)
    List<Vegetable> searchByName(String name);
}
