package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;
import com.jf.jf_smartsite.IOTData.entity.ConfStation;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.entity.comEntity.SelectEntity;
import com.jf.jf_smartsite.IOTData.server.ConfCommunicateService;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceService;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import com.jf.jf_smartsite.IOTData.server.ConfStationService;
import com.jf.jf_smartsite.Util.SelectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 用于设备新增的,查询所有的站点
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
     * 用于设备新增的,查询所有的设备类型
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
     * 用于设备新增的,查询所有的通讯
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
}
