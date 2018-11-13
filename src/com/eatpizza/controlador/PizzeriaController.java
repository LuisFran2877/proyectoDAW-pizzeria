package com.eatpizza.controlador;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.util.Accion;

/**
 * Servlet implementation class PizzeriaController
 */
@WebServlet(
		name = "PizzeriaController",
		urlPatterns = {"/PizzeriaController", "/addToCart", "/removeFromCart", "/login", "/logout", "/addUser"}
		)
public class PizzeriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzeriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = request.getServletPath();
		String separadorSlash = Pattern.quote("/");
		String [] partesUrl = url.split(separadorSlash);
		url = partesUrl[1];
		Accion accion = Accion.getAccion(url);
		
		if(url.equals("addToCart") || url.equals("removeFromCart")) {
			String carrito = accion.ejecutar(request, response);
			response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().print(carrito);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (url.equals("login") || url.equals("logout") || url.equals("addUser")) {
			//RequestDispatcher despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
			//despachador.forward(request, response);
			response.sendRedirect(request.getContextPath() + accion.ejecutar(request, response));
		}
			
	}

}
