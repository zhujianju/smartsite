//站点服务层
app.service('iotproductService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../iotproduct/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../iotproduct/"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../iotproduct/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../iotproduct/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../iotproduct/delete.m?id='+id);
    }
    //查询iot下所有的站点
    this.findIotStation=function (id) {
        return $http.get('../confstation/findIotStation.m?id='+id);
    }
});