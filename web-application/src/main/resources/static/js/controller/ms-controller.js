var app = angular.module('microservicesSampleApp');
app.controller('MicroservicesSampleController', ['$scope', '$http',
  function($scope, $http) {
    $scope.one = function(points, evt) {
      $('#service-one').addClass("active");
      $('#service-two').removeClass("active");
      $('#service-three').removeClass("active");
      $scope.call("one");
    }, $scope.two = function(points, evt) {
      $('#service-one').removeClass("active");
      $('#service-two').addClass("active");
      $('#service-three').removeClass("active");
      $scope.call("two");
    }, $scope.three = function(points, evt) {
      $('#service-one').removeClass("active");
      $('#service-two').removeClass("active");
      $('#service-three').addClass("active");
      $scope.call("three");
    }, $scope.call = function(service_no) {
      var request = $http.get("http://localhost:8080/service-" 
    		  + service_no);
      request.success(function(response){
    	  $scope.response = angular.copy(response.data);
      });
    }
  }
]);