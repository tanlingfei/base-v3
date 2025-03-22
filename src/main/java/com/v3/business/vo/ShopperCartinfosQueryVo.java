package com.v3.business.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author administrator
 * @version 1.0
 * @description vo类
 * @date 2024-06-30 01:15:21
 */
@Data
public class ShopperCartinfosQueryVo {
    private Integer quantity;
    private String commodityinfosId;
    private String commodityinfosName;
    private String userId;
    private String userName;
    private Date createTimeBegin;
    private Date createTimeEnd;
    private Date updateTimeBegin;
    private Date updateTimeEnd;
}

