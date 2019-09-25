//控制层
app.controller('recordAlarmlogController',function ($scope,$controller,recordAlarmlogService) {
    $controller('baseController',{$scope:$scope});//继承通用的控制层

    //分页
    $scope.findPage=function(page,rows){
        recordAlarmlogService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.searchEntity={};//定义搜索对象
    //搜索并分页
    $scope.search=function(page,rows){
        recordAlarmlogService.findPage(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

    //初始化方法
    $scope.findSelect=function(){
        findSataion();
        findDevcie();
        findDevcieType();
        findChann();
    }

    /*站点下拉框设置*/
    $scope.stationList=[];
    //查询所有站点
    findSataion=function () {
        recordAlarmlogService.findSataion().success(
            function(response){
                $scope.stationList= response;
            }
        );
    }

    /*定义站点的数据字典转换的方法*/
    $scope.findStationText=function (id) {
        for (var i=0;i<$scope.stationList.length;i++){
            if($scope.stationList[i].id==id){
                return $scope.stationList[i].text;
            }
        }
    }

    /*设备类型下拉框设置*/
    $scope.deviceTypes=[]
    //查询所有设备类型
    findDevcieType=function () {
        recordAlarmlogService.findDevcieType().success(
            function(response){
                $scope.deviceTypes=response;
            }
        );
    }

    /*定义设备类型的数据字典转换的方法*/
    $scope.findDeviceTypeText=function (id) {
        for (var i=0;i<$scope.deviceTypes.length;i++){
            if($scope.deviceTypes[i].id==id){
                return $scope.deviceTypes[i].text;
            }
        }
    }

    /*设备下拉框设置*/
    $scope.devices=[];
    //查询所有设备
    findDevcie=function () {
        recordAlarmlogService.findDevcie().success(
            function(response){
                $scope.devices= response;
            }
        );
    }
    /*定义设备的数据字典转换的方法*/
    $scope.findDevice=function (id) {
        for (var i=0;i<$scope.devices.length;i++){
            if($scope.devices[i].id==id){
                return $scope.devices[i].text;
            }
        }
    }

    /*通道下拉框设置*/
    $scope.channels=[];
    //查询所有设备
    findChann=function () {
        recordAlarmlogService.findAllChann().success(
            function(response){
                $scope.channels= response;
            }
        );
    }
    /*定义设备的数据字典转换的方法*/
    $scope.findChannlText=function (id) {
        for (var i=0;i<$scope.channels.length;i++){
            if($scope.channels[i].id==id){
                return $scope.channels[i].text;
            }
        }
    }


});