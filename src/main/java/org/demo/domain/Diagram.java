package org.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
	
	private int id;
	
	private String name ;
	
	private String version ;
	
	private List<Shape> shapes ;
	
	public Diagram() {
		super();
		this.shapes = new ArrayList<>();
	}

	public Diagram(int id, String name, String version) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.shapes = new ArrayList<>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	public void addShappe(Shape shape) {
		shapes.add(shape);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( "Diagram [" );
		sb.append( "\n  " );
		sb.append( "id=" + id + ", name=" + name + ", version=" + version );
		sb.append( "\n  " );
		sb.append( "shapes : " );
		for ( Shape shape : shapes ) {
			sb.append( "\n  " );
			sb.append(shape.toString());
		}
		sb.append( "\n  " );
		sb.append( "]" );
		return sb.toString();
	}

}
