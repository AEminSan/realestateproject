package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.Business;
import com.sancarahmet.springboot.project.entity.Property;
import com.sancarahmet.springboot.project.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BusinessDaoImpl implements BusinessDao{
    private EntityManager entityManager;

    public BusinessDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Business business){
        entityManager.persist(business);
    }

    @Override
    public Business findByUserId(int userId) {
        TypedQuery<Business> typedQuery = entityManager.createQuery(
                "FROM Business where userId=:theData", Business.class);

        typedQuery.setParameter("theData", userId);
        return typedQuery.getSingleResult();

    }


}
