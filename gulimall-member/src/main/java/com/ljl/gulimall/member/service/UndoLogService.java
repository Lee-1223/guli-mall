package com.ljl.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-06 15:56:29
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

