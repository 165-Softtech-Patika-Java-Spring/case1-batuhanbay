package com.patika.util;

import com.patika.model.Residence;

import java.math.BigDecimal;
import java.util.List;

public class ResidenceUtil {
    private ResidenceUtil(){

    }

    /**
     *  Check if residence list which is passed to this function, has  value less than zero or equal to zero for price
     *
     * @param residenceList Specifies the list of all type of residence
     * @return true if residence which is in residence list, has price value less than zero or equal to zero otherwise false.
     */
    public static  boolean checkPricesIsLessAndEqualsZero(List<Residence> residenceList){
        boolean isLessAndEqualsZeroValue = false;
        for (Residence residence : residenceList) {
            if(residence.getPrice().compareTo(BigDecimal.ZERO) <= 0){
                isLessAndEqualsZeroValue = true;
            }
        }
        return isLessAndEqualsZeroValue;
    }

    /**
     *  Check if residence list which is passed to this function, has  value less than zero or equal to zero for square meter
     *
     * @param residenceList Specifies the list of all type of residence
     * @return true if residence which is in residence list, has square meter value less than zero or equal to zero otherwise false.
     */
    public static  boolean checkSquareMetersIsLessAndEqualsZero(List<Residence> residenceList){
        boolean isLessAndEqualsZeroValue = false;
        for (Residence residence : residenceList) {
            if(residence.getSquareMeter().compareTo(BigDecimal.ZERO) <= 0){
                isLessAndEqualsZeroValue = true;
            }
        }
        return isLessAndEqualsZeroValue;
    }

    /**
     *  Print the list of the entities with its properties for test in main.
     *
     * @param residenceList Specifies the list of all type of residence.
     * @return void
     */
    public static void printResidence(List<Residence> residenceList){
        residenceList.forEach(residence -> System.out.println("Residence Id: " + residence.getId()
                + " Residence Price: " + residence.getPrice()
                + " Residence Room Number: " + residence.getNumberOfRoom()
                + " Residence Living Room Number: " + residence.getNumberOfLivingRoom()));
    }


}
