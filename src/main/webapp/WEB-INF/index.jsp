<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Herd Manager</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body onload="getSheepsFromServer('http://localhost:8080${ pageContext.request.contextPath}')">
	<div class="container">
	<div class="row">	
		<div class="col-8" id="divDisplayMiscellaneous"></div>
		<div class="col-4" id="divSearch">
			<div class="row">
				<div class="col-8">
					<input class="form-control" id="searchBar"
						placeholder="Nom ou numéro d'identification">
				</div>
				<div class="col-4">
					<button class="btn btn-primary" id="btnSearchSheep"
						onclick="searchSheep()">
						<em class="fa fa-search"></em>
					</button>
				</div>
			</div>
			<div class="row">
				<div id="divDisplaySheepList"></div>
			</div>
		</div>
		</div>
	</div>
	<template id="templateDisplaySheep">
		<br />
		<div class="row">
			<div class="col-6">
				<h3 id="sheepName"></h3>
			</div>
			<div class="col-6">
				<h3 id="registrationNumber"></h3>
			</div>
			<div class="col-2">
				<button class="btn btn-success"
					onclick="displaySheepOnDivMiscellaneous(this)">
					<em class="fa fa-exchange-alt"></em>
				</button>
			</div>
		</div>
	</template>
	<template id="templateSheepOnDivMiscellaneous">
		<br />
		<div class="row">
			<div class="col-4">
				<h3 id="sheepName"></h3>
			</div>
			<div class="col-4">
				<h3 id="registrationNumber"></h3>
			</div>
			<div class="col-4">
				<h3 id="birthDate"></h3>
			</div>
		</div>
		<div class="row">
			<div class="col-8">
				<h3 id="comments"></h3>
			</div>
			<div class="col-4">
				<img alt="Image représentant l'animal" src="">
			</div>
		
		</div>
	</template>
</body>
</html>