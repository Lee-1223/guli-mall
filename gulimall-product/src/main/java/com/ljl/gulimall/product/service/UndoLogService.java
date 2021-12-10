package com.ljl.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.product.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:48
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

