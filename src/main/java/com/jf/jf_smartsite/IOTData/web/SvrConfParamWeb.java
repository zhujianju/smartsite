package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.SvrConfParam;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.SvrConfParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 参数信息表
 */
@RestController
@RequestMapping("svrconfparam")
public class SvrConfParamWeb {
    @Autowired
    private SvrConfParamService svrConfParamService;

    @RequestMapping("findAll.m")
    public List<SvrConfParam> findAll(){
        return svrConfParamService.findAll();
    }

    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody SvrConfParam svrConfParam, int page, int rows){
        PageResult page1 = svrConfParamService.findPage(page, rows,svrConfParam);
        return page1;
    }

    /**
     * 根据id查询单个站点
     * @param key
     * @return
     */
    @RequestMapping("/{keyz}")
    public SvrConfParam findOne(@PathVariable("keyz") String key ){


        SvrConfParam one = svrConfParamService.findOne(key);
        return one;
    }

    /**
     * 新增的方法
     * @param svrConfParam
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody SvrConfParam svrConfParam){
        try {
            if(findExits(svrConfParam.getKeyz())){
                return new Result(false, "操作失败,ID已经存在");
            }
            svrConfParamService.insert(svrConfParam);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param svrConfParam
     * @return
     */
    @RequestMapping("update.m")
    public Result update(@RequestBody SvrConfParam svrConfParam){
        try {
            svrConfParamService.updateByid(svrConfParam);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    @RequestMapping("delete.m")
    public Result delete(String keyz){
        try {
            svrConfParamService.deleteById(keyz);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 用于新增和修改前,查看对象是否存在
     * @param key
     * @return
     */
    private boolean findExits(String key){
        SvrConfParam one = svrConfParamService.findOne(key);
        if(one != null){
            return true;
        }
        return  false;
    }

}
