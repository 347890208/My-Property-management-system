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
    @ApiModelProperty(value="")
    private String id;

    @Column(name = "num")
    @ApiModelProperty(value="")
    private String num;

    @Column(name = "dep")
    @ApiModelProperty(value="")
    private String dep;

    @Column(name = "`type`")
    @ApiModelProperty(value="")
    private String type;

    @Column(name = "area")
    @ApiModelProperty(value="")
    private String area;

    @Column(name = "sell")
    @ApiModelProperty(value="")
    private String sell;

    @Column(name = "unit")
    @ApiModelProperty(value="")
    private String unit;

    @Column(name = "`floor`")
    @ApiModelProperty(value="")
    private String floor;

    @Column(name = "direction")
    @ApiModelProperty(value="")
    private String direction;

    @Column(name = "memo")
    @ApiModelProperty(value="")
    private String memo;

    @Column(name = "ownerid")
    @ApiModelProperty(value="")
    private String ownerid;

    private static final long serialVersionUID = 1L;
}