package com.telmex.sipac.presenter;

import com.telmex.sipac.ui.view.MainListener;
import com.telmex.sipac.ui.view.MainView;

public class MainPresenter implements MainListener {

	MainView mainView;
	
	public MainPresenter(MainView view) {
		mainView = view;
		
		view.addListener(this);
	}

	@Override
	public void processGetUserName(String id) {
		// Obtiene la información del usuario a partir del ID
		String userData = "JESUS LOPEZ TABLEROS";
		
		// Enviar la información a la vista
		mainView.updateGetUserName(userData);
	}

}
