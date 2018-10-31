<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EatPizza</title>
    <link rel="stylesheet" href="style.css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet"> 
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet"> 
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
	<header>
		<h1>
			<div>eat</div>
			<div>pizza</div>
		</h1>
	</header>
	<main>
		<div id="pizza-wrapper">
			<c:forEach items="${pizzas}" var="pizza">
			<div class="pizza" id="pizza${pizza.getId()}">
				<div class="nombre">${pizza.getNombre()}</div>
				<c:set var = "ingredientes" value = "${pizza.getIngredientes()}"/>
				<div class="ingredientes">
					<c:forEach items="${ingredientes}" var="ingrediente" varStatus="i">
						<c:if test="${i.index == ingredientes.size() -1}">
							${ingrediente.getNombre()}.
						</c:if>
						<c:if test="${i.index < ingredientes.size() -1}">
							${ingrediente.getNombre()}, 
						</c:if>
					</c:forEach>
				</div>
				<div class="precio">${pizza.getPrecio()}€</div>
				<button id="submit${pizza.getId()}" class="add fas fa-cart-plus"></button>
			</div>
			</c:forEach>
		</div>
		<div class="carrito">
			<div>Tu compra</div>
			<button>Comprar</button>
			<div id="lista-carrito"><ul>${sessionScope["carrito"]}</ul></div>
		</div>
	</main>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="index.js"></script>
</body>
</html>