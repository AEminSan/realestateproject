package com.sancarahmet.springboot.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    @Column(name="address")
    private String address;

    @Column(name="number_of_rooms")
    private int numberOfRooms;

    @Column(name="floor")
    private int floor;

    @Column(name = "total_floors")
    private int totalFloors;

    @Column(name = "heating")
    private String heating;

    @Column(name="size")
    private int size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="business_id")
    private Business business;

//    @Column(name="bid")
//    private int businessId;

    @Column(name="uid")
    private int userId;

    public Property(){

    }

    public Property(String type, String address, int numberOfRooms, int floor, int totalFloors, String heating, int size) {
        this.type = type;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
        this.totalFloors = totalFloors;
        this.heating = heating;
        this.size = size;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getBusinessId() {
//        return businessId;
//    }
//
//    public void setBusinessId(int businessId) {
//        this.businessId = businessId;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", floor=" + floor +
                ", totalFloors=" + totalFloors +
                ", heating='" + heating + '\'' +
                ", business=" + business +
                ", size='" + size + '\'' +
                '}';
    }
}
