//控制层
app.controller('iotproductController',function ($scope,$controller,iotproductService) {
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
        iotproductService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        iotproductService.findOne(id).success(
            function(response){
                $scope.IotEntity= response;
                $scope.IotEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.IotEntity.status == 1){//如果有状态
            serviceObject=iotproductService.update( $scope.IotEntity ); //修改
        }else{
            serviceObject=iotproductService.add( $scope.IotEntity  );//增加
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
            iotproductService.dele( id ).success(
                function(response){
                    if(response.success){
                        $scope.reloadList();//刷新列表
                    }
                }
            );
        }
    }

    //根据iotId查询站点信息
    $scope.findIotStation=function (id) {
        iotproductService.findIotStation(id).success(
            function (response) {
                $scope.stationList=response;
            }
        );
    }

});