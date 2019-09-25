package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.*;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.entity.comEntity.SelectEntity;
import com.jf.jf_smartsite.IOTData.server.*;
import com.jf.jf_smartsite.IOTData.Util.SelectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息查询
 */
@RestController
@RequestMapping("device")
public class ConfDeviceWeb {
    @Autowired
    private ConfDeviceService confDeviceService;
    @Autowired
    private ConfStationService confStationService;
    @Autowired
    private SelectUtil selectUtil;
    @Autowired
    private ConfDeviceTypeService confDeviceTypeService;
    @Autowired
    private ConfCommunicateService confCommunicateService;
    @Autowired
    private ConfChanneltypeService confChanneltypeService;
    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody ConfDevice confDevice, int page, int rows){
        PageResult page1 = confDeviceService.findPage(page, rows,confDevice);
        return page1;
    }



    @RequestMapping("findDevicByStationId.m")
    public List<ConfDeviceDTypeDCom> findDevicByStationId(Integer id){
        return confDeviceService.findDeviceByStationId(id);
    }

    /**
     * 根据id查询单个设备
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfDevice findOne(@PathVariable("id") Integer id){
        return  confDeviceService.findOne(id);
    }


    /**
     * 添加设备
     * @param confDevice
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfDevice confDevice){
        try {

            if(findExits(confDevice.getDeviceid().intValue())){
                return new Result(false, "操作失败,ID已经存在");
            }
            confDeviceService.insert(confDevice);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {
            confDeviceService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("update.m")
    public Result update(@RequestBody ConfDevice confDevice){
        try {

            confDeviceService.updateByid(confDevice);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 用于设备新增的,查询所有的站点,用于select2和数据字典
     */
    @RequestMapping("findSataion.m")
    public List<SelectEntity> findSataion(){
        List<ConfStation> stations = confStationService.findAll();
        List<SelectEntity> list =new ArrayList<>();//用于接受结果并返回
        for (ConfStation confStation :stations) {
            SelectEntity selectEntity = selectUtil.exchangToSelect(confStation.getId().longValue(), confStation.getName());
            list.add(selectEntity);
        }
        return list;
    }
    /**
     * 用于设备新增的,查询所有的设备类型,用于select2和数据字典
     */
    @RequestMapping("findDevcieType.m")
    public List<SelectEntity> findDevcieType(){
        List<ConfDevicetype> deviceTypes = confDeviceTypeService.findAll();
        List<SelectEntity> list =new ArrayList<>();//用于接受结果并返回
        for (ConfDevicetype deviceType :deviceTypes) {
            SelectEntity selectEntity = selectUtil.exchangToSelect(deviceType.getId(), deviceType.getName());
            list.add(selectEntity);
        }
        return list;
    }
    /**
     * 用于设备新增的,查询所有的通讯,用于select2和数据字典
     */
    @RequestMapping("findCommunicate.m")
    public List<SelectEntity> findCommunicate(){
        List<ConfCommunicate> confCommunicates = confCommunicateService.findAll();
        List<SelectEntity> list =new ArrayList<>();//用于接受结果并返回
        for (ConfCommunicate communicate :confCommunicates) {
            SelectEntity selectEntity = selectUtil.exchangToSelect(communicate.getId().longValue(), communicate.getName());
            list.add(selectEntity);
        }
        return list;
    }
    /**
     * 查询所有设备，用于select2和数据字典
     */
    @RequestMapping("findDevice.m")
    public List<SelectEntity> findAllDevice(){
        List<ConfDevice> allConfDevices = confDeviceService.findAll();
        List<SelectEntity> list =new ArrayList<>();//用于接受结果并返回
        for (ConfDevice confDevice :allConfDevices) {
            SelectEntity selectEntity = selectUtil.exchangToSelect(confDevice.getDeviceid().longValue(), confDevice.getName());
            list.add(selectEntity);
        }
        return list;
    }
    /**confChanneltype
     * 查询所有通道，用于select2和数据字典
     */
    @RequestMapping("findAllChann.m")
    public List<SelectEntity> findAllChann(){
        List<ConfChanneltype> all = confChanneltypeService.findAll();
        List<SelectEntity> list =new ArrayList<>();//用于接受结果并返回
        for (ConfChanneltype confChanneltype :all) {
            SelectEntity selectEntity = selectUtil.exchangToSelect(confChanneltype.getId().longValue(), confChanneltype.getChannelname());
            list.add(selectEntity);
        }
        return list;
    }



    /**
     * 用于新增和修改前,查看对象是否存在
     * @param id
     * @return
     */
    private boolean findExits(Integer id){
        ConfDevice one = confDeviceService.findOne(id);
        if(one != null){
            return true;
        }
        return  false;
    }

}
