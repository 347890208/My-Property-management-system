package com.rainy.property.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: House
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@ApiModel(value="com-rainy-property-domain-House")
@Data
@Table(name = "house")
public class House implements Serializable {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="house的id 主键")
    private String id;

    @Column(name = "num")
    @ApiModelProperty(value="门牌号")
    private String num;

    @Column(name = "dep")
    @ApiModelProperty(value="楼层数")
    private String dep;

    @Column(name = "`type`")
    @ApiModelProperty(value="户型")
    private String type;

    @Column(name = "area")
    @ApiModelProperty(value="区域")
    private String area;

    @Column(name = "sell")
    @ApiModelProperty(value="是否已售")
    private String sell;

    @Column(name = "unit")
    @ApiModelProperty(value="单元")
    private String unit;

    @Column(name = "`floor`")
    @ApiModelProperty(value="楼层数")
    private String floor;

    @Column(name = "direction")
    @ApiModelProperty(value="面向")
    private String direction;

    @Column(name = "memo")
    @ApiModelProperty(value="")
    private String memo;

    @Column(name = "ownerid")
    @ApiModelProperty(value="户主ID")
    private String ownerid;

    private static final long serialVersionUID = 1L;
}