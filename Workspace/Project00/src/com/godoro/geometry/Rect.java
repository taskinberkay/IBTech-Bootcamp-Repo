package com.godoro.geometry;

public class Rect {
	private int width, height;
	
	Rect(){
		width = 1;
		height = 1;
	}
	
	Rect(int width, int height){
		this.width = width;
		this.height = height;
	}

	public void setHeight(int height) {
		if(height < 1) {
			throw new IllegalArgumentException("This attribute cannot be negative");
		}else {
			this.height = height;
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		if(width < 1) {
			throw new IllegalArgumentException("This attribute cannot be negative");
		}else {
			this.width = width;
		}
		
	}
	
	public int getWidth() {
		return width;
	}
	
	
	int getArea() {
		return width * height;
	}
	
	int getCircumference() {
		return (width+height)*2;
	}
	
}