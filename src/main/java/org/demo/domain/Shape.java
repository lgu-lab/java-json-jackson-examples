package org.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeinfo") // add an attribute "typeinfo" to identify the concrete class
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") // use the same attribute as "type" attribute (add @JsonIgnore on this attribute)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Triangle.class,  name = "T"),  // JSON : "type" : "T" if class is Triangle
  @JsonSubTypes.Type(value = Circle.class,    name = "C"),  // JSON : "type" : "C" if class is Circle
  @JsonSubTypes.Type(value = Rectangle.class, name = "R")   // JSON : "type" : "R" if class is Rectangle
})
public abstract class Shape {
	
	public static final String TRIANGLE  = "T" ;
	public static final String CIRCLE    = "C" ;
	public static final String RECTANGLE = "R" ;
	public static final String UNDEFINED = "X" ;
	
	private int id;
	
	private String color ;
	
	@JsonIgnore // ignore because "type" is already managed by @JsonTypeInfo
	private String type ;
	
	public Shape(String type) {
		super();
		this.type = type;
	}

	public Shape(String type, int id, String color) {
		super();
		this.type = type;
		this.id = id;
		this.color = color;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Shape [id=" + id + ", color=" + color + ", type=" + type + "]";
	}

}
