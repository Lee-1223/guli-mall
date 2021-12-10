package com.ljl.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljl.gulimall.product.entity.CategoryEntity;
import com.ljl.gulimall.product.service.CategoryService;
import com.ljl.common.utils.PageUtils;
import com.ljl.common.utils.R;



/**
 * 商品三级分类
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:50
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类及其子分类，并以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> list = categoryService.listWithTree();

        return R.ok().put("categoryTree", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);  // 为了配合前端的修改，和回显的数据名称一致吗
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改拖动列表后的信息
     */
    @RequestMapping("/save/sort")
    // @RequiresPermissions("product:category:save")
    public R saveBatchSort(@RequestBody CategoryEntity[] category){  // SpringMVC自动将JSON数组封装成CategoryEntity[]
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){  // @RequestBody 将JSON请求参数中的数据抽取出来，组成一个Long[]数组

        // categoryService.removeByIds(Arrays.asList(catIds));

        // 自定义批量删除方法，需要检查待删除的分类是否被其他地方引用
		categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
