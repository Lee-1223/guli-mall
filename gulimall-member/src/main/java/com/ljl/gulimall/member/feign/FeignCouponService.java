package com.ljl.gulimall.member.feign;

import com.ljl.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("guli-coupon")
public interface FeignCouponService {

    @RequestMapping(value = "/coupon/coupon/member/list")
    public R couponList();

}
