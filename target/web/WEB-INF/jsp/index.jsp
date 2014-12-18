<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html ng-app="app">
   <head>
   <title>Hello Spring MVC</title>
   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css.map" >
   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.css.map" >
   
   <script type="text/javascript" src="resources/js/angularjs/angular.min.js"></script>
   <script type="text/javascript" src="resources/js/angularjs/angular-route.min.js"></script>
   <script type="text/javascript" src="resources/js/angularjs/angular-resource.min.js"></script>

	<style>
	    .fieldValid {
	        border: 1px solid #00ff00;
	    }
	    .fieldInvalid {
	        border: 1px solid #ff0000;
	    }
	</style>

   </head>

   <body>
   		<div ng-controller="hello">
			<h2>Spring MVC + AngularJS Demo</h2>
			<p>User Name : {{user.userName}}</p>
		</div>
  	<a href="#/route1">Route 1</a><br/>
  		<div ng-controller="MyController" >
		    <form  name="userNg"  novalidate>
		        <input type="text" name="userName" ng-model="userForm.userName" 
		        		ng-class="userForm.getFormFieldCssClass(userNg.userName)" ng-minlength="2" > First name <br/>
		        <input type="text" name="lastName"  ng-model="userForm.lastName"> Last name <br/>
		    </form>
		
<!-- 		    <div> -->
<!-- 		        {{userForm.userName}} {{userForm.lastName}} -->
<!-- 		    </div> -->
		    
		    <div ng-show="userNg.userName.$invalid">
	            You must enter a valid name.
	        </div>
		    <button ng-click="userForm.submitTheForm()">Submit Form</button>
		</div>
		
		<div ng-view></div>
		
  	<script>
  	
  	function hello($scope, $http) {
	    $http.get('http://localhost:8080/web/home').
	        success(function(data) {
	        	$scope.user = data;
	        });
	}
  	
  	
	 var app =   angular.module("app", ['ngRoute']);
	 app.controller("MyController", function($scope, $http,$route,$location) {
           $scope.userForm = {};
           $scope.userForm.submitTheForm = function(item, event) {

           var user = {
           	userName : $scope.userForm.userName
              ,lastName  : $scope.userForm.lastName
           };
           
           $http.defaults.headers.post["Content-Type"] = "application/json";
           var responsePromise = $http.post("http://localhost:8080/web/home/save", user);
              
           responsePromise.success(function(dataFromServer, status, headers, config) {
        	   $location.path('saved');
           });
               
            responsePromise.error(function(data, status, headers, config) {
              alert("Submitting form failed!");
           });

	
           }
	                
     } );
	    
// var app = angular.module('app', []);

app.config(function ($routeProvider, $locationProvider) {
  $routeProvider
    .when('/saved', {
        templateUrl: 'http://localhost:8080/web/home/test',
        controller: 'MyController'
    }).
    when('/route2', {
        templateUrl: 'angular-route-template-2.jsp',
        controller: 'MyController'
    }).
    otherwise({
        redirectTo: '/'
    });
});

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
	</script>
   </body>
</html>