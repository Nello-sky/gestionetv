package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;
import it.prova.gestionetv.service.televisore.TelevisoreService;

/**
 * Servlet implementation class ExecuteDeleteAbitanteServlet
 */
@WebServlet("/ExecuteDeleteTelevisoreServlet")
public class ExecuteDeleteTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteDeleteTelevisoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idDelete = Long.parseLong(request.getParameter("idDelete"));
		// Business
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
		televisoreService.rimuovi(idDelete);

		request.setAttribute("listTelevisoriAttributeName", televisoreService.listAll());

		// forward
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
