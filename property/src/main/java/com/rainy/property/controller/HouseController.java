package com.rainy.property.controller;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import com.rainy.property.util.UrlUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: My-Property-management-system
 * @ClassName: HouseController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/12 17:46
 */
//@CrossOrigin(origins = "http://localhost:9527")
@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    HouseService houseService;

    @GetMapping("/resource/{id}")
    public House selectOneHouseById(@PathVariable String id){


        return houseService.selectHouseById(id);

    }

    @GetMapping("/list/")
    public UrlUtil selectAllByPage(@RequestParam(defaultValue = "id") String orderBy,
                                   @RequestParam(defaultValue = "1") int pageIndex,
                                   @RequestParam(defaultValue = "3") int pageSize){
        List<House> houses = houseService.selectAll(orderBy, pageIndex, pageSize);
        UrlUtil urlUtil = new UrlUtil(20000, houses);
        return urlUtil;
    }

    @GetMapping("/")
    public UrlUtil selectAll(){
        List<House> houses = houseService.selectListAll();
        UrlUtil urlUtil = new UrlUtil(20000, houses);
        return urlUtil;
    }

    @PostMapping("/")
    public House insertOne (@NotNull House house){

        try {
            if ("".equals(house.getId())){return null;}
            if ("".equals(house.getArea())){return null;}
            if ("".equals(house.getDep())){return null;}
            if ("".equals(house.getDirection())){return null;}
            if ("".equals(house.getFloor())){return null;}
            if ("".equals(house.getMemo())){return null;}
            if ("".equals(house.getNum())){return null;}
            if ("".equals(house.getOwnerid())){return null;}
            if ("".equals(house.getSell())){return null;}
            if ("".equals(house.getType())){return null;}
            if ("".equals(house.getUnit())){return null;}
            if ("".equals(house.getStatus())){return null;}
        } catch (Exception e){
            System.out.println("异常了");
        }
        houseService.insertOneHouse(house);
        return house;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById (@PathVariable String id){
        House house = new House();
        house.setId(id);

        return houseService.deleteByHouse(house);

    }

}
