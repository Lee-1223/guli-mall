package com.ljl.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljl.common.utils.PageUtils;
import com.ljl.common.utils.Query;

import com.ljl.gulimall.product.dao.CategoryDao;
import com.ljl.gulimall.product.entity.CategoryEntity;
import com.ljl.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    // 查出所有分类，并组装成树形解构
    @Override
    public List<CategoryEntity> listWithTree() {

        // 直接使用父类的baseMapper，因为传入的泛型就是CategoryDao
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        // 组装成父子结构
        List<CategoryEntity> category1 = categoryEntities.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == 0;
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildren(categoryEntity, categoryEntities));  // 寻找子菜单
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());  // 对子菜单排序
        }).collect(Collectors.toList());

        return category1;
    }

    // 递归寻找一个菜单的子菜单
    public List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {

        List<CategoryEntity> children = all.stream().filter((categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();  // 找到直接的子分类
        })).map(categoryEntity -> {
            categoryEntity.setChildren(getChildren(categoryEntity, all));  // 递归寻找子分类的子分类
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());  // 按照排序字段排序子分类
        }).collect(Collectors.toList());

        return children;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {

        // TODO 添加判断条件，该分类是否被引用

        baseMapper.deleteBatchIds(asList);
    }
}