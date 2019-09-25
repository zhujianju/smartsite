package com.jf.jf_smartsite.siteData.web;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.siteData.entity.RunRecordAlarmlog;
import com.jf.jf_smartsite.siteData.server.RunRecordAlarmServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 警报数据web层
 */
@RestController
@RequestMapping("runRecordAlar")
public class RunRecordAlarmWeb {
    @Autowired
    private RunRecordAlarmServer recordAlarmServer;

    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody RunRecordAlarmlog runRecordAlarmlog, int page, int rows){
        PageResult page1 = recordAlarmServer.findPage(page, rows,runRecordAlarmlog);
        return page1;
    }

}
