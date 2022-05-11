package com.java.team.service;

import java.nio.charset.MalformedInputException;

import javax.print.attribute.standard.RequestingUserName;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import com.java.team.domain.Architect;
import com.java.team.domain.Designer;
import com.java.team.domain.Employee;
import com.java.team.domain.Equipment;
import com.java.team.domain.NoteBook;
import com.java.team.domain.PC;
import com.java.team.domain.Printer;
import com.java.team.domain.Programmer;
/**
 * 
 * @Description负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法
 * @author nan-jing 
 * @version v1.0
 * @date 2022年5月10日下午3:41:17
 */
public class NameListService {
	
	private Employee[] employees;
	/*
	 * 给数组和数组元素进行初始化
	 */
	public NameListService() {
		Equipment equipment;
		double bonus;
		int stack;
		employees = new Employee[Data.EMPLOYEES.length];
		for (int i = 0; i < employees.length; i++) {
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			//获取基本信息
			int id =  Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]); 
			employees[i] = new Employee(id, age, name, salary);
			switch (type) {
			case Data.EMPLOYEE:
				break;
			case Data.PROGRAMMER:
				equipment = creteEquipment(i);
				employees[i] = new Programmer(id, age, name, salary, equipment); 
				break;
			case Data.DESIGNER:
				equipment = creteEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, age, name, salary, equipment, bonus);
				break;
			case Data.ARCHITECT: 
				equipment = creteEquipment(i);
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				stack = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Architect(id, age, name, salary, equipment, bonus, stack);
			}
		}
	}
	/**
	 * 
	 * @Description,获取基本设备信息
	 * @author nan-jing 
	 * @version v1.0
	 * @date 2022年5月10日下午4:10:46
	 */
	private Equipment creteEquipment(int index){
		int type =Integer.parseInt(Data.EQUIPMENTS[index][0]);
		switch (type) {
		case Data.PC:
			return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
		case Data.NOTEBOOK:
			return new NoteBook(Data.EQUIPMENTS[index][1], Double.parseDouble(Data.EQUIPMENTS[index][2]));
		
		case Data.PRINTER:
			return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
		}
		return null;
		
	}
	/**
	 * 
	 * @Description 获取全部对象的基本信息
	 * @author nan-jing 
	 * @version
	 * @date 2022年5月10日下午4:49:35
	 */
	public Employee[] getAllEmployees(){
		return employees;
	}
	
	public Employee getEmplyee(int id) throws TeamException{
		for(int i = 0 ; i < employees.length ; i++){
			if (employees[i].getId() == id) {
				return employees[i];
			}
			
		}
		throw new TeamException("找不到指定员工");
	}
	
	


	

}
