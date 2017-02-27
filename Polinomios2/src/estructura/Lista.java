package estructura;

import modelo.Monomio;

public class Lista {

	private Nodo inicio;
	
	public Lista() { }
	
	public boolean estaVacia() {
		return inicio == null;
	}
	
	public void agregar(Monomio monomio) {
		Nodo nuevo = new Nodo(monomio);
		
		if (estaVacia()) {
			inicio = nuevo;
		} else {
			Nodo aux = inicio;
			while (aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
	}
	
	public Nodo getInicio() {
		return inicio;
	}
	
	public void eliminar(Monomio m) {
		Nodo aux = inicio;
		Nodo ant = null;
		
		while (aux != null && aux.getMonomio() != m) {
			ant = aux;
			aux = aux.getSiguiente();
		}
		
		if (ant == null) {
			inicio = aux.getSiguiente();
		} else {
			ant.setSiguiente(aux.getSiguiente() != null ? aux.getSiguiente() : null);
		}
	}
}