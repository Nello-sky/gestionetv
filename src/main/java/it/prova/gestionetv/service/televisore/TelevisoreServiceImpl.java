package it.prova.gestionetv.service.televisore;

import java.util.List;

import it.prova.gestionetv.dao.televisore.TelevisoreDAO;
import it.prova.gestionetv.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService{
	
	private TelevisoreDAO televisoreDAO;
	

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;		
	}

	@Override
	public List<Televisore> cercaPerMarcaEModello(String marca, String modello) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.findByMarcaAndModello(marca, modello);
	}

	@Override
	public Televisore caricaSingolo(Long id) {
		try {
			return televisoreDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int inserisciNuovo(Televisore input) {
		try {
			return televisoreDAO.insert(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	@Override
	public List<Televisore> listAll() {
		try {
			return televisoreDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void rimuovi(Long idTelevisore) {
		try {
			televisoreDAO.delete(idTelevisore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void aggiorna(Televisore input) {
		try {
			televisoreDAO.update(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
