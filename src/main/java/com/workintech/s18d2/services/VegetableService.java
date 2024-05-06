package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    public Vegetable getById(long l);

    public List<Vegetable> getByPriceAsc();
    public Vegetable save(Vegetable vegetable);
    public Vegetable delete(long l);
    public List<Vegetable> searchByName(String apple);
}
