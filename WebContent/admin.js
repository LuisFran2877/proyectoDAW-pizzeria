$(document).ready(function() {
	
	$('#editar select').on("change", obtenerPrecio);
	obtenerPrecio();
	
});

function obtenerPrecio() {
	
	var opcion = $("#editar select option:selected").text();
	var precio = $("#editar input")
	
	$.post( "obtenerPrecio", { nombrePizza : opcion },
			function(data){
				precio.val(data);
			}, "text");
	
}