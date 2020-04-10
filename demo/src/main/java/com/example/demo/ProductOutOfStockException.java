package com.example.demo;

public class ProductOutOfStockException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProductOutOfStockException(String msg) {
		super(msg);
	} 
	
	public ProductOutOfStockException(String msg,Throwable t) {
		super(msg,t);
	} 
	
	
}
