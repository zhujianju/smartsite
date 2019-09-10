package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.*;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备信息查询
 */
@RestController
@RequestMapping("channelType")
public class ConfChanneltypeWeb {
    @Autowired
    private ConfChanneltypeService confChanneltypeService;


    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody ConfChanneltype confChanneltype, int page, int rows){
        PageResult page1 = confChanneltypeService.findPage(page, rows,confChanneltype);
        return page1;
    }

    /**
     * 根据id查询单个设备
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfChanneltype findOne(@PathVariable("id") Integer id){
        return  confChanneltypeService.findOne(id);
    }


    /**
     * 添加设备
     * @param confChanneltype
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfChanneltype confChanneltype){
        try {
            if(findExits(confChanneltype.getId().intValue())){
                return new Result(false, "操作失败,ID已经存在");
            }
            confChanneltypeService.insert(confChanneltype);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {

            confChanneltypeService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("update.m")
    public Result update(@RequestBody ConfChanneltype confChanneltype){
        try {

            confChanneltypeService.updateByid(confChanneltype);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 用于新增和修改前,查看对象是否存在
     * @param id
     * @return
     */
    private boolean findExits(Integer id){
        ConfChanneltype one = confChanneltypeService.findOne(id);
        if(one != null){
            return true;
        }
        return  false;
    }

}
