package com.rainy.property.util;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @version v1.0
 * @ProjectName: property
 * @ClassName: MessageUtil
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/3/15 15:47
 */
@Data
public class MessageUtil {
    private static ConcurrentHashMap<String,String> message;

    private static ConcurrentHashMap<String,String> information;

    static {


    }

}
