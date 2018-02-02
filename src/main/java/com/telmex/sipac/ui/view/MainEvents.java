package com.telmex.sipac.ui.view;

public interface MainEvents {
	// Aquí van los métodos de negocio hacia la interfaz usuario
	// Las operaciones deben tener el prefijo "update"

	/**
	 * Permite asociar la vista con el presenter
	 * @param listener
	 */	
	public void addListener(MainListener listener);

	public void updateGetUserName(String userName);
	//public void updateLastName(String value);
	
}
