package com.ljl.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.gulimall.product.entity.BrandEntity;
import com.ljl.gulimall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.integration.IntegrationGraphEndpoint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GulimallProductApplicationTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void main() {
        // 改
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(6L);
//        brandEntity.setDescript("测试修改语句是否可用");
//        brandService.updateById(brandEntity);

        // 增
//        brandEntity.setName("测试商品abibas");
//        brandService.save(brandEntity);
//        System.out.println("保存成功！！");

        // 查询
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().between("brand_id", 3, 6));
        for (BrandEntity brandEntity : list) {
            System.out.println(brandEntity.toString());
        }

//        int mb = (int)Math.pow(10, 10)/1024/1024;
//        System.out.println(mb);

    }
}