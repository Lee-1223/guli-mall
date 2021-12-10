package com.ljl.gulimall.product.dao;

import com.ljl.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:50
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
