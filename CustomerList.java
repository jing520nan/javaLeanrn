package com.love.Controller;

import com.love.bean.Customer;

public class CustomerList {
	
	private Customer[] customers;
	private int total = 0;
	
	
	public CustomerList() {

	}
	/*
	 * 对数组进行初始化
	 */

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * 
	 * @Description
	 * @author nan-jing 
	 * @version
	 * @date 2022年5月1日上午11:22:16
	 * @boolean 添加成功，返回true
	 *
	 */
	public boolean addCustomer(Customer cust){
		if(total >= customers.length){
			return false;
		}else{
			customers[total] = cust ;
			total++;
			return true ;
		}
		
	}
	/**
	 * 
	 * @Description,改变顾客信息
	 * @author nan-jing 
	 * @version
	 * @date 2022年5月1日上午11:26:45
	 */
	public boolean replaceCustomer(int index, Customer cust){
		if(index >= 0 && index < total){
			customers[index] = cust;
			return true;
		}else{
			return false ;
		}
	}
	public boolean deleteCustomer(int index){
		if(index >= 0 && index < total){
			for(int i = index ; i < total - 1 ; i++){
				
				customers[i] = customers[i+1];
				
			}
			customers[total - 1] =null;
			total--;
			return true;
			
		}else{
			
			return false ;
			
		}
	}
	public Customer[] getAllCustomer(){
		Customer[] custs = new Customer[total];
		for(int i = 0; i< total ; i++){
			custs[i] = customers[i];
		}
		return custs;
	}
	public Customer getCustomer(int index){
		if(index >= 0 && index < total){
			return customers[index];
		}else{
			return null ;
		}
	}
	public int getTotal(){
		return total;
	}
	
	

}
