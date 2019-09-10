//站点服务层
app.service('channelTypeService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../channelType/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../channelType/"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../channelType/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../channelType/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../channelType/delete.m?id='+id);
    }
    //查询iot
    this.findOneIot=function (id) {
        return  $http.get('../channelType/'+id);
    }

    //为select2提供所有的设备类型
    this.findDevcieType=function (id) {
        return $http.get('../device/findDevcieType.m');
    }

    //为根据id查找单个设备类型
    this.findDevcieTypeByid=function (id) {
        return $http.get('../devicetype/'+id);
    }

});