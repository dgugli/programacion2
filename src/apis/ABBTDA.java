package apis;

public interface ABBTDA {
	int Raiz();
	ABBTDA HijoIzq();
	ABBTDA HijoDer();
	boolean ArbolVacio();
	void InicializaArbol();
	void AgregarElem(int x);
	void EliminarElem(int x);
}