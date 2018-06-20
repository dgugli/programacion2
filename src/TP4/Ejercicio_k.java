package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_k {

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
				
		// (k) Contar la cantidad de elementos que estan en un cierto nivel N
		int nivel = 2;
		System.out.println("Cantidad de elementos en nivel " + nivel + ": " + util.elementosNivelArbol(abb, nivel) );

	}

}
