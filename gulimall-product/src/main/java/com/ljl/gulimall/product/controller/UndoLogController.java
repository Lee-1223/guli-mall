package com.ljl.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljl.gulimall.product.entity.UndoLogEntity;
import com.ljl.gulimall.product.service.UndoLogService;
import com.ljl.common.utils.PageUtils;
import com.ljl.common.utils.R;



/**
 * 
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:48
 */
@RestController
@RequestMapping("product/undolog")
public class UndoLogController {
    @Autowired
    private UndoLogService undoLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    // @RequiresPermissions("product:undolog:list")  // 修改controller模版，不使用shiro
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = undoLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    // @RequiresPermissions("product:undolog:info")
    public R info(@PathVariable("id") Long id){
		UndoLogEntity undoLog = undoLogService.getById(id);

        return R.ok().put("undoLog", undoLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:undolog:save")
    public R save(@RequestBody UndoLogEntity undoLog){
		undoLogService.save(undoLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:undolog:update")
    public R update(@RequestBody UndoLogEntity undoLog){
		undoLogService.updateById(undoLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:undolog:delete")
    public R delete(@RequestBody Long[] ids){
		undoLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
