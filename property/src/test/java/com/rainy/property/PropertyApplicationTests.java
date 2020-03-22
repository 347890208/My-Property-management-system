package com.rainy.property;

import com.rainy.property.domain.House;
import com.rainy.property.mapper.HouseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class PropertyApplicationTests {

    @Autowired
    HouseMapper houseMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        ListIterator<House> houseListIterator = houseMapper.selectAll().listIterator(3);
//        redisTemplate.opsForHash().putAll("jila", (Map<?, ?>) houseListIterator);


    }

    @Test
    void testhashmap(){

        House house = new House();
        house.setId("121");
        House house1 = houseMapper.selectOne(house);
        redisTemplate.opsForHash().put("honleins","osdfinoef",house1);
//        redisTemplate.opsForHash().delete("honleins","osdfinoef");
        redisTemplate.expire("honleins",1, TimeUnit.HOURS);
        House o = (House) redisTemplate.opsForHash().get("honleins", "osdfinoef");
        System.out.println(o);
    }

}
