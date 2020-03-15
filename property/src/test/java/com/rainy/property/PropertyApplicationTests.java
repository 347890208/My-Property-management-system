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

}
