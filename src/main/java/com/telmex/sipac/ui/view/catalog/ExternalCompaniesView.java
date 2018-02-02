package com.telmex.sipac.ui.view.catalog;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.telmex.sipac.ui.view.request.NewRequestView;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SpringComponent
public class ExternalCompaniesView extends ExternalCompanies implements ExternalCompaniesEvents, View {

	private static final Logger log = LoggerFactory.getLogger(NewRequestView.class);
	
	@PostConstruct
	public void init() {
		log.info("Inicializa layout ExternalCompanies");
		
		// Botón cancelar
		btnCancel.addClickListener(e -> closeModalWindow(e));
	}

	private void closeModalWindow(ClickEvent e) {
		log.info("closeWindow ExternalCompanies");
		
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
}
