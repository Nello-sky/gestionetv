package it.prova.gestionetv.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.prova.gestionetv.model.Televisore;


public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "samsung", "v38", 150, 50, "c1"));
		LISTA_TELEVISORI.add(new Televisore(2l, "asus", "a18", 120, 40, "c2"));
		LISTA_TELEVISORI.add(new Televisore(3l, "dell", "d89", 200, 45, "c3"));
		LISTA_TELEVISORI.add(new Televisore(4l, "philps", "p78", 250, 60, "c4"));
		LISTA_TELEVISORI.add(new Televisore(5l, "aquos", "a11", 100, 45, "c5"));
		LISTA_TELEVISORI.add(new Televisore(6l, "samsung", "v99", 130, 38, "c6"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId=LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getIdTelevisore)).get().getIdTelevisore();
		return ++resultId;
	}
}
