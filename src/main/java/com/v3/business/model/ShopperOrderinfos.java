package com.v3.business.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.v3.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author administrator
 * @version 1.0
 * @description po类
 * @date 2024-06-29 15:39:58
 */
@Data
@ApiModel(description = "")
@TableName("shopper_orderinfos")
public class ShopperOrderinfos extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "")
    @TableField("price")
    private java.math.BigDecimal price;
    @ApiModelProperty(value = "")
    @TableField("user_id")
    private String userId;
    @TableField(exist = false)
    private String userName;
    @ApiModelProperty(value = "")
    @TableField("state")
    private String state;
    @TableField(exist = false)
    private String[] cartids;
}
