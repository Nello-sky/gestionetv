package it.prova.gestionetv.dao.televisore;

import java.util.List;

import it.prova.gestionetv.dao.IBaseDAO;
import it.prova.gestionetv.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public List<Televisore> findByMarcaAndModello(String marca, String modello);

}
