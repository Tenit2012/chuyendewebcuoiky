var app = angular.module('detailMeetingApp', []);
app.controller('DetailmeetingController', meetingController);
var link = 'http://localhost:8080/smeetingregister/sworld'
function meetingController($scope, $http) {
	$scope.viewDetail = function() {
		$scope.partakerObj = {};
		$scope.customObjectAttend = {};
		var barcodes = $scope.barcode;
		$http
				.get(
						link + '/meetingregister/getdetailmeetingbybarcode/'
								+ barcodes).then(function(response) {
					if (response.data.status == "SUCCESS") {
						$scope.meeting = response.data.obj;
						$scope.partaker = response.data.obj.partaker;
						$scope.detail = response.data.obj.detailMeeting;
						$scope.hour = response.data.obj.hour;
						$scope.minute = response.data.obj.minute;
						$scope.orgname = response.data.obj.orgMeetingName;
						$scope.barcode = "";
						$scope.orgpartakerid = response.data.obj.orgPartakerId;
						bindingdata(response.data.obj);
					}
				}, function errorCallback(response) {
					console.log(response.statusText);
				});

	}
	$scope.selectPartaker = function(user) {
		$scope.partakerObj = user;
	}
	$scope.deletePartaker = function() {
		var objDelete = $scope.partakerObj;
		$http.get(link + '/partaker/deletepartaker/' + objDelete.id).then(
				function(response) {
					if (response.data.status == "SUCCESS") {
						$scope.listObj.splice($scope.listObj
								.indexOf($scope.partakerObj), 1);
					}
				}, function errorCallback(response) {
					console.log(response.statusText);
				});
	}
	$scope.addPartaker = function() {
		var customObjectTosyn = $scope.customObjectAttend;
		var dataObj = {
			"id" : 0,
			"name" : $scope.name,
			"position" : $scope.posision,
			"email" : $scope.email,
			"orgPartakerId" : $scope.customObjectAttend.orgattendId
		};
		var dataType = {
			dataType : "json"
		};
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		};
		var res = $http.post(link + '/partaker/insertpartaker', dataObj,
				dataType, config);
		res.then(function(response) {
			if (response.data.status == "SUCCESS") {
				$scope.name = "";
				$scope.posision = "";
				$scope.email = "";
			}
			bindingdata(customObjectTosyn);

		}, _error);
	}
	function bindingdata(obj) {
		$scope.customObjectAttend = obj;
		var partaker = obj.partaker;
		$http.get(link + '/partaker/getlistpartakerbyorgid/' + obj.orgattendId)
				.then(function(response) {
					if (response.data.status == "SUCCESS") {
						$scope.listObj = response.data.obj;
					}
				}, function errorCallback(response) {
					console.log(response.statusText);
				});
	}

	function _error(response) {
		console.log(response.statusText);
	}
}
