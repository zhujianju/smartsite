package com.jf.jf_smartsite.mapper;



import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfDeviceTypeTest {
    @Autowired
    private ConfDeviceTypeService confDeviceTypeService;
    @Test
    public void findAll(){
        List<ConfDevicetype> all = confDeviceTypeService.findAll();
        System.out.println(all);
    }
}
