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
 * Servlet implementation class ExecuteEditTelevisoreService
 */
@WebServlet("/ExecuteEditTelevisoreService")
public class ExecuteEditTelevisoreService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteEditTelevisoreService() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceInstance();
		
		// binding
				String marcaDaPagina = request.getParameter("marcaInput");
				String modelloDaPagina = request.getParameter("modelloInput");
				Integer prezzoDaPagina = UtilityForm.parseFromString(request.getParameter("prezzoInput"));
				Integer polliciDaPagina = UtilityForm.parseFromString(request.getParameter("polliciInput"));
				String codiceDaPagina = request.getParameter("codiceInput");
				Long idDaPagina = Long.parseLong(request.getParameter("idUpdate"));
						

				Televisore televisoreInsert = new Televisore(idDaPagina, marcaDaPagina, modelloDaPagina, prezzoDaPagina, polliciDaPagina, codiceDaPagina);

				// validazioni
				if (televisoreInsert.getMarca().isBlank() || televisoreInsert.getModello().isBlank() || televisoreInsert.getPrezzo()==null
						|| televisoreInsert.getNumeroPollici()==null || televisoreInsert.getCodice().isBlank()) {
					
					
					
					String messaggioDiErrore = "riempire tutti i campi";
					request.setAttribute("messaggioDiErrore", messaggioDiErrore);
					Televisore televisoreToUpdate = televisoreService.caricaSingolo(idDaPagina);
					request.setAttribute("TelevisoreToUpdate", televisoreToUpdate);
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					return;
				}

				// Business
				televisoreService.aggiorna(televisoreInsert);

				request.setAttribute("listTelevisoriAttributeName", televisoreService.listAll());

				// forward
				request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
