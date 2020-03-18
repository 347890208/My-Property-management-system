package com.rainy.property.mapper;

import com.rainy.property.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: NoticeMapper
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@Mapper
public interface NoticeMapper extends tk.mybatis.mapper.common.Mapper<Notice> {
    Map<String,Object> findAllById();


}