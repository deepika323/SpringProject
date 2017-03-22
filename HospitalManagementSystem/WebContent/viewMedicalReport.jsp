<%@page import="model.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sapient HealthCare</title>
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
										<li class="menu__item menu__item--current"><a href="" class="menu__link"><span class="menu__helper">Home</span></a></li>
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
<style>
table {
    /*border-collapse: collapse;*/
    align:center;
    width:50%;
}
th {
background-color: #4CAF50;
    color: white;
    height: 50px;
}
table,th,td
{
 	padding: 15px;
    border:1px solid black;
        border-bottom: 1px solid #ddd;
}
tr:hover{background-color:#f5f5f5}
tr:nth-child(even) {background-color: #f2f2f2}
caption
{
 text-align:center;
font-weight: bold;
}

</style>
 
<div style="overflow-x:auto;width:100%">
<table  border="1" cellpadding="5">
 <caption>&#9; Medical Reports</caption>
	<tr>
	<th>Medical Report Id</th>
	<th>Visit Date</th>
	<th>Diagnosis</th>
	<th>Investigations</th>
	<th>Tests</th>
	<th>Recommendations</th>
	<th>Doctor Id</th>
	<th>Technician Id</th>
	</tr>
	
        <tr>
        	<td>${report.appointmentId}</td> 
            <td>${report.visitDate}</td> 
            <td>${report.diagnosis}</td>
            <td>${report.investigations}</td>
            <td>${report.tests}</td>
            <td>${report.recommendations}</td>
            <td>${report.doctorId}</td>
            <td>${report.technicianId}</td>
        </tr> 
   
</table>
</div>
<br><br>
<!--//header-top-->
 <!-- //Line Slider --><!-- 
		<div class="top_banner two">
			<div class="container">
			       <div class="sub-hd-inner">
						<h3 class="tittle">Single <span>Page</span></h3>
					</div>
			</div>
		</div> -->
	<!--/single--><!-- 
 <div class="single">
			<div class="container">
				<div class="article-post w3l">
				<div class="post-details s-page">
				   <img src="images/wallhaven-27263.jpg" alt="image" class="img-responsive">
					<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h2>
					<p>Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo.
					 eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis. Curabitur vitae velit in neque dictum blandit. <b>Proin in iaculis neque.</b> Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur vitae velit in neque dictum blandit. Proin in iaculis neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. </p>
					<p class="eget">Duis dapibus aliquam mi, eget euismod sem scelerisque ut. <b>Vivamus at elit quis urna adipiscing iaculis.</b> Curabitur vitae velit in neque dictum blandit. Proin in iaculis neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur vitae velit in neque dictum blandit. Proin in iaculis neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. </p>
					<p class="eget">Duis dapibus aliquam mi, eget euismod sem scelerisque ut. Vivamus at elit quis urna adipiscing iaculis. Curabitur <b>vitae velit in neque dictum blandit.</b> Proin in iaculis neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur vitae velit in neque dictum blandit. Proin in iaculis neque. Pellentesque habitant morbi tristique senectus et netus <b>et malesuada fames ac turpis egestas.</b> </p>
				</div>
				post-details
				<div class="clearfix"> </div>
				</div>	
		   <div class="top-single w3l">
			    <div class="single-middle">
				  <ul class="social-share">
					<li><span>SHARE</span></li>
					<li><a href="#"><i> </i></a></li>						
					<li><a href="#"><i class="tin"> </i></a></li>
					<li><a href="#"><i class="message"> </i></a></li>				
				</ul>
				<a href="#"><i class="arrow"> </i></a>
				<div class="clearfix"> </div>
			</div>
			<div class="top-comments">
			<h3>10 <span> Comments</span> </h3>
			<div class="met">
				<div class="code-in">
					<p class="smith"><a href="#">Robert Smith</a> <span>05 march 2016, 15:20</span></p>
					<p class="reply"><a href="#"><i> </i>REPLY</a></p>
					<div class="clearfix"> </div>
				</div>
				<div class="comments-top-top">
					<div class="men" >
						<i class="glyphicon glyphicon-user"></i>
					</div>					
						<p class="men-it">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using Lorem Ipsum is that it has a more-or-less </p>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="met met-in">
				<div class="code-in">
					<p class="smith"><a href="#">Robert Smith</a> <span>02 april 2016, 15:20</span></p>
					<div class="clearfix"> </div>
				</div>
				<div class="comments-top-top top-in">
					<div class="men" >
						<i class="glyphicon glyphicon-user"></i>
					</div>					
						<p class="men-it two">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using Lorem Ipsum is that it has a more-or-less </p>
					<div class="clearfix"> </div>
				</div>
			</div>
			<div class="met">
				<div class="code-in">
					<p class="smith"><a href="#">Robert Smith</a> <span>18 may 2016, 15:20</span></p>
					<p class="reply"><a href="#"><i> </i>REPLY</a></p>
					<div class="clearfix"> </div>
				</div>
				<div class="comments-top-top">
					<div class="men" >
						<i class="glyphicon glyphicon-user"></i>
					</div>					
						<p class="men-it">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using Lorem Ipsum is that it has a more-or-less </p>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="leave w3l">
			<h3>Leave <span> a comment </span></h3>
				<form>
					<div class="single-grid">
						<div class="single-us">
						   <form>
								<input type="text" placeholder="Name" required="">
								<input type="text" placeholder="Email" required="">
								<textarea placeholder="Message"></textarea>
								<input type="submit" value="SEND" >

						   </form>

						</div>
				</form>
				</div>
			</div>			
		</div>
			</div>
	</div> -->
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