<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>

<form name='loginForm' action="<c:url value='/login.htm' />" method='POST'>

	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='username' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password' /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit"
				value="submit" /></td>
		</tr>
	</table>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

</form>

<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h2>
		User : ${pageContext.request.userPrincipal.name} | <a
			href="javascript:formSubmit()"> Logout</a>
	</h2>
</c:if>