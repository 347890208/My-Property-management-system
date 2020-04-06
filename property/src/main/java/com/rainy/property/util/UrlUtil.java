package com.rainy.property.util;

import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: property
 * @ClassName: urlUtil
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 34789
 * @Date: 2020/4/6 13:41
 */
@Data
public class UrlUtil {

    private int code;

    private Object data;

    public UrlUtil(int anInt, Object obj) {
        this.code = anInt;
        this.data = obj;
    }

}
