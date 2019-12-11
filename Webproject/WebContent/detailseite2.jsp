<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,webprojects.*,java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Startseite</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="">Navbar</a>
	<button aria-controls="navbarNav" aria-expanded="false"
		aria-label="Toggle navigation" class="navbar-toggler"
		data-target="#navbarNav" data-toggle="collapse" type="button">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="login.jsp">Logout</a></li>
		</ul>
	</div>
	<form class="form-inline">
		<input class="form-control mr-sm-2" type="Suche" placeholder="Suche"
			aria-label="Suche">
		<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Suche</button>
	</form>
	</nav>

	<div class="jumbotron text-center">
		<h1>Willkommen</h1>
		<footer class="blockquote-footer">Sie befinden sich auf der
		Detailseite der vorher ausgewählten Klasse.</footer>
	</div>

	<style>
html, body {
	overflow-x: hidden;
}
</style>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Posts</th>
			</tr>
		</thead>
		<tbody>
			<%
				DBManager db = DBManager.getInstance();
				Connection con = db.getConnection();
				ArrayList<Artikel> posts = (ArrayList<Artikel>) db.getPostsFromTopic(con,
						Integer.parseInt(request.getParameter("topicid")));
				for (Artikel s : posts) {
					out.append("<tr><td onclick='showPost(" + s.getId() + ")'>");
					out.append(s.getHeadline());
					out.append("<br/>");
					out.append(s.getText());
					out.append("</td></tr>");
				}
			%>
		</tbody>
	</table>

	<!-- 
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Kommentare</th>
			</tr>
		</thead>
		<tbody>
	for (Artikel s : posts) {
				out.append("<tr><td onclick='showPost(" + s.getId() + ")'>");
				out.append(s.getHeadline());
				out.append("<br/><li>");
				out.append(s.getText());
				out.append("</li>");
				out.append("</td></tr>");
			}
			%>
		</tbody>
	</table>
	-->

	<div id='Artikelliste'></div>
	<div id='PostListe'></div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		function PostzuThemengebiet(themenID) {
			var xhttp = new XMLHTTPRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var arr = JSON.parse(this.responseText);
					var htmlcode = PostArrayFormatieren1(arr);
					document.getElementById('Artikelliste').innerHTML = htmlcode;
				}
			};
			xhttp.open("POST", "ReadArtikel", true);
			xhttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhttp.send("themenId=" + themenID);
		}

		function showPost() {
			var xhttp = new XMLHTTPRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var arr = this.responseText;
					var htmlcode = ArrayFormatieren2(arr);
					document.getElementById('PostListe').innerHTML = htmlcode;
				}
			};
			xhttp.open("POST", "ReadPosts", true);
			xhttp.sendRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
		}

		function ArrayFormatieren1(arr) {
			var len, text, i, elem;
			len = arr.length;
			postlist = arr;
			text = "<dl>";
			for (i = 0; i < len; i++) {
				elem = arr[i];
				text += "<dt>";
				text += elem.getHeadline();
				text += "</dt>"

			}
			text += "</dl>";
			return text;
		}

		function ArrayFormatieren2(arr) {
			var len, text, i, elem;
			len = arr.length;
			postlist = arr;
			text = "<dl>";
			for (i = 0; i < len; i++) {
				elem = arr[i];
				text += "<dt>";
				text += elem.getText();
				text += "</dt>"

			}
			text += "</dl>";
			return text;
		}
	</script>
</body>
</html>