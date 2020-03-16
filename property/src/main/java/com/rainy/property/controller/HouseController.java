package com.rainy.property.controller;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

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
@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    HouseService houseService;

    @GetMapping("/resource/{id}")
    public House selectOneHouseById(@PathVariable String id){


        return houseService.selectHouseById(id);

    }

    @GetMapping("/")
    public List<House> selectAllByPage(@RequestParam(defaultValue = "id") String orderBy,
                                       @RequestParam(defaultValue = "3") int pageSize,
                                       @RequestParam(defaultValue = "1") int pageIndex){
        return houseService.selectAll(orderBy,pageSize,pageIndex);
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
