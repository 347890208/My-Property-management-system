package com.rainy.property.mapper;

import com.rainy.property.domain.House;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version v1.0
 * @ProjectName: My-Property-management-system
 * @ClassName: HouseMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/12 17:06
 */
@Mapper
public interface HouseMapper extends tk.mybatis.mapper.common.Mapper<House> {


    /**
     * 分页查询
     *
     * @param orderBy
     * @param pageSize
     * @param pageIndex
     * @return
     */


}