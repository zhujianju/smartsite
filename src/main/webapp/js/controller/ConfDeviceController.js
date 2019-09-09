//控制层
app.controller('deviceController',function ($scope,$controller,deviceService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        deviceService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        deviceService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne=function(id){
        deviceService.findOne(id).success(
            function(response){
                $scope.deivceEntity= response;

                $scope.deivceEntity.status=1;
            }
        );
    }

    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.deivceEntity.status == 1){//如果有状态
            serviceObject=deviceService.update( $scope.deivceEntity ); //修改
        }else{
            serviceObject=deviceService.add( $scope.deivceEntity  );//增加
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
            deviceService.dele( id ).success(
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
        deviceService.findOneIot(id).success(
            function(response){
                $scope.IotEntity= response;
            }
        );
    }
    //根据站点id查询设备
    $scope.findDevice=function (id) {
        deviceService.findDevice(id).success(
            function(response){
                $scope.deviList= response;
            }
        );
    }
    //初始化方法
    $scope.findSelect=function(){
        findSataion();
        findCommunicate();
        findDevcieType();
    }

    /*站点下拉框设置*/
    $scope.stationList=[];
    //查询所有站点
    findSataion=function () {
        deviceService.findSataion().success(
            function(response){
                $scope.stationList= response;
            }
        );
    }



    /*类型下拉框设置*/
    $scope.deviceTypes=[]
    //查询所有站点
    findDevcieType=function () {
        deviceService.findDevcieType().success(
            function(response){
                $scope.deviceTypes=response;
            }
        );
    }

    /*通讯下拉框设置*/
    $scope.communicates=[];
    //查询所有站点
    findCommunicate=function () {
        deviceService.findCommunicate().success(
            function(response){
                $scope.communicates= response;
            }
        );
    }

    $scope.enableList=[{id:1,text:'启用'},{id:2,text:'禁用'}];
});