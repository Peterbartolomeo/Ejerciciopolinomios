package modelo;

public class Monomio {

	private double coeficiente;
	private int exponente;
	
	public Monomio() { }
	
	public Monomio(double coeficiente, int exponente) {
		this.coeficiente = coeficiente;
		this.exponente = exponente;
	}
	
	public static Monomio sumar(Monomio m1, Monomio m2) {
		return new Monomio(m1.coeficiente + m2.coeficiente, m1.exponente);
	}
	
	public static Monomio multiplicar(Monomio m1, Monomio m2) {
		return new Monomio(m1.coeficiente * m2.coeficiente, m1.exponente + m2.exponente);
	}
	
	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public int getExponente() {
		return exponente;
	}

	public void setExponente(int exponente) {
		this.exponente = exponente;
	}
	
	public void cambiarSigno() {
		coeficiente *= -1;
	}

	@Override
	public String toString() {
		/*if (coeficiente == 0)
			return "";
		*/if (exponente == 0)
			return String.format("%+.0f", coeficiente);
		if (exponente == 1) 
			return String.format("%+.0fx", coeficiente);
		
		return String.format("%+.0fx^%d", coeficiente, exponente);
	}
}