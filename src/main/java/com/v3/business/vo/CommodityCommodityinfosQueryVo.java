package com.v3.business.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表 vo类
 * @date 2024-06-24 23:41:35
 */
@Data
public class CommodityCommodityinfosQueryVo {
    private String name;
    private String sezes;
    private String types;
    private String typesName;
    private java.math.BigDecimal price;
    private java.math.BigDecimal discount;
    private Integer stock;
    private Integer sold;
    private Integer likes;
    private String img;
    private String details;
    private Date createTimeBegin;
    private Date createTimeEnd;
    private Date updateTimeBegin;
    private Date updateTimeEnd;

    private Long page;
    private Long limit;

}

