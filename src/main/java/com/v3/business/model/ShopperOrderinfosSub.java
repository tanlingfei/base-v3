package com.v3.business.model;

import com.v3.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
/**
* @author administrator
* @version 1.0
* @description 订单商品表 po类
* @date 2025-03-20 23:49:56
*/
@Data
@ApiModel(description = "订单商品表")
@TableName("shopper_orderinfos_sub")
public class ShopperOrderinfosSub extends BaseEntity {
        private static final long serialVersionUID = 1L;
        @ApiModelProperty(value = "订单id")
        @TableField("order_id")
        private String orderId;
        @ApiModelProperty(value = "商品id")
        @TableField("commodity_id")
        private String commodityId;
        @ApiModelProperty(value = "商品数量")
        @TableField("quantity")
        private Integer quantity;
        @ApiModelProperty(value = "商品名称")
        @TableField(exist = false)
        private String commodityName;
}
