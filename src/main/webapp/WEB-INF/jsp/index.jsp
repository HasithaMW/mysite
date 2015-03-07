<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<ul class="nav nav-tabs">
    <li class="active">
    	<a href="#rated" data-toggle="tab">Top Rated</a>
    </li>
    <li>
    	<a href="#views" data-toggle="tab">Most Views</a>
    </li>
    <li>
    	<a href="#topics" data-toggle="tab">Topics</a>
    </li>
    <li>
    	<a href="#settings" data-toggle="tab">Test</a>
    </li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane fade in active" id="rated">
		<div class="well well-sm">
			<div class="row">
				<div class="col-lg-2">
					<h4>Small Well</h4>
				</div>
				<div class="col-lg-10">
         			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
				</div>
			</div>
       	</div> 
       	<div class="well well-sm">
			<div class="row">
				<div class="col-lg-2">
					<h4>Small Well</h4>
				</div>
				<div class="col-lg-10">
         			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
				</div>
			</div>
       	</div>    
    </div>
    <div class="tab-pane fade" id="views">
        <h4>Profile Tab</h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    </div>
    <div class="tab-pane fade" id="topics">
        <h4>Messages Tab</h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    </div>
    <div class="tab-pane fade" id="settings">
    	<c:url var="addAction" value="/add" ></c:url>
    	<form:form action="${addAction}" commandName="user">
		<table>
		    <tr>
		        <td>
		            <form:label path="userName">
		                <spring:message text="User Name"/>
		            </form:label>
		        </td>
		        <td>
		            <form:input path="userName"  size="8"   />
		        </td> 
		    </tr>
		 
		    <tr>
		        <td>
		            <form:label path="lastName">
		                <spring:message text="lastName"/>
		            </form:label>
		        </td>
		        <td>
		            <form:input path="lastName" />
		        </td> 
		    </tr>
		    <tr>
		        <td>
		            <form:label path="password">
		                <spring:message text="Country"/>
		            </form:label>
		        </td>
		        <td>
		        	<form:password path="password"/>
		        </td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <c:if test="${!empty user.userName}">
		                <input type="submit"
		                    value="<spring:message text="Edit User"/>" />
		            </c:if>
		            <c:if test="${empty user.userName}">
		                <input type="submit"
		                    value="<spring:message text="Add User"/>" />
		            </c:if>
		        </td>
		    </tr>
		</table>  
	</form:form>
    	
    	
    </div>
</div>