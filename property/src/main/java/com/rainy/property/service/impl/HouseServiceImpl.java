package com.rainy.property.service.impl;

import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.property.mapper.HouseMapper;

import java.util.concurrent.TimeUnit;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: HouseServiceImpl
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private HouseMapper houseMapper;
//
//    //    @Resource
//    Jedis jedis = new Jedis();


    @Override
    public House selectHouseById(String id) {
        String string = "House:id:"+id;
        if ("".equals(id)){
            return null;
        }


        //双重检测,防止缓存穿透
        House house = (House) redisTemplate.opsForValue().get(string);
        if (null == house){
            synchronized (this) {
                house = (House) redisTemplate.opsForValue().get(string);
                if (null == house){

                    System.out.println("MySQL查询");

                    House house1 = new House();
                    house1.setId(id);
                    house = houseMapper.selectOne(house1);
                    //查询并写入redis
                    redisTemplate.opsForValue().set(string,house1,4, TimeUnit.HOURS);
                }
            }


        }else {
            System.out.println("Redis查询House");
        }



        return house;

    }

}
