//设备服务层
app.service('deviceService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../device/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../device/+"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../device/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../device/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../device/delete.m?id='+id);
    }
    //查询iot下所有的站点
    this.findIotStation=function (id) {
        return $http.get('../device/findIotStation.m?id='+id);
    }
    //为select2提供所有的站点
    this.findSataion=function (id) {
        return $http.get('../device/findSataion.m');
    }
    //为select2提供所有的设备类型
    this.findDevcieType=function (id) {
        return $http.get('../device/findDevcieType.m');
    }
    //为select2提供所有的通讯
    this.findCommunicate=function (id) {
        return $http.get('../device/findCommunicate.m');
    }
});