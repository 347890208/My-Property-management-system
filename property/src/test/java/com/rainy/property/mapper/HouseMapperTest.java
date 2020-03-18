package com.rainy.property.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;

/**
 * @version v1.0
 * @ProjectName: property
 * @ClassName: HouseMapperTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/18 14:23
 */
public class HouseMapperTest {
    private static HouseMapper mapper;

    @org.junit.BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(HouseMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/HouseMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(HouseMapper.class, builder.openSession(true));
    }

    @org.junit.Test
    public void testSelectAllLimit() throws FileNotFoundException {
        mapper.selectAllLimit("id",3,1);
    }
}
