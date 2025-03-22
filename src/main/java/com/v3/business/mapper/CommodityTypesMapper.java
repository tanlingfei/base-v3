package com.v3.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.CommodityTypes;
import com.v3.business.vo.CommodityTypesQueryVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author administrator
 * @version 1.0
 * @description 商品分类描述 Mapper层
 * @date 2024-06-24 23:05:25
 */
@Repository
@Mapper
public interface CommodityTypesMapper extends BaseMapper<CommodityTypes> {
    IPage<CommodityTypes> selectPage(Page<CommodityTypes> page, @Param("vo") CommodityTypesQueryVo commodityTypesQueryVo);

    List<CommodityTypes> queryList(@Param("vo") CommodityTypesQueryVo commodityTypesQueryVo);

    @MapKey("id")
    List<Map> getAllTypesFirst();
}
