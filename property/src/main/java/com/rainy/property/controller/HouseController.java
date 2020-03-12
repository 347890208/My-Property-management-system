package com.rainy.property.controller;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version v1.0
 * @ProjectName: My-Property-management-system
 * @ClassName: HouseController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/12 17:46
 */
@RestController
public class HouseController {

    @Resource
    HouseService houseService;

    @GetMapping("/house/{id}")
    public House selectOneHouseById(@PathVariable String id){


        return houseService.selectHouseById(id);

    }

}
