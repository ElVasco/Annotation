package anotaciones;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //SI NO PONGO ESTO, LA ANOTACION NO EXISTE CUANDO 
									//EJECUTE LA APLICACION
public @interface AnotacionEntidad {
	//lo siguiente no es un metodo abstracto, ni se va a implementa en 
	//ningun sitio, simplemente estamos diciento que cuando se use la anotacion
	//se le debe especificar un nombre de tabla
	public String nombreTabla();
}
