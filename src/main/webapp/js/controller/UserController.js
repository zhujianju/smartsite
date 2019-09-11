//控制层
app.controller('userController',function ($scope,$controller,UserService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //查询单个iot实体
    $scope.getUser=function () {
        UserService.getUser().success(
            function(response){
                $scope.userEntity= response;
            }
        );
    }


});