package org.demo.app;

import java.io.IOException;

import org.demo.domain.Animal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App1AnimalBasic {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		Animal animal = new Animal(1, "Felix", "cat");
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("JAVA to JSON : ");
		String json = mapper.writeValueAsString(animal);
		System.out.println(" . JAVA : " + animal );
		System.out.println(" . JSON : " + json );
		
		Animal animal2 = mapper.readValue(json, Animal.class);
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		System.out.println(" . JAVA : " + animal2 );
	}

}
