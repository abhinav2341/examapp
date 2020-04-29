<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>login page</title>
	<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/background.css">
	<link rel="stylesheet" type="text/css" href="resources/css/animate.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style type="text/css">
		input {
 			 	border: none;
 				border-bottom: 2px solid red;
			}
		input:focus{
			background-color: none;
			border: none;
			border-bottom: 2px solid red;
		}
		#message
		{
			font-family: 'Baloo Bhai', cursive;	
		}
		body
		{
			background: #4e73df;
			padding: none;
			height: auto;
		}
		#header
		{
			margin: 5%;
		}
		#left-block,#right-block,#center-block
		{
			margin:none;
			padding:none;
		}
		.card
		{
			background-color: white;font-weight: bold;color: red;
			height: 45em;
			width: 60em;
		}
		.card-body {
 			background: ;
    		display: inherit;
    		height: -webkit-fill-available;
		}
		#image
		{
			display:flex;
			height:100%;
			width :100%;
		}
		img
		{
			display:flex;
			height:100%;
			width:100%;
		}
		.form-body
		{
			display:flex;
			align:center;
			height: -webkit-fill-available;
		}
		label
		{
			font-size: 4rem;
    		font-weight: lighter;
			color:#3a3b45;
			text-align:center;
			padding-left:13.5rem;
			width:40rem;
			height: calc(1.5em + .75rem + 2px);
		}
		.form-control
		{
			width:40rem;
			/* margin:20rem; */
			height: calc(1.5em + .75rem + 2px);
			border-radius: 40rem;
		    font-size: medium;
		    font-weight: lighter;
		    padding: 2.45rem
		}
		.button{
			width:40rem;
			border-radius: 40rem;
			font-weight: bold;
		}
		.card-body
		{
			display: block;
 			height: 50%;
    		width: 77%;
		}
		.card
		{
			height: 44rem;
			width: 64rem;
		}
		
	</style>
	
</head>
<body>
	<div class="container">
		<div id="wrapper">
			<div class="row" id="header"></div>	
<!-- *******************************************body****************************************************** -->
		    <div class="row" id="content">
		        <div class="col-lg-2 col-sm-2 col-xs-1" id="left-block"></div>
		        <div class="col-lg-8 col-sm-8 card col-xs-10" id="center-block"class="loginbox" 
		        style="">
						<div class="">
						    <div class="">
						    	<div class="col-sm-1 col-lg-1 col-xs-1"></div>
						    	<div class="col-sm-9 col-lg-9 col-xs-9">
						    		<div class="form-body card-body">
						    			<div class="col-sm-2 col-lg-2 col-xs-2"></div>
						    			<div class="col-sm-8 col-lg-8 col-xs-8">
						    				<div class="row">
								   			<div class="col-lg-12 col-sm-12 col-xs-12">
								   				<%-- <div id="errorMessage">
								   				<%
								   					if(request.getAttribute("ERROR_MESSAGE") != null) {
								   						String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
								   						out.println(errorMessage);
								   					}
								   				%>
								   				</div> --%>
								   			</div>
						    			</div>
							    		<div class="row">&nbsp;</div>
							    		<div class="row">&nbsp;</div>
							    		<div class="row">
								    		<div class="col-lg-6 col-sm-6 col-xs-6">
									    		<div id="form-container">
									    			<div id="form-content">
									    				<div class="row"></div>
									    				<div class="row">
									    					<form action="Login_authentication" method="post">
															<div class="form-group">
																<label>LOGIN</label>
															</div>
															<div class="form-group"> 
																<input type="email" class="form-control form-control-user" name="email" placeholder="Email" required>
															</div>
															<div class="form-group">
																<input type="password" class="form-control form-control-user" name="pass" placeholder="Password" required>
															</div>
															<button type="submit" class="button btn btn-primary btn-user btn-block">Log In</button>
														</form>	
									    				</div>
									    				<div class="row">
											   			<div class="col-lg-12 col-sm-12 col-xs-12">
											   				<div id="errorMessage">
											   				<%
											   					if(request.getAttribute("ERROR_MESSAGE") != null) {
											   						String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
											   						out.println(errorMessage);
											   					}
											   				%>
								   							</div>
								   						</div>
									    			</div>	
									    		</div>
											</div>
										</div>
						    			</div>
						    			<div class="col-sm-2 col-lg-2 col-xs-2"></div>
						    		</div>
						    	</div>
						    	<div class="col-sm-2 col-lg-2 col-xs-2"></div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-sm-2 col-xs-1" id="right-block" ></div>
			</div>    
	    </div>	
	</div>
	
</body>
</html>