package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_a {

	public static void main(String[] args) {
		
		// (a) Dado un elemento, determinar si esta o no en un ABB
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
		
		buscado = 80;

		if (util.existeElementoEnABB(abb, buscado))
			System.out.println("El elemento " + buscado + " existe en el arbol");
		else
			System.out.println("El elemento " +  buscado + " no existe en el arbol.");
	}

}
