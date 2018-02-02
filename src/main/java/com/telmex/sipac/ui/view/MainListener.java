package com.telmex.sipac.ui.view;

public interface MainListener {
	// Aquí van los métodos de negocio hacia la capa del modelo
	// Las operaciones deben tener la prefijo "process"
	
	void processGetUserName(String id);
	//void processDataUser(String value);
	//void processUserAvailability(String value);
	//void processQueryUser();
	//void processDeleteUser();
	//void processUpdateUser();	
}
