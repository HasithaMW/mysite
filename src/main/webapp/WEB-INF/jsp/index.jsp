<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
   <head>
   	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   
   <title>Hello Spring MVC</title>
   <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/theme.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/metisMenu.min.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/morris.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/main.css" >
   <link rel="stylesheet" type="text/css" href="resources/css/timeline.css" >
   
   <link rel="stylesheet" href="resources/fonts/font-awesome/css/font-awesome.min.css">
   
   <script type="text/javascript" src="resources/js/angularjs/angular.min.js"></script>
   
<!-- 	<script type="text/javascript" src="resources/js/angularstrap/angular-strap.min.js"></script> -->
<!-- 	<script type="text/javascript" src="resources/js/angularstrap/angular-strap.tpl.min.js"></script> -->
	
   </head>

   <body >
   <div id="wrapper">
   
   <!-- Navigation -->
   <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0" ng-app="app">
		<div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
                 
            </div>
            <!-- /.navbar-header -->
            
            <div  >
            
            
            <%
            	boolean isLogedin = true;
            	if(!isLogedin){
            %>		
            	<div class="nav navbar-top-login navbar-right">
					<form class="navbar-form">
					   <input class="span2" type="text" placeholder="Email">
					   <input class="span2" type="password" placeholder="Password">
					   <button type="submit" class="btn">Sign in</button>
					 </form>
				</div>
            <% 		
            	}
            	else{
       		%>
       				<ul class="nav navbar-top-links navbar-right">
		                <li class="dropdown">
		                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
		                    </a>
		                    <ul class="dropdown-menu dropdown-messages">
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <strong>John Smith</strong>
		                                    <span class="pull-right text-muted">
		                                        <em>Yesterday</em>
		                                    </span>
		                                </div>
		                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <strong>John Smith</strong>
		                                    <span class="pull-right text-muted">
		                                        <em>Yesterday</em>
		                                    </span>
		                                </div>
		                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <strong>John Smith</strong>
		                                    <span class="pull-right text-muted">
		                                        <em>Yesterday</em>
		                                    </span>
		                                </div>
		                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a class="text-center" href="#">
		                                <strong>Read All Messages</strong>
		                                <i class="fa fa-angle-right"></i>
		                            </a>
		                        </li>
		                    </ul>
		                    <!-- /.dropdown-messages -->
		                </li>
		                <!-- /.dropdown -->
		                <li class="dropdown">
		                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
		                    </a>
		                    <ul class="dropdown-menu dropdown-tasks">
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <p>
		                                        <strong>Task 1</strong>
		                                        <span class="pull-right text-muted">40% Complete</span>
		                                    </p>
		                                    <div class="progress progress-striped active">
		                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
		                                            <span class="sr-only">40% Complete (success)</span>
		                                        </div>
		                                    </div>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <p>
		                                        <strong>Task 2</strong>
		                                        <span class="pull-right text-muted">20% Complete</span>
		                                    </p>
		                                    <div class="progress progress-striped active">
		                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
		                                            <span class="sr-only">20% Complete</span>
		                                        </div>
		                                    </div>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <p>
		                                        <strong>Task 3</strong>
		                                        <span class="pull-right text-muted">60% Complete</span>
		                                    </p>
		                                    <div class="progress progress-striped active">
		                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
		                                            <span class="sr-only">60% Complete (warning)</span>
		                                        </div>
		                                    </div>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <p>
		                                        <strong>Task 4</strong>
		                                        <span class="pull-right text-muted">80% Complete</span>
		                                    </p>
		                                    <div class="progress progress-striped active">
		                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
		                                            <span class="sr-only">80% Complete (danger)</span>
		                                        </div>
		                                    </div>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a class="text-center" href="#">
		                                <strong>See All Tasks</strong>
		                                <i class="fa fa-angle-right"></i>
		                            </a>
		                        </li>
		                    </ul>
		                    <!-- /.dropdown-tasks -->
		                </li>
		                <!-- /.dropdown -->
		                <li class="dropdown">
		                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
		                    </a>
		                    <ul class="dropdown-menu dropdown-alerts">
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <i class="fa fa-comment fa-fw"></i> New Comment
		                                    <span class="pull-right text-muted small">4 minutes ago</span>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
		                                    <span class="pull-right text-muted small">12 minutes ago</span>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
		                                    <span class="pull-right text-muted small">4 minutes ago</span>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <i class="fa fa-tasks fa-fw"></i> New Task
		                                    <span class="pull-right text-muted small">4 minutes ago</span>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a href="#">
		                                <div>
		                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
		                                    <span class="pull-right text-muted small">4 minutes ago</span>
		                                </div>
		                            </a>
		                        </li>
		                        <li class="divider"></li>
		                        <li>
		                            <a class="text-center" href="#">
		                                <strong>See All Alerts</strong>
		                                <i class="fa fa-angle-right"></i>
		                            </a>
		                        </li>
		                    </ul>
		                    <!-- /.dropdown-alerts -->
		                </li>
		                <!-- /.dropdown -->
		                <li class="dropdown">
		                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
		                    </a>
		                    <ul class="dropdown-menu dropdown-user">
		                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
		                        </li>
		                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
		                        </li>
		                        <li class="divider"></li>
		                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
		                        </li>
		                    </ul>
		                    <!-- /.dropdown-user -->
		                </li>
	                <!-- /.dropdown -->
            		</ul>	
	            <!-- /.navbar-top-links -->
       			
            <%		
            	}
            %>
            </div>
				<div class="navbar-default sidebar" role="navigation">
	                <div class="sidebar-nav navbar-collapse">
	                    <ul class="nav" id="side-menu">
	                        <li class="sidebar-search">
	                            <div class="input-group custom-search-form">
	                                <input type="text" class="form-control" placeholder="Search...">
	                                <span class="input-group-btn">
	                                <button class="btn btn-default" type="button">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </span>
	                            </div>
	                            <!-- /input-group -->
	                        </li>
	                        <li>
	                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="flot.html">Flot Charts</a>
	                                </li>
	                                <li>
	                                    <a href="morris.html">Morris.js Charts</a>
	                                </li>
	                            </ul>
	                            <!-- /.nav-second-level -->
	                        </li>
	                        <li>
	                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
	                        </li>
	                        <li>
	                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="panels-wells.html">Panels and Wells</a>
	                                </li>
	                                <li>
	                                    <a href="buttons.html">Buttons</a>
	                                </li>
	                                <li>
	                                    <a href="notifications.html">Notifications</a>
	                                </li>
	                                <li>
	                                    <a href="typography.html">Typography</a>
	                                </li>
	                                <li>
	                                    <a href="icons.html"> Icons</a>
	                                </li>
	                                <li>
	                                    <a href="grid.html">Grid</a>
	                                </li>
	                            </ul>
	                            <!-- /.nav-second-level -->
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="#">Second Level Item</a>
	                                </li>
	                                <li>
	                                    <a href="#">Second Level Item</a>
	                                </li>
	                                <li>
	                                    <a href="#">Third Level <span class="fa arrow"></span></a>
	                                    <ul class="nav nav-third-level">
	                                        <li>
	                                            <a href="#">Third Level Item</a>
	                                        </li>
	                                        <li>
	                                            <a href="#">Third Level Item</a>
	                                        </li>
	                                        <li>
	                                            <a href="#">Third Level Item</a>
	                                        </li>
	                                        <li>
	                                            <a href="#">Third Level Item</a>
	                                        </li>
	                                    </ul>
	                                    <!-- /.nav-third-level -->
	                                </li>
	                            </ul>
	                            <!-- /.nav-second-level -->
	                        </li>
	                        <li>
	                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
	                            <ul class="nav nav-second-level">
	                                <li>
	                                    <a href="blank.html">Blank Page</a>
	                                </li>
	                                <li>
	                                    <a href="login.html">Login Page</a>
	                                </li>
	                            </ul>
	                            <!-- /.nav-second-level -->
	                        </li>
	                    </ul>
	                </div>
	                <!-- /.sidebar-collapse -->
	            </div>

    </nav>
   
   
	  
	  <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" placeholder="Email address">
        <input type="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>
	  
	  
	</div>
	<!-- 
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
		        <input type="password" name="password"  ng-model="userForm.password"> password <br/>
		    </form>
		

		    <div ng-show="userNg.userName.$invalid">
	            You must enter a valid name.
	        </div>
		    <button ng-click="userForm.submitTheForm()" class="btn btn-lg btn-primary" 
		    	data-animation="am-fade-and-scale" data-placement="center" bs-modal="modal">Submit Form</button>
		</div>
		
		<div ng-view></div>
		 -->
		 


<script type="text/javascript" src="resources/js/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap/metisMenu.min.js"></script>	
<script type="text/javascript" src="resources/js/bootstrap/raphael-min.js"></script>	
<script type="text/javascript" src="resources/js/bootstrap/raphael-min.js"></script>	
<script type="text/javascript" src="resources/js/bootstrap/morris.min.js"></script>		
<script type="text/javascript" src="resources/js/bootstrap/morris-data.js"></script>	
<script type="text/javascript" src="resources/js/bootstrap/flot-data.js"></script>	
<script type="text/javascript" src="resources/js/bootstrap/theme.js"></script>	 
  	<script>
  	
  	function hello($scope, $http) {
	    $http.get('http://localhost:8080/web/home').
	        success(function(data) {
	        	$scope.user = data;
	        });
	}
  	
  	
	 var app =   angular.module("app", ['ngRoute']);
	 app.controller("MyController", function($scope, $http,$route,$location) {
		 
		 $scope.modal = {
				  "title": "Title",
				  "content": "Hello Modal<br />This is a multiline message!"
				};
		 
           $scope.userForm = {};
           $scope.userForm.submitTheForm = function(item, event) {

           var user = {
           	userName : $scope.userForm.userName
              ,lastName  : $scope.userForm.lastName
              ,password  : $scope.userForm.password
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