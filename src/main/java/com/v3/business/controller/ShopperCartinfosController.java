package com.v3.business.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.ShopperCartinfos;
import com.v3.business.service.ShopperCartinfosService;
import com.v3.business.vo.ShopperCartinfosQueryVo;
import com.v3.common.result.Result;
import com.v3.system.utils.UserUtil;
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
 * @description
 * @date 2024-06-30 01:15:21
 */
@Api(tags = "")
@RestController
@RequestMapping("/business/shopperCartinfos")
public class ShopperCartinfosController {
    @Autowired
    private ShopperCartinfosService shopperCartinfosService;


    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "shopperCartinfosQueryVo", value = "查询对象", required = false)
                        ShopperCartinfosQueryVo shopperCartinfosQueryVo) {
        Page<ShopperCartinfos> pageParam = new Page<>(page, limit);
        IPage<ShopperCartinfos> pageModel = shopperCartinfosService.selectPage(pageParam, shopperCartinfosQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.listCart')")
    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    public Result list(@ApiParam(name = "shopperCartinfosQueryVo", value = "查询对象", required = false)
                       ShopperCartinfosQueryVo shopperCartinfosQueryVo) {
        String userId = UserUtil.getUserId();
        shopperCartinfosQueryVo.setUserId(userId);
        List<ShopperCartinfos> list = shopperCartinfosService.queryList(shopperCartinfosQueryVo);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.list')")
    @ApiOperation(value = "所有列表")
    @GetMapping("findAll")
    public Result findAllShopperCartinfos() {
        //调用service的方法实现查询所有的操作
        List<ShopperCartinfos> list = shopperCartinfosService.list(null);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.list')")
    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        ShopperCartinfos shopperCartinfos = shopperCartinfosService.getById(id);
        return Result.ok(shopperCartinfos);
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.list')")
    @ApiOperation(value = "获取集合")
    @PostMapping("/getByIds")
    public Result getByIds(@RequestBody List<String> idList) {
        List<ShopperCartinfos> list = shopperCartinfosService.getByIds(idList);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody ShopperCartinfos shopperCartinfos) {
        shopperCartinfosService.save(shopperCartinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.addCart')")
    @ApiOperation(value = "前台添加购物车")
    @PostMapping("/addCart")
    public Result addCart(@RequestBody ShopperCartinfos shopperCartinfos) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("commodityInfos_id", shopperCartinfos.getCommodityinfosId());
        queryWrapper.eq("user_id", UserUtil.getUserId());
        ShopperCartinfos temp = shopperCartinfosService.getOne(queryWrapper);
        if (temp != null) {
            temp.setQuantity(temp.getQuantity() + 1);
            shopperCartinfosService.updateById(temp);
        } else {
            String userId = UserUtil.getUserId();
            shopperCartinfos.setUserId(userId);
            shopperCartinfosService.save(shopperCartinfos);
        }
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.update')")
    @ApiOperation(value = "更新")
    @PutMapping("/update")
    public Result updateById(@RequestBody ShopperCartinfos shopperCartinfos) {
        shopperCartinfosService.updateById(shopperCartinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        shopperCartinfosService.removeById(id);
        return Result.ok();
    }

    //前台删除购物车
    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.removeCart')")
    @ApiOperation(value = "前台删除购物车")
    @PostMapping("/removeCart/{id}")
    public Result removeCart(@PathVariable String id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //根据登录用户删除，确保不会跨权限删除
        queryWrapper.eq("user_id",UserUtil.getUserId());
        queryWrapper.eq("commodityInfos_id",id);
        shopperCartinfosService.remove(queryWrapper);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperCartinfos.remove')")
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        boolean b = shopperCartinfosService.removeByIds(idList);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
