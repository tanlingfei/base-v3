package com.v3.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.v3.business.model.ShopperOrderinfosSub;
import com.v3.business.vo.ShopperOrderinfosSubQueryVo;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 订单商品表 Service接口
 * @date 2025-03-20 23:49:56
 */
public interface ShopperOrderinfosSubService extends IService<ShopperOrderinfosSub> {
    IPage<ShopperOrderinfosSub> selectPage(Page<ShopperOrderinfosSub> pageParam, ShopperOrderinfosSubQueryVo queryVo);

    List<ShopperOrderinfosSub> queryList(ShopperOrderinfosSubQueryVo queryVo);

    public boolean save(ShopperOrderinfosSub shopperOrderinfosSub);

    public boolean updateById(ShopperOrderinfosSub shopperOrderinfosSub);

    public ShopperOrderinfosSub getById(String id);

    public List<ShopperOrderinfosSub> getByIds(List<String> ids);
}
