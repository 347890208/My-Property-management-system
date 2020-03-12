package com.rainy.property.service;

import com.rainy.property.domain.House;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: HouseService
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
public interface HouseService{
    /**
     * 通过id查找一个House
     * @param id
     * @return
     */
    House selectHouseById(String id);


}
