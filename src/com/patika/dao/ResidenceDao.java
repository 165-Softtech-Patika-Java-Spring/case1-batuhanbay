package com.patika.dao;

import com.patika.model.Home;
import com.patika.model.Residence;
import com.patika.model.SummerHouse;
import com.patika.model.Villa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResidenceDao {
    private  List<Residence> homeList;
    private  List<Residence> villaList;
    private  List<Residence> summerHouseList;
    private  List<Residence> residences;

    public ResidenceDao() {
        this.homeList = Arrays.asList(
                new Home(new BigDecimal("20000"),new BigDecimal("110"), 2,5),
                new Home(new BigDecimal("15000"),new BigDecimal("90"), 1,3),
                new Home(new BigDecimal("5000"),new BigDecimal("50"), 1,1)
                );
        this.villaList = Arrays.asList(
                new Villa(new BigDecimal("40000"),new BigDecimal("150"), 1,5),
                new Villa(new BigDecimal("60000"),new BigDecimal("120"), 1,3),
                new Villa(new BigDecimal("20000"),new BigDecimal("100"), 1,1)
                );
        this.summerHouseList = Arrays.asList(
                new SummerHouse(new BigDecimal("30000"),new BigDecimal("180"),1,3),
                new SummerHouse(new BigDecimal("60000"),new BigDecimal("100"),1,1),
                new SummerHouse(new BigDecimal("45000"),new BigDecimal("220"),2,5),
                new SummerHouse(new BigDecimal("5000"),new BigDecimal("50"),1,1)
        );
        this.residences = setResidencesList(this.homeList, this.villaList, this.summerHouseList);
    }

    public List<Residence> getHomeList(){
        return this.homeList;
    }

    public List<Residence> getVillaList(){
        return this.villaList;
    }

    public List<Residence> getSummerHouseList(){
        return this.summerHouseList;
    }

    public List<Residence> getResidences(){
        return this.residences;
    }

    private  List<Residence> setResidencesList(List<Residence> homeList, List<Residence> villaList, List<Residence> summerHouseList){
        List<Residence> residenceList = new ArrayList<>();
        residenceList.addAll(homeList);
        residenceList.addAll(villaList);
        residenceList.addAll(summerHouseList);
        return residenceList;
    }
}
