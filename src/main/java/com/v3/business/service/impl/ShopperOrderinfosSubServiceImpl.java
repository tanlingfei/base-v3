package com.v3.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v3.business.mapper.ShopperOrderinfosSubMapper;
import com.v3.business.model.ShopperOrderinfosSub;
import com.v3.business.service.ShopperOrderinfosSubService;
import com.v3.business.vo.ShopperOrderinfosSubQueryVo;
import com.v3.common.result.ResultCodeEnum;
import com.v3.system.exception.LanfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 订单商品表 Service实现类
 * @date 2025-03-20 23:49:56
 */
@Transactional
@Service
public class ShopperOrderinfosSubServiceImpl extends ServiceImpl
        <ShopperOrderinfosSubMapper, ShopperOrderinfosSub> implements ShopperOrderinfosSubService {
    @Autowired
    private ShopperOrderinfosSubMapper shopperOrderinfosSubMapper;

    @Override
    public IPage<ShopperOrderinfosSub> selectPage(Page<ShopperOrderinfosSub> pageParam, ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo) {
        return shopperOrderinfosSubMapper.selectPage(pageParam, shopperOrderinfosSubQueryVo);
    }

    @Override
    public List<ShopperOrderinfosSub> queryList(ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo) {
        List<ShopperOrderinfosSub> result = shopperOrderinfosSubMapper.queryList(shopperOrderinfosSubQueryVo);
        return result;
    }

    @Override
    public boolean save(ShopperOrderinfosSub shopperOrderinfosSub) {
        int result = this.shopperOrderinfosSubMapper.insert(shopperOrderinfosSub);
        return result > 0;
    }

    @Override
    public boolean updateById(ShopperOrderinfosSub shopperOrderinfosSub) {
        int row = this.shopperOrderinfosSubMapper.updateById(shopperOrderinfosSub);
        if (row <= 0) {
            throw new LanfException(ResultCodeEnum.UPDATE_ERROR);
        }
        return row > 0;
    }

    @Override
    public ShopperOrderinfosSub getById(String id) {
        ShopperOrderinfosSub shopperOrderinfosSub = shopperOrderinfosSubMapper.selectById(id);
        return shopperOrderinfosSub;
    }

    @Override
    public List<ShopperOrderinfosSub> getByIds(List<String> ids) {
        List<ShopperOrderinfosSub> list = this.shopperOrderinfosSubMapper.selectBatchIds(ids);
        return list;
    }
}
