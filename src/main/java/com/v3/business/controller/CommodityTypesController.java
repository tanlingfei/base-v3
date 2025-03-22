package com.v3.business.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.CommodityTypes;
import com.v3.business.service.CommodityTypesService;
import com.v3.business.vo.CommodityTypesQueryVo;
import com.v3.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author administrator
 * @version 1.0
 * @description 商品分类描述
 * @date 2024-06-24 23:05:25
 */
@Api(tags = "商品分类描述")
@RestController
@RequestMapping("/business/commodityTypes")
public class CommodityTypesController {
    @Autowired
    private CommodityTypesService commodityTypesService;


    @PreAuthorize("hasAuthority('bnt.commodityTypes.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "commodityTypesQueryVo", value = "查询对象", required = false)
                        CommodityTypesQueryVo commodityTypesQueryVo) {
        Page<CommodityTypes> pageParam = new Page<>(page, limit);
        IPage<CommodityTypes> pageModel = commodityTypesService.selectPage(pageParam, commodityTypesQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.list')")
    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    public Result list(@ApiParam(name = "commodityTypesQueryVo", value = "查询对象", required = false)
                       CommodityTypesQueryVo commodityTypesQueryVo) {
        List<CommodityTypes> list = commodityTypesService.queryList(commodityTypesQueryVo);
        return Result.ok(list);
    }

    // @PreAuthorize("hasAuthority('bnt.commodityTypes.list')")
    @CrossOrigin
    @ApiOperation(value = "所有商品分类描述列表")
    @GetMapping("findAll")
    public Result findAllCommodityTypes(@ApiParam(name = "commodityTypesQueryVo", value = "查询对象", required = false)
                                        CommodityTypesQueryVo commodityTypesQueryVo) {
        List<CommodityTypes> list = commodityTypesService.list(null);
        return Result.ok(list);
    }


    @PreAuthorize("hasAuthority('bnt.commodityTypes.list')")
    @ApiOperation(value = "获取商品分类描述")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        CommodityTypes commodityTypes = commodityTypesService.getById(id);
        return Result.ok(commodityTypes);
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.list')")
    @ApiOperation(value = "获取商品分类描述集合")
    @PostMapping("/getByIds")
    public Result getByIds(@RequestBody List<String> idList) {
        List<CommodityTypes> list = commodityTypesService.getByIds(idList);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.add')")
    @ApiOperation(value = "保存商品分类描述")
    @PostMapping("/save")
    public Result save(@RequestBody CommodityTypes commodityTypes) {
        commodityTypesService.save(commodityTypes);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.update')")
    @ApiOperation(value = "更新商品分类描述")
    @PutMapping("/update")
    public Result updateById(@RequestBody CommodityTypes commodityTypes) {
        commodityTypesService.updateById(commodityTypes);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.remove')")
    @ApiOperation(value = "删除商品分类描述")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        commodityTypesService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.commodityTypes.remove')")
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        boolean b = commodityTypesService.removeByIds(idList);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
