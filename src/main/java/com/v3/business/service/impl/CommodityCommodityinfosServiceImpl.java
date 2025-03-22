package com.v3.business.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v3.business.mapper.CommodityCommodityinfosMapper;
import com.v3.business.model.CommodityCommodityinfos;
import com.v3.business.model.CommodityTypes;
import com.v3.business.service.CommodityCommodityinfosService;
import com.v3.business.service.CommodityTypesService;
import com.v3.business.vo.CommodityCommodityinfosQueryVo;
import com.v3.common.result.ResultCodeEnum;
import com.v3.system.exception.LanfException;
import com.v3.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表 Service实现类
 * @date 2024-06-24 23:41:35
 */
@Transactional
@Service
public class CommodityCommodityinfosServiceImpl extends ServiceImpl
        <CommodityCommodityinfosMapper, CommodityCommodityinfos> implements CommodityCommodityinfosService {
    @Autowired
    private CommodityCommodityinfosMapper commodityCommodityinfosMapper;

    @Autowired
    private CommodityTypesService commodityTypesService;

    @Autowired
    private FileService fileService;

    @Override
    public IPage<CommodityCommodityinfos> selectPage(Page<CommodityCommodityinfos> pageParam, CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo) {
        return commodityCommodityinfosMapper.selectPage(pageParam, commodityCommodityinfosQueryVo);
    }

    @Override
    public List<CommodityCommodityinfos> queryList(CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo) {
        List<CommodityCommodityinfos> result = commodityCommodityinfosMapper.queryList(commodityCommodityinfosQueryVo);
        return result;
    }

    @Override
    public boolean save(CommodityCommodityinfos commodityCommodityinfos) {
        MultipartFile file = commodityCommodityinfos.getFile();
        String filePath = null;
        if (file != null) {
            try {
                filePath = fileService.upload(file);
            } catch (Exception e) {
                e.printStackTrace();
                throw new LanfException(ResultCodeEnum.UPLOAD_ERROR);
            }
        }
        if (filePath != null) {
            commodityCommodityinfos.setImg(filePath);
        }
        int result = this.commodityCommodityinfosMapper.insert(commodityCommodityinfos);
        return result > 0;
    }

    @Override
    public boolean updateById(CommodityCommodityinfos commodityCommodityinfos) {
        MultipartFile file = commodityCommodityinfos.getFile();
        String filePath = null;
        if (file != null) {
            try {
                filePath = fileService.upload(file);
            } catch (Exception e) {
                e.printStackTrace();
                throw new LanfException(ResultCodeEnum.UPLOAD_ERROR);
            }
        }
        if (filePath != null) {
            commodityCommodityinfos.setImg(filePath);
        } else {
            if (!StringUtils.isEmpty(commodityCommodityinfos.getImg())) {
                CommodityCommodityinfos data = this.getById(commodityCommodityinfos.getId());
                commodityCommodityinfos.setImg(data.getImg());
            }
        }
        int row = this.commodityCommodityinfosMapper.updateById(commodityCommodityinfos);
        if (row <= 0) {
            throw new LanfException(ResultCodeEnum.UPDATE_ERROR);
        }
        return row > 0;
    }

    @Override
    public CommodityCommodityinfos getById(String id) {
        CommodityCommodityinfos commodityCommodityinfos = commodityCommodityinfosMapper.selectById(id);
        return commodityCommodityinfos;
    }

    @Override
    public List<CommodityCommodityinfos> getByIds(List<String> ids) {
        List<CommodityCommodityinfos> list = this.commodityCommodityinfosMapper.selectBatchIds(ids);
        return list;
    }

}
