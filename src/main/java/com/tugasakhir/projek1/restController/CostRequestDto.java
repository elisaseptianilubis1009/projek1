package com.tugasakhir.projek1.restController;


public class CostRequestDto {
	
	private Integer origin;
	
	private Integer destination;
	
	private Integer weight;
	
	private String courier;

	
	public CostRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CostRequestDto(Integer origin, Integer destination, Integer weight, String courier) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.courier = courier;
	}

	public Integer getOrigin() {
		return origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	public Integer getDestination() {
		return destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}
	
	
	
	
	
}
