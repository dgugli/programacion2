package implementacion.estaticos;

import apis.PilaTDA;

public class PilaTF implements PilaTDA {

	int[] a;
	int indice;
	
	@Override
	public void InicializarPila() {
		a = new int[100];
		indice = 0;
	}

	@Override
	public void Apilar(int x) {
		a[indice] = x;
		indice++;
	}

	@Override
	public void Desapilar() {
		indice--;
	}

	@Override
	public boolean PilaVacia() {
		return (indice == 0);
	}

	@Override
	public int Tope() {
		return a[indice-1];
	}

	void PasarPila(PilaTDA a, PilaTDA b){
		while (!a.PilaVacia()){
			b.Apilar(a.Tope());
			a.Desapilar();
		}
	}
}
