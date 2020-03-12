package com.rainy.property.controller;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping("/one/{id}")
    public House selectOneHouseById(@PathVariable String id){


        return houseService.selectHouseById(id);

    }

    @GetMapping("/list/")
    public List<House> selectAllByPage(@PathVariable int pageSize,@PathVariable int pageIndex){
        return houseService.selectAll(pageSize,pageIndex);
    }

    @PostMapping("/")
    public boolean insertOne (House house){
        houseService.insertOneHouse(house);
        return true;
    }
}
