package com.telmex.sipac.backend;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.telmex.sipac.backend.data.entity.Customer;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class TestModelImpl implements TestModel, Serializable {
	private String userName="usuario anonimo";

	@Autowired
	CustomerRepository customersRepo;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String generateSuccessMessage(){
		String successMessage;
		successMessage = "Hola " + userName + ". Esta es la lista de Clientes:";
		return successMessage;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = customersRepo.findAll();
		
		return customerList;
	}
	
	

}
