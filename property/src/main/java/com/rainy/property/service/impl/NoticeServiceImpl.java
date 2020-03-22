package com.rainy.property.service.impl;

import com.rainy.property.domain.House;
import com.rainy.property.domain.Notice;
import com.rainy.property.service.NoticeService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.property.mapper.NoticeMapper;

import java.util.concurrent.TimeUnit;

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
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private RedisTemplate<String, Notice> redisTemplate;

    @Override
    public Notice selectOne(Notice notice) {

        String id = notice.getId();
        String string = "Notice:id:";
        if ("".equals(id)) {
            return null;
        }


        //双重检测,防止缓存穿透
        notice = (Notice) redisTemplate.opsForHash().get(string, id);
        if (null == notice) {
            synchronized (this) {
                notice = redisTemplate.opsForValue().get(string);
                if (null == notice) {
                    System.out.println("MySQL查询");
                    Notice notice1 = new Notice();
                    notice1.setId(id);
                    notice = noticeMapper.selectByPrimaryKey(notice1);


                    //查询并写入redis
                    redisTemplate.opsForValue().set(string, notice, 4, TimeUnit.HOURS);
                }
            }
        } else {
            System.out.println("Redis查询House");
        }
        return notice;

    }
}
