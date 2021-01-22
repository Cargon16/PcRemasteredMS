package Negocio.Parseador;

public class Parseador {
	

	public static boolean ComprobarDNI(String DNI) {
		DNI = DNI.toLowerCase();
		String numeros = "0123456789";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		boolean Letra = false;
		int i =0;
		if(DNI.length() == 9){
		while (i < DNI.length() - 1 && !Letra){
			if (numeros.indexOf(DNI.charAt(i)) == -1)
				Letra = true;
			i++;
		}
		if(!Letra)
		return (letras.indexOf(DNI.charAt(DNI.length() - 1)) != -1);
		else return false;
		}
		else return false;
	}

	public static boolean ComprobarTelefono(Integer telefono) {
		String s = String.valueOf(telefono);
		return s.length() == 9;
	}

	public static Boolean comprobarNumeroPositivo(Integer numero) {

		return numero.intValue() >= 0;
	}

	public static Boolean comprobarNumeroPositivo(Float numero) {
		return numero.floatValue() >= 0;
	}

	public static boolean esNumerico(String text) { //comprobar que funciona
		return text.matches("[0-9]+");			
		}
	
	public static boolean esNumericoFloat(String cadena) {
		boolean ok = false;
		try {
			if(Float.parseFloat(cadena) > 0 ){
			Float.parseFloat(cadena);
			ok = true;
			}
			
		
	}catch(NumberFormatException e){
		ok=false;

	}

	return ok;

	}

	public static boolean esAlfabetico(String text) { //idem
		return !text.equals("") && text !=null && text.matches("^[a-zA-Z]*$");
	}
	
	}
