//参数服务层
app.service('svrConfParamService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows,searchEntity) {
        return $http.post("../svrconfparam/findBypage.m?page="+page+"&rows="+rows,searchEntity);
    }

    //根据id查询单个
    this.findOne=function (keyz) {
        return $http.get("../svrconfparam/"+keyz);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../svrconfparam/save.m',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../svrconfparam/update.m',entity );
    }
    //删除
    this.dele=function(keyz){
        return $http.get('../svrconfparam/delete.m?keyz='+keyz);
    }
});