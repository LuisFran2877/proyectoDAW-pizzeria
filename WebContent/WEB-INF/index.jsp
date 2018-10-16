<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${datos.getQ()} - Search in AcidLime</title>
    <link rel="stylesheet" href="../style.css" />
    <link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
    <script>
        var cb = function() {
            var l = document.createElement('link');
            l.rel = 'stylesheet';
            l.href = 'https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css';
            var h = document.getElementsByTagName('head')[0];
            h.parentNode.insertBefore(l, h);
        };
        var raf = requestAnimationFrame || mozRequestAnimationFrame ||
            webkitRequestAnimationFrame || msRequestAnimationFrame;
        if (raf) raf(cb);
        else window.addEventListener('load', cb);
    </script>
</head>
<body>
	<ul>
	<c:forEach items="${pizzas}" var="pizza">
		<li>
		${pizza.getNombre()}
		<c:set var = "ingredientes" value = "${pizza.getIngredientes()}"/>
			<ul>
			<c:forEach items="${ingredientes}" var="ingrediente">
				<li>
				${ingrediente.getNombre()}
				</li>
			</c:forEach>
			</ul>
		</li>
	</c:forEach>
	</ul>
</body>
</html>