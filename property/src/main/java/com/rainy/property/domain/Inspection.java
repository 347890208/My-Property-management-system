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
  * @ClassName: Inspection
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@ApiModel(value="com-rainy-property-domain-Inspection")
@Data
@Table(name = "inspection")
public class Inspection implements Serializable {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="")
    private String id;

    @Column(name = "person")
    @ApiModelProperty(value="")
    private String person;

    @Column(name = "`type`")
    @ApiModelProperty(value="")
    private String type;

    @Column(name = "itime")
    @ApiModelProperty(value="")
    private Date itime;

    @Column(name = "conductor")
    @ApiModelProperty(value="")
    private String conductor;

    @Column(name = "party")
    @ApiModelProperty(value="")
    private String party;

    @Column(name = "`result`")
    @ApiModelProperty(value="")
    private String result;

    @Column(name = "memo")
    @ApiModelProperty(value="")
    private String memo;

    private static final long serialVersionUID = 1L;
}