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
			<a href="index.jsp">
			<svg aria-labelledby="title1 desc1" role="img" version="1.1" font-weight="700" viewBox="0 0 90 34">
				<text font-family="Ubuntu" font-size="40" x="0" fill="#fefefe" y="24">e</text>
				<text font-family="Ubuntu" font-size="20" fill="#fefefe" y="24" textLength="18" x="20">at</text>
				<text font-family="Ubuntu" font-size="40" fill="#fefefe" y="24" x="35">p</text>
				<text font-family="Ubuntu" font-size="20" fill="#fefefe" y="24" textLength="32" x="57">izza</text>
			</svg>
			</a>
		</h1>
		<c:if test="${sessionScope.usuario.getRol().getRol().equals(\"ADMIN\") }">
			<a class="enlace" href="admin.jsp">admin</a>
		</c:if>
		<c:if test="${sessionScope.usuario != null}" > 
    			<a class="enlace" href="logout">logout</a>
		</c:if>
		<c:if test="${sessionScope.usuario == null}" > 
    			<a class="enlace" href="login.jsp">login</a>
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
		<p>Si te has dejado algo puedes <a class="enlace" href="index.jsp">Seguir comprando</a></p>
    </main>
    <footer>
        <p>Realizado por Luis Francisco Martínez Vigil &copy;2018</p>
        <p>EatPizza. Proyecto Desarrollo de Aplicaciones Web</p>
    </footer>
	<script src="disable-back.js"></script>
</body>
</html>
