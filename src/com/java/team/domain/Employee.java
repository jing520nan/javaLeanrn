package com.java.team.domain;

public class Employee {
	private int id;
	private int age;
	private String name;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * 构建构造器
	 */
	public Employee() {
		super();
	}

	public  Employee(int id, int age, String name, double salary) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public String getDetails(){
		return  id + "\t"+ name+"\t" + age + "\t" + salary; 
	}
	@Override
	public String toString() {
		return  getDetails();
	}

}
