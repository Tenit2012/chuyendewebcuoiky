var app = angular.module('angularApp', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/',{
		templateUrl: '/Home.html',
        controller:'homeController'
	})
    .when('/register',{
        templateUrl: '/Register.html',
        controller:'RegisterController'
    })
    ;
});
app.controller('homeController',['$scope', function($scope){
    
}]);
app.controller('RegisterController',['$scope', function($scope){
    
}]);