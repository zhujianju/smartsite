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

    //搜索并分页
    $scope.search=function(page,rows){
        stationService.findPage(page,rows).success(
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
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.stationEntity.id!=null){//如果有ID
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
});