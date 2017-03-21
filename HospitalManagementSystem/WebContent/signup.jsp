
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sapient HealthCare</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Medicinal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="applisalonion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<link rel="stylesheet" href="css/slider.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/web-font-->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>


</head>
<body>
<div class="header-top">
			  <div class="container">
					 <nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
						<div class="logo">
							</a><img src="images/logo.png" alt=" " /></h1>
							<h1><a class="navbar-brand" href="index.jsp"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sapient</span>HealthCare&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						  <div class="top-menu">
							<nav class="menu menu--francisco">
									<ul class="nav navbar-nav menu__list">
										<li class="menu__item menu__item--current"><a href="index.jsp" class="menu__link"><span class="menu__helper">Home</span></a></li>
										<li class="menu__item"><a href="personlogin.jsp" class="menu__link"><span class="menu__helper">Patient</span></a></li>
										
										<li class="menu__item"><a href="./HospitalInfo" class="menu__link"><span class="menu__helper">Hospital Info</span></a></li>
										<li class="menu__item"><a href="" onclick="history.go(-1);" class="menu__link"><span class="menu__helper">Back</span></a></li>
									</ul>
								</nav>
							</div>
					</div>
					<!-- /.navbar-collapse -->
				</nav>

			   <div class="clearfix"></div>
			</div>
	</div>
<br><br>
<!--//header-top-->
 <!-- //Line Slider -->
		<div class="top_banner two">
			<div class="container">
			       <div class="sub-hd-inner">
						<h3 class="tittle">Sign Up <span>Page</span></h3>
					</div>
			</div>
		</div>
	<!--/single-->
	

 <div class="single">
			<div class="container">
				<div class="article-post w3l">
				<div class="post-details s-page">
				<h2><span><a href="?lang=de">German</a>|<a href="?lang=en">English</a></span></h2>
		<div class="leave w3l">
			<h3>Enter <span> your details </span></h3>
			<br>
			<br>
				
					<div class="single-grid">
						<div class="single-us">
						
						<form:form action="./SignUpController" modelAttribute="person" method="post">
							<table>
									
									<tr>
										<td><c:set var="id"><spring:message code="id"/></c:set>
										<form:input path="personId" placeholder="${id}" /></td> 
										<td><form:errors path="personId"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="idType"><spring:message code="idType"/></c:set>
										<form:input path="personIdType" placeholder="${idType}" /></td> 
										<td><form:errors path="personIdType"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="name"><spring:message code="name"/></c:set>
										<form:input path="personName" placeholder="${name}" /></td> 
										<td><form:errors path="personName"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="dob"><spring:message code="dob"/></c:set>
										<input type="date" name="personDateOfBirth"  placeholder="${dob}"/></td>
										<%-- <td><form:input path="personDateOfBirth" value="${personDateOfBirth}"  hidden="hidden"/></td> 
										<td><form:errors path="personDateOfBirth"></form:errors></td> --%>
									</tr>
									<tr>
										<td><c:set var="age"><spring:message code="age"/></c:set>
										<form:input path="personAge" placeholder="${age}" /></td> 
										<td><form:errors path="personAge"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="gender"><spring:message code="gender"/></c:set>
										<form:radiobutton path="personGender" value="m" placeholder="${gender}" />Male</td> 
										<td><form:radiobutton path="personGender" value="f"  placeholder="${gender}" />Female</td>
										<td><form:errors path="personGender"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="address"><spring:message code="address"/></c:set>
										<form:input path="personAddress" placeholder="${address}" /></td> 
										<td><form:errors path="personAddress"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="ph"><spring:message code="ph"/></c:set>
										<form:input path="personPhoneNo" placeholder="${ph}" /></td> 
										<td><form:errors path="personPhoneNo"></form:errors></td>
									</tr>
									<tr>
										<td><c:set var="password"><spring:message code="password"/></c:set>
										<form:password path="personPassword" placeholder="${password}" /></td> 
										<td><form:errors path="personPassword"></form:errors></td>
									</tr>
							</table>
							<c:set var="signup"><spring:message code="signup"/></c:set>
							<input type="submit" value="${signup}" >
						</form:form>
						
						
						
						  <%--  <form>
						   		<input type="text" name="personId" placeholder="ID(Any identification number for eg. aadhar card, pan card, etc.)" required="">
						   		<input type="text" name="personIdType" placeholder="ID Type" required="">
								<input type="text" name="personName" placeholder="Name" required="">
								Select Date of Birth:&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="personDateOfBirth" placeholder="Date Of Birth" required="">
								<input type="number" name="personAge" placeholder="Age" required="">
								<br><br>
								Select Gender
								<br><br>
								<input type="radio" name="radio" value="male" required>Male
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio" value="female" required>Female
								<textarea name="personAddress" rows="3" cols="50" placeholder="Address" required=""></textarea>
								<input name="personPhoneNo" type="number" placeholder="Phone No" required="">
								<input name="personPassword" type="password" placeholder="Password (Secured Using SHA-1)" required="">
								<input type="submit" value="SignUp" >

						   </form> --%>
							<form action="./index.jsp">
								<input type="submit" value="CANCEL" >
						   </form>
						</div>
				
				
				</div>
			</div>			
		</div>
			</div>
	</div>
	<!--//single-->	

	  <!--/start-footer-section-->
	   <div class="footer-section">
				<div class="container">
					<div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
						<div class="col-md-3 footer-grid">
						<h4>About <span>Medicinal</span></h4>
						<div class="border2"></div>
						  <p class="sub">Sapient Healthcare Limited is a leading integrated healthcare delivery service provider in India. The healthcare verticals of the company primarily comprise hospitals, diagnostics and day care specialty facilities. Currently, the company operates its healthcare delivery services in India, Dubai, Mauritius and Sri Lanka with 45 healthcare facilities (including projects under development), approximately 10,000 potential beds and 314 diagnostic centres.</p>
						</div>
						<div class="col-md-3 footer-grid tags">
								<h4><span>Contact </span>Us</h4>
								<div class="border2"></div>
							<p class="sub">Unitech Infospace,<br>
							 				Tower A Building 2,<br>
							 				Sector 21 Old Delhi,<br>
							 				Gurgaon Road Dundahera,<br>
							 				Gurugram, Haryana 122016<br>
							 				Phone: 0124 499 6000</p>
						</div>
						<div class="col-md-3 footer-grid tweet">
								<h4>Latest <span>Tweets</span></h4>
								<div class="border2"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
									</div>
							<div class="icon-text">
								<p>I feel very lucky!!! #SapientHealthCare<a href="#"> @SamuelLJackson </a></p>
								<h5>15 mins ago</h5>
							</div>
								<div class="clearfix"></div>
								<div class="icon-3-square">
										<a href="#"><i class="square-3"></i></a>
								</div>
								<div class="icon-text">
								    <p>I feel blessed!!! #SapientHealthCare<a href="#"> @JasonStatham </a> </p>
									<h5>15 mins ago</h5>
								</div>
								<div class="clearfix"></div>
						</div>
						<div class="col-md-3 footer-grid flickr">
								<h4>Flickr <span>Feed </span></h4>
								<div class="border2"></div>
								<div class="flickr-grids">
										<div class="flickr-grid">
											<a href="#"><img src="images/t1.jpg" alt=" " title="Senior Surgeon(Cardiology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t2.jpg" alt=" " title="Surgeon(Cardiology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t3.jpg" alt=" " title="Junior Surgeon(Cardiology)" /></a>
										</div>
										<div class="clearfix"> </div>
										
										<div class="flickr-grid">
											<a href="#"><img src="images/t2.jpg" alt=" " title="Senior Surgeon(Neurology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t3.jpg" alt=" " title="Surgeon(Neurology)" /></a>
										</div>
										<div class="flickr-grid">
											<a href="#"><img src="images/t1.jpg" alt=" " title="Junior Surgeon(Neurology)" /></a>
										</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>
		</div>
	<!--//end-footer-section-->
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>� 2017 Sapient Hospital. All rights reserved | Design by <a href="http://sapient.com">Deepika,  Chinmay,  Debanjan & Tushar</a></p>
		</div>
	</div>
		<!--start-smooth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
								<!--end-smooth-scrolling-->
		<a href="#house" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<script src="js/bootstrap.js"></script>

</body>
</html>