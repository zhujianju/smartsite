    package com.jf.jf_smartsite.entity.IOTData;



import lombok.Data;

import java.io.Serializable;

/**
 * 设备信息对象 conf_device
 * 
 * @author 欧阳兴
 * @date 2019-09-05
 */
@Data
public class ConfDevice implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 站点索引编号 */

    private Integer stationid;

    /** 设备类型编号 */

    private Integer typeid;

    /** 设备编号 */
    private Integer deviceid;

    /** 设备名称 */

    private String name;

    /** Iot服务Id */

    private String iotcode;

    /** 通讯编号 */

    private Long communicateid;

    /** 设备子地址 */

    private Long subaddr;

    /** 服务器Ip */
    private String ip;

    /** 通讯端口 */
    private Long port;

    /** 社区 */
    private String community;

    /** 密码 */
    private String pwd;

    /** 设备数据校验标识 */
    private Integer checks;

    /** 设备是否启用 */

    private Integer enable;

    /** 备注 */
    private String remask;


}
