import api.DiccionarioMultipleTDA;
import implementacion.dinamicas.DicMultiplel;

public class Ejercicio5_a {

	public static void main(String[] args) {
		DiccionarioMultipleTDA dim_a = new DicMultiplel();
		DiccionarioMultipleTDA dim_b = new DicMultiplel();
		DiccionarioMultipleTDA dim_c = new DicMultiplel();
		
		
		dim_a.InicializarDiccionario();
		dim_b.InicializarDiccionario();
		dim_c.InicializarDiccionario();
		
		dim_a.Agregar(0, 1);
		dim_a.Agregar(0, 2);
		dim_a.Agregar(1, 3);
		dim_a.Agregar(2, 4);
		
		dim_b.Agregar(3, 1);
		dim_b.Agregar(4, 1);
		dim_b.Agregar(5, 1);
		dim_b.Agregar(6, 1);
		
		
		

	}

}
