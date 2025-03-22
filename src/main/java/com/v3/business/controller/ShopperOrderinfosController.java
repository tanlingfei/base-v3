package com.v3.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.v3.business.model.CommodityCommodityinfos;
import com.v3.business.model.ShopperCartinfos;
import com.v3.business.model.ShopperOrderinfos;
import com.v3.business.model.ShopperOrderinfosSub;
import com.v3.business.service.CommodityCommodityinfosService;
import com.v3.business.service.ShopperCartinfosService;
import com.v3.business.service.ShopperOrderinfosService;
import com.v3.business.service.ShopperOrderinfosSubService;
import com.v3.business.vo.ShopperOrderinfosQueryVo;
import com.v3.common.result.Result;
import com.v3.system.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author administrator
 * @version 1.0
 * @description
 * @date 2024-06-29 15:39:58
 */
@Api(tags = "")
@RestController
@RequestMapping("/business/shopperOrderinfos")
public class ShopperOrderinfosController {
    @Autowired
    private ShopperOrderinfosService shopperOrderinfosService;

    @Autowired
    private ShopperCartinfosService shopperCartinfosService;

    @Autowired
    private ShopperOrderinfosSubService shopperOrderinfosSubService;

    @Autowired
    private CommodityCommodityinfosService commodityCommodityinfosService;


    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.list')")
    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "shopperOrderinfosQueryVo", value = "查询对象", required = false)
                        ShopperOrderinfosQueryVo shopperOrderinfosQueryVo) {
        Page<ShopperOrderinfos> pageParam = new Page<>(page, limit);
        IPage<ShopperOrderinfos> pageModel = shopperOrderinfosService.selectPage(pageParam, shopperOrderinfosQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.pageList')")
    @ApiOperation(value = "前台根据用户查询订单")
    @GetMapping("/pageList/{page}/{limit}")
    public Result pageList(@ApiParam(name = "page", value = "当前页码", required = true)
                        @PathVariable Long page,
                        @ApiParam(name = "limit", value = "每页记录数", required = true)
                        @PathVariable Long limit,
                        @ApiParam(name = "shopperOrderinfosQueryVo", value = "查询对象", required = false)
                        ShopperOrderinfosQueryVo shopperOrderinfosQueryVo) {
        shopperOrderinfosQueryVo.setUserId(UserUtil.getUserId());
        Page<ShopperOrderinfos> pageParam = new Page<>(page, limit);
        IPage<ShopperOrderinfos> pageModel = shopperOrderinfosService.selectPage(pageParam, shopperOrderinfosQueryVo);
        return Result.ok(pageModel);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.list')")
    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    public Result list(@ApiParam(name = "shopperOrderinfosQueryVo", value = "查询对象", required = false)
                       ShopperOrderinfosQueryVo shopperOrderinfosQueryVo) {
        List<ShopperOrderinfos> list = shopperOrderinfosService.queryList(shopperOrderinfosQueryVo);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.list')")
    @ApiOperation(value = "所有列表")
    @GetMapping("findAll")
    public Result findAllShopperOrderinfos() {
        //调用service的方法实现查询所有的操作
        List<ShopperOrderinfos> list = shopperOrderinfosService.list(null);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.list')")
    @ApiOperation(value = "获取")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable String id) {
        ShopperOrderinfos shopperOrderinfos = shopperOrderinfosService.getById(id);
        return Result.ok(shopperOrderinfos);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.list')")
    @ApiOperation(value = "获取集合")
    @PostMapping("/getByIds")
    public Result getByIds(@RequestBody List<String> idList) {
        List<ShopperOrderinfos> list = shopperOrderinfosService.getByIds(idList);
        return Result.ok(list);
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.add')")
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody ShopperOrderinfos shopperOrderinfos) {
        shopperOrderinfosService.save(shopperOrderinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.addOrder')")
    @ApiOperation(value = "前台结算功能")
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody ShopperOrderinfos shopperOrderinfos) {
        String[] cartids = shopperOrderinfos.getCartids();
        List<ShopperOrderinfosSub> orderSubList = new ArrayList();
        BigDecimal sumPrice = BigDecimal.ZERO;
        if (cartids != null && cartids.length > 0) {
            for (String cartid : cartids) {
                //获取每一条购物车信息
                ShopperCartinfos shopperCartinfos = shopperCartinfosService.getById(cartid);
                CommodityCommodityinfos commodityCommodityinfos = commodityCommodityinfosService.getById(shopperCartinfos.getCommodityinfosId());
                sumPrice = sumPrice.add(commodityCommodityinfos.getPrice().multiply(new BigDecimal(shopperCartinfos.getQuantity())));
                //赋值订单商品信息表
                ShopperOrderinfosSub shopperOrderinfosSub = new ShopperOrderinfosSub();
                shopperOrderinfosSub.setCommodityId(commodityCommodityinfos.getId());
                shopperOrderinfosSub.setQuantity(shopperCartinfos.getQuantity());
                orderSubList.add(shopperOrderinfosSub);
            }
        }
        //订单信息赋值
        shopperOrderinfos.setPrice(sumPrice);
        shopperOrderinfos.setUserId(UserUtil.getUserId());
        shopperOrderinfos.setState("未支付");
        //保存订单信息
        shopperOrderinfosService.save(shopperOrderinfos);
        if (orderSubList != null && orderSubList.size() > 0) {
            for (ShopperOrderinfosSub sub : orderSubList) {
                //赋值订单商品信息表订单id
                sub.setOrderId(shopperOrderinfos.getId());
            }
            //保存订单商品信息表
            shopperOrderinfosSubService.saveBatch(orderSubList);
        }
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.update')")
    @ApiOperation(value = "更新")
    @PutMapping("/update")
    public Result updateById(@RequestBody ShopperOrderinfos shopperOrderinfos) {
        shopperOrderinfosService.updateById(shopperOrderinfos);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.remove')")
    @ApiOperation(value = "删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable String id) {
        shopperOrderinfosService.removeById(id);
        return Result.ok();
    }

    @PreAuthorize("hasAuthority('bnt.shopperOrderinfos.remove')")
    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<String> idList) {
        boolean b = shopperOrderinfosService.removeByIds(idList);
        if (b) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
