package com.v3.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.CommodityCommodityinfos;
import com.v3.business.service.CommodityCommodityinfosService;
import com.v3.business.vo.CommodityCommodityinfosQueryVo;
import com.v3.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author administrator
 * @version 1.0
 * @description 商品信息表
 * @date 2024-06-24 23:41:35
 */
@Api(tags = "商品信息表")
@RestController
@RequestMapping("/business/commodityCommodityinfos")
public class CommodityCommodityinfosController {
    @Autowired
    private CommodityCommodityinfosService commodityCommodityinfosService;


    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "commodityCommodityinfosQueryVo", value = "查询对象", required = false)
                        CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo, HttpServletRequest request) {
        Page<CommodityCommodityinfos> pageParam = new Page<>(page, limit);
        IPage<CommodityCommodityinfos> pageModel = commodityCommodityinfosService.selectPage(pageParam, commodityCommodityinfosQueryVo);
        Map<String, Object> data = new HashMap<>();
        data.put("vals", pageModel);
        data.put("ctxPath", "http://" + request.getServerName() + ":" + request.getServerPort());
        return Result.ok(data);
    }

    @ApiOperation(value = "获取分页列表 给前台调用")
    @CrossOrigin
    @GetMapping("/pageList")
    public Result pageList(
            @ApiParam(name = "commodityCommodityinfosQueryVo", value = "查询对象", required = false)
            CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo, HttpServletRequest request) {
        Page<CommodityCommodityinfos> pageParam = new Page<>(commodityCommodityinfosQueryVo.getPage(), commodityCommodityinfosQueryVo.getLimit());
        IPage<CommodityCommodityinfos> pageModel = commodityCommodityinfosService.selectPage(pageParam, commodityCommodityinfosQueryVo);
        Map<String, Object> data = new HashMap<>();
        data.put("vals", pageModel);
        data.put("ctxPath", "http://" + request.getServerName() + ":" + request.getServerPort());
        return Result.ok(data);
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.list')")
    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    public Result list(@ApiParam(name = "commodityCommodityinfosQueryVo", value = "查询对象", required = false)
                       CommodityCommodityinfosQueryVo commodityCommodityinfosQueryVo) {
        List<CommodityCommodityinfos> list = commodityCommodityinfosService.queryList(commodityCommodityinfosQueryVo);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.list')")
    @ApiOperation(value = "所有商品信息表列表")
    @GetMapping("findAll")
    public Result findAllCommodityCommodityinfos() {
        //调用service的方法实现查询所有的操作
        List<CommodityCommodityinfos> list = commodityCommodityinfosService.list(null);
        return Result.ok(list);
    }

    //@PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.list')")
    @ApiOperation(value = "获取商品信息表")
    @GetMapping("/get/{id}")
    @CrossOrigin
    public Result get(@PathVariable String id, HttpServletRequest request) {
        CommodityCommodityinfos commodityCommodityinfos = commodityCommodityinfosService.getById(id);
        if (StringUtils.isNotBlank(commodityCommodityinfos.getImg())) {
            commodityCommodityinfos.setImg("http://" + request.getServerName() + ":" + request.getServerPort() + commodityCommodityinfos.getImg());
        }
        return Result.ok(commodityCommodityinfos);
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.list')")
    @ApiOperation(value = "获取商品信息表集合")
    @PostMapping("/getByIds")
    public Result getByIds(@RequestBody List<String> idList) {
        List<CommodityCommodityinfos> list = commodityCommodityinfosService.getByIds(idList);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.add')")
    @ApiOperation(value = "保存商品信息表")
    @PostMapping("/save")
    public Result save(CommodityCommodityinfos commodityCommodityinfos) {
        commodityCommodityinfosService.save(commodityCommodityinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.update')")
    @ApiOperation(value = "更新商品信息表")
    @PutMapping("/update")
    public Result updateById(CommodityCommodityinfos commodityCommodityinfos) {
        commodityCommodityinfosService.updateById(commodityCommodityinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.remove')")
    @ApiOperation(value = "删除商品信息表")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        commodityCommodityinfosService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityCommodityinfos.remove')")
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        boolean b = commodityCommodityinfosService.removeByIds(idList);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
