package fecha;

/**
 * Clase que va a guardar los tres elementos mas importantes de una fecha: El
 * dia, el mes y el año
 */
public class Fecha {
	public static final int DIEZ = 10;
	

	/**
	 * Variable que va a guardar el dia de la fecha
	 */
	private int dia; // d�a
	

	/**
	 * Variable que va a guardar el mes de la fecha
	 */
	private int mes; // mes
	

	/**
	 * Variable que va a guardar el año de la fecha
	 */
	private int anio; // a�o

	/**
	 * Constructor de fecha
	 */
	public Fecha() {

	}

	/**
	 * Constructor de fecha que tiene estos parametros de entrada:
	 * 
	 * @param dia  Parametro que va a marcar el dia de la fecha
	 * @param mes  Parametro que va a marcar el mes de la fecha
	 * @param anio Parametro que va a marcar el año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	/**
	 * Funcion que devuelve si la fecha con la que ha sido llamada es correcta
	 * 
	 * @return Devuele true si es correcta y false si no lo es
	 */
	public boolean fechaCorrecta() {

		boolean diaCorrecto;

		boolean mesCorrecto;

		boolean anioCorrecto;

		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Metodo que comprueba si el año es bisiesto. Solo lo usa fechaCorrecta, por
	 * eso es privado
	 * 
	 * @return Devuelve true si es bisiesto y false si no lo es
	 */
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}


	/**
	 * Metodo que le añade un dia a la fecha
	 */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	/**
	 * Metodo toString para sacar la fecha por pantalla de la forma deseada
	 */
	public String toString() {

		String respuesta;

		if (dia < DIEZ && mes < DIEZ) {
			respuesta = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < DIEZ && mes >= DIEZ) {
			respuesta = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= DIEZ && mes < DIEZ) {
			respuesta = dia + "-0" + mes + "-" + anio;
		} else {
			respuesta = dia + "-" + mes + "-" + anio;
		}

		return respuesta;

	}

}
