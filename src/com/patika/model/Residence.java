package com.patika.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *  This class is abstract class which  has methods and properties for home entity, villa entity and summer house entity
 *
 */
public abstract class Residence {

    private String id = UUID.randomUUID().toString();;
    private BigDecimal price;
    private BigDecimal squareMeter;
    private Integer numberOfLivingRoom;
    private  Integer numberOfRoom;

    public Residence(BigDecimal  price, BigDecimal squareMeter, Integer numberOfLivingRoom, Integer numberOfRoom) {
        this.price = price;
        this.squareMeter = squareMeter;
        this.numberOfLivingRoom = numberOfLivingRoom;
        this.numberOfRoom = numberOfRoom;
    }

    public String getId() {
        return id;
    }

    public BigDecimal  getPrice() {
        return price;
    }

    public void setPrice(BigDecimal  price) {
        this.price = price;
    }

    public BigDecimal getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(BigDecimal squareMeter) {
        this.squareMeter = squareMeter;
    }

    public Integer getNumberOfLivingRoom() {
        return numberOfLivingRoom;
    }

    public void setNumberOfLivingRoom(Integer numberOfLivingRoom) {
        this.numberOfLivingRoom = numberOfLivingRoom;
    }

    public Integer getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(Integer numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }
}
