package com.java.team.domain;

public class Architect extends Designer {

	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Architect() {
		super();
	}

	public Architect(int id, int age, String name, double salary, Equipment equipment, double bonus, int stock) {
		super(id, age, name, salary, equipment, bonus);
		this.stock = stock;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getDetails() + "\t架构师\t" +getStatus() + "\t" + getBonus() + "\t" + stock + "\t" +getEquipment().getDescription();
	}
}
