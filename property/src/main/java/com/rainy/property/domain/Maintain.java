package com.rainy.property.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
  *
  * @ProjectName: My-Property-management-system
  * @ClassName: Maintain
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@ApiModel(value="com-rainy-property-domain-Maintain")
@Data
@Table(name = "maintain")
public class Maintain implements Serializable {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="")
    private String id;

    @Column(name = "thing")
    @ApiModelProperty(value="")
    private String thing;

    @Column(name = "`status`")
    @ApiModelProperty(value="")
    private String status;

    @Column(name = "homesnumber")
    @ApiModelProperty(value="")
    private String homesnumber;

    @Column(name = "sdate")
    @ApiModelProperty(value="")
    private Date sdate;

    @Column(name = "rdate")
    @ApiModelProperty(value="")
    private Date rdate;

    @Column(name = "tcost")
    @ApiModelProperty(value="")
    private Integer tcost;

    @Column(name = "scost")
    @ApiModelProperty(value="")
    private Integer scost;

    @Column(name = "maintainer")
    @ApiModelProperty(value="")
    private String maintainer;

    @Column(name = "smemo")
    @ApiModelProperty(value="")
    private String smemo;

    private static final long serialVersionUID = 1L;
}