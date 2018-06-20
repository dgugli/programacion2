package implementacion.estaticos;

import apis.ColaPrioridadTDA;

public class ColaPrioridadDA implements ColaPrioridadTDA {
	int[] elementos;
	int[] prioridades;
	int indice;
	
	@Override
	public void InicializarCola() {
		indice = 0;
		elementos = new int[100];
		prioridades = new int[100];
	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		// desplaza a la derecha los elementos de la cola mientras estos
		// tengan mayor o igual prioridade que la x
		int j = indice;
		for ( ; j>0 && prioridades[j-1]>= prioridad; j--) {
			elementos[j] = elementos[j-1];
			prioridades[j] = prioridades[j-1];
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}

	@Override
	public void Desacolar() {
		indice--;
		
	}

	@Override
	public int Primero() {
		return elementos[indice-1];
	}

	@Override
	public boolean ColaVacia() {
		return (indice==0);
	}

	@Override
	public int Prioridad() {
		return prioridades[indice-1];
	}

}
