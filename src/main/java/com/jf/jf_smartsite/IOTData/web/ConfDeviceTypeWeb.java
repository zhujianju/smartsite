package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.ConfChanneltype;
import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.ConfChanneltypeService;
import com.jf.jf_smartsite.IOTData.server.ConfCommunicateService;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 设备信息查询
 */
@RestController
@RequestMapping("devicetype")
public class ConfDeviceTypeWeb {
    @Autowired
    private ConfDeviceTypeService confDeviceTypeService;
    @Autowired
    private ConfChanneltypeService confChanneltypeService;


    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody ConfDevicetype confDevicetype, int page, int rows){
        PageResult page1 = confDeviceTypeService.findPage(page, rows,confDevicetype);
        return page1;
    }

    /**
     * 根据id查询单个设备
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfDevicetype findOne(@PathVariable("id") Integer id){
        return  confDeviceTypeService.findOne(id);
    }


    /**
     * 添加设备
     * @param confDevicetype
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfDevicetype confDevicetype){
        try {
            if(findExits(confDevicetype.getId().intValue())){
                return new Result(false, "操作失败,ID已经存在");
            }
            confDeviceTypeService.insert(confDevicetype);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {
            confDeviceTypeService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("update.m")
    public Result update(@RequestBody ConfDevicetype confDevicetype){
        try {

            confDeviceTypeService.updateByid(confDevicetype);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 根据设备类型id查找所有的通道
     * @param id
     * @return
     */
    @RequestMapping("findChannelTypeByDeviceId.m")
    public List<ConfChanneltype> findChannelTypeByDeviceId(Integer id){
        return confChanneltypeService.findChannelTypeByDeviceId(id);
    }

    /**
     * 用于新增和修改前,查看对象是否存在
     * @param id
     * @return
     */
    private boolean findExits(Integer id){
        ConfDevicetype one = confDeviceTypeService.findOne(id);
        if(one != null){
            return true;
        }
        return  false;
    }


}
