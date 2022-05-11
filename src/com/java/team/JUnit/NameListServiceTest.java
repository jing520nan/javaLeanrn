package com.java.team.JUnit;

import org.junit.Test;

import com.java.team.domain.Employee;
import com.java.team.service.NameListService;
import com.java.team.service.TeamException;

public class NameListServiceTest {
//	@Test
//	public void testGetAllEmployees(){
//		NameListService service = new NameListService();
//		Employee[] employees = service.getAllEmployees();
//		for (int i = 0; i < employees.length; i++) {
//			System.out.println(employees[i]);
//		}
//		
//	}
	@Test
	public  void testGetEmployee(){
		NameListService service = new NameListService();
		int id = 10;
		try {
			Employee employee = service.getEmplyee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
