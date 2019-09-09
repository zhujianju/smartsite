package com.jf.jf_smartsite.mapper;

import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfDeviceTest {
    @Autowired
    private ConfDeviceService confDeviceService;
    @Test
    public void findByname(){
       PageResult smartSiteGateWas = confDeviceService.findPage(1, 2, null);
      System.out.println(smartSiteGateWas.getRows().get(0));
    }
    @Test
    public void findAll(){
        List<ConfDevice> all = confDeviceService.findAll();
        System.out.println(all);
    }
    @Test
    public void findOne(){
        ConfDevice one = confDeviceService.findOne(1001);
        System.out.println(one);
    }
    @Test
    public void findDevicByStation(){
        List<ConfDeviceDTypeDCom> deviceByStationId = confDeviceService.findDeviceByStationId(1);
        System.out.println(deviceByStationId);
    }
}
