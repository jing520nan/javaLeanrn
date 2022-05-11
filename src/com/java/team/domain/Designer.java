package com.java.team.domain;

import com.java.team.service.Status;

public class Designer extends Programmer {
	
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Designer() {
		super();
	}

	public Designer(int id, int age, String name, double salary, Equipment equipment, double bonus) {
		super(id, age, name, salary, equipment);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus +"\t\t" +getEquipment().getDescription();
	}
	
}
