package com.v3.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v3.business.mapper.CommodityTypesMapper;
import com.v3.business.model.CommodityTypes;
import com.v3.business.service.CommodityTypesService;
import com.v3.business.vo.CommodityTypesQueryVo;
import com.v3.common.result.ResultCodeEnum;
import com.v3.system.exception.LanfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author administrator
 * @version 1.0
 * @description 商品分类描述 Service实现类
 * @date 2024-06-24 23:05:25
 */
@Transactional
@Service
public class CommodityTypesServiceImpl extends ServiceImpl
        <CommodityTypesMapper, CommodityTypes> implements CommodityTypesService {
    @Autowired
    private CommodityTypesMapper commodityTypesMapper;

    @Override
    public IPage<CommodityTypes> selectPage(Page<CommodityTypes> pageParam, CommodityTypesQueryVo commodityTypesQueryVo) {
        return commodityTypesMapper.selectPage(pageParam, commodityTypesQueryVo);
    }

    @Override
    public List<CommodityTypes> queryList(CommodityTypesQueryVo commodityTypesQueryVo) {
        List<CommodityTypes> result = commodityTypesMapper.queryList(commodityTypesQueryVo);
        return result;
    }

    @Override
    public boolean save(CommodityTypes commodityTypes) {
        int result = this.commodityTypesMapper.insert(commodityTypes);
        return result > 0;
    }

    @Override
    public boolean updateById(CommodityTypes commodityTypes) {
        int row = this.commodityTypesMapper.updateById(commodityTypes);
        if (row <= 0) {
            throw new LanfException(ResultCodeEnum.UPDATE_ERROR);
        }
        return row > 0;
    }

    @Override
    public CommodityTypes getById(String id) {
        CommodityTypes commodityTypes = commodityTypesMapper.selectById(id);
        return commodityTypes;
    }

    @Override
    public List<CommodityTypes> getByIds(List<String> ids) {
        List<CommodityTypes> list = this.commodityTypesMapper.selectBatchIds(ids);
        return list;
    }

    @Override
    public List<Map> getAllTypesFirst() {
        return this.commodityTypesMapper.getAllTypesFirst();
    }

}
