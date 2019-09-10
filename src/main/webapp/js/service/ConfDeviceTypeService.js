//站点服务层
app.service('deviceTypeService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../devicetype/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../devicetype/"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../devicetype/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../devicetype/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../devicetype/delete.m?id='+id);
    }

    //根据设备类型id查找所有的通道
    this.findChannelTypeByDeviceId=function(id){
        return $http.get('../devicetype/findChannelTypeByDeviceId.m?id='+id);
    }




});