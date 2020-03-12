package com.rainy.property.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.property.mapper.NoticeMapper;
import com.rainy.property.service.impl.NoticeService;
/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: NoticeServiceImpl
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@Service
public class NoticeServiceImpl implements NoticeService{

    @Resource
    private NoticeMapper noticeMapper;

}
