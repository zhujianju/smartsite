package com.jf.jf_smartsite.IOTData.entity.comEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体bean
 */

public class PageResult implements Serializable {
    //总记录数
    private Long total;
    //当前页的记录数
    private List rows;

    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    public PageResult() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rowsl=" + rows +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}
