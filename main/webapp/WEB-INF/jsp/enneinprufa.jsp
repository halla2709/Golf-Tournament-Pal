<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<title>Scoreboard test</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/postitnote.css"/>" />
</head>
<body>

	<h1>
		<a href="/">Heim</a>
	</h1>

	<sf:form method="POST" commandName="scoreboard" action="/wow">
		<div class="w3-card-8" style="padding: 2em;">
			<sf:input path="course" class="w3-input" type="text"
				style="width: 30%" />
			<label class="w3-label w3-validate w3-border">Course</label>

			<sf:input path="startDate" class="w3-input" type="date"
				style="width: 10%" />
			<label class="w3-label w3-validate w3-border">Date</label> <br>
			<sf:input path="numberOfRounds" class="w3-input" type="number"
				style="width: 10%" />
			<label class="w3-label w3-validate w3-border">Number of
				Rounds</label> <br>
			<input type="submit" value="Senda"/>

		</div>
		<br>
	</sf:form>

</body>
</html>

