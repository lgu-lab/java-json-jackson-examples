package org.demo.domain;

public class Triangle extends Shape {
	
	long length1 ;
	long length2 ;
	long length3 ;
	
	public Triangle() {
		super(Shape.TRIANGLE);
	}

//	public Triangle(int id, String color) {
//		super(id, color);
//	}
	
	public Triangle(int id, String color, long length1, long length2, long length3) {
		super(Shape.TRIANGLE, id, color);
		this.length1 = length1;
		this.length2 = length2;
		this.length3 = length3;
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

	public long getLength3() {
		return length3;
	}
	public void setLength3(long length3) {
		this.length3 = length3;
	}

	@Override
	public String toString() {
		return "Triangle ["
				+ "type=" + super.getType() 
				+ ", id=" + super.getId() 
				+ ", color=" + super.getColor() 
				+ ", length1=" + length1 
				+ ", length2=" + length2 
				+ ", length3=" + length3 
				+ "]";
	}

}
