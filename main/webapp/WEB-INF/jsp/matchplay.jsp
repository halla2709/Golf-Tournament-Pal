<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="shortcut icon" href="../images/images.jpg"/>
<script src="/addInput.js" language="Javascript" type="text/javascript"></script>
<script src="/checkBox.js" language="Javascript" type="text/javascript"></script>


<html lang="is">
<title>Golf-Tournament Pal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.theme.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">

<body>

  <!-- Navigation (&Header)-->
<ul class="w3-navbar w3-container w3-theme" style="position:fixed; top:0px; height:12em; width:100%; z-index:0;">
  <li><a class="w3-padding-16 w3-hover-white" href="/index">Home</a></li>
  <li class ="w3-dropdown-hover"><a class="w3-padding-16 w3-hover-white" href="javascript:void(0)">Create Tournament</a>
  	<div class="w3-dropdown-content w3-theme w3-card-4">
  		<a class="w3-padding-16 w3-hover-white" href="/matchplay">Matchplay Tournament</a>
  		<a class="w3-padding-16 w3-hover-white" href="/scoreboard">Scoreboard Tournament</a>
  	</div>
  </li>
  <li><a class="w3-padding-16 w3-hover-white" href="/results">Results</a></li>
  <li><a class="w3-padding-16 w3-hover-white" href="/mypage">My Page</a></li><br><br>
  <!-- <li style="float:right"><a class="w3-padding-16 w3-hover-white" href="/login">Login</a></li> -->

  <!-- Header(&Navigation) -->
	<header class="w3-container w3-theme w3-padding w3-center" id="myHeader">
  		<h2>Golf-Tournament Pal!</h2>
  		<h5 class="w3-large w3-animate-bottom">Your best Golf friend</h5>
	</header>
</ul>
<hr>
	

  <!-- Main Text -->
<div class="w3-row w3-container" style="position:relative; top:8em; padding: 2em; margin-bottom:150px; z-index:0;" > 
	<h1>Create a Matchplay Tournament</h1>
	<br>
	<!-- Container Participants -->
	<div class="w3-col s5" style="margin-right:5em;">
	<h3>1. Fill out information about participants:</h3>	
		<form method ="POST">		
			<div id="dynamicInput">
				<div class="w3-card-8" style="padding:2em">
					<span onclick="this.parentElement.style.display='none'" class="w3-closebtn w3-margin-right w3-medium">&times;</span>
					<input class="w3-input w3-animate-input" type="text" required style="width:50%" name="myInputs[]">
			  		<label class="w3-label w3-validate w3-border">Name</label>
			  		<input class="w3-input w3-animate-input" type="text" required style="width:50%" name="myInputs[]">
			  		<label class="w3-label w3-validate w3-border">Social Security Number</label>
			  		<input class="w3-input w3-animate-input" type="email" required style="width:50%" name="myInputs[]">
			  		<label class="w3-label w3-validate w3-border">Email</label>	
			  		<input class="w3-input w3-animate-input" type="number" required style="width:15%" name="myInputs[]">
			  		<label class="w3-label w3-validate w3-border">Handicap</label>
		  		</div>
			</div>	
		</form>				
		<p>
		<input class="w3-btn w3-theme" type="button" value="Add another player" onClick="addInput('dynamicInput');"><br>
	</div>

	<!-- Container Tournament -->
	<div class="w3-col s6">
	<h3>2. Fill out information about the tournament:</h3>
		<form>
			<div class="w3-card-8" style="padding:2em;">
				<input class="w3-input w3-animate-input" type="text" required style="width:50%">
		  		<label class="w3-label w3-validate w3-border">Course</label>
		  		<p>
		  		<input class="w3-input w3-animate-input" type="date" required style="width:25%">
		  		<label class="w3-label w3-validate w3-border">Date</label>	
		  		<p>
		  		<input class="w3-input w3-animate-input" type="time" required style="width:25%">
		  		<label class="w3-label w3-validate w3-border">Time</label>	
	  			<p>
	  				<input onClick="myfunction();" class="w3-check" type="checkbox" id="brackets"><label> Brackets</label>
	  			<p>
		  		<select class="w3-select" style="width:50%; display:none;" id="bracketschecked">
		  		  <option value="" disabled selected>How many participant exit the bracket? </option>
				  <option value="1">1 participant</option>
				  <option value="2">2 participants</option>
				</select> <br>
	  		</div><br>
	  		<a href="/matchplay2" class="w3-btn w3-theme w3-large w3-right">Create Tournament!</a>
	  		<br>
		</form>
	</div>
</div>
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

