package com.v3.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.v3.business.model.CommodityCommodityinfos;
import com.v3.business.vo.CommodityCommodityinfosQueryVo;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表 Service接口
 * @date 2024-06-24 23:41:35
 */
public interface CommodityCommodityinfosService extends IService<CommodityCommodityinfos> {
    IPage<CommodityCommodityinfos> selectPage(Page<CommodityCommodityinfos> pageParam, CommodityCommodityinfosQueryVo queryVo);

    List<CommodityCommodityinfos> queryList(CommodityCommodityinfosQueryVo queryVo);

    public boolean save(CommodityCommodityinfos commodityCommodityinfos);

    public boolean updateById(CommodityCommodityinfos commodityCommodityinfos);

    public CommodityCommodityinfos getById(String id);

    public List<CommodityCommodityinfos> getByIds(List<String> ids);
}
