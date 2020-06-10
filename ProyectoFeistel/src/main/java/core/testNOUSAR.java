package core;

public class testNOUSAR {
	public static void main(String[] args) {
//		String cadena = "clave de acceso sistema osit klo";
//		String cadena = "clave de acceso sistema osit";
		
//		String cadena = "clavedeaccesosistemaosit";
//		String cadena = "cgfgxencuqukueegvqukcvgo";
		
//		String cadena = "EcuadorUPSpasswordtelexy";
//		String cadena = "WfqtcGewquuycRUr{ngzgtfv";//4123
		String cadena = "ftWqGwceuyquRrcUnz{gtvgf";//1342
		int bloques = 8;
//		int bloques = 10;
		int iteraciones = 1 * 2;
		int permutacion = 1342;
//		int permutacion = 54321;
		int mod = 2;
		
//		char accion = 'E';
		char accion = 'D';
		Feistel f =  new Feistel();
//		f.cadenaDeCaracteres(bloques, cadena);
		
		String cadenaNueva = f.cadenaDeCaracteres(bloques, cadena);
		String[] subbloques = f.subBloques(bloques, cadenaNueva);
		System.out.println("subbloques");
		for (String string : subbloques) {
			System.out.print(string+" | ");
		}
		System.out.println();

		if(accion == 'E') {
			//crear bucle
			for (int i = 0; i <iteraciones; i++) {
				subbloques = f.Sustitucion(subbloques, mod);				
				subbloques = f.Permutacion(subbloques, permutacion+"");
				//cambiar la posicion excepto cuando es la ultima sub_vuelta
				subbloques = f.cambioDeSubbloques(subbloques,iteraciones,i);
			}		
			System.out.println("\n\n accion: "+accion);
			for (String string : subbloques) {
				System.out.print(string+" | ");
			}
		}
		
		if(accion == 'D') {
			//crear bucle
			for (int i = 0; i <iteraciones; i++) {
				subbloques = f.Sustitucion(subbloques, mod*(-1));
//				System.out.println("\n\n-"+i+"- sustitucion: "+accion);
//				for (String string : subbloques) {
//					System.out.print(string+" | ");
//				}
				subbloques = f.Permutacion(subbloques, permutacion+"",accion);
							
				//cambiar la posicion excepto cuando es la ultima sub_vuelta
				subbloques = f.cambioDeSubbloques(subbloques,iteraciones,i);
			}		
			System.out.println("\n\n accion: "+accion);
			for (String string : subbloques) {
				System.out.print(string+" | ");
			}
		}
		
				
	}

}
