package com.java.team.domain;

import com.java.team.service.Status;

public class Programmer extends Employee{
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	
	public Programmer() {
		super();
	}
	


	public int getMemberId() {
		return memberId;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Equipment getEquipment() {
		return equipment;
	}



	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}



	public Programmer(int memberId, Status status, Equipment equipment) {
		super();
		this.memberId = memberId;
		this.status = status;
		this.equipment = equipment;
	}



	public Programmer(int id ,int age,String name,double salary, Equipment equipment) {
		super(id, age, name, salary);
	
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	

}
