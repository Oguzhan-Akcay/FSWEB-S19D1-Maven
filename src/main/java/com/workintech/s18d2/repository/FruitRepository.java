package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM fruit f ORDER BY f.price DESC ", nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value = "Select f.id, f.name, f.price, f.fruit_type From fruit f order by f.price asc ", nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query(value = "select f.id, f.name, f.price, f.fruit_type from Fruit f where f.name LIKE %:name%", nativeQuery = true)
    List<Fruit> searchByName(String name);

}
