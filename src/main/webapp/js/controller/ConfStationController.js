//控制层
app.controller('stationController',function ($scope,$controller,stationService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        stationService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        stationService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        stationService.findOne(id).success(
            function(response){
                $scope.stationEntity= response;
                $scope.stationEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.stationEntity.status == 1){//如果有状态
            serviceObject=stationService.update( $scope.stationEntity ); //修改
        }else{
            serviceObject=stationService.add( $scope.stationEntity  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }

    //删除
    $scope.delete=function(id){
        if (confirm("是否确认删除")){
            //获取选中的复选框
            stationService.dele( id ).success(
                function(response){
                    if(response.success){
                        $scope.reloadList();//刷新列表
                    }
                }
            );
        }
    }
    //查询单个iot实体
    $scope.findOneIot=function (id) {
        stationService.findOneIot(id).success(
            function(response){
                $scope.IotEntity= response;
            }
        );
    }
    //根据站点id查询设备
    $scope.findDevice=function (id) {
        stationService.findDevice(id).success(
            function(response){
                $scope.deviList= response;
               console.log($scope.deviList);
            }
        );
    }
    //调用后台导出功能  /equipment/gen/GenFile
    $scope.export=function (id) {
        alert("导出");
        window.open("../equipment/gen/download?id="+id );
        /*stationService.export(id).success(
            function(response){
               alert("导出成功");

            }
        );*/
    }

});