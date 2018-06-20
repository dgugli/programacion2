package librerias;

import apis.ABBTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.PilaTDA;
import implementacion.estaticos.ColaTF;
import implementacion.estaticos.PilaTF;

public class Utilidades {

	int altura;
	int counter;
	// Pilas
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
	
	public boolean verificaABBElementosIguales(ABBTDA a, ABBTDA b) {
		if (!a.ArbolVacio() && !b.ArbolVacio() && a.Raiz() == b.Raiz()) {
			return ( verificaABBElementosIguales(a.HijoDer(), b.HijoDer()) && verificaABBElementosIguales(a.HijoIzq(), b.HijoIzq()));
		}				
		else 
			return (a.ArbolVacio() ? false : b.ArbolVacio() ? false : (a.Raiz()==b.Raiz()));
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
