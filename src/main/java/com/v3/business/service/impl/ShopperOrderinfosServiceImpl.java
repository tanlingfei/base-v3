package com.v3.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v3.business.mapper.ShopperOrderinfosMapper;
import com.v3.business.model.ShopperOrderinfos;
import com.v3.business.service.ShopperOrderinfosService;
import com.v3.business.vo.ShopperOrderinfosQueryVo;
import com.v3.common.result.ResultCodeEnum;
import com.v3.system.exception.LanfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description Service实现类
 * @date 2024-06-29 15:39:58
 */
@Transactional
@Service
public class ShopperOrderinfosServiceImpl extends ServiceImpl
        <ShopperOrderinfosMapper, ShopperOrderinfos> implements ShopperOrderinfosService {
    @Autowired
    private ShopperOrderinfosMapper shopperOrderinfosMapper;

    @Override
    public IPage<ShopperOrderinfos> selectPage(Page<ShopperOrderinfos> pageParam, ShopperOrderinfosQueryVo shopperOrderinfosQueryVo) {
        return shopperOrderinfosMapper.selectPage(pageParam, shopperOrderinfosQueryVo);
    }

    @Override
    public List<ShopperOrderinfos> queryList(ShopperOrderinfosQueryVo shopperOrderinfosQueryVo) {
        List<ShopperOrderinfos> result = shopperOrderinfosMapper.queryList(shopperOrderinfosQueryVo);
        return result;
    }

    @Override
    public boolean save(ShopperOrderinfos shopperOrderinfos) {
        int result = this.shopperOrderinfosMapper.insert(shopperOrderinfos);
        return result > 0;
    }

    @Override
    public boolean updateById(ShopperOrderinfos shopperOrderinfos) {
        int row = this.shopperOrderinfosMapper.updateById(shopperOrderinfos);
        if (row <= 0) {
            throw new LanfException(ResultCodeEnum.UPDATE_ERROR);
        }
        return row > 0;
    }

    @Override
    public ShopperOrderinfos getById(String id) {
        ShopperOrderinfos shopperOrderinfos = shopperOrderinfosMapper.selectById(id);
        return shopperOrderinfos;
    }

    @Override
    public List<ShopperOrderinfos> getByIds(List<String> ids) {
        List<ShopperOrderinfos> list = this.shopperOrderinfosMapper.selectBatchIds(ids);
        return list;
    }
}
