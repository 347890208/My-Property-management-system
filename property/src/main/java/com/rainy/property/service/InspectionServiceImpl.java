package com.rainy.property.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.property.mapper.InspectionMapper;
import com.rainy.property.service.impl.InspectionService;
/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: InspectionServiceImpl
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@Service
public class InspectionServiceImpl implements InspectionService{

    @Resource
    private InspectionMapper inspectionMapper;

}
