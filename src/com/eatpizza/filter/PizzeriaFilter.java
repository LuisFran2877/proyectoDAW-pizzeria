package com.eatpizza.filter;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;

import com.eatpizza.modelo.IngredienteVO;
import com.eatpizza.modelo.PizzaVO;
import com.eatpizza.modelo.RolVO;
import com.eatpizza.modelo.UsuarioVO;
import com.eatpizza.service.ServiceIngredientes;
import com.eatpizza.service.ServiceIngredientesImp;
import com.eatpizza.service.ServicePizzas;
import com.eatpizza.service.ServicePizzasImp;
import com.eatpizza.service.ServiceUsuarios;
import com.eatpizza.service.ServiceUsuariosImp;

@WebFilter(urlPatterns = {"/login.jsp", "/factura.jsp", "/admin.jsp"})
public class PizzeriaFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(true);
        
        String url = request.getServletPath();
		String separadorSlash = Pattern.quote("/");
		String [] partesUrl = url.split(separadorSlash);
		url = partesUrl[1];
		
		if(url.equals("login.jsp")) {
			if(session.getAttribute("usuario") != null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		
		if(url.equals("factura.jsp")) {
			if(session.getAttribute("productos") == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		
		if(url.equals("admin.jsp")) {
			
			if(session.getAttribute("usuario") != null) {
				
				UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
				
				if(usuario.getRol().getRol().equals("ADMIN")) {
					
					List<PizzaVO> pizzas;
					ServicePizzas sp = new ServicePizzasImp();
					pizzas = sp.getPizzas();
					
					List<IngredienteVO> ingredientes;
					ServiceIngredientes si = new ServiceIngredientesImp();
					ingredientes = si.getIngredientes();
					
					request.setAttribute("pizzas", pizzas);
					request.setAttribute("ingredientes", ingredientes);
					chain.doFilter(request, response);
					
				}
				else {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
				
			}
			else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
