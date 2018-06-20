package librerias;

import api.ABBTDA;
import api.ColaPrioridadTDA;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;
import implementacion.dinamicas.ColaPrioridadAO;
import implementacion.dinamicas.ConjuntoLD;
import implementacion.estaticos.ColaPI;
import implementacion.estaticos.ColaPU;
import implementacion.estaticos.ColaPrioridadDA;
import implementacion.estaticos.ColaTF;
import implementacion.estaticos.PilaTF;

public class Utilidades {

	// Objetos y atributos auxiliares para la carga de elementos
	int altura;
	int counter;
	int aux;
	boolean verificado;
	ConjuntoTDA conjuntoAux;

	// Pilas
	public void ImprimirPila(PilaTDA o){

		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		CopiarPila(o,aux);
		while(!aux.PilaVacia()){
			System.out.println(aux.Tope());
			aux.Desapilar();
		}
	}

	public void InvertirPila(PilaTDA o){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		PasarPila(o,aux);
		CopiarPila(aux,o);
	}
	
	public static void PasarPila(PilaTDA a, PilaTDA b){
		while (!a.PilaVacia()){
			b.Apilar(a.Tope());
			a.Desapilar();
		}
	}
	
	public void CopiarPila(PilaTDA o, PilaTDA d){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		PasarPila(o,aux);
		while (!aux.PilaVacia()){
			o.Apilar(aux.Tope());
			d.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}

	public int sumarElementosPila(PilaTDA p) {
		int suma = 0;
		
		while (!p.PilaVacia()) {
			suma = suma + p.Tope();
			p.Desapilar();
		}
		return suma;		
	}
	
	// Colas
	public void ImprimirCola(ColaTDA o){
		
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		CopiarCola(o,aux);
		while(!aux.ColaVacia()){
			System.out.println(aux.primero());
			aux.Desacolar();
			}
		}
	public void PasarCola(ColaTDA o, ColaTDA d){
		while (!o.ColaVacia())
		{ 
			d.Acolar(o.primero()); 
			o.Desacolar(); 
		}
	}
	
	public void CopiarCola(ColaTDA o, ColaTDA d){
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		PasarCola(o,aux);
		while(!aux.ColaVacia()){
			o.Acolar(aux.primero());
			d.Acolar(aux.primero());
			aux.Desacolar();
			}
		}
	
	public void InvertirCola(ColaTDA o){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while (!o.ColaVacia())
		{ 
			aux.Apilar(o.primero()); 
			o.Desacolar(); 
		}
		while (!aux.PilaVacia())
		{ 
			o.Acolar(aux.Tope()); 
			aux.Desapilar();
		}
		
		
	}
	public void InvertirColaR(ColaTDA c){
		int x;
		x = c.primero();
		c.Desacolar();
		if (!c.ColaVacia())
			InvertirColaR(c);
		c.Acolar(x);
	}
	
	public boolean IsColaEqual(ColaTDA a,ColaTDA b){
		int cola1=0;
		int cola2=0;
		while(!a.ColaVacia()){
			cola1++;
			a.Desacolar();
		}
			
		while(!b.ColaVacia()){
			cola2++;
			b.Desacolar();
		}
		
		if(cola1==cola2){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean IsColaInvertida(ColaTDA a,ColaTDA b){
		this.InvertirCola(b);
		
		while(!a.ColaVacia()){
			if(a.primero()!=b.primero())
				return false;
			
			a.Desacolar();
			b.Desacolar();	
		}
		return true;
		
	}
	
	public boolean IsColaCapicua(ColaTDA a){
		PilaTDA pilaaux = new PilaTF();
		pilaaux.InicializarPila();
		ColaTDA colaaux = new ColaPI();
		colaaux.InicializarCola();
		
		this.CopiarCola(a, colaaux);
		
		while (!colaaux.ColaVacia())
		{ 
			pilaaux.Apilar(colaaux.primero()); 
			colaaux.Desacolar(); 
		}
		
		while(!a.ColaVacia()){
			if(pilaaux.Tope()!=a.primero())
				return false;
				
			pilaaux.Desapilar();
			a.Desacolar();
		}
		
		return true;
		
		
	}


/////////////////////////////////////////////////////////////////////////////
//Cola con Prioridad
/////////////////////////////////////////////////////////////////////////////

	public void CombinarColaPrioridad(ColaPrioridadTDA a,ColaPrioridadTDA b){
		ColaPrioridadTDA colaaux = new ColaPrioridadDA();
		colaaux.InicializarCola();
		
		//Primero Acolo CP1
		while(!a.ColaVacia())
		{
			colaaux.AcolarPrioridad(a.Primero(), a.Prioridad());
			a.Desacolar();
		}
		//Primero Acolo CP2
		while(!b.ColaVacia())
		{
			colaaux.AcolarPrioridad(b.Primero(), b.Prioridad());
			b.Desacolar();
		}
	}
	
	public boolean VerificarColaPrioridadIdentica(ColaPrioridadTDA a,ColaPrioridadTDA b){
		//Genero 2 nuevas colas  y las copio para no destruir las originales
		ColaPrioridadTDA cola_a = new ColaPrioridadDA();
		cola_a.InicializarCola();
		ColaPrioridadTDA cola_b = new ColaPrioridadDA();
		cola_b.InicializarCola();
		
		while(!a.ColaVacia())
		{
			if (a.Primero() != b.Primero() || a.Prioridad() != b.Prioridad())
			{
				return false;
			}
			a.Desacolar();
			b.Desacolar();
		}
		return true;
	}

	public void CopiarColaPrioridad(ColaPrioridadTDA o, ColaPrioridadTDA d) {
		ColaPrioridadAO colaaux = new ColaPrioridadAO();
		colaaux.InicializarCola();
		
		while (!o.ColaVacia()) {
			colaaux.AcolarPrioridad(o.Primero(), o.Prioridad());
			o.Desacolar();
		}
		while (!colaaux.ColaVacia()) {
			o.AcolarPrioridad(colaaux.Primero(), colaaux.Prioridad());
			d.AcolarPrioridad(colaaux.Primero(), colaaux.Prioridad());
			colaaux.Desacolar();
		}
	}

	
	// Arboles
	public void preOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
	
	public void inOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	public void postOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}
	public int ContarPila(PilaTDA p){
		int total = 0;
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		CopiarPila(p,aux);
		while (!aux.PilaVacia())
		{
			total++;
			aux.Desapilar();
		}
		return total;
			
	}
	
	public float CalcularPromedioPila(PilaTDA p)
	{ 
		int suma = 0;
		int cantidad = 0;
		float promedio = 0;
		suma = sumarElementosPila(p);
		cantidad = ContarPila(p);
		promedio = suma/cantidad;
		return promedio;
	}
	
	// Metodo para cargar un conjunto siempre que los valores del arbol sean mayor que K
	public ConjuntoTDA cargarConjunto(ABBTDA arbol, int k) {
		conjuntoAux = new ConjuntoLD();
		conjuntoAux.InicializarConjunto();
		cConjunto(arbol, k);
		return conjuntoAux;
	}
	
	// Metodo auxiliar recursivo para la carga del conjunto enviado desde cargarConjunto()
	private void cConjunto(ABBTDA arbol, int k) {
		if (!arbol.ArbolVacio()) {
			if (arbol.Raiz()>k)
				conjuntoAux.Agregar(arbol.Raiz());
			cConjunto(arbol.HijoDer(), k);
			cConjunto(arbol.HijoIzq(), k);
		}
	}
	
	// Buscar el valor inmediatamente anterior a k en un arbol
	public int valorAnterior(ABBTDA arbol, int k) {
		aux = k;
		valAnterior (arbol, k);
		return aux;
	}
	
	private void valAnterior(ABBTDA arbol, int k) {
		if (!arbol.ArbolVacio()) {
			if (!arbol.HijoDer().ArbolVacio() && arbol.HijoDer().Raiz()==k)
				aux = arbol.Raiz();
			if (!arbol.HijoIzq().ArbolVacio() && arbol.HijoIzq().Raiz()==k)
				aux = arbol.Raiz();
			valAnterior(arbol.HijoDer(),k);
			valAnterior(arbol.HijoIzq(),k);			
		}
	}
	
	public boolean verificaABBElementosIguales(ABBTDA a, ABBTDA b) {
		// Siempre que sean identicos entra en este if
		if (!a.ArbolVacio() && !b.ArbolVacio() && a.Raiz() == b.Raiz()) {
			return ( (verificaABBElementosIguales(a.HijoDer(), b.HijoDer()) && 
					verificaABBElementosIguales(a.HijoIzq(), b.HijoIzq())));
		}				
		else // si llego al final devuelve true ya que son identicos hasta el final, si hay diferencias devuelve false
			return (a.ArbolVacio() && b.ArbolVacio() ? true : false);
	}
	
	public boolean verificaABBIguales(ABBTDA a, ABBTDA b) {
		// Siempre que sean identicos entra en este if
		if (!a.ArbolVacio() && !b.ArbolVacio()) {
			return ( (verificaABBIguales(a.HijoDer(), b.HijoDer()) && verificaABBIguales(a.HijoIzq(), b.HijoIzq())));
		}				
		else // si llego al final devuelve true ya que son identicos hasta el final, si hay diferencias devuelve false
			return (a.ArbolVacio() && b.ArbolVacio() ? true : false);
	}
	
	public int Contar(ABBTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		} else {
			return (1+Contar(a.HijoIzq()) + Contar(a.HijoDer()));
		}
	}
	
	public int sumarElementos(ABBTDA a) {
		if (a.ArbolVacio())
			return 0;
		else 
			return (a.Raiz()+sumarElementos(a.HijoDer()) + sumarElementos(a.HijoIzq()));
	}
	
	public int contarHojas(ABBTDA a) {
		if (a.ArbolVacio())
			return 0;
		else if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio())
			return 1 + contarHojas(a.HijoDer()) + contarHojas(a.HijoIzq());
		else
			return contarHojas(a.HijoDer()) + contarHojas(a.HijoIzq());

	}
	
	public int alturaArbol(ABBTDA a) {
		altura = 0;
		if (!a.ArbolVacio())
			alturaArbol(a,1);
		return altura;
	}
	
	public void alturaArbol(ABBTDA a, int nivel) {
		if (!a.ArbolVacio()) {
			alturaArbol(a.HijoDer(),nivel+1);
			if (nivel>altura)
				altura = nivel;
			alturaArbol(a.HijoIzq(), nivel+1);
		}
	}
	
	public int elementosNivelArbol(ABBTDA a, int nivel) {
		altura = nivel;
		
		if (!a.ArbolVacio())
			nivelArbol(a, 1);
		return counter;
	}
	
	public void nivelArbol(ABBTDA a, int nivel) {
		if (!a.ArbolVacio()) {
			nivelArbol(a.HijoDer(), nivel+1);
			if (nivel==altura)
				counter++;
			nivelArbol(a.HijoIzq(),nivel+1);
		}
	}
	
	public boolean existeElementoEnABB(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return false;
		} else if (t.Raiz() == x) {
			return true;
		} 
		else if (t.Raiz() > x) {
			return this.existeElementoEnABB(t.HijoIzq(), x);
		} else 
			return this.existeElementoEnABB(t.HijoDer(),x);
	}
	
	public int calcularProfundidad(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return 0;
		}
		else if (t.Raiz() == x) {
			return 0;
		} else if (t.Raiz() >x) {
			return (1+this.calcularProfundidad(t.HijoIzq(), x));
		} else 
			return (1+this.calcularProfundidad(t.HijoDer(), x));
	}
	
	
	public boolean esHoja(ABBTDA a, int x) {
		if (a.ArbolVacio())
			return false;
		else if ( a.Raiz() == x && a.HijoDer().ArbolVacio() && a.HijoDer().ArbolVacio()) {
			return true;
		} else if (a.Raiz() > x)
			return this.esHoja(a.HijoIzq(), x);
		else
			return this.esHoja(a.HijoDer(), x);
	}
	
	public int mayor(ABBTDA a) {
		if (a.HijoDer().ArbolVacio())
			return a.Raiz();
		else 
			return mayor(a.HijoDer());
	}
	
	public int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}
	
	// Conjuntos 
	public boolean SonConjuntosIguales(ConjuntoTDA c1, ConjuntoTDA c2) {
		int elemento;
		boolean sonIguales = true;
		while (!c1.ConjuntoVacio() && c2.ConjuntoVacio() && sonIguales) {
			elemento = c1.Elegir();
			if (!c2.Pertenece(elemento))
				sonIguales = false;
			else {
				c1.Sacar(elemento);
				c2.Sacar(elemento);
			}			
		}
		return (c1.ConjuntoVacio() && c2.ConjuntoVacio());
		
	}
	
	// Colas
	public void pasarCola(ColaTDA origen, ColaTDA destino) {
		while (!origen.ColaVacia()) {
			destino.Acolar(origen.primero());
			origen.Desacolar();
		}
	}
	
	public void copiarCola(ColaTDA origen, ColaTDA destino) {
		ColaTDA aux = new ColaTF();
		aux.InicializarCola();
		
		pasarCola(origen, aux);
		
		while (!aux.ColaVacia()) {
			origen.Acolar(aux.primero());
			destino.Acolar(aux.primero());
			aux.Desacolar();
		}
	}
}
