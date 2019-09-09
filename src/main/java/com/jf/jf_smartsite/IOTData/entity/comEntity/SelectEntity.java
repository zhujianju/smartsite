package com.jf.jf_smartsite.IOTData.entity.comEntity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于select2下拉框的类型转换
 */
@Data
public class SelectEntity implements Serializable {

    private Long id;

    private String text;

}
