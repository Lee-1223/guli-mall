package com.ljl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:49
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

