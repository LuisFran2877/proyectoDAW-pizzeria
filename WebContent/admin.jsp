<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Administración - EatPizza</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="admin.css">
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
		<c:if test="${sessionScope.usuario.getRol().getRol().equals(\"ADMIN\") }">
			<a href="admin.jsp">admin</a>
		</c:if>
		<c:if test="${sessionScope.usuario != null}" > 
    		<a href="logout">logout</a>
		</c:if>
		<c:if test="${sessionScope.usuario == null}" > 
    		<a href="login.jsp">login</a>
		</c:if> 
	</header>
	<main>
		<div id="admin-container">
			<h2>Añadir</h2>
	        <form method="POST" id="#add" action="addPizza">
	        	<div id="data-container">
		        	<label for="nombre">Nombre</label>
					<input type="text" name="nombre" id="nombre" required>
					<div></div>
					<label for="precio">Precio</label>
					<input type="number" name="precio" id="precio" step="0.10" min="0" required>
					<div></div>
				</div>
	            <fieldset>
	            	<legend>Ingredientes:</legend>
	            	<c:forEach items="${ingredientes}" var="ingrediente">
	            		<label><input type="checkbox" name="ingrediente" value="${ingrediente.getId()}">${ingrediente.getNombre()}</label>
	            	</c:forEach>
	            </fieldset>
	            <button type="submit">Añadir</button>
	        </form>
	        <h2>Editar/Borrar</h2>
	        <form method="POST" id="editar" action="editDelete">
	        	<select name="pizza-list">
	            <c:forEach items="${pizzas}" var="pizza">
	            	<option value="${pizza.getId()}">${pizza.getNombre()}</option>
	            </c:forEach>
	            </select>
	           	<button type="submit" name="editPizza">Editar</button>
	           	<label for="edit-precio">Precio</label>
	            <input type="number" name="edit-precio" id="edit-precio" step="0.10" min="0" required>
	            <div></div>
	            <button type="submit" name="deletePizza">Borrar</button>
	        </form>
        </div>
    </main>
    <footer>
        <p>Realizado por Luis Francisco Martínez Vigil &copy;2018</p>
        <p>EatPizza. Proyecto Desarrollo de Aplicaciones Web</p>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="admin.js"></script>
	<script src="disable-back.js"></script>
</body>
</html>