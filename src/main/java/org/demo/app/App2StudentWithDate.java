package org.demo.app;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.demo.domain.Student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App2StudentWithDate {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		
		testWithSingleObject();
		System.out.println("==========");
		testWithListOfObjects();
	}

	public static void testWithSingleObject() throws JsonProcessingException, IOException {
		
		Student student = new Student(1, "Bart", "Simpson", LocalDate.of(1995, 3, 25));
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("JAVA to JSON : ");
		String json = mapper.writeValueAsString(student);
		System.out.println(" . JAVA : " + student );
		System.out.println(" . JSON : " + json );
		
		Student student2 = mapper.readValue(json, Student.class);
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		System.out.println(" . JAVA : " + student2 );
	}

	public static void testWithListOfObjects() throws JsonProcessingException, IOException {
		
		List<Student> students =  new ArrayList<>();
		students.add( new Student(1, "Bart", "Simpson", LocalDate.of(1995, 3, 25)) );
		students.add( new Student(2, "Joe", "Foo", LocalDate.of(2012, 11, 02)) );
		students.add( new Student(3, "Joe", "Dalton", LocalDate.of(1994, 9, 11)) );

		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("JAVA to JSON : ");
		String json = mapper.writeValueAsString(students);
		System.out.println(" . JAVA : " );
		print(students);
		System.out.println(" . JSON : " + json );
		System.out.println("----------");
		
		List<?> students2 = mapper.readValue(json, List.class);
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		System.out.println(" . JAVA (List) : " );
		print(students2); // result : list of LinkedHashMap
		System.out.println("----------");
		
		List<Student> students3 = mapper.readValue(json, new TypeReference<List<Student>>() {});
		System.out.println("JSON to JAVA : " );
		System.out.println(" . JSON : " + json );
		System.out.println(" . JAVA (List) : " );
		print(students3); // result : list of LinkedHashMap
		System.out.println("----------");
		
		
	}
	
	private static void print(List<?> list) {
		for ( Object o : list ) {
			System.out.println(" . " + o.getClass().getSimpleName() + " : " + o);
		}
	}

}
