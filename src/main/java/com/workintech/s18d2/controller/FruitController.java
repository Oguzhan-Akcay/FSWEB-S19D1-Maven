package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitDto;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.FruitType;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruit")
@AllArgsConstructor
public class FruitController {
    private final FruitService fruitService;

    @GetMapping("/{id}")
    public FruitDto getById(@Positive(message = "id must be bigger than 0.") @PathVariable("id") long id){
        return new FruitDto(fruitService.getById(id));
    }

    @GetMapping("")
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/name/{name}")
    public  List<Fruit> searchByName(@Size(min = 2, max = 45, message = "it must be between 2 and 45")
                                         @PathVariable("name") String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit f){
        return fruitService.save(f);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@NotNull @Positive @PathVariable Long id){
        return fruitService.delete(id);
    }

}
