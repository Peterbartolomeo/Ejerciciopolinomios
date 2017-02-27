package modelo;

import javax.management.RuntimeErrorException;

import estructura.Lista;
import estructura.Nodo;

public class Polinomio {

	private Lista monomios;

	public Polinomio() {
		monomios = new Lista();
	}

	public static Polinomio simplificar(Polinomio p) {
		if (p.estaVacio()) {
			return null;
		}

		Polinomio copia = p.getCopia();
		Polinomio simplificado = new Polinomio();

		Nodo aux = copia.monomios.getInicio();
		Nodo aux2 = null;

		while (aux != null) {
			aux2 = aux.getSiguiente();
			Monomio suma = aux.getMonomio();

			while (aux2 != null) {
				Monomio m2 = aux2.getMonomio();

				if (suma.getExponente() == m2.getExponente()) {
					suma = Monomio.sumar(suma, m2);
					copia.monomios.eliminar(m2);
				}

				aux2 = aux2.getSiguiente();
			}

			simplificado.agregar(suma);
			aux = aux.getSiguiente();
		}

		return simplificado;
	}

	public static Polinomio sumar(Polinomio p1, Polinomio p2) {
		Polinomio resultado = p1.getCopia();
		resultado.unir(p2);

		return Polinomio.simplificar(resultado);
	}

	public static Polinomio restar(Polinomio p1, Polinomio p2) {
		Polinomio aux = p2.getCopia();
		aux.cambiarSignos();

		return Polinomio.sumar(aux, p1);
	}

	public static Polinomio multiplicar(Polinomio p1, Polinomio p2) {
		Polinomio resultado = new Polinomio();
		
		Nodo aux = p1.monomios.getInicio();
		Nodo aux2 = null;
		
		while (aux != null) {
			aux2 = p2.monomios.getInicio();
			
			while (aux2 != null) {
				resultado.agregar(Monomio.multiplicar(aux.getMonomio(), aux2.getMonomio()));
				
				aux2 = aux2.getSiguiente();
			}
			
			aux = aux.getSiguiente();
		}
		
		return Polinomio.simplificar(resultado);
	}

	//Cambia los signos de cada uno los monomios
	private void cambiarSignos() {
		Nodo aux = monomios.getInicio();

		while (aux != null) {
			Monomio m = aux.getMonomio();
			m.cambiarSigno();
			aux.setMonomio(m);
			
			aux = aux.getSiguiente();
		}
	}

	//Devuelve una copia del polinomio
	public Polinomio getCopia() {
		Polinomio copia = new Polinomio();
		Nodo aux = monomios.getInicio();

		while (aux != null) {
			copia.agregar(aux.getMonomio());
			aux = aux.getSiguiente();
		}

		return copia;
	}

	//Enlaza el ultimo término del polinomio con el
	//primer término del polinomio p
	private void unir(Polinomio p) {
		Nodo aux = monomios.getInicio();

		while (aux.getSiguiente() != null) {
			aux = aux.getSiguiente();
		}

		aux.setSiguiente(p.getCopia().monomios.getInicio());
	}

	//mayor exponente a menor
	public void ordenar() {
		Nodo aux = monomios.getInicio();
		Nodo sig = null;

		Monomio m = null;

		while(aux != null) {
			sig = aux.getSiguiente();

			while(sig != null) {
				if(aux.getMonomio().getExponente() < sig.getMonomio().getExponente()) {
					m = aux.getMonomio();

					aux.setMonomio(sig.getMonomio());
					sig.setMonomio(m);
				}

				sig = sig.getSiguiente();
			}

			aux = aux.getSiguiente();
		}
	}

	public void agregar(Monomio monomio) {
		monomios.agregar(monomio);
	}

	public boolean estaVacio() {
		return monomios.estaVacia();
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Nodo aux = monomios.getInicio();
		while (aux != null) {
			sb.append(aux.getMonomio().toString());
			aux = aux.getSiguiente();
		}

		return sb.toString();
	}
}