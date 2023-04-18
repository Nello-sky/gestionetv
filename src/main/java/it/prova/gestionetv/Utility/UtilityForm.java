package it.prova.gestionetv.Utility;

public class UtilityForm {

	public static Integer parseFromString(String input) {
		Integer result = null;
		
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
		}
		
		
		return result;
	}
	
}
