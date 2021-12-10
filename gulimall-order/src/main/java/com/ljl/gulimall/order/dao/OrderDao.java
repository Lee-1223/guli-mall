package com.ljl.gulimall.order.dao;

import com.ljl.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-06 16:04:03
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
