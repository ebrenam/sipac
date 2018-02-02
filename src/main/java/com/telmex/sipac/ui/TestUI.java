package com.telmex.sipac.ui;

import com.telmex.sipac.backend.TestModelImpl;
import com.telmex.sipac.presenter.TestPresenter;
import com.telmex.sipac.ui.view.TestViewImpl;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringUI
public class TestUI extends UI {
	
	//private final CustomerRepository repo;

	@Autowired
	TestModelImpl testModel;
	@Autowired
	TestViewImpl  testView;
		
	@Override
	public void init(VaadinRequest request) {
		
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		new TestPresenter(testModel, testView);

		// The view implementation is a Vaadin component
		layout.addComponent(testView);
	}
	

}
