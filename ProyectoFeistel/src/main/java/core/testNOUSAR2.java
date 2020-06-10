package core;

public class testNOUSAR2 {
	public static void main(String[] args) {
//		String cadena = "clave de acceso sistema osit klo";
//		String cadena = "clave de acceso sistema osit";

//		String cadena = "clavedeaccesosistemaosit";
//		String cadena = "cgfgxencuqukueegvqukcvgo";//4123

//		String cadena = "EcuadorUPSpasswordtelexy";
//		String cadena = "WfqtcGewquuycRUr{ngzgtfv";//4123
//		String cadena = "ftWqGwceuyquRrcUnz{gtvgf";// 1342

		String cadena = "Ecuador UPS password telexy";
//		String cadena = "\"fqtcGewurcu\"WRUn\"vgfyqt33333gz{";//4123 relle&ntilde;o de 1
//		String cadena = "\"fqtcGewurcu\"WRUn\"vgfyqt\"\"\"\"\"gz{";//4123 relle&ntilde;o de espacios
		
		int bloques = 8;
		int iteraciones = 1 * 2;
		int permutacion = 4123;
		int mod = 2;
		char accion = 'E';

		Feistel f = new Feistel();

		String cadenaNueva = f.cadenaDeCaracteres(bloques, cadena);
		String[] subbloques = f.subBloques(bloques, cadenaNueva);
		System.out.println("subbloques");
		for (String string : subbloques) {
			System.out.print(string + " | ");
		}
		System.out.println();

		// crear bucle
		for (int i = 0; i < iteraciones; i++) {
			subbloques = f.Sustitucion(subbloques, mod, accion);
//				System.out.println("\n\n-"+i+"- sustitucion: "+accion);
//				for (String string : subbloques) {
//					System.out.print(string+" | ");
//				}
			subbloques = f.Permutacion(subbloques, permutacion + "", accion);

			// cambiar la posicion excepto cuando es la ultima sub_vuelta
			subbloques = f.cambioDeSubbloques(subbloques, iteraciones, i);
		}
		System.out.println("\n\n accion: " + accion);
		String res = "";
		for (String string : subbloques) {
			System.out.print(string + " | ");
			res += string;
		}
		System.out.println("\n\nres: "+res);

	}

}
