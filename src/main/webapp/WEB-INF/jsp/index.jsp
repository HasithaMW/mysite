<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="app">
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
   <script type="text/javascript" src="resources/js/angularjs/angular-route.min.js"></script>
   
<!-- 	<script type="text/javascript" src="resources/js/angularstrap/angular-strap.min.js"></script> -->
<!-- 	<script type="text/javascript" src="resources/js/angularstrap/angular-strap.tpl.min.js"></script> -->
	
   </head>

   <body >
   <div id="wrapper">
   
   <!-- Navigation -->
   <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0" 
   data-ng-controller="menuController" ng-init="init()">
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
            
            <div ng-bind-html="topMenu" >
	           
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
<script type="text/javascript" src="resources/js/bootstrap/morris.min.js"></script>		
<!-- <script type="text/javascript" src="resources/js/bootstrap/morris-data.js"></script>	 -->
<!-- <script type="text/javascript" src="resources/js/bootstrap/flot-data.js"></script>	 -->
<script type="text/javascript" src="resources/js/bootstrap/theme.js"></script>	 
<script type="text/javascript" src="resources/js/app.js"></script>	 
 
   </body>
</html>