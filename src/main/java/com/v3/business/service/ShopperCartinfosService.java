package com.v3.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.v3.business.model.ShopperCartinfos;
import com.v3.business.vo.ShopperCartinfosQueryVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description Service接口
 * @date 2024-06-30 01:15:21
 */
public interface ShopperCartinfosService extends IService<ShopperCartinfos> {
    IPage<ShopperCartinfos> selectPage(Page<ShopperCartinfos> pageParam, ShopperCartinfosQueryVo queryVo);

    List<ShopperCartinfos> queryList(ShopperCartinfosQueryVo queryVo);

    public boolean save(ShopperCartinfos shopperCartinfos);

    public boolean updateById(ShopperCartinfos shopperCartinfos);

    public ShopperCartinfos getById(String id);

    public List<ShopperCartinfos> getByIds(List<String> ids);
}
