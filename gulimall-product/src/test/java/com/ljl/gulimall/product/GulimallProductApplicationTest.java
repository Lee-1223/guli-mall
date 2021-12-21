package com.ljl.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljl.gulimall.product.entity.BrandEntity;
import com.ljl.gulimall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.integration.IntegrationGraphEndpoint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@RefreshScope  //
public class GulimallProductApplicationTest {

    @Autowired
    private BrandService brandService;

    @Value("${test.version}")
    private String value;

    @Test
    public void test1() {
        System.out.println(this.value);
    }

//    @Autowired
//    private OSSClient ossClient;  // ⚠️ commom没有再引入oss了，所以删除测试
//
//    @Test
//    public void uploadTest() {
//
//        // 创建PutObjectRequest对象。
//        // 依次填写Bucket名称（例如examplebucket）、Object完整路径（例如exampledir/exampleobject.txt）和本地文件的完整路径。Object完整路径中不能包含Bucket名称。
//        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
//        PutObjectRequest putObjectRequest = new PutObjectRequest(
//                "gulimall-lee1223",
//                "研究生各培养环节完成时间.xlsx",
//                new File("/Users/ljl/Desktop/研究生各培养环节完成时间.xlsx"));
//
//        // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
//        // ObjectMetadata metadata = new ObjectMetadata();
//        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//        // metadata.setObjectAcl(CannedAccessControlList.Private);
//        // putObjectRequest.setMetadata(metadata);
//
//        // 上传文件。
//        ossClient.putObject(putObjectRequest);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//
//        System.out.println("上传成功");
//    }

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