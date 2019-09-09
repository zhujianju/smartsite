package com.jf.jf_smartsite.gen.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jf.jf_smartsite.gen.domain.Devices;
import com.jf.jf_smartsite.gen.domain.ServiceTypeCapabilitie;
import com.jf.jf_smartsite.gen.domain.ServiceTypeCapabilities;
import com.jf.jf_smartsite.gen.mapper.EqGenTableMapper;
import com.jf.jf_smartsite.gen.util.JsonFormatTool;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class EqGemTableServiceImpl implements EqGenTableService {
    private static final Logger log = LoggerFactory.getLogger(EqGemTableServiceImpl.class);
    private static StringBuffer filePath = new StringBuffer("./local/SmartSiteGateWay/");
    private String fileName = "devicetype-capability";
    /**
     * 查询设备原型信息
     *
     * @return 设备原型信息
     */
    @Autowired
    private EqGenTableMapper eqGenTableMapper;

    @Override
    public byte[] selectGenTable(int id) {
        deleteFile(new File(filePath.toString()));
        genDevice(id);
        String sourceFilePath = "./local/";
        String zipFilePath = "./local/";
        String fileName = "SmartSiteGateWay";
        boolean flag = fileToZip(sourceFilePath, zipFilePath, fileName);
        if(flag){
            System.out.println("文件打包成功!");
        }else{
            System.out.println("文件打包失败!");
        }

        return zip();
    }


    public byte[] zip() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        try {
            // 添加到zip
            zip.putNextEntry(new ZipEntry("local/SmartSiteGateWay"));
            IOUtils.write("SmartSiteGateWay", zip, "UTF-8");
            zip.closeEntry();
        } catch (Exception e) {

        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


    /**
     * genDevice 生成主要profile文件
     *
     * @return
     * @pram 配置服务文件集合
     */
    public boolean genDevice(int id) {
        Devices devices = eqGenTableMapper.selectGenTable(id);
        List<ServiceTypeCapabilitie> list = eqGenTableMapper.selectGenTableByid(id);
        System.out.println(list);
        devices.setServiceTypeCapabilitiesList(list);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("devices", devices);
        String jsonString1 = JSONArray.toJSONString(map, SerializerFeature.WriteMapNullValue);
        boolean flag = createJsonFile(jsonString1, filePath.append("profile/"), fileName);
        genDevice(list);
        return flag;
    }

    /**
     * genDevice 生成服务文件
     *
     * @return
     * @pram 配置服务文件集合
     */
    public void genDevice(List<ServiceTypeCapabilitie> list) {
        for (ServiceTypeCapabilitie service : list) {
            StringBuffer Path = new StringBuffer("local/SmartSiteGateWay/");
            Path.append("/service/");
            Path.append(service.getServiceType());
            Path.append("/profile/");
            Map<String, Object> map = new HashMap<String, Object>();
            ServiceTypeCapabilities serviceTypeCapabilities = eqGenTableMapper.selectGenByid(service.getServiceType());
            serviceTypeCapabilities.setPropertiesList(eqGenTableMapper.selectGenPro(serviceTypeCapabilities.getDeviceTypeId()));
            serviceTypeCapabilities.setDeviceTypeId(null);
            map.put("services", serviceTypeCapabilities);
            String jsonString1 = JSONArray.toJSONString(map, SerializerFeature.WriteMapNullValue);
            createJsonFile(jsonString1, Path, "servicetype-capability");
        }
    }

    /**
     * 删除文件夹
     *
     * @return
     */
    public static void deleteFile(File file) {
        if (file.exists()) {//判断文件是否存在
            if (file.isFile()) {//判断是否是文件
                file.delete();//删除文件
            } else if (file.isDirectory()) {//否则如果它是一个目录
                File[] files = file.listFiles();//声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) {//遍历目录下所有的文件
                    deleteFile(files[i]);//把每个文件用这个方法进行迭代
                }
                file.delete();//删除文件夹
            }
        } else {
            System.out.println("所删除的文件不存在");
        }
    }

    public boolean createJsonFile(String jsonString, StringBuffer filePath, String fileName) {
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


    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return
     */
    public boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    } else {
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024 * 10];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024 * 10);
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                //关闭流
                try {
                    if (null != bis) bis.close();
                    if (null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;

    }
}
