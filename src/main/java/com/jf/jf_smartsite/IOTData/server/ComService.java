package com.jf.jf_smartsite.IOTData.server;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;

import java.util.List;

/**
 * 通用的服务层方法
 * @param <T>
 */
public interface ComService <T>{
    /**
     * 查找所有的列表
     * @return
     */
    public List<T> findAll();

    /**
     * 分页查找
     * @param pageNum 当前页数
     * @param pageSize 多少条数据
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 带条件的分页查询
     * @param pageNum
     * @param pageSize
     * @param t 名字
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize, T t);

    /**
     * 根据id查询单个站点
     * @param id
     * @return 返回站点对象
     */
    public T findOne(Integer id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int deleteById(Integer id);

    /**
     * 修改,
     * @param t
     * @return
     */
    public int updateByid(T t);

    /**
     * 新增
     * @param t
     * @return
     */
    public int insert(T t);
}
