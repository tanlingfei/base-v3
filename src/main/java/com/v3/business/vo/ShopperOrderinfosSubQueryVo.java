package com.v3.business.vo;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
* @author administrator
* @version 1.0
* @description 订单商品表 vo类
* @date 2025-03-20 23:49:56
*/
@Data
public class ShopperOrderinfosSubQueryVo {
       private String orderId;
       private String commodityId;
       private String quantity;
       private Date createTimeBegin;
       private Date createTimeEnd;
       private Date updateTimeBegin;
       private Date updateTimeEnd;
}

