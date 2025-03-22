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
 * @description 商品分类描述 po类
 * @date 2024-06-24 23:05:25
 */
@Data
@ApiModel(description = "商品分类描述")
@TableName("commodity_types")
public class CommodityTypes extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "分类")
    @TableField("seconds")
    private String seconds;
}
