package com.ljl.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljl.gulimall.coupon.entity.CouponEntity;
import com.ljl.gulimall.coupon.service.CouponService;
import com.ljl.common.utils.PageUtils;
import com.ljl.common.utils.R;



/**
 * 优惠券信息
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-06 15:08:35
 */
@RefreshScope  // 在线读取配置中心的更新内容
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")  // 从application中获取配置信息
    private String name;

    @Value("${coupon.user.age}")
    private Integer age;

    /**
     * 测试配置中心的方法
     */
    @RequestMapping("/testConfig")
    public R testConfig() {
        return R.ok().put("name", name).put("age", age);
    }

    /**
     * 查询一个会员的所有优惠券
     */
    @RequestMapping(value = "/member/list")
    public R couponList() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("优衣库优惠券");
        couponEntity.setNum(1);
        couponEntity.setNote("满299减99");
        return R.ok().put("coupons", couponEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("coupon:coupon:list")  // 修改controller模版，不使用shiro
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
