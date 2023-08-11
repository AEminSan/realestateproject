package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.Property;

import java.util.List;

public interface PropertyDao {
    void save(Property property);

    List<Property> findAll();

    List<Property> findByBusinessId(int id);

    List<Property> findBySearch(String type, int noOfRooms, int floor, String heating, int size);
}
