package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.Business;
import com.sancarahmet.springboot.project.entity.Property;

import java.util.List;

public interface BusinessDao {

    void save(Business business);

    Business findByUserId(int id);

}
