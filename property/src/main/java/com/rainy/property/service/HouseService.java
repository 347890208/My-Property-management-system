package com.rainy.property.service;

import com.rainy.property.domain.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: My-Property-management-system
 * @ClassName: HouseService
 * @Description: 对House表管理的service
 * @Author: 34789
 * @Date: 2020/3/12 17:06
 */
public interface HouseService {
    /**
     * 通过id查找一个House
     *
     * @param id
     * @return
     */
    House selectHouseById(String id);

    /**
     * 分页查询所有
     * 在impl中有pageSize限定结果数
     * 当用户查询第二页后往redis中缓存后一页
     * 提高搜索效率
     * @param pageSize
     * @param pageIndex
     * @return
     */
    List<House> selectAll(@Param("pageSize")int pageSize,@Param("pageIndex") int pageIndex);

    /**
     * 插入一条House信息
     * @param house
     * @return
     */
    boolean insertOneHouse(House house);


}
