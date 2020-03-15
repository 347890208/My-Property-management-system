package com.rainy.property.controller;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
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
@RestController
@RequestMapping("/house")
public class HouseController {

    @Resource
    HouseService houseService;

    @GetMapping("/one/")
    public House selectOneHouseById(@PathVariable String id){


        return houseService.selectHouseById(id);

    }

    @GetMapping("/list/")
    public List<House> selectAllByPage(@RequestParam(defaultValue = "id") String orderBy,
                                       @RequestParam(defaultValue = "3") int pageSize,
                                       @RequestParam(defaultValue = "1") int pageIndex){
        return houseService.selectAll(orderBy,pageSize,pageIndex);
    }

    @PostMapping("/")
    public boolean insertOne (@NotNull House house){

        try {
            if ("".equals(house.getId())){return false;}
            if ("".equals(house.getArea())){return false;}
            if ("".equals(house.getDep())){return false;}
            if ("".equals(house.getDirection())){return false;}
            if ("".equals(house.getFloor())){return false;}
            if ("".equals(house.getMemo())){return false;}
            if ("".equals(house.getNum())){return false;}
            if ("".equals(house.getOwnerid())){return false;}
            if ("".equals(house.getSell())){return false;}
            if ("".equals(house.getType())){return false;}
            if ("".equals(house.getUnit())){return false;}

        } catch (Exception e){
            System.out.println("异常了");
        }
        houseService.insertOneHouse(house);
        return true;
    }


}
