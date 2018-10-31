package carrito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.modelo.ProductoVO;
import com.eatpizza.util.CarritoAccion;

public class AddProducto extends CarritoAccion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String precioEUR = request.getParameter("precio");
		precioEUR = precioEUR.substring(0, precioEUR.length() - 1);
		double precio = Double.parseDouble(precioEUR);
		
		List<ProductoVO> productos;
		ProductoVO producto = new ProductoVO(new PizzaVO(id, nombre, precio), 1);
		
		
		if(session.getAttribute("productos") == null) {
			
			productos = new ArrayList<ProductoVO>();
			productos.add(producto);
			session.setAttribute("productos", productos);
			
		} else {
			
			productos = (List<ProductoVO>) session.getAttribute("productos");
			int index = existe(producto, productos);
			
			if(index == -1) {
				productos.add(producto);
			} else {
				int cantidad = productos.get(index).getCandidad() + 1;
				productos.get(index).setCandidad(cantidad);
			}
			
		}
		
		double total = totalPrecio(productos);
		
		StringBuilder carritoString = new StringBuilder();
		
		for(ProductoVO p : productos) {
			carritoString.append("<li>");
			carritoString.append("<span>"+p.getCandidad()+"</span>");
			carritoString.append("<span>"+p.getProducto().getNombre()+"</span>");
			carritoString.append("<span>" + p.getCandidad() * p.getProducto().getPrecio() +"€</span>");
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
