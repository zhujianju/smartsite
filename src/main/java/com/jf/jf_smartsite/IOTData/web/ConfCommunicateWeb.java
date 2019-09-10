package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.ConfChanneltype;
import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.ConfChanneltypeService;
import com.jf.jf_smartsite.IOTData.server.ConfCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备信息查询
 */
@RestController
@RequestMapping("communicate")
public class ConfCommunicateWeb {
    @Autowired
    private ConfCommunicateService confCommunicateService;


    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody ConfCommunicate confCommunicate, int page, int rows){
        PageResult page1 = confCommunicateService.findPage(page, rows,confCommunicate);
        return page1;
    }

    /**
     * 根据id查询单个设备
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfCommunicate findOne(@PathVariable("id") Integer id){
        return  confCommunicateService.findOne(id);
    }


    /**
     * 添加设备
     * @param confCommunicate
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfCommunicate confCommunicate){
        try {
            if(findExits(confCommunicate.getId().intValue())){
                return new Result(false, "操作失败,ID已经存在");
            }

            confCommunicateService.insert(confCommunicate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {
            confCommunicateService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    @RequestMapping("update.m")
    public Result update(@RequestBody ConfCommunicate confCommunicate){
        try {

            confCommunicateService.updateByid(confCommunicate);
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
        ConfCommunicate one = confCommunicateService.findOne(id);
        if(one != null){
            return true;
        }
        return  false;
    }



}
