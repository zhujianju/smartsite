package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.ConfIotproductService;
import com.jf.jf_smartsite.IOTData.entity.ConfIotproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IOTweb层
 */
@RestController
@RequestMapping("iotproduct")
public class ConfIotproductWeb {
    @Autowired
    private ConfIotproductService confIotproductService;

    /**
     * 根据id查询单个IOT
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfIotproduct findOne(@PathVariable("id") Integer id){
      return  confIotproductService.findOne(id);
    }

    @RequestMapping("findBypage.m")
    public PageResult findByPage(int page, int rows){
        PageResult page1 = confIotproductService.findPage(page, rows);
        return page1;
    }

    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {
            confIotproductService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 新增的方法
     * @param confIotproduct
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfIotproduct confIotproduct){
        try {
            confIotproductService.insert(confIotproduct);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param confIotproduct
     * @return
     */
    @RequestMapping("update.m")
    public Result update(@RequestBody ConfIotproduct confIotproduct){
        try {
            confIotproductService.updateByid(confIotproduct);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
}
