package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_i {

	public static void main(String[] args) {
		Utilidades util = new Utilidades();
		// (i) Comprobar si dos ABBs tienen la misma forma
		ABBTDA ab1 = new ABB();
		ABBTDA ab2 = new ABB();
		ab1.InicializaArbol();
		ab2.InicializaArbol();
		
		// arbol 1
		ab1.AgregarElem(1);
		ab1.AgregarElem(3);
		ab1.AgregarElem(8);
		
		// arbol 2
		ab2.AgregarElem(1);
		ab2.AgregarElem(3);
		ab2.AgregarElem(8);
		System.out.println("Verificar si 2 arboles tienen los mismos elementos: " + util.verificaABBIguales(ab1, ab2));

	}
}
