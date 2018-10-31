package com.eatpizza.controlador;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatpizza.util.CarritoAccion;

/**
 * Servlet implementation class PizzeriaController
 */
@WebServlet(
		name = "PizzeriaController",
		urlPatterns = {"/PizzeriaController", "/addToCart"}
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
		
		CarritoAccion accion = CarritoAccion.getAccion(url);
		accion.ejecutar(request, response);
		
	}

}
