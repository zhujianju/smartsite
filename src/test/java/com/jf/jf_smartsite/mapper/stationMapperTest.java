package com.jf.jf_smartsite.mapper;

import com.jf.jf_smartsite.IOTData.entity.ConfStation;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.server.ConfStationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class stationMapperTest {


    @Autowired
    private ConfStationService confStationService;

    @Test
    public void findAllStation() {
        List<ConfStation> confStations = confStationService.findAll();
        System.out.println(confStations);
    }
    @Test
    public void findByPage(){
        PageResult page = confStationService.findPage(1, 1);
        System.out.println(page.getTotal());
        System.out.println(page.getRows().get(0));
    }
    @Test
    public void findByPage2(){
      /*  PageResult page = confStationService.findPage(1, 1,"2");
        System.out.println(page.getTotal());
        System.out.println(page.getRows().get(0));*/
    }
    @Test
    public void insert(){
        ConfStation confStation = new ConfStation();
        confStation.setId(3);
        confStation.setName("银谷工地");
        confStation.setProvince("广东省");
        confStation.setCity("东莞市");
        confStation.setIotnodeid("hzoyx123456790");
        confStation.setIotverifycode("JFSSGW20190903");
        confStation.setIottypeid(1L);
        int insert = confStationService.insert(confStation);
        System.out.println(insert);
    }
    @Test
    public void update(){
        ConfStation confStation = new ConfStation();
        confStation.setAddress("东莞街道");
        confStation.setId(3);
        int i = confStationService.updateByid(confStation);
        System.out.println(i);
    }
    @Test
    public void delete(){
        confStationService.deleteById(3);
    }
    @Test
    public void findOne(){
        ConfStation one = confStationService.findOne(1);
        System.out.println(one);
    }
}
