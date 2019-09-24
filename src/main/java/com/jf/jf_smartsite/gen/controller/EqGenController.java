package com.jf.jf_smartsite.gen.controller;


import com.jf.jf_smartsite.gen.service.EqGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 代码生成 操作处理
 *
 * @author 胡正
 */
@Controller
@RequestMapping("/equipment/gen")
public class EqGenController {
    /*定义项目路径*/
    private String path;

    @Autowired
    EqGenTableService eqGenTableService;

    /**
     * 生成profile 产品原型
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public @ResponseBody String batchGenCode(HttpServletResponse response, HttpServletRequest request,int id) throws Exception {
        String realPath = request.getRealPath("");
        path=realPath+"local/";
        eqGenTableService.selectGenTable(id,path);
        genCode(response, FileBytes());
        return "下载成功";
    }


    public byte[] FileBytes() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        FileInputStream fin = new FileInputStream(path+"/SmartSiteGateWay.zip");//要转换的文件名
        int read;
        byte[] bytes = new byte[1024*10];
        while ((read = fin.read(bytes)) > 0) {
            out.write(bytes, 0, read);
        }
        fin.close();
        bytes = out.toByteArray(); // 这就是全部的字节数组了。
        out.close();
        return bytes;
    }


    /**
     * 下载zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"SmartSiteGateWay.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}