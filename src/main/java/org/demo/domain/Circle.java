package org.demo.domain;

public class Circle extends Shape {
	
	private long radius ;

	public Circle() {
		super(Shape.CIRCLE);
	}

	public Circle(int id, String color, long radius) {
		super(Shape.CIRCLE, id, color);
		this.radius = radius;
	}

	public long getRadius() {
		return radius;
	}

	public void setRadius(long radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [" 
				+ "type=" + super.getType() 
				+ ", id=" + super.getId() 
				+ ", radius=" + radius 
				+ "]";
	}


}
