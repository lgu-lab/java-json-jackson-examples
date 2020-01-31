package org.demo.domain;

public class Rectangle extends Shape {
	
	long length1 ;
	long length2 ;
	
	public Rectangle() {
//		super(Shape.UNDEFINED); 
		super(Shape.RECTANGLE);
	}

	public Rectangle(int id, String color, long length1, long length2) {
//		super(Shape.UNDEFINED, id, color);
		super(Shape.RECTANGLE, id, color);
		this.length1 = length1;
		this.length2 = length2;
	}

	public long getLength1() {
		return length1;
	}
	public void setLength1(long length1) {
		this.length1 = length1;
	}

	public long getLength2() {
		return length2;
	}
	public void setLength2(long length2) {
		this.length2 = length2;
	}

	@Override
	public String toString() {
		return "Rectangle ["
				+ "type=" + super.getType() 
				+ ", id=" + super.getId() 
				+ ", color=" + super.getColor() 
				+ ", length1=" + length1 
				+ ", length2=" + length2 
				+ "]";
	}

}
