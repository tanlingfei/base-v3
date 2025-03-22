package com.v3.business.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.v3.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表 po类
 * @date 2024-06-24 23:41:35
 */
@Data
@ApiModel(description = "商品信息表")
@TableName("commodity_commodityinfos")
public class CommodityCommodityinfos extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "商品名称")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "颜色规格")
    @TableField("sezes")
    private String sezes;
    @ApiModelProperty(value = "二级分类")
    @TableField("types")
    private String types;
    @TableField(exist = false)
    private String typesName;
    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private java.math.BigDecimal price;
    @ApiModelProperty(value = "折后价格")
    @TableField("discount")
    private java.math.BigDecimal discount;
    @ApiModelProperty(value = "存货数量")
    @TableField("stock")
    private Integer stock;
    @ApiModelProperty(value = "已售数量")
    @TableField("sold")
    private Integer sold;
    @ApiModelProperty(value = "收藏数量")
    @TableField("likes")
    private Integer likes;
    @ApiModelProperty(value = "商品主图")
    @TableField("img")
    private String img;
    @ApiModelProperty(value = "商品介绍图")
    @TableField("details")
    private String details;

    //商品主图文件对象
    @TableField(exist = false)
    private MultipartFile file;
}
