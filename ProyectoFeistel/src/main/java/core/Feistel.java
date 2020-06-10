package core;

/**
@autor: Kevin Palacios
Si usas el c&oacute;digo, por favor asegurate de dar el cr&eacute;dito correspondiente
*/
public class Feistel {

	/**
	 * Metodo que verifica y rellena de 1 cuando la cadena de caracteres es valida,
	 * seg&uacute;n los par&aacute;metros de entrada
	 */
	public String cadenaDeCaracteres(int tamanioDelBloque, String cadena) {
		String cadenaNueva = "";
		int c = 1;
		int tamanioCadena = cadena.length();
		int C = 0;
		// verificando el tama&ntilde;o de la cadena
		while (C < tamanioCadena) {
			C = tamanioDelBloque * c;
			c++;
		}

		// validando si el la cadena tiene el mismo tama&ntilde;o que C
		if (tamanioCadena != C) {
			c = 0;
			while (c < (C - tamanioCadena)) {
				cadenaNueva += " ";
				c++;
			}
			cadenaNueva = cadena + cadenaNueva;
		} else {
			cadenaNueva = cadena;
		}
		return cadenaNueva;
	}

	/**
	 * M&eacute;todo donde se obtiene los subbloques. Ya que se trabaja con ASCII se
	 * toma encuenta el espacio
	 */
	public String[] subBloques(int tamanioDelBloque, String cadenaNueva) {
		char[] sbloques = cadenaNueva.toCharArray();
		int i = 0;
		int l = cadenaNueva.length();

		// Se calcula el sub_Bloque seg&uacute;n el tamanioDelBloque
		int sub_Bloque = tamanioDelBloque / 2;

		// Se obtiene el tama&ntilde;o del array
		String[] subbloques = new String[l / sub_Bloque];
		int c = 0;

		// Separando en subbloques y a&ntilde;adiendo al array
		String aux = "";
		while (i < l) {

			// Valida si el indice mod subbloque es 0
			if ((i + 1) % sub_Bloque != 0) {
				aux += sbloques[i];
			} else {
				aux += sbloques[i];
				subbloques[c] = aux;
				c++;
				aux = "";
			}
			i++;
		}
		return subbloques;
	}

	/**
	 * M&eacute;todo donde se realiza la sustitucion dentro de los subbloques
	 * impares
	 */
	public String[] Sustitucion(String[] subBloques, int mod) {
		int l = subBloques.length;
		int c = 0;

		while (c < l) {
			// se realiza la sustitucion solo en los bloques de &iacute;ndice 0,2,4 -->
			// subBloques 1,3,5
			if (c % 2 == 0) {
				char[] aux = subBloques[c].toCharArray();
				String aux2 = "";
				for (char d : aux) {
					int valorChar = (int) d;
					int newValorChar = valorChar + mod;
					aux2 += (char)newValorChar;
//					String e = Character.toString(newValorChar);
//					System.out.println(d + " ("+valorChar+") | "+e + " ("+newValorChar+")" );
				}
				subBloques[c] = aux2;
			}
//			System.out.println();
			c++;
		}
		return subBloques;
	}
	
	/**
	 * M&eacute;todo donde se realiza la sustitucion dentro de los subbloques
	 * impares
	 */
	public String[] Sustitucion(String[] subBloques, int mod, char accion) {
		int l = subBloques.length;
		int c = 0;
		
		if(accion=='D') {
			mod = mod * (-1);
		}

		while (c < l) {
			// se realiza la sustitucion solo en los bloques de &iacute;ndice 0,2,4 -->
			// subBloques 1,3,5
			if (c % 2 == 0) {
				char[] aux = subBloques[c].toCharArray();
				String aux2 = "";
				for (char d : aux) {
					int valorChar = (int) d;
					int newValorChar = valorChar + mod;
					aux2 += (char)newValorChar;
//					String e = Character.toString(newValorChar);
//					System.out.println(d + " ("+valorChar+") | "+e + " ("+newValorChar+")" );
				}
				subBloques[c] = aux2;
			}
//			System.out.println();
			c++;
		}
		return subBloques;
	}

	/**
	 * M&eacute;todo donde se realiza la permutacion dentro de los subbloques
	 * impares
	 */
	public String[] Permutacion(String[] subBloques, String permutacion) {
		int l = subBloques.length;
		int c = 0;

		char[] Perm = permutacion.toCharArray();
		int largoPerm = permutacion.length();
		int i = 0;

		while (c < l) {
			// se realiza la permutaci&oacute; solo en los bloques de &iacute;ndice 0,2,4
			// -->
			// subBloques 1,3,5
			if (c % 2 == 0) {
				char[] aux = subBloques[c].toCharArray();
				// Realizando la permutacion
				String aux2 = "";
				while (i < largoPerm) {
					aux2 += aux[Integer.valueOf(Perm[i] + "") - 1];
					i++;
				}
				subBloques[c] = aux2;
				i = 0;
			}
			c++;
		}

		return subBloques;
	}

//	/**
//	 * M&eacute;todo donde se realiza la permutacion dentro de los subbloques
//	 * impares<br>
//	 * <br>
//	 * Desencriptar
//	 */
//	public String[] Permutacion(String[] subBloques, String permutacion, char accion) {
//		int l = subBloques.length;
//		int c = 0;
//
//		char[] Perm = permutacion.toCharArray();
//		int largoPerm = permutacion.length();
//		char[] nuevoSubBloque = new char[largoPerm];
//		int i = 0;
//
//		while (c < l) {
//			// se realiza la permutaci&oacute; solo en los bloques de &iacute;ndice 0,2,4
//			// -->
//			// subBloques 1,3,5
//			if (c % 2 == 0) {
//				char[] aux = subBloques[c].toCharArray();
//				// Realizando la permutacion
//				String aux2 = "";
//
//				// para desencriptar
//
//				while (i < largoPerm) {
//
//					nuevoSubBloque[Integer.valueOf(Perm[i] + "") - 1] = aux[i];
//
//					i++;
//				}
//				for (char d : nuevoSubBloque) {
//					aux2 += d + "";
//				}
//				subBloques[c] = aux2;
//				i = 0;
//			}
//			c++;
//		}
//
//		return subBloques;
//	}

	/**
	 * M&eacute;todo donde se realiza la permutacion dentro de los subbloques
	 * impares
	 */
	public String[] Permutacion(String[] subBloques, String permutacion, char accion) {
		int l = subBloques.length;
		int c = 0;

		char[] Perm = permutacion.toCharArray();
		int largoPerm = permutacion.length();
		char[] nuevoSubBloque = new char[largoPerm];
		int i = 0;

		while (c < l) {
			// se realiza la permutaci&oacute; solo en los bloques de &iacute;ndice 0,2,4
			// -->
			// subBloques 1,3,5
			if (c % 2 == 0) {
				char[] aux = subBloques[c].toCharArray();
				// Realizando la permutacion
				String aux2 = "";

				// para encriptar
				if (accion == 'E') {
					while (i < largoPerm) {
						aux2 += aux[Integer.valueOf(Perm[i] + "") - 1];
						i++;
					}
					subBloques[c] = aux2;
					i = 0;
				}

				// para desencriptar
				if (accion == 'D') {
					while (i < largoPerm) {
						nuevoSubBloque[Integer.valueOf(Perm[i] + "") - 1] = aux[i];
						i++;
					}
					for (char d : nuevoSubBloque) {
						aux2 += d + "";
					}
					subBloques[c] = aux2;
					i = 0;
				}
			}
			c++;
		}

		return subBloques;
	}

	/**
	 * M&eacute;todo donde se realiza el cruce de los subbloques
	 */
	public String[] cambioDeSubbloques(String[] subBloques, int iteraciones, int i) {
		int l = subBloques.length;
		int c = 0;
		String aux = "";

		if (i != (iteraciones - 1)) {

			while (c < l) {
				if (c % 2 == 0) {
					aux = subBloques[c + 1];
					subBloques[c + 1] = subBloques[c];
				} else {
					subBloques[c - 1] = aux;
				}
				c++;
			}
		}

		return subBloques;
	}

}
