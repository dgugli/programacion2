package TP4;

import api.ABBTDA;
import implementacion.dinamicas.ABB;
import librerias.Utilidades;

public class Ejercicio_j {

	public static void main(String[] args) {
		Utilidades util = new Utilidades();
		// (j) Comprobar si dos ABBs soniguales
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


	}
}
