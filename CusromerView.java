package com.jing.Service;

import java.awt.Menu;

import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;
import javax.swing.text.View;

import com.love.Controller.CustomerList;
import com.love.Utility.CMUtility;
import com.love.bean.Customer;

public class CusromerView {
	CustomerList customersList = new CustomerList(10);
	
	

	public CusromerView() {
		Customer customer = new Customer("nan ma", 18, '男', "15309539625", "3128309974@qq.com");
		customersList.addCustomer(customer);
	}

	public void mainMenu() {
		boolean isFlag = true;
		while(isFlag){
		System.out.println("\n-----------------客户信息管理软件-----------------\n");
		System.out.println("                   1 添 加 客 户");
		System.out.println("                   2 修 改 客 户");
		System.out.println("                   3 删 除 客 户");
		System.out.println("                   4 客 户 列 表");
		System.out.println("                   5 退       出\n");
		System.out.print("                   请选择(1-5)：");
		
		char menu = CMUtility.readMenuSelection();
			switch(menu){
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				System.out.println("确认是否退出（Y/N）");
				char isExit = CMUtility.readConfirmSelection();
				if(isExit == 'Y'){
					isFlag = false;	
				}
			}
		
	}
	}
	
	private void addNewCustomer(){
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.println();
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.println();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.println();
		System.out.print("电话：");
		String phone =CMUtility.readString(11);
		System.out.println();
		System.out.print("邮箱：");
		String email  = CMUtility.readString(30);
		System.out.println();
		
		Customer cust = new Customer(name, age, gender, phone, email);
//		cust.setAge(age);
//		cust.setName(name);
//		cust.setGender(gender);
//		cust.setPhone(phone);
//		cust.setEmail(email);
		customersList.addCustomer(cust);
		boolean isSuccess = customersList.addCustomer(cust);
		if(isSuccess){
			System.out.println("---------------------添加完成---------------------");
		}else{
			System.out.println("---------------------添加失败---------------------");
		}
		}
	
	
	private void modifyCustomer(){
		System.out.println("---------------------修改客户---------------------");
		int total = customersList.getTotal();
		int number = 0;
		boolean ismodify = true;
		Customer cust=null;
		while(ismodify){
			System.out.print("请选择待修改客户编号（-1退出）：");
			number = CMUtility.readInt();
			if(number == -1){
				return;
			}
			cust = customersList.getCustomer(number-1);
			if(cust == null){
				System.out.println("无法找到指定客户！");
				
			}else{
				ismodify = false ;
			}
		}
		System.out.print("姓名（"+cust.getName()+")");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别（"+cust.getGender()+")");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄（"+cust.getAge()+")");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话（"+cust.getPhone()+")");
		String phone = CMUtility.readString(11, cust.getPhone());
		System.out.print("邮箱（"+cust.getEmail()+")");
		String email = CMUtility.readString(30, cust.getEmail());
		Customer newcust = new Customer(name, age, gender, phone, email);
//		customersList.replaceCustomer(number-1, newcust);
		boolean isReplace = customersList.replaceCustomer(number - 1, newcust);
		if(isReplace == true){
			System.out.println("---------------------修改成功---------------------");
		}else{
			System.out.println("---------------------修改失败---------------------");
		}
		
		
		
	}
	
	
	private void deleteCustomer(){
		int number = 0;
		Customer cust = null ;
		for(;;){
			System.out.println("请选择待删除客户编号（-1退出）：");
			number = CMUtility.readInt();
			if(number == -1){
				return;
			}
			cust = customersList.getCustomer(number-1);
			if(cust == null){
				System.out.println("无法找到指定客户！");
				
			}else{
				break;
			}
		
		}
		System.out.print("确认是否删除（Y/N）");
		char isDelete =CMUtility.readConfirmSelection();
		if(isDelete == 'Y'){
			boolean deleteSuccess = customersList.deleteCustomer(number - 1);
			if(deleteSuccess == true){
				System.out.println("---------------------删除成功---------------------");
			}else{
				System.out.println("---------------------删除失败---------------------");
			}
		}else{
			return ;
			
		}
	}
	
	private void listAllCustomer(){
		System.out.println("---------------------------客户列表---------------------------");
		int total = customersList.getTotal();
		if(total == 0){
			System.out.println("没有客户记录！");
		}else{
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱\t\t");
			Customer[] custs = customersList.getAllCustomer();
			for(int i = 0 ; i < custs.length-1 ; i++){
				Customer cust = custs[i]; 
				System.out.println((i + 1 ) + "\t" +cust.getName()+"\t"+cust.getGender()+"\t"+cust.getAge()+"\t"+
				cust.getPhone()+"\t"+cust.getEmail()+"\t");	
			}
		}
		
		
		
		System.out.println("-------------------------客户列表完成-------------------------");
		
	}
	
	
	
		

	public static void main(String[] args) {
		CusromerView view = new CusromerView();
		view.mainMenu();

	}
}
