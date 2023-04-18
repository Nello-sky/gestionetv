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
 * Servlet implementation class PrepareEditTelevisoreServlet
 */
@WebServlet("/PrepareEditTelevisoreServlet")
public class PrepareEditTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareEditTelevisoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indiceTelevisoreToUpdate= request.getParameter("idDaInviareComeParametro");
		TelevisoreService abitanteServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();
		Televisore result = null;
		try {
			result = abitanteServiceInstance.caricaSingolo(Long.parseLong(indiceTelevisoreToUpdate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		request.setAttribute("TelevisoreToUpdate", result);
		
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
