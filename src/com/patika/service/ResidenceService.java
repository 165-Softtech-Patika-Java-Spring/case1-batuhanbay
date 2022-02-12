package com.patika.service;

import com.patika.dao.ResidenceDao;
import com.patika.model.Residence;
import com.patika.util.ResidenceUtil;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResidenceService {

    private  ResidenceDao residenceDao;

    // Precision value is for result of the divide operation. If the result of the divide operation has digit more than precision value,
    // digit of the result  will be precision value.
    private final  MathContext precision  = new MathContext(5);

    public ResidenceService(ResidenceDao residenceDao) {
        this.residenceDao = residenceDao;
    }

    // Method which is responsible to evaluate total price of homes
    public BigDecimal evaluateTotalPriceOfHomes(){
        List<Residence> homeList = residenceDao.getHomeList();
        BigDecimal totalPrice = new BigDecimal("0");
        if (!homeList.isEmpty() && !ResidenceUtil.checkPricesIsLessAndEqualsZero(homeList)){
            totalPrice = homeList.stream().map(Residence::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return  totalPrice;
    }

    // Method which is responsible to evaluate total price of all villas
    public BigDecimal evaluateTotalPriceOfVillas(){
        List<Residence> villaList = residenceDao.getVillaList();
        BigDecimal totalPrice = new BigDecimal("0");
        if (!ResidenceUtil.checkPricesIsLessAndEqualsZero(villaList)){
            totalPrice  = villaList.stream().map(Residence::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return  totalPrice;
    }

    // Method which is responsible to evaluate total price of all summer houses
    public BigDecimal evaluateTotalPriceOfSummerHouses(){
        List<Residence> summerHouseListList = residenceDao.getSummerHouseList();
        BigDecimal totalPrice = new BigDecimal("0");
        if (!summerHouseListList.isEmpty() && !ResidenceUtil.checkPricesIsLessAndEqualsZero(summerHouseListList)){
            totalPrice = summerHouseListList.stream().map(Residence::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return totalPrice;
    }

    // Method which is responsible to evaluate total price of all residences
    public BigDecimal evaluateTotalPriceOfAllResidences(){
        List<Residence> residenceList = residenceDao.getResidences();
        BigDecimal totalPrice = new BigDecimal("0");
        if (!residenceList.isEmpty() && !ResidenceUtil.checkPricesIsLessAndEqualsZero(residenceList)){
            totalPrice = residenceList.stream().map(Residence::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return totalPrice;
    }

    // Method which is responsible to evaluate average square meters of houses
    public BigDecimal evaluateAverageSquareMeterOfHomes(){
        List<Residence> homeList = residenceDao.getHomeList();
        BigDecimal averageSquareMeter = new BigDecimal("0");
        if (!homeList.isEmpty() && !ResidenceUtil.checkSquareMetersIsLessAndEqualsZero(homeList)){
            BigDecimal totalSquareMeter = evaluateTotalSquareMeterOfHomes();
            BigDecimal divisor = BigDecimal.valueOf(homeList.size());
            averageSquareMeter = totalSquareMeter.divide(divisor,precision);
        }
        return averageSquareMeter;
    }

    // Method which is responsible to evaluate average square meters of villas
    public BigDecimal evaluateAverageSquareMeterOfVillas(){
        List<Residence> villaList = residenceDao.getVillaList();
        BigDecimal averageSquareMeter = new BigDecimal("0");
        if (!villaList.isEmpty() && !ResidenceUtil.checkSquareMetersIsLessAndEqualsZero(villaList)) {
            BigDecimal sumSquareMeter = evaluateTotalSquareMeterOfVillas();
            BigDecimal divisor = BigDecimal.valueOf(villaList.size());
            averageSquareMeter = sumSquareMeter.divide(divisor, precision);
        }
        return averageSquareMeter;
    }

    // Method which is responsible to evaluate average square meters of summer houses
    public BigDecimal evaluateAverageSquareMeterOfSummerHouses(){
        List<Residence> summerHouseList = residenceDao.getSummerHouseList();
        BigDecimal averageSquareMeter = new BigDecimal("0");
        if (!summerHouseList.isEmpty() && !ResidenceUtil.checkSquareMetersIsLessAndEqualsZero(summerHouseList)) {
            BigDecimal sumSquareMeter = evaluateTotalSquareMeterOfSummerHouses();
            BigDecimal divisor = BigDecimal.valueOf(summerHouseList.size());
            averageSquareMeter = sumSquareMeter.divide(divisor, precision);
        }
        return averageSquareMeter;
    }

    // Method which is responsible to evaluate average square meters of all residences
    public BigDecimal evaluateAverageSquareMeterOfAllResidences(){
        List<Residence> residencesList = residenceDao.getResidences();
        BigDecimal averageSquareMeter = new BigDecimal("0");
        if (!residencesList.isEmpty() && !ResidenceUtil.checkSquareMetersIsLessAndEqualsZero(residencesList)){
            BigDecimal sumSquareMeter = evaluateTotalSquareMeterOfResidences();
            BigDecimal divisor = BigDecimal.valueOf(residencesList.size());
            averageSquareMeter = sumSquareMeter.divide(divisor,precision);
        }
        return  averageSquareMeter;
    }

    // Method which is responsible to filter according to room and living room number
    public List<Residence> filterResidencesByRoomAndLivingRoom(Integer room, Integer livingRoom) {
        List<Residence> filteredResidenceList =  new ArrayList<>();
        List<Residence> residenceList = residenceDao.getResidences();
        if (!residenceList.isEmpty()){
            filteredResidenceList = residenceList.stream()
                    .filter(residence -> residence.getNumberOfRoom().equals(room) && residence.getNumberOfLivingRoom().equals(livingRoom))
                    .collect(Collectors.toList());
        }
        return filteredResidenceList;
    }

    // Method which is responsible to evaluate total price of houses in order to use evaluate average of square meters.
    private BigDecimal evaluateTotalSquareMeterOfHomes(){
        return residenceDao.getHomeList().stream().map(Residence::getSquareMeter).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Method which is responsible to evaluate total price of villas in order to use evaluate average of square meters.
    private  BigDecimal evaluateTotalSquareMeterOfVillas(){
        return residenceDao.getVillaList().stream().map(Residence::getSquareMeter).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Method which is responsible to evaluate total price of summer houses in order to use evaluate average of square meters.
    private  BigDecimal evaluateTotalSquareMeterOfSummerHouses(){
        return residenceDao.getSummerHouseList().stream().map(Residence::getSquareMeter).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Method which is responsible to evaluate total price of all residences in order to use evaluate average of square meters.
    private BigDecimal evaluateTotalSquareMeterOfResidences(){
        return residenceDao.getResidences().stream().map(Residence::getSquareMeter).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
