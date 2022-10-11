<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Signup</title>
    <%@include file="all_js_css.jsp" %>
</head>
<body>

  <div class="container-fluid p-0">
  	<%@include file="navbar.jsp"%>
  </div>
  <div>
  </div>
  
  <!--Login from start from here  -->
  
  <div class="global-container">
	<div class="card login-form">
	<div class="card-body">
		<h3 class="card-title text-center">Sign Up Voters</h3>
		<div class="card-text">
			<!--
			<div class="alert alert-danger alert-dismissible fade show" role="alert">Incorrect username or password.</div> -->
			<form action="register_user_id" method="post">
				<!-- to error: add class "has-danger" -->
				<div class="form-group">
					<label for="exampleInputEmail1">Name</label>
					<input 
					name="votername"
					type="text" 
					class="form-control form-control-sm" 
					id="votername" 
					aria-describedby="emailHelp">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Aadhar number</label>
					<input 
					name="voteraadhar"
					type="text" 
					class="form-control form-control-sm" 
					id="voterAadhar" 
					aria-describedby="emailHelp">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<input 
					name="voteremailaddress"
					type="email" 
					class="form-control form-control-sm" 
					id="voterEmail" 
					aria-describedby="emailHelp"> 
				</div>
				<div class="form-check form-check-inline pt-1">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
				  <label class="form-check-label" for="inlineRadio1">Voter</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
				  <label class="form-check-label" for="inlineRadio2">Member</label>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label>
					<input 
					name="voterpassword"					
					type="password" 
					class="form-control form-control-sm" 
					id="voterPassword">
				</div>
				<button type="submit" class="btn btn-primary btn-block">Sign in</button>
				
				<div class="Login">
					Already have an account? <a href="voterlogin.jsp">Login</a>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
  
  
    <%@include file="footer.jsp" %>
  
</body>
</html>