var app = angular.module('angularApp',['ngRoute']);

app.config(function($routeProvider){
    $routeProvider.when('/',{
        templateUrl: 'pages/home.html',
        controller: 'homeController'
    })
    .when('/foreCast',{
          templateUrl: 'pages/ForeCast.html',
        controller: 'foreCastController'
    })
                        
});
app.service('shareService',function(){
    
    this.name = 'tenit';
});
app.controller('homeController',['$scope','shareService',function($scope,shareService){
    $scope.username = shareService.name;
    $scope.$watch('username',function(){
    shareService.name = $scope.username;
    });
}]);
app.controller('foreCastController',['$scope','shareService',function($scope,shareService){
    $scope.names = shareService.name;
}]);