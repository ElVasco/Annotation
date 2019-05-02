package entidades;

import anotaciones.AnotacionEntidad;
import anotaciones.ClavePrimaria;

@AnotacionEntidad(nombreTabla = "tabla_usuario")
public class Entidad {

	private String nombre;
	private String email;
	
	@ClavePrimaria
	private long id;

	
	
}
