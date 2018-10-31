/**
 * 
 */
$(document).ready(function() {
	
	$('button').on("click", addCarrito);
	if($('#lista-carrito > ul').html()) {
		$('.carrito').css('transform', 'scale(1)');
		$('.carrito').css('opacity', '1');
		$('.carrito').show();
	}
	
});

function addCarrito() {
	
	//obtengo el id del botón pulsado
	var id = $(this).attr("id");
	//Elimino el texto de la id y obtendo un número que coincide
	//Con el de la id de la pizza
	var pizzaId = id.replace(/^\D+/g, "");
	
	//Obtengo los datos de la pizza
	var nombrePizza = $(`#pizza${pizzaId} > .nombre`).text();
	var precioPizza = $(`#pizza${pizzaId} > .precio`).text();
	var carrito = $("#lista-carrito > ul");
	
	//Actualizo el carrito
	$.post( "addToCart", { id: pizzaId, nombre: nombrePizza, precio: precioPizza },
			function(data){
		carrito.html(data);
		console.log($('#lista-carrito > ul > li').length);
		if($('.carrito').css('opacity') == 0) {
			$('.carrito').addClass('visible');
			$('.carrito').show(300);
		}
	}, "text");
	
}

/*function mostrarCarrito() {
	
	if($('#lista-carrito > ul').html()) {
		$('.carrito').addClass('visible');
		$('.carrito').show(300);
	}
	else {
		$('.carrito').removeClass('visible');
		$('.carrito').hide(300);
	}
	
}*/