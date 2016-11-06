<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-colors-highway.css">
<link rel="shortcut icon" href="../images/images.jpg" />
<html lang="is">

<title>Golf-Tournament Pal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.theme.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<body>

  <!-- Navigation (&Header)-->
	<div class=w3-top>
		<ul class="w3-navbar w3-container w3-theme" style="position:fixed; top:0px; height:12em; width:100%; z-index:0;">
		  <li><a class="w3-padding-16 w3-hover-white" href="/index">Home</a></li>
		  <li class ="w3-dropdown-hover"><a class="w3-padding-16 w3-hover-white" href="javascript:void(0)">Create Tournament</a>
		  	<div class="w3-dropdown-content w3-theme w3-card-4">
		  	<a class="w3-padding-16 w3-hover-white" href="/matchplay">Matchplay Tournament</a>
		  	<a class="w3-padding-16 w3-hover-white" href="/scoreboard">Scoreboard Tournament</a>
		  	</div>
		  	</li>
		  <li><a class="w3-padding-16 w3-hover-white" href="/results">Results</a></li>
		  <li><a class="w3-padding-16 w3-hover-white" href="/mypage">My Page</a></li>
		  <!-- <li style="float:right"><a class="w3-padding-16 w3-hover-white" href="/login">Login</a></li> -->
		  <br>
		  <br>
		
		  <!-- Header(&Navigation) -->
		<header class="w3-container w3-theme w3-padding" id="myHeader">
		  <div class="w3-center">
		  <h2>Golf-Tournament Pal!</h2>
		  <h5 class="w3-large w3-animate-bottom">Your best Golf friend</h5>
		</header>
		</ul>
	</div>
<hr>

  <!-- Main Text -->
  
<div class="w3-row w3-container" style="position:relative; top:8em; padding: 2em; margin-bottom:150px; z-index:0;" > 
<h1>My Page</h1>
<br>
  <div class="w3-col s3 w3-center w3-card-8" style="padding:2em; height:25em;">
  		<img src="images/userprofilepicture.png" alt="My Image" style="max-width:100%;">
  		<h4>Name</h4>
  		<p>Slogan</p>
  </div>
  <div class="w3-col s8 w3-card w3-card-8" style="height:25em; padding:2em; margin-left:2em;">
  	<h2 class="w3-center">My Information</h2>
  	<h3>Name: </h3>
	<h3>Email: </h3>
	<h3>Handicap: </h3>
	<br> 
	<p>See My latest tournaments</p>
	<p>Or Create a new tournament</p> 
  </div>
</div>

<br>
<hr>


  <!-- Footer -->
<div style="width:100%; height:150px; bottom:0px; position:relative;" >
  <div class="w3-third w3-container w3-theme w3-medium" style="height:12em">
    <h3>Contact Info</h3>
    <p><i class="fa fa-map-marker" style="width:30px"></i> Korpúlfsstaðir</p>
    <p><i class="fa fa-phone" style="width:30px"></i> Phone: +354 5850200</p>
    <p><i class="fa fa-envelope" style="width:30px"> </i> Email: GR@GRGOLF.is</p>
  </div>
  <div class="w3-third w3-center w3-medium w3-theme w3-text-white" style="height:12em">
    <h3>Contact Us</h3>
    <p>If you have an idea.</p>
    <p>What are you waiting for?</p>
  </div>
  <div class="w3-third w3-center w3-medium w3-theme w3-text-white" style="height:12em">
    <h3>Like Us</h3>
    <ul style="list-style: none;"><a href="http://www.facebook.com"><img src='http://www.womenactionmedia.org/cms/assets/themes/crate/images/social/facebook.png'/></a></ul>
    <ul style="list-style: none;"><a href="http://www.twitter.com"><img src='http://grfx.cstv.com/schools/wis/graphics/icon_twitter24.jpg' /></a></ul>
  </div>
</div>

  <!-- Extras -->
<style>
.w3-theme {
color:#fff !important;background-color:#1a237e !important}
</style>

</body>
</html>

