package com.ljl.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.ljl.common.valid.AddGroup;
import com.ljl.common.valid.UpdateGroup;
import com.ljl.common.valid.UpdateStatusGroup;
import com.ljl.common.valid.ValueList;
import lombok.Data;
import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author ljl
 * @email 462338850@qq.com
 * @date 2021-12-08 11:45:50
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改的时候必须提供id", groups = {UpdateGroup.class})  // ❓ Class<?>要求是接口
	@Null(message = "新增的时候不能自己指定id", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "商品名称不能为空", groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty(message = "URL不能为空", groups = AddGroup.class)
	@URL(message = "格式必须是一个URL的地址", groups = {UpdateGroup.class, AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups = {UpdateGroup.class, AddGroup.class})
	@ValueList(values = {0,1}, groups = {UpdateStatusGroup.class})  // ⚠️ 虽然是数组, 但是指定值的时候使用的是{}
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(message = "新增时，该字段不能为空", groups = AddGroup.class)
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是a-z或A-Z", groups = {UpdateGroup.class, AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "新增时，该字段不能为空", groups = AddGroup.class)
	@Min(value = 0, message = "排序字段必须是大于等于0的数字", groups = {UpdateGroup.class, AddGroup.class})
	private Integer sort;

}
