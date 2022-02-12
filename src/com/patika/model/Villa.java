package com.patika.model;

import java.math.BigDecimal;

public class Villa extends Residence {

    public Villa(BigDecimal price, BigDecimal squareMeter, Integer numberOfLivingRoom, Integer numberOfRoom) {
        super(price, squareMeter, numberOfLivingRoom, numberOfRoom);
    }

}
