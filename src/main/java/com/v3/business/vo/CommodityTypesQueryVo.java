package com.v3.business.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author administrator
 * @version 1.0
 * @description 商品分类描述 vo类
 * @date 2024-06-24 23:05:25
 */
@Data
public class CommodityTypesQueryVo {
    private String seconds;
    private Date createTimeBegin;
    private Date createTimeEnd;
    private Date updateTimeBegin;
    private Date updateTimeEnd;
}

