package estructura;

import modelo.Monomio;

public class Nodo {

	private Monomio monomio;
	private Nodo siguiente;
	
	public Nodo() { }
	
	public Nodo(Monomio dato) {
		this.monomio = dato;
		siguiente = null;
	}

	public Monomio getMonomio() {
		return monomio;
	}

	public void setMonomio(Monomio monomio) {
		this.monomio = monomio;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

}