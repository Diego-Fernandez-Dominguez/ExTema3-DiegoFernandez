package fecha;

/**
 * Clase que va a guardar los tres elementos mas importantes de una fecha: El
 * dia, el mes y el año
 */
public class Fecha {

	/**
	 * Variable que va a guardar el dia de la fecha
	 */
	private int d;

	/**
	 * Variable que va a guardar el mes de la fecha
	 */
	private int m;

	/**
	 * Variable que va a guardar el año de la fecha
	 */
	private int a;

	/**
	 * Creo un constructor de fecha
	 */
	public Fecha() {

	}

	/**
	 * Creo un constructor de fecha que tiene estos parametros de entrada:
	 * 
	 * @param dia  Parametro que va a marcar el dia de la fecha
	 * @param mes  Parametro que va a marcar el mes de la fecha
	 * @param anio Parametro que va a marcar el año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Funcion que devuelve si la fecha con la que ha sido llamada es correcta
	 * 
	 * @return Devuele true si es correcta y false si no lo es
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
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
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Metodo que le añade un dia a la fecha
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Metodo toString para sacar la fecha por pantalla de la forma deseada
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
