package com.educando.course.course.model.enums;

public enum OrderStatus {

	PAID(1),
	SHIPPED(2),
	WAITING_PAYMENT(3),
	CANCELED(4);
	
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
	public static OrderStatus valueOF(int code) {
		
		for (OrderStatus var : OrderStatus.values()) {
			
			if(var.getCode() == code) {
				return var;
			}
			
		}

		throw new IllegalArgumentException("Invalid OrderStatus Code");
		
	}
	
	
	
	
	
}
