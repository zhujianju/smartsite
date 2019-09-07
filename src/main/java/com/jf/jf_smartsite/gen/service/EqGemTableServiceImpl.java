package com.jf.jf_smartsite.gen.service;

import com.alibaba.fastjson.JSONArray;
import com.jf.jf_smartsite.gen.domain.Prototype;
import com.jf.jf_smartsite.gen.mapper.EqGenTableMapper;
import com.jf.jf_smartsite.gen.util.JsonFormatTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@Service
public class EqGemTableServiceImpl implements EqGenTableService {
    private static final Logger log = LoggerFactory.getLogger(EqGemTableServiceImpl.class);
    private static final String filePath="D:/SmartSiteGateWay/profile/";
    private String fileName="devicetype-capability";

    /**
     * 查询设备原型信息
     *
     * @return 设备原型信息
     */
    @Autowired
    private EqGenTableMapper eqGenTableMapper;
    @Override
    public Prototype selectGenTable( ) {
        Prototype prototype= eqGenTableMapper.selectGenTable();
        String jsonString1 = JSONArray.toJSONString(prototype);
        System.out.println(jsonString1);
        createJsonFile(jsonString1, filePath,fileName );
        System.out.println(prototype);
        return prototype ;
    }
    public static boolean createJsonFile(String jsonString, String filePath, String fileName) {
        // 标记文件生成是否成功
        boolean flag = true;

        // 拼接文件完整路径
        String fullPath = filePath + File.separator + fileName + ".json";

        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();

            if (jsonString.indexOf("'") != -1) {
                //将单引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
                jsonString = jsonString.replaceAll("'", "\\'");
            }
            if (jsonString.indexOf("\"") != -1) {
                //将双引号转义一下，因为JSON串中的字符串类型可以单引号引起来的
                jsonString = jsonString.replaceAll("\"", "\\\"");
            }

            if (jsonString.indexOf("\r\n") != -1) {
                //将回车换行转换一下，因为JSON串中字符串不能出现显式的回车换行
                jsonString = jsonString.replaceAll("\r\n", "\\u000d\\u000a");
            }
            if (jsonString.indexOf("\n") != -1) {
                //将换行转换一下，因为JSON串中字符串不能出现显式的换行
                jsonString = jsonString.replaceAll("\n", "\\u000a");
            }

            // 格式化json字符串
            jsonString = JsonFormatTool.formatJson(jsonString);

            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        // 返回是否成功的标记
        return flag;
    }
}
