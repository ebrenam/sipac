package com.telmex.sipac.presenter;

import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.telmex.sipac.backend.TestModel;
import com.telmex.sipac.backend.TestModelImpl;
import com.telmex.sipac.backend.data.entity.Customer;
import com.telmex.sipac.ui.view.TestView;

public class TestPresenter implements TestView.TestViewListener, Serializable {
	
	TestModel model;
	TestView view;
		
	private static final Logger log = LoggerFactory.getLogger(TestPresenter.class);

	public TestPresenter(TestModelImpl model, TestView view) {
		
		this.model = model;
		this.view = view;
		
		//Se registre al presenter para atender los mensajes de la Vista.
		view.addListener(this);
	}

	@Override
	public void buttonClick(String value) {
		
		//Se utiliza el modelo para generar una respuesta.
		if (value.length()>0) 
			model.setUserName(value);
		
		String successResponse = model.generateSuccessMessage();
		
		//Se indica a la vista que muestre el resultado.
		List<Customer> customers = model.getCustomers();
		view.fillGrid(customers);
		view.showMessage(successResponse);
		
	}

	
}
