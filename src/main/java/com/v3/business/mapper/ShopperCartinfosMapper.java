package com.v3.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.ShopperCartinfos;
import com.v3.business.vo.ShopperCartinfosQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description Mapper层
 * @date 2024-06-30 01:15:21
 */
@Repository
@Mapper
public interface ShopperCartinfosMapper extends BaseMapper<ShopperCartinfos> {
    IPage<ShopperCartinfos> selectPage(Page<ShopperCartinfos> page, @Param("vo") ShopperCartinfosQueryVo shopperCartinfosQueryVo);

    List<ShopperCartinfos> queryList(@Param("vo") ShopperCartinfosQueryVo shopperCartinfosQueryVo);
}
