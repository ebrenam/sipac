package com.telmex.sipac.ui.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.telmex.sipac.backend.data.entity.Customer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button.ClickEvent;

@SpringComponent
public class TestViewImpl extends TestDesign implements View, TestView, Serializable {
	
	/* Solo el presenter registrara 1 listener... */
	List<TestViewListener> listeners = new ArrayList<TestViewListener>();
	
	private static final Logger log = LoggerFactory.getLogger(TestViewImpl.class);
	
	@PostConstruct
	public void init() {
				
		log.info("-UI-");
		
		
		btnPress.addClickListener(e -> clickResponse(e));

	}
	
	public void clickResponse(ClickEvent event){

		String userName = txtField.getValue();
		
		for (TestViewListener listener : listeners)
			listener.buttonClick(userName);
	}
	
	public TestViewImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enter(ViewChangeEvent event) {
		String cadena = event.getParameters();
	
		
	}

	@Override
	public void showMessage(String value) {
		txtField.setValue(value);
		
	}

	@Override
	public void addListener(TestViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void fillGrid(List<Customer> customerList) {
		
		log.info("Numero de elementos en customerList = " + customerList.size());
		
		
		gridCustomers.setItems(customerList);
		gridCustomers.addColumn(Customer::getId).setCaption("Id");
		gridCustomers.addColumn(Customer::getFirstName).setCaption("FirstName");
		gridCustomers.addColumn(Customer::getLastName).setCaption("LastName");
		
	}
	

}
