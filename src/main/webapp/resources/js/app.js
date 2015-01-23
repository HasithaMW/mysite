/**
 * 
 */


//function hello($scope, $http) {
//	    $http.get('http://localhost:8080/web/home').
//	        success(function(data) {
//	        	$scope.user = data;
//	        });
//	}
//  	
  	
	 var app =   angular.module('app', ['ngSanitize']);
	 app.controller("menuController", function($scope,$http) {
		 $scope.init = function () {
			 $http.get('topmenu').success(function(data) {
				 $scope.topMenu = data;
	        });
		 };
		 
	 });
	 
//	 app.controller("MyController", function($scope, $http,$route,$location) {
//		 
//		 $scope.modal = {
//				  "title": "Title",
//				  "content": "Hello Modal<br />This is a multiline message!"
//				};
//		 
//           $scope.userForm = {};
//           $scope.userForm.submitTheForm = function(item, event) {
//
//           var user = {
//           	userName : $scope.userForm.userName
//              ,lastName  : $scope.userForm.lastName
//              ,password  : $scope.userForm.password
//           };
//           
//           $http.defaults.headers.post["Content-Type"] = "application/json";
//           var responsePromise = $http.post("http://localhost:8080/web/home/save", user);
//              
//           responsePromise.success(function(dataFromServer, status, headers, config) {
//        	   $location.path('saved');
//           });
//               
//            responsePromise.error(function(data, status, headers, config) {
//              alert("Submitting form failed!");
//           });
//
//	
//           }
//	                
//     } );
	    
// var app = angular.module('app', []);

//app.config(function ($routeProvider, $locationProvider) {
//  $routeProvider
//    .when('/saved', {
//        templateUrl: 'http://localhost:8080/web/home/test',
//        controller: 'MyController'
//    }).
//    when('/route2', {
//        templateUrl: 'angular-route-template-2.jsp',
//        controller: 'MyController'
//    }).
//    otherwise({
//        redirectTo: '/'
//    });
//});


// app.controller("MyController", function ($rootScope) {
//   $rootScope.$on("$routeChangeStart", 
//                  function (event, current, previous, rejection) {
//     console.log($scope, $rootScope, $route, $location);
//   });      
//   $rootScope.$on("$routeChangeSuccess", 
//                  function (event, current, previous, rejection) {
//     console.log($scope, $rootScope, $route, $location);
//   });
// });

// var viewCtrl = app.controller("ViewCtrl", function ($scope, $route) {
//   $scope.changeRoute = function () {
//     console.log($scope);
//     $location.path("/new");
//   }
// });

// app.controller("NewCtrl", function($scope, loadData, $template) {
//   console.log($scope, loadData, $template);
// });

// viewCtrl.loadData = function ($q, $timeout) {
//   var defer = $q.defer;
//   $timeout(function () {
//     defer.resolve({message:"success"}); 
//   }, 2000);
//   return defer.promise;
// };