package com.jf.jf_smartsite.gen.controller;



import com.jf.jf_smartsite.gen.service.EqGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 代码生成 操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/equipment/gen")
public class EqGenController
{
    private String prefix = "equip/gen";

    @Autowired
    EqGenTableService eqGenTableService;

    /**
     * 生成profile 产品原型
     */
    @RequestMapping("/GenFile")
    public void batchGenCode(HttpServletResponse response, Integer id) throws IOException
    {
        byte[] data =   eqGenTableService.selectGenTable(id);
        genCode(response, new byte[1]);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException
    {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"profile.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}