package com.telmex.sipac.ui.view.catalog;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telmex.sipac.ui.view.request.NewRequestView;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SpringComponent
public class EmployeesView extends Employees implements EmployeesEvents, View {

	@Autowired
	ExternalCompaniesView extenalCompanyCatalogView;	

	private static final Logger log = LoggerFactory.getLogger(NewRequestView.class);
	
	@PostConstruct
	public void init() {
		log.info("Inicializa layout Employees");
		
		// Botón cancelar
		btnCancel.addClickListener(e -> closeModalWindow(e));

		// Botón buscar empresa
		btnSearchExternalCompany.addClickListener(e -> searchExternalCompany(e));
	}

	private void closeModalWindow(ClickEvent e) {
		log.info("closeWindow Employees");
		
		// Validar si es la forma ideal de cerrar la ventana
		Integer max = getUI().getWindows().size();
		Integer contador = 0;
		for (Window window : UI.getCurrent().getWindows())
        {
			contador++;
			
			if (contador == max) {
				UI.getCurrent().removeWindow(window);
				window.close();
			}
        }
	}
	
	private void searchExternalCompany(ClickEvent e) {
		log.info("searchExternalCompany");
		
		//txtCompany.focus();
		
		Window modalWindow = new Window("Buscar empresas externas");
		modalWindow.setWidth("800px");
		modalWindow.setHeight("500px");
		modalWindow.setModal(true);
		modalWindow.setResizable(false);
                
		// Se asigna el layout de catálogo de compañias externas
        modalWindow.setContent(extenalCompanyCatalogView);
        
        // Validar si esta es la forma adecuada de mostrar la ventana       
        UI.getCurrent().addWindow(modalWindow);
        //this.getUI().getUI().addWindow(modalWindow);
	}

}
