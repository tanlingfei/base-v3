package com.v3.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v3.business.mapper.ShopperCartinfosMapper;
import com.v3.business.model.ShopperCartinfos;
import com.v3.business.service.ShopperCartinfosService;
import com.v3.business.vo.ShopperCartinfosQueryVo;
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
 * @date 2024-06-30 01:15:21
 */
@Transactional
@Service
public class ShopperCartinfosServiceImpl extends ServiceImpl
        <ShopperCartinfosMapper, ShopperCartinfos> implements ShopperCartinfosService {
    @Autowired
    private ShopperCartinfosMapper shopperCartinfosMapper;

    @Override
    public IPage<ShopperCartinfos> selectPage(Page<ShopperCartinfos> pageParam, ShopperCartinfosQueryVo shopperCartinfosQueryVo) {
        return shopperCartinfosMapper.selectPage(pageParam, shopperCartinfosQueryVo);
    }

    @Override
    public List<ShopperCartinfos> queryList(ShopperCartinfosQueryVo shopperCartinfosQueryVo) {
        List<ShopperCartinfos> result = shopperCartinfosMapper.queryList(shopperCartinfosQueryVo);
        return result;
    }

    @Override
    public boolean save(ShopperCartinfos shopperCartinfos) {
        int result = this.shopperCartinfosMapper.insert(shopperCartinfos);
        return result > 0;
    }

    @Override
    public boolean updateById(ShopperCartinfos shopperCartinfos) {
        int row = this.shopperCartinfosMapper.updateById(shopperCartinfos);
        if (row <= 0) {
            throw new LanfException(ResultCodeEnum.UPDATE_ERROR);
        }
        return row > 0;
    }

    @Override
    public ShopperCartinfos getById(String id) {
        ShopperCartinfos shopperCartinfos = shopperCartinfosMapper.selectById(id);
        return shopperCartinfos;
    }

    @Override
    public List<ShopperCartinfos> getByIds(List<String> ids) {
        List<ShopperCartinfos> list = this.shopperCartinfosMapper.selectBatchIds(ids);
        return list;
    }
}
