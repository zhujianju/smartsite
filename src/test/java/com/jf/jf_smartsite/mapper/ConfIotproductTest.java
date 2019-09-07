package com.jf.jf_smartsite.mapper;

import com.jf.jf_smartsite.entity.IOTData.ConfIotproduct;
import com.jf.jf_smartsite.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.server.ConfIotproductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfIotproductTest {
    @Autowired
    private ConfIotproductService confIotproductService;
    @Test
    public void findAll(){
        List<ConfIotproduct> all = confIotproductService.findAll();
        System.out.println(all);
    }
    @Test
    public void findByPage(){
        PageResult smartSiteGateWas = confIotproductService.findPage(1, 1, "abcdd");
        System.out.println(smartSiteGateWas);
    }

}
