package com.eatpizza.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;

/**
 * Servlet implementation class IndexController
 */
@WebServlet(
		name = "IndexController",
		urlPatterns = {"/index.jsp", "/index.html"}
		)
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PizzaVO> pizzas;
		ServicePizzas sp = new ServicePizzasImp();
		pizzas = sp.getPizzas();
		
		request.setAttribute("pizzas", pizzas);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
