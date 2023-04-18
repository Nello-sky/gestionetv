package it.prova.gestionetv.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.Utility.UtilityForm;
import it.prova.gestionetv.model.Televisore;
import it.prova.gestionetv.service.MyServiceFactory;
import it.prova.gestionetv.service.televisore.TelevisoreService;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 */
@WebServlet("/ExecuteInsertTelevisoreServlet")
public class ExecuteInsertTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteInsertTelevisoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// binding
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		Integer prezzoDaPagina = UtilityForm.parseFromString(request.getParameter("prezzoInput"));
		Integer polliciDaPagina = UtilityForm.parseFromString(request.getParameter("polliciInput"));
		String codiceDaPagina = request.getParameter("codiceInput");


		Televisore televisoreInsert = new Televisore(marcaDaPagina, modelloDaPagina, prezzoDaPagina, polliciDaPagina, codiceDaPagina);

		// validazioni
		if (televisoreInsert.getMarca().isBlank() || televisoreInsert.getModello().isBlank() || televisoreInsert.getPrezzo()==null
				|| televisoreInsert.getNumeroPollici()==null || televisoreInsert.getCodice().isBlank()) {
			String messaggioDiErrore = "riempire tutti i campi";
			request.setAttribute("messaggioDiErrore", messaggioDiErrore);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		// Business
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
		televisoreService.inserisciNuovo(televisoreInsert);

		request.setAttribute("listAbitantiAttributeName", televisoreService.listAll());

		// forward
		request.getRequestDispatcher("results.jsp").forward(request, response);

	}

}
