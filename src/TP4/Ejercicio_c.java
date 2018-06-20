package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_c {

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
		
		
		// (c) Dado un elemento, calcular su profundidad en el ABB
		buscado = 150;
		System.out.println("La profundidad del elemento " + buscado + " es:" +
				util.calcularProfundidad(abb, buscado));

	}

}
