package com.ljl.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljl.common.utils.PageUtils;
import com.ljl.gulimall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-06 15:56:29
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

