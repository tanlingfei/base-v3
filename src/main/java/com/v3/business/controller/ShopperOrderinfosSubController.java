package com.v3.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.ShopperOrderinfosSub;
import com.v3.business.service.ShopperOrderinfosSubService;
import com.v3.business.vo.ShopperOrderinfosSubQueryVo;
import com.v3.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description 订单商品表
 * @date 2025-03-20 23:49:56
 */
@Api(tags = "订单商品表")
@RestController
@RequestMapping("/business/shopperOrderinfosSub")
public class ShopperOrderinfosSubController {
    @Autowired
    private ShopperOrderinfosSubService shopperOrderinfosSubService;

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "shopperOrderinfosSubQueryVo", value = "查询对象", required = false)
                        ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo) {
        Page<ShopperOrderinfosSub> pageParam = new Page<>(page, limit);
        IPage<ShopperOrderinfosSub> pageModel = shopperOrderinfosSubService.selectPage(pageParam, shopperOrderinfosSubQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.list')")
    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    public Result list(@ApiParam(name = "shopperOrderinfosSubQueryVo", value = "查询对象", required = false)
                       ShopperOrderinfosSubQueryVo shopperOrderinfosSubQueryVo) {
        List<ShopperOrderinfosSub> list = shopperOrderinfosSubService.queryList(shopperOrderinfosSubQueryVo);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.list')")
    @ApiOperation(value = "所有订单商品表列表")
    @GetMapping("findAll")
    public Result findAllShopperOrderinfosSub() {
        //调用service的方法实现查询所有的操作
        List<ShopperOrderinfosSub> list = shopperOrderinfosSubService.list(null);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.list')")
    @ApiOperation(value = "获取订单商品表")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        ShopperOrderinfosSub shopperOrderinfosSub = shopperOrderinfosSubService.getById(id);
        return Result.ok(shopperOrderinfosSub);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.list')")
    @ApiOperation(value = "获取订单商品表集合")
    @PostMapping("/getByIds")
    public Result getByIds(@RequestBody List<String> idList) {
        List<ShopperOrderinfosSub> list = shopperOrderinfosSubService.getByIds(idList);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.add')")
    @ApiOperation(value = "保存订单商品表")
    @PostMapping("/save")
    public Result save(@RequestBody ShopperOrderinfosSub shopperOrderinfosSub) {
        shopperOrderinfosSubService.save(shopperOrderinfosSub);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.update')")
    @ApiOperation(value = "更新订单商品表")
    @PutMapping("/update")
    public Result updateById(@RequestBody ShopperOrderinfosSub shopperOrderinfosSub) {
        shopperOrderinfosSubService.updateById(shopperOrderinfosSub);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.remove')")
    @ApiOperation(value = "删除订单商品表")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        shopperOrderinfosSubService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfosSub.remove')")
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        boolean b = shopperOrderinfosSubService.removeByIds(idList);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
