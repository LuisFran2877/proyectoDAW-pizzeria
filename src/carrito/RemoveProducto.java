package carrito;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.modelo.ProductoVO;
import com.eatpizza.util.CarritoAccion;

public class RemoveProducto extends CarritoAccion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		int id = Integer.parseInt(request.getParameter("id"));
		List<ProductoVO> productos;
		
		ProductoVO producto = new ProductoVO(new PizzaVO(id));
		productos = (List<ProductoVO>) session.getAttribute("productos");
		int index = existe(producto, productos);
		
		int cantidad = productos.get(index).getCantidad() - 1;
		if(cantidad == 0) {
			productos.remove(index);
		}
		else {
			productos.get(index).setCantidad(cantidad);
		}
		
		double total = totalPrecio(productos);
		
		StringBuilder carritoString = new StringBuilder();
		
		for(ProductoVO p : productos) {
			carritoString.append("<li>");
			carritoString.append("<span>"+p.getCantidad()+"</span>");
			carritoString.append("<span>"+p.getProducto().getNombre()+"</span>");
			carritoString.append("<span>" + p.getCantidad() * p.getProducto().getPrecio() +"€</span>");
			carritoString.append("<button id=\"remove"+ p.getProducto().getId() +"\" class=\"remove far fa-minus-square\"></button>");
			carritoString.append("</li>");
		}
		carritoString.append("<li>Total " + total + "€</li>");
		
		
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    try {
			response.getWriter().print(carritoString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    session.setAttribute("carrito", carritoString);
	}

}
