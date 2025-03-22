package com.v3.business.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.v3.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author administrator
 * @version 1.0
 * @description po类
 * @date 2024-06-30 01:15:21
 */
@Data
@ApiModel(description = "")
@TableName("shopper_cartinfos")
public class ShopperCartinfos extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "")
    @TableField("quantity")
    private Integer quantity;
    @ApiModelProperty(value = "")
    @TableField(exist = false)
    private BigDecimal price;
    @TableField("commodityInfos_id")
    private String commodityinfosId;
    @TableField(exist = false)
    private String commodityinfosName;
    @ApiModelProperty(value = "")
    @TableField("user_id")
    private String userId;
    @TableField(exist = false)
    private String userName;
}
