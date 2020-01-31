package org.demo.app;

import java.io.IOException;

import org.demo.domain.Circle;
import org.demo.domain.Diagram;
import org.demo.domain.Rectangle;
import org.demo.domain.Triangle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App4Diagram {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		Diagram diagram = new Diagram(123, "My diagram", "1.2.3");
		diagram.addShappe(new Triangle(123, "red", 20, 30, 40));
		diagram.addShappe(new Triangle(456, "green", 70, 80, 90));
		diagram.addShappe(new Circle(888, "blue", 22));
		diagram.addShappe(new Rectangle(1001, "green", 150, 250));
		diagram.addShappe(new Circle(999, "yellow", 44));
		diagram.addShappe(new Triangle(789, "green", 70, 80, 90));
		
		javaToJsonToJava(diagram, Diagram.class);
	}

	private static void javaToJsonToJava(Object object1, Class<?> clazz) throws JsonProcessingException, IOException {
		
		System.out.println("-----");
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("JAVA to JSON : ");
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object1);
		System.out.println(" . JAVA : " + object1 );
		System.out.println(" . JSON : " + json );
		
		System.out.println("-----");
		Object object2 = mapper.readValue(json, clazz);
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		System.out.println(" . JAVA : " + object2 );
	}
}
