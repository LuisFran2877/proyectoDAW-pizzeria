/**
 * 
 */
$(document).ready(function() {
	
	$('.add').on("click", addProducto);
	$('.remove').on("click", removeProducto);
	if($('#lista-carrito > ul > li').length >= 2) {
		$('.carrito').show();
		$('.carrito').addClass('visible');
	}
	
});

function addProducto() {
	
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
				$('.remove').on("click", removeProducto);
				if($('.carrito').css('display') == 'none') {
					$('.carrito').addClass('visible');
					$('.carrito').removeClass('occult');
					$('.carrito').show(300);
				}
			}, "text");
	
}

function removeProducto(e) {
	
	 e.preventDefault();
	//obtengo el id del botón pulsado
	var id = $(this).attr("id");
	//Elimino el texto de la id y obtendo un número que coincide
	//Con el de la id de la pizza
	var pizzaId = id.replace(/^\D+/g, "");
	
	var carrito = $("#lista-carrito > ul");
	
	//Actualizo el carrito
	$.post( "removeFromCart", { id: pizzaId },
			function(data){
				carrito.html(data);
				$('.remove').on("click", removeProducto);
				if($('#lista-carrito > ul > li').length < 2) {
					$('.carrito').addClass('occult');
					$('.carrito').removeClass('visible');
					$('.carrito').hide(300);
				}
			}, "text");
	
}