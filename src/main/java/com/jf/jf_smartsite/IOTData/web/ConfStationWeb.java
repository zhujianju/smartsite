package com.jf.jf_smartsite.IOTData.web;

import com.jf.jf_smartsite.IOTData.entity.ConfStation;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.entity.comEntity.Result;
import com.jf.jf_smartsite.IOTData.server.ConfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 站点web层
 */
@RestController
@RequestMapping("confstation")
public class ConfStationWeb {

    @Autowired
    private ConfStationService confStationService;

    @RequestMapping("findAll.m")
    public List<ConfStation> findAll(){
           return confStationService.findAll();
    }

    @RequestMapping("findBypage.m")
    public PageResult findByPage(@RequestBody ConfStation confStation, int page,int rows){
        PageResult page1 = confStationService.findPage(page, rows,confStation);
        return page1;
    }

    /**
     * 根据id查询单个站点
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ConfStation findOne(@PathVariable("id") Integer id){
        ConfStation one = confStationService.findOne(id);
        return one;
    }

    /**
     * 新增的方法
     * @param confStation
     * @return
     */
    @RequestMapping("save.m")
    public Result add(@RequestBody ConfStation confStation){
        try {
            confStationService.insert(confStation);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param confStation
     * @return
     */
        @RequestMapping("update.m")
    public Result update(@RequestBody ConfStation confStation){
        try {
            confStationService.updateByid(confStation);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }
    @RequestMapping("delete.m")
    public Result delete(Integer id){
        try {
            confStationService.deleteById(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    @RequestMapping("findIotStation.m")
    public List<ConfStation> findStationByIOTid(Integer id){
        return confStationService.findStationByIOTid(id);
    }

}
