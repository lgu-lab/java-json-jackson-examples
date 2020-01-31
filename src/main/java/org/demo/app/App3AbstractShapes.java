package org.demo.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.demo.domain.Circle;
import org.demo.domain.Shape;
import org.demo.domain.Triangle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class App3AbstractShapes {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		Shape shape ;
		shape = new Triangle(123, "Red", 20, 30, 40);
		javaToJsonToJava(shape, Shape.class);

		shape = new Circle(456, "Green", 150);
		javaToJsonToJava(shape, Shape.class);
		
		List<Shape> shapes =  new ArrayList<>();
		shapes.add(new Triangle(123, "red", 20, 30, 40));
		shapes.add(new Triangle(456, "green", 70, 80, 90));
		shapes.add(new Circle(888, "blue", 22));
		shapes.add(new Circle(999, "yellow", 44));
		shapes.add(new Triangle(789, "green", 70, 80, 90));		

		javaToJsonToJava(shapes, List.class);
		
		javaToJsonToJavaWithTypeReference(shapes);
		
	}

	private static void javaToJsonToJava(Object object1, Class<?> clazz) throws JsonProcessingException, IOException {
		
		System.out.println("-----");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT); // to enable pretty-printing (JSON formatting)
		
		System.out.println("JAVA to JSON : ");
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object1);
		String json = mapper.writeValueAsString(object1);
		System.out.println(" . JAVA : " + object1 );
		System.out.println(" . JSON : " + json );
		
		Object object2 = mapper.readValue(json, clazz);
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		if ( object2 instanceof List) {
			print((List<?>)object2);
		}
		else {
			System.out.println(" . JAVA : " + object2 );
		}
	}
	private static void javaToJsonToJavaWithTypeReference(List<Shape> shapes) throws JsonProcessingException, IOException {
		
		System.out.println("-----");
		
		TypeReference<List<Shape>> typeRef = new TypeReference<List<Shape>>() {};
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT); // to enable pretty-printing (JSON formatting)
		
		System.out.println("JAVA to JSON : ");
		String json = mapper.writerFor(typeRef).writeValueAsString(shapes);
		
		System.out.println(" . JAVA : " + shapes );
		System.out.println(" . JSON : " + json );
		
		Object object2 = mapper.readValue(json, typeRef); // Use "TypeReference"
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		if ( object2 instanceof List) {
			print((List<?>)object2);
		}
		else {
			System.out.println(" . JAVA : " + object2 );
		}
	}
	private static void print(List<?> list) {
		for ( Object o : list ) {
			if ( o instanceof Shape) {
				System.out.println(" . SHAPE : " + (Shape)o);
			}
			else {
				System.out.println(" . " + o.getClass().getSimpleName() + " : " + o);
			}
		}
	}
}
