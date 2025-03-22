package com.v3.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.CommodityCommodityinfos;
import com.v3.business.vo.CommodityCommodityinfosQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表 Mapper层
 * @date 2024-06-24 23:41:35
 */
@Repository
@Mapper
public interface CommodityCommodityinfosMapper extends BaseMapper<CommodityCommodityinfos> {
    IPage<CommodityCommodityinfos> selectPage(Page<CommodityCommodityinfos> page, @Param("vo") CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo);

    List<CommodityCommodityinfos> queryList(@Param("vo") CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo);
}
