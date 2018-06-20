package TP4;

import api.ABBTDA;
import api.ConjuntoTDA;
import implementacion.dinamicas.ABB;
import implementacion.dinamicas.ConjuntoLD;
import librerias.Utilidades;

public class Ejercicio_n {

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
		
		// (n) Dado un elemento de valor v (presente en el ABB), obtener el elemento
		// del arbol que es inmediatamente anterior
		int valorBuscado = 150;
		int valorEncontrado = util.valorAnterior(abb, valorBuscado);
		if (valorEncontrado==valorBuscado)
			System.out.println("No se ha encontrado el elemento anterior.");
		else
			System.out.println("El elemento anterior al elemento buscado (" + valorBuscado + ") es: " + valorEncontrado);

	}

}
