package com.v3.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.v3.business.model.ShopperOrderinfos;
import com.v3.business.vo.ShopperOrderinfosQueryVo;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 * @author administrator
 * @version 1.0
 * @description Service接口
 * @date 2024-06-29 15:39:58
 */
public interface ShopperOrderinfosService extends IService<ShopperOrderinfos> {
    IPage<ShopperOrderinfos> selectPage(Page<ShopperOrderinfos> pageParam, ShopperOrderinfosQueryVo queryVo);

    List<ShopperOrderinfos> queryList(ShopperOrderinfosQueryVo queryVo);

    public boolean save(ShopperOrderinfos shopperOrderinfos);

    public boolean updateById(ShopperOrderinfos shopperOrderinfos);

    public ShopperOrderinfos getById(String id);

    public List<ShopperOrderinfos> getByIds(List<String> ids);
}
