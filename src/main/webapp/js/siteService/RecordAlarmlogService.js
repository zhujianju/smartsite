//站点服务层
app.service('recordAlarmlogService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../runRecordAlar/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //为select2和数据字典提供所有的站点
    this.findSataion=function () {
        return $http.get('../device/findSataion.m');
    }
    //为select2和数据字典提供所有的设备类型
    this.findDevcieType=function () {
        return $http.get('../device/findDevcieType.m');
    }
    //为select2和数据字典提供所有的设备
    this.findDevcie=function () {
        return $http.get('../device/findDevice.m');
    }
    //为数据字典提供所有的设备
    this.findAllChann=function () {
        return $http.get('../device/findAllChann.m');
    }

});