package com.v3.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.ShopperOrderinfosSub;
import com.v3.business.vo.ShopperOrderinfosSubQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 订单商品表 Mapper层
 * @date 2025-03-20 23:49:56
 */
@Repository
@Mapper
public interface ShopperOrderinfosSubMapper extends BaseMapper<ShopperOrderinfosSub> {
    IPage<ShopperOrderinfosSub> selectPage(Page<ShopperOrderinfosSub> page, @Param("vo") ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo);

    List<ShopperOrderinfosSub> queryList(@Param("vo") ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo);
}
