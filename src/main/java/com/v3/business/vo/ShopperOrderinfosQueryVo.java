package com.v3.business.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author administrator
 * @version 1.0
 * @description vo类
 * @date 2024-06-29 15:39:58
 */
@Data
public class ShopperOrderinfosQueryVo {
    private java.math.BigDecimal price;
    private String userId;
    private String userName;
    private String state;
    private Date createTimeBegin;
    private Date createTimeEnd;
    private Date updateTimeBegin;
    private Date updateTimeEnd;
    private String id;
}

