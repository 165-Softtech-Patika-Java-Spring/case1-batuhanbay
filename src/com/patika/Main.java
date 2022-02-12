package com.patika;

import com.patika.dao.ResidenceDao;
import com.patika.model.Residence;
import com.patika.service.ResidenceService;
import com.patika.util.ResidenceUtil;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ResidenceDao residenceDao = new ResidenceDao();
        ResidenceService residenceService = new ResidenceService(residenceDao);

        BigDecimal totalPriceOfHouse = residenceService.evaluateTotalPriceOfHomes();
        if (!totalPriceOfHouse.equals(BigDecimal.ZERO)) {
            System.out.println("Total Price Of Homes:" + totalPriceOfHouse);
        } else {
            System.out.println("Home list can not be empty and has not price of the house which is less than 0 or equal to 0");
        }

        BigDecimal totalPriceOfVillas = residenceService.evaluateTotalPriceOfVillas();
        if (!totalPriceOfVillas.equals(BigDecimal.ZERO)){
            System.out.println("Total Price Of Villas:" + totalPriceOfVillas);
        } else {
            System.out.println("Villa list can not be empty and has not price of the house which is less than 0 or equal to 0");
        }

        BigDecimal totalPriceOfSummerHouses = residenceService.evaluateTotalPriceOfSummerHouses();
        if (!totalPriceOfSummerHouses.equals(BigDecimal.ZERO)){
            System.out.println("Total Price Of Summer Houses:" + totalPriceOfSummerHouses);
        } else {
            System.out.println("Summer house list can not be empty and has not price of the house which is less than 0 or equal to 0");
        }

        BigDecimal totalPriceOfAllResidences = residenceService.evaluateTotalPriceOfAllResidences();
        if (!totalPriceOfAllResidences.equals(BigDecimal.ZERO)){
            System.out.println("Total Price Of All Residences:" + totalPriceOfAllResidences);
        } else {
            System.out.println("Residence list can not be empty and has not price of the residence which is less than 0 or equal to 0");
        }

        BigDecimal averageSquareMeterOfHomes = residenceService.evaluateAverageSquareMeterOfHomes();
        if (!averageSquareMeterOfHomes.equals(BigDecimal.ZERO)){
            System.out.println("Average Square Meter Of Homes: " + averageSquareMeterOfHomes);
        } else {
            System.out.println("Home list can not be empty and has not square meter of the home which is less than 0 or equal to 0");
        }

        BigDecimal averageSquareMeterOfVillas = residenceService.evaluateAverageSquareMeterOfVillas();
        if (!averageSquareMeterOfVillas.equals(BigDecimal.ZERO)){
            System.out.println("Average Square Meter Of Villas: " + averageSquareMeterOfVillas);
        } else {
            System.out.println("Villa list can not be empty and has not square meter of the villa which is less than 0 or equal to 0");
        }

        BigDecimal averageSquareMeterOfSummerHouses = residenceService.evaluateAverageSquareMeterOfSummerHouses();
        if (!averageSquareMeterOfSummerHouses.equals(BigDecimal.ZERO)){
            System.out.println("Average Square Meter Of Summer Houses: " + averageSquareMeterOfSummerHouses);
        } else {
            System.out.println("Summer house list can not be empty and has not square meter of the summer house which is less than 0 or equal to 0");
        }

        BigDecimal averageSquareMeterOfResidences = residenceService.evaluateAverageSquareMeterOfAllResidences();
        if (!averageSquareMeterOfResidences.equals(BigDecimal.ZERO)){
            System.out.println("Average Square Meter Of All Residences: " + averageSquareMeterOfResidences);
        } else {
            System.out.println("Residences list can not be empty and has not square meter of the summer house which is less than 0 or equal to 0");
        }
        System.out.println("-----------------------------------Response Filter According To Room And Living Room Number-----------------");
        List<Residence> filteredResidences =  residenceService.filterResidencesByRoomAndLivingRoom(1,1);
        if (!filteredResidences.isEmpty()){
            filteredResidences.forEach(
                    residence -> System.out.println(
                            "Residence id: "+ residence.getId() +
                            " Residence Room Number: " +residence.getNumberOfRoom() +
                            " Residence Living Room Number: " +
                            residence.getNumberOfLivingRoom() ));
        } else {
            System.out.println("There is not any residence which has specified room number and living room number!");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------");

            // You can validate if filter method works correctly by passing residence list which you want to validate!
            // Parameters which might be use for testing respectively:residenceDao.getHomeList(), residenceDao.getVillaList(), residenceDao.getSummerHouseList()
            ResidenceUtil.printResidence(residenceDao.getHomeList());

    }
}
