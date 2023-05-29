<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<div class="top-bar">
		<div class="logo">
			<img src="imgs/logo.png" alt="Logo" height="90">
		</div>
		<div>
			<img style="padding: 0 20px 0 0" src="imgs/account.png" alt="Account"
				height="40"> <img style="padding-right: 10px"
				src="imgs/settings.png" alt="Impostazioni" height="40">
		</div>
	</div>
	<div class="navbar">
		<ul>
			<li><a href="#"><img src="imgs/search.png" alt="search"
					height="40"></a></li>
			<li><a href="#"><img src="imgs/computer.png" alt="computer"
					height="40"></a></li>
			<li><a href="#"><img src="imgs/console.png" alt="console"
					height="40"></a></li>
			<li><a href="#"><img src="imgs/videogame.png"
					alt="videogame" height="40"></a></li>
			<li style="margin: 0px 10px 0px;"><a href="#"><img
					src="imgs/gadget.png" alt="gadget" height="40"></a></li>
		</ul>
	</div>
	<div class="background-div">

		<div class="image-slider">
			<div class="slider-controls">
				<img src="imgs/arrow.png" alt="Freccia su" height="15"
					style="transform: rotate(180deg)">
			</div>
			<div class="slider-dots">
				<div class="slider-dot"></div>
				<div class="slider-dot"></div>
				<div class="slider-dot"></div>
			</div>
			<div class="slider-controls">
				<img src="imgs/arrow.png" alt="Freccia gi�" height="15">
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 100px;">
		<div class="row justify-content-center">
			<div class="col-3 carta">
				<img class="border-img"
					src="imgs/homepage/prima_vetrina/fallout.jpg" alt="prima_offerta"
					height="500px">
				<div class="overlay">
					<h1>Compra subito</h1>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis molestie in ipsum sit amet accumsan. Curabitur consequat
						sollicitudin dapibus. Proin sit amet sagittis augue.</p>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-3">
				<img class="border-img" src="imgs/homepage/prima_vetrina/rdr2.jpg"
					alt="seconda_offerta" height="500px">
			</div>
			<div class="col-1"></div>
			<div class="col-3">
				<img class="border-img"
					src="imgs/homepage/prima_vetrina/outer_worlds.jpg"
					alt="terza_offerta" height="500px">
			</div>
		</div>
	</div>

	<p style="padding: 400px">Padding</p>
	<img src="imgs/homepage/carousel/sekiro.jpg" class="img-fluid">
	<p style="padding: 400px">Padding</p>
	<p style="padding: 400px">Padding</p>




	<%@include file="includes/footer.jsp"%>
</body>
</html>