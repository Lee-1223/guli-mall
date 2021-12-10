package com.ljl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:48
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

