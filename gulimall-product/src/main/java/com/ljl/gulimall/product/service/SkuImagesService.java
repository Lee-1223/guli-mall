package com.ljl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:49
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

