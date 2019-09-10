//控制层
app.controller('deviceTypeController',function ($scope,$controller,deviceTypeService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        deviceTypeService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        deviceTypeService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        deviceTypeService.findOne(id).success(
            function(response){
                $scope.deviceTypeEntity= response;
                $scope.deviceTypeEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.deviceTypeEntity.status == 1){//如果有状态
            serviceObject=deviceTypeService.update( $scope.deviceTypeEntity ); //修改
        }else{
            serviceObject=deviceTypeService.add( $scope.deviceTypeEntity  );//增加
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
            deviceTypeService.dele( id ).success(
                function(response){
                    if(response.success){
                        $scope.reloadList();//刷新列表
                    }
                }
            );
        }
    }

    //根据设备类型id查找所有的通道
    $scope.findChannelTypeByDeviceId=function(id){
        deviceTypeService.findChannelTypeByDeviceId(id).success(
            function(response){
                $scope.channelList=response;
            }
        );
    }

    //定义标识主服务字段下拉框数组
    $scope.optionList=[{id:'Master',text:'Master(主服务)'},{id:'Mandatory',text:'Mandatory(必选服务)'},{id:'Optional',text:'Optional(可选服务)'}];

});