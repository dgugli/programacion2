package implementacion.dinamicas;

import apis.ColaTDA;

public class ColaLD implements ColaTDA {

	// primer elemento en la cola
	Nodo primero;
	// ultimo elemento en la cola, es decir, el ultimo agregado
	Nodo ultimo;
	
	@Override
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void Acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		// Si la cola no esta vacia
		if (ultimo != null)
			ultimo.sig = aux;
		ultimo = aux;
		
		// Si la cola estaba vacia
		if (primero==null)
			primero = ultimo;
	}

	@Override
	public void Desacolar() {
		primero = primero.sig;
		if (primero == null)
			ultimo = null;
	}

	@Override
	public boolean ColaVacia() {
		return (ultimo == null);
	}

	@Override
	public int primero() {
		return primero.info;
	}

}
