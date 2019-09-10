//控制层
app.controller('channelTypeController',function ($scope,$controller,channelTypeService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        channelTypeService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        channelTypeService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        channelTypeService.findOne(id).success(
            function(response){
                $scope.channlEntity= response;
                $scope.channlEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.channlEntity.status == 1){//如果有状态
            serviceObject=channelTypeService.update( $scope.channlEntity ); //修改
        }else{
            serviceObject=channelTypeService.add( $scope.channlEntity  );//增加
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
            channelTypeService.dele( id ).success(
                function(response){
                    if(response.success){
                        $scope.reloadList();//刷新列表
                    }
                }
            );
        }
    }
    //查询管道所属的设备类型
    $scope.findDevcieTypeByid=function(id){
        channelTypeService.findDevcieTypeByid(id).success(
            function(response){
                $scope.devcieTypeEntity= response;
            }
        );
    }


    //初始化方法
    $scope.findSelect=function(){
        findDevcieType();
    }
    /*类型下拉框设置*/
    $scope.deviceTypes=[]
    //查询所有设备类型
    findDevcieType=function () {
        channelTypeService.findDevcieType().success(
            function(response){

                $scope.deviceTypes=response;
            }
        );
    }
    /*定义类型的数据字典转换的方法*/
    $scope.findDeviceTypeText=function (id) {
        for (var i=0;i<$scope.deviceTypes.length;i++){
            if($scope.deviceTypes[i].id==id){
                return $scope.deviceTypes[i].text;
            }
        }
    }

    //定义通道类型下拉框数组
    $scope.channeltypes=[{id:1,text:'遥测'},{id:2,text:'遥信'},{id:3,text:'遥调'},{id:4,text:'遥控'}];
    //定义数据类型下拉框数组
    $scope.datatypes=[{id:1,text:'Float'},{id:2,text:'Int'},{id:3,text:'String'}];
    //定义是否必选下拉框数组
    $scope.requireds=[{id:1,text:'TRUE'},{id:2,text:'FALSE'}];




});