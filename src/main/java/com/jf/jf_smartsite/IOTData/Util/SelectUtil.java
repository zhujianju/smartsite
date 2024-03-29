package com.jf.jf_smartsite.IOTData.Util;

import com.jf.jf_smartsite.IOTData.entity.comEntity.SelectEntity;
import org.springframework.stereotype.Component;

/**
 * 类型转换工具类
 */
@Component
public class SelectUtil {

    public SelectEntity exchangToSelect(Long id, String text){
        SelectEntity selectEntity=new SelectEntity();
        selectEntity.setId(id);
        selectEntity.setText(text);
        return selectEntity;
    }

}
