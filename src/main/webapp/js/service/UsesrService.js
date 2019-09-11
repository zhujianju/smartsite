//设备服务层
app.service('UserService',function ($http) {

    //读取列表数据绑定到表单中
    this.getUser=function () {
        return $http.post("../login/getUser");
    }


});