//控制层
app.controller('communicateController',function ($scope,$controller,communicateService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        communicateService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        communicateService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        communicateService.findOne(id).success(
            function(response){
                $scope.communicateEntity= response;
                $scope.communicateEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.communicateEntity.status == 1){//如果有状态
            serviceObject=communicateService.update( $scope.communicateEntity ); //修改
        }else{
            serviceObject=communicateService.add( $scope.communicateEntity  );//增加
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
            communicateService.dele( id ).success(
                function(response){
                    if(response.success){
                        $scope.reloadList();//刷新列表
                    }
                }
            );
        }
    }

    //为select2下拉框定义通讯类型数组
    $scope.communicats=[{id:1,text:'串口通讯'},{id:2,text:'TCP客户端通讯'},{id:3,text:'TCP服务端通讯'},{id:4,text:'SNMP通讯'}];

    $scope.enableList=[{id:1,text:'启用'},{id:0,text:'禁用'}];

});