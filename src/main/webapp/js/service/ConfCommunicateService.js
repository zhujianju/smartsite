//站点服务层
app.service('communicateService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../communicate/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../communicate/"+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../communicate/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../communicate/update.m',entity );
    }
    //删除
    this.dele=function(id){
        return $http.get('../communicate/delete.m?id='+id);
    }

});