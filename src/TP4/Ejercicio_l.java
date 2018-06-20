package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_l {

	public static void main(String[] args) {
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
	}

}
