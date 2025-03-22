package com.v3.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.ShopperOrderinfos;
import com.v3.business.vo.ShopperOrderinfosQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description Mapper层
 * @date 2024-06-29 15:39:58
 */
@Repository
@Mapper
public interface ShopperOrderinfosMapper extends BaseMapper<ShopperOrderinfos> {
    IPage<ShopperOrderinfos> selectPage(Page<ShopperOrderinfos> page, @Param("vo") ShopperOrderinfosQueryVo shopperOrderinfosQueryVo);

    List<ShopperOrderinfos> queryList(@Param("vo") ShopperOrderinfosQueryVo shopperOrderinfosQueryVo);
}
