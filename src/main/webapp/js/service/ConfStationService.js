//站点服务层
app.service('stationService',function ($http) {

    //读取列表数据绑定到表单中
    this.findPage=function (page,rows) {
        return $http.get("../confstation/findBypage.m?page="+page+"&rows="+rows);
    }

    //根据id查询单个
    this.findOne=function (id) {
        return $http.get("../confstation/"+id);
    }
    //新增的服务


});