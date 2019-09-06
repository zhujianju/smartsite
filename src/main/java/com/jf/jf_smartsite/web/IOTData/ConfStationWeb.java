package com.jf.jf_smartsite.web.IOTData;

import com.jf.jf_smartsite.entity.IOTData.ConfStation;
import com.jf.jf_smartsite.server.IOTData.ConfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("confstation")
public class ConfStationWeb {

    @Autowired
    private ConfStationService confStationService;

    @RequestMapping("findAll.m")
    public List<ConfStation> findAll(){
           return confStationService.findAll();
    }

}
