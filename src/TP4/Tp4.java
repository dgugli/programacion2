package TP4;

import apis.ABBTDA;
import apis.ConjuntoTDA;
import implementacion.dinamicas.ABB;
import implementacion.dinamicas.ConjuntoLD;
import librerias.Utilidades;

public class Tp4 {

	public static void main(String[] args) {
		int buscado;
		ABBTDA abb = new ABB();
		Utilidades util = new Utilidades();
		
		abb.InicializaArbol();
		abb.AgregarElem(100);
		abb.AgregarElem(50);
		abb.AgregarElem(800);
		abb.AgregarElem(200);
		abb.AgregarElem(150);
		abb.AgregarElem(25);
		abb.AgregarElem(52);
		abb.AgregarElem(900);
		abb.AgregarElem(850);
		abb.AgregarElem(910);
		abb.AgregarElem(125);
		
		// A continuacion se adjuntan las verificaciones utilizando implementacion dinamica de cada ejercicio
		
		// (a) Dado un elemento, determinar si esta o no en un ABB
		buscado = 80;
		
		if (util.existeElementoEnABB(abb, buscado))
			System.out.println("El elemento " + buscado + " existe en el arbol");
		else
			System.out.println("El elemento " +  buscado + " no existe en el arbol.");
		
		// (b) Dado un elemento, determinar si es una hoja de un ABB
		buscado = 100;
		System.out.println("Es hoja el elemento " + buscado + "?:" + util.esHoja(abb, 100));
		
		// (c) Dado un elemento, calcular su profundidad en el ABB
		buscado = 150;
		System.out.println("La profundidad del elemento " + buscado + " es:" +
				util.calcularProfundidad(abb, buscado));
		
		// (d) Obtener el valor del menor elemento de un ABB		
		if (!abb.ArbolVacio())
			System.out.println("El menor elemento del Arbol es: " + util.menor(abb));
		else
			System.out.println("El arbol esta vacio.");
		
		// (e) Calcular la cantidad de elementos que contiene un ABB
		if (!abb.ArbolVacio())
			System.out.println("El arbol contiene " + util.Contar(abb) + " elementos.");
		else
			System.out.println("El arbol esta vacio.");
		
		// (f) Calcular la suma de los elementos que contiene un ABB
		System.out.println("Suma de elementos del ABB: " + util.sumarElementos(abb));
		
		// (g) Calcular la cantidad de hojas de un ABB
		System.out.println("Cantidad de hojas en el ABB: " + util.contarHojas(abb));
		
		// (h) Calcular la altura de un ABB
		System.out.println("Altura del arbol: " + util.alturaArbol(abb));
		
		// (i) Comprobar si dos ABBs tienen la misma forma
				ABBTDA ab1 = new ABB();
				ABBTDA ab2 = new ABB();
				ab1.InicializaArbol();
				ab2.InicializaArbol();
				
				ab1.AgregarElem(1);
				ab1.AgregarElem(3);
				ab1.AgregarElem(8);
				
				ab2.AgregarElem(1);
				ab2.AgregarElem(3);
				ab2.AgregarElem(8);
		System.out.println("Verificar si 2 arboles tienen los mismos elementos: " + util.verificaABBElementosIguales(ab1, ab2));
		
		// (k) Contar la cantidad de elementos que estan en un cierto nivel N
		int nivel = 2;
		System.out.println("Cantidad de elementos en nivel " + nivel + ": " + util.elementosNivelArbol(abb, nivel) );
		
		// (l) Mostrar por pantalla todos los elementos que contiene un ABB (inOrden, PreOrden, PostOrden)
		// in-orden
		System.out.println("Elementos del ABB In-orden: ");
		util.inOrder(abb);
		
		// pre-orden
		System.out.println("Elementos del ABB Pre-orden: ");
		util.preOrder(abb);
		// post-orden
		System.out.println("Elementos del ABB Post-orden:");
		util.postOrder(abb);
	
		// (m) Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k.
		ConjuntoTDA con = new ConjuntoLD();
		con.InicializarConjunto();
		int k=150;
		
		
		
	}
	
}
