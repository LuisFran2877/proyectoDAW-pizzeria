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
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="form.css">
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
        <form method="POST" action="addUser">
            <h2>Regístrate</h2>
            <label for="email">Email</label>
            <input type="email" name="email" id="email" required placeholder="Sólo lo usaremos para confimar que eres tú">
            <div></div>
            <label for="password">Contraseña</label>
            <input type="password" name="password" id="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder="Mínimo 6 caractéres, 1 número, 1 mayúscula y 1 minúscula">
            <div></div>
            <label for="conf-password">Confirmar contraseña</label>
            <input type="password" name="conf-password" id="conf-password" required placeholder="Repite la contraseña">
            <div></div>
            <label for="direccion">Dirección</label>
            <input type="text" name="direccion" id="direccion" required placeholder="¿A dónde quieres que te enviemos el pedido?">
            <div></div>
            <c:if test="${sessionScope.registerError != null}">
   				<p class="error">${sessionScope.registerError}</p>
   				<c:remove var="registerError" scope="session" />
			</c:if>
            <button type="submit">Registrarme</button>
        </form>
    </main>
    <footer>
        <p>Realizado por Luis Francisco Martínez Vigil &copy;2018</p>
        <p>EatPizza. Proyecto Desarrollo de Aplicaciones Web</p>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="registro.js"></script>
</body>
</html>