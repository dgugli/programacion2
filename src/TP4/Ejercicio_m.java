package TP4;

import api.ABBTDA;
import api.ConjuntoTDA;
import implementacion.dinamicas.ABB;
import implementacion.dinamicas.ConjuntoLD;
import librerias.Utilidades;

public class Ejercicio_m {
	
	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		ConjuntoTDA con = new ConjuntoLD();
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
				

		// (m) Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k.
		con.InicializarConjunto();
		int k=125;
		
		con = util.cargarConjunto(abb, k);
		
		System.out.println("Datos cargados en el conjunto: ");
		while (!con.ConjuntoVacio()) {
			System.out.println(con.Elegir());
			con.Sacar(con.Elegir());
		}
		

	}
	
}
