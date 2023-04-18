package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.model.Televisore;
import it.prova.gestionetv.service.MyServiceFactory;
import it.prova.gestionetv.service.televisore.TelevisoreService;

/**
 * Servlet implementation class PrepareDeleteTelevisoreServlet
 */
@WebServlet("/PrepareDeleteTelevisoreDaServlet")
public class PrepareDeleteTelevisoreDaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareDeleteTelevisoreDaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String indiceTelevisoreToDelete = request.getParameter("idDaInviareComeParametro");
			TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();
			Televisore result = null;
			try {
				result = televisoreServiceInstance.caricaSingolo(Long.parseLong(indiceTelevisoreToDelete));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
			request.setAttribute("TelevisoreToDelete", result);
			
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}

}
