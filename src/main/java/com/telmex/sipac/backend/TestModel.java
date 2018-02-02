package com.telmex.sipac.backend;

import java.util.List;
import com.telmex.sipac.backend.data.entity.Customer;

public interface TestModel {

	public void setUserName(String value);
	public String generateSuccessMessage();
	public List<Customer> getCustomers();
}
