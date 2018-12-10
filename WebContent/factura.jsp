<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Factura - EatPizza</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="factura.css">
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
		<div id="contenedor">
			<h2>Factura</h2>
	       	<div id="factura">
	       		<span>Cantidad</span>
	       		<span>Producto</span>
	       		<span>Subtotal</span>
		       	<c:set var="precioTotal" value="${0}" scope="page" />
		       	<c:forEach items="${productos}" var="p">
	       			<span>${p.getCantidad()}</span>
	       			<span>${p.getProducto().getNombre()}</span>
	       			<span>${p.getCantidad() * p.getProducto().getPrecio()}€</span>
	       			<c:set var="precioTotal" value="${precioTotal + p.getCantidad() * p.getProducto().getPrecio()}" scope="page" />
		       	</c:forEach>
		       	<span>Total: ${precioTotal}€</span>
	       	</div>
	       	<h2>Datos de contacto</h2>
       		<c:if test="${sessionScope.usuario != null}" > 
	    		<form id="contacto" action="pedido">
		            <label for="email">Email</label>
		            <input type="email" name="email" id="email" value="${usuario.getEmail()}" disabled>
		            <div></div>
		            <label for="direccion">Dirección</label>
		            <input type="text" name="direccion" id="direccion" value="${usuario.getDireccion()}" disabled>
		            <div></div>
		            <button type="submit">Finalizar compra</button>
		        </form>
			</c:if>
			<c:if test="${sessionScope.usuario == null}" >
				<form id="contacto" action="pedido">
		            <label for="email">Email</label>
		            <input type="email" name="email" id="email" required placeholder="Sólo lo usaremos para confimar el pedido">
		            <div></div>
		            <label for="direccion">Dirección</label>
		            <input type="text" name="direccion" id="direccion" required placeholder="¿A dónde quieres que te enviemos el pedido?">
		            <div></div>
		            <button type="submit">Finalizar compra</button>
		        </form>
			</c:if>
		</div>
		<p>Si te has dejado algo puedes <a href="index.jsp">Seguir comprando</a></p>
    </main>
    <footer>
        <p>Realizado por Luis Francisco Martínez Vigil &copy;2018</p>
        <p>EatPizza. Proyecto Desarrollo de Aplicaciones Web</p>
    </footer>
	<script src="disable-back.js"></script>
</body>
</html>