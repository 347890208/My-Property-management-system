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
  * @ClassName: Notice
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/12 17:06
  * @version v1.0
  *
  */
@ApiModel(value="com-rainy-property-domain-Notice")
@Data
@Table(name = "notice")
public class Notice implements Serializable {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="公告ID")
    private String id;

    @Column(name = "content")
    @ApiModelProperty(value="公告内容")
    private String content;

    @Column(name = "ndate")
    @ApiModelProperty(value="公告日期")
    private Date ndate;

    @Column(name = "title")
    @ApiModelProperty(value="公告标题")
    private String title;

    @Column(name = "uper")
    @ApiModelProperty(value="上传者")
    private String uper;

    private static final long serialVersionUID = 1L;
}