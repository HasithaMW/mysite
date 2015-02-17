<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    
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
   
   </head>

   <body >
   <div id="wrapper" >
	   <!-- Navigation -->
	   <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0" >
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
	          
	    </nav>
	 	<div id="page-wrapper"  >
	 		<tiles:insertAttribute name="content" />
	  	</div>
        <!-- /#page-wrapper -->
	</div>
	
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