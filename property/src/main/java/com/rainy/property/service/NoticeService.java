package com.rainy.property.service;

import com.rainy.property.domain.Notice;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: NoticeService
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
public interface NoticeService{

        Notice selectOne(Notice notice);
}
