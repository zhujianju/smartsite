package com.jf.jf_smartsite.gen.controller;


import com.jf.jf_smartsite.gen.service.EqGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * 代码生成 操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/equipment/gen")
public class EqGenController {
    private String prefix = "equip/gen";

    @Autowired
    EqGenTableService eqGenTableService;

    /**
     * 生成profile 产品原型
     */
    @RequestMapping("/GenFile")
    public void batchGenCode(HttpServletResponse response, int id)  {
        eqGenTableService.selectGenTable(id);
        genCode(response);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse res)  {
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment; filename=SmartSiteGateWay");
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;

        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(
                    new File("./local/SmartSiteGateWay.zip")));
            int i = bis.read(buff);

            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("export file finish");
    }

}