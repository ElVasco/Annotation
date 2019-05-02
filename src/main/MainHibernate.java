package main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import anotaciones.AnotacionEntidad;
import anotaciones.ClavePrimaria;

//ejemplo ilustrativo de los que hibernate y otros frameworks hacer
//para tratar anotaciones
public class MainHibernate {

	public static void main(String[] argv) {
		try {
			Class classEntidad = Class.forName("entidades.Entidad");
			//hibernate podria lanzar una sql de creacion de la tabla
			//correspondiente en este caso a entidades.Entidad
			
			//hibernate necesita entre otras cosas saber el nombre de la tabla
			//que debe crear, y como debe llamarse el campo correspondiente
			//a la clave primaria
			
			//obetener el nombre de la tabla
			Annotation annotation = classEntidad.getAnnotation(AnotacionEntidad.class);
			//si no existe esa anotacion, es uqe no va a haber una tabla para la clase
			
			if(annotation != null) {
				AnotacionEntidad anotacionCorrespondiente = (AnotacionEntidad)annotation;
				String nombreTabla = anotacionCorrespondiente.nombreTabla();
				System.out.println("nombre de la tabla a crear: " + nombreTabla);
			}else {
				System.out.println("anotacion no encontrada");
			}
			
			//ahora queremos sacar que campo ha sido marcado como clave primaria
			Field[] campos = classEntidad.getDeclaredFields();
			 for (Field field : campos) {
				Annotation annotationClavePrimaria = field.getAnnotation(ClavePrimaria.class);
				if(annotationClavePrimaria != null) {
					System.out.println("el campo que sera la clave primaria es: " + field.getName());
				}
			}
		} catch (Exception e) {
			System.out.println("error usando reflection");
			e.printStackTrace();
		}
		
	}
	
}
