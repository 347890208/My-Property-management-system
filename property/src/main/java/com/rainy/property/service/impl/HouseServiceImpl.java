package com.rainy.property.service.impl;

import com.alibaba.druid.pool.vendor.NullExceptionSorter;
import com.rainy.property.domain.House;
import com.rainy.property.service.HouseService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.property.mapper.HouseMapper;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
    private RedisTemplate<String, House> redisTemplate;
    @Resource
    private HouseMapper houseMapper;
//    @Resource
//    private Redisson redisson;
    @Override
    public House selectHouseById(String id) {
        String string = "House:id:"+id;
        if ("".equals(id)){
            return null;
        }


        //双重检测,防止缓存穿透
        House house = redisTemplate.opsForValue().get(string);
        if (null == house){
            synchronized (this) {
                house = redisTemplate.opsForValue().get(string);
                if (null == house){
                    System.out.println("MySQL查询");
                    House house1 = new House();
                    house1.setId(id);
                    house = houseMapper.selectOne(house1);


                    //查询并写入redis
                    redisTemplate.opsForValue().set(string,house,4, TimeUnit.HOURS);
                }
            }
        }else {
            System.out.println("Redis查询House");
        }
        return house;
    }

    @Override
    public List<House> selectAll(String orderBy,int pageSize,int pageIndex) {
//        String key = "HouseAll:"+orderBy+":"+String.valueOf(pageSize)+":"+String.valueOf(pageIndex);
        pageIndex=3*(pageIndex-1);
//        String lockName = "Lock:House:Write";
//        //判断是否有缓存
//        if (redisTemplate.hasKey(key)) {
//        } else {
//            RLock rLock = redisson.getLock(lockName);
//            try  {
//                rLock.lock();
//                if (redisTemplate.hasKey(lockName)){
//
//                }
//            }finally {
//                rLock.unlock();
//            }
//        }
//        ListIterator<House> houseListIterator = houseMapper.selectAll().listIterator(3);
//        redisTemplate.opsForHash().putAll("jila", (Map<?, ?>) houseListIterator);
        //当pageIndex>=redisOn时,启动redis缓存
//        int redisOn = 2;
        List<House> houses = houseMapper.selectAllLimit(orderBy, pageSize, pageIndex);
//        if (pageIndex>=redisOn){
//            synchronized (this){}
//        }
        return houses;
    }

    @Override
    public boolean insertOneHouse(House house) {
//
//        if (null == house.getId()||houseMapper.existsWithPrimaryKey(house.getId())){
//            return false;
//        }
//        if (null == house.getArea()){
//            return false;
//        }
//        if (null == house.getDep()){
//
//        }
        House key = new House();
        key.setId(house.getId());
        boolean withPrimaryKey = houseMapper.existsWithPrimaryKey(key);
        if (withPrimaryKey){
            return this.updateHouse(house);
        }else {
            int insert = houseMapper.insert(house);
            if (insert!=0){
                redisTemplate.opsForValue().set("House:id:"+house.getId(),house,1,TimeUnit.DAYS);
            }else {
                return false;
            }
            System.out.println(insert);
        }

        return true;
    }

    @Override
    public boolean updateHouse(House house) {
        int i = houseMapper.updateByPrimaryKey(house);
        if (i!=0){

            redisTemplate.opsForValue().set("House:id:"+house.getId(),house,1,TimeUnit.DAYS);
        }
        return i != 0;
    }

    @Override
    public boolean deleteByHouse(House house) {
        return false;
    }


}
