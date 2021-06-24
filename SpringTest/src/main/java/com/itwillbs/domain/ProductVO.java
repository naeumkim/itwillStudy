package com.itwillbs.domain;

public class ProductVO {
	// VO(value Object) <==> DTO와 유사한 개념 <==> 자바빈
	
	private String name;
	private double price;
	
	public ProductVO() {
	//기본 생성자
	}
	
	public ProductVO(String name,double price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
	
}
