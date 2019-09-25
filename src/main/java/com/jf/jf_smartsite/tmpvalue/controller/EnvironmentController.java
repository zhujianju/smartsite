package com.jf.jf_smartsite.tmpvalue.controller;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.tmpvalue.domain.Tmpvalue;
import com.jf.jf_smartsite.tmpvalue.service.TmpValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 环境检测，防汛检测
 *
 * @author 胡正
 */
@Controller
@RequestMapping("/tmpvalue")
public class EnvironmentController {
    @Autowired
    TmpValueService tmpValueService;

    @RequestMapping("/selectList")
    @ResponseBody
        public PageResult selectListEnvironment(int page, int limit, Tmpvalue tmpvalue ){
        PageResult page1= tmpValueService.findPage(page,limit,tmpvalue);
        return page1;
    }
}
