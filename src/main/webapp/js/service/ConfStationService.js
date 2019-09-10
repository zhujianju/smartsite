//站点服务层
app.service('stationService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../confstation/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../confstation/"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../confstation/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../confstation/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../confstation/delete.m?id='+id);
    }
    //查询iot
    this.findOneIot=function (id) {
        return  $http.get('../iotproduct/'+id);
    }
    //根据设备id查询设备列表
    this.findDevice=function (id) {
        return  $http.get('../device/findDevicByStationId.m?id='+id);
    }

    //根据设备id查询设备列表
    this.export=function (id) {
        return  $http.get('../equipment/gen/download?id='+id);
    }
});