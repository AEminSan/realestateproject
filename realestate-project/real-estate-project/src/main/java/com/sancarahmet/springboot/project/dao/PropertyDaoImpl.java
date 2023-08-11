package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.Property;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PropertyDaoImpl implements PropertyDao {
    private EntityManager entityManager;

    @Autowired
    public void PropertyDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Property property){
        entityManager.persist(property);
    }

    @Override
    public List<Property> findAll() {
        TypedQuery<Property> typedQuery = entityManager.createQuery("FROM Property", Property.class);

        return  typedQuery.getResultList();
    }

    @Override
    public List<Property> findByBusinessId(int id) {
        TypedQuery<Property> typedQuery = entityManager.createQuery(
                "FROM Property where userId=:theData", Property.class);

        typedQuery.setParameter("theData", id);


        return typedQuery.getResultList();
    }

    @Override
    public List<Property> findBySearch(String type, int noOfRooms, int floor, String heating, int size) {
        TypedQuery<Property> typedQuery = entityManager.createQuery(
                "SELECT p FROM Property p WHERE " +
                        "p.type = :type " +
                        "and p.numberOfRooms = :noOfRooms " +
                        "and p.floor = :floor " +
                        "and p.heating = :heating " +
                        "and p.size >= :size"
                , Property.class);

        typedQuery.setParameter("type", type);
        typedQuery.setParameter("noOfRooms", noOfRooms);
        typedQuery.setParameter("floor", floor);
        typedQuery.setParameter("heating", heating);
        typedQuery.setParameter("size", size);

        return typedQuery.getResultList();
    }

}
