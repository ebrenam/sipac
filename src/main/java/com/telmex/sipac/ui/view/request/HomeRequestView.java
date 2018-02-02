package com.telmex.sipac.ui.view.request;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;

@SpringComponent
public class HomeRequestView extends HomeRequest implements HomeRequestEvents, View {
	
	private static final Logger log = LoggerFactory.getLogger(HomeRequestView.class);

	@Autowired
	NewRequestView newRequestView;	
	@Autowired
	SearchRequestView searchRequestView;	
	@Autowired
	TemplateRequestView templateRequestView;

	@PostConstruct
	public void init() {
		log.info("Inicializa layout HomeRequest");
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Método que se ejecuta cuando se accede a la vista
		
		// Cargar vista de búsqueda por default
		SearchRequestView search = new SearchRequestView();
		tbRequestSearch.removeAllComponents();
		tbRequestSearch.addComponent(search);
		
		// Agregar listener para el evento "cambio de opción en tab"
		tsRequestMenu.addSelectedTabChangeListener(e -> tabChangeListener(e));
	}

	private void tabChangeListener(SelectedTabChangeEvent e) {
		// Buscar el tabsheet seleccionado
		TabSheet tabsheet  = e.getTabSheet();
		
		// Buscar el tab (todos son layouts)
		Layout tab = (Layout) tabsheet.getSelectedTab();
		
		// Obtener el tab caption del objeto tab
		String caption = tabsheet.getTab(tab).getCaption().trim();

		if (caption.equals("Búsqueda")) {
			//SearchRequestViewImpl searchRequest = new SearchRequestViewImpl();
			tbRequestSearch.removeAllComponents();
			tbRequestSearch.addComponent(searchRequestView);
		}
		else if (caption.equals("Nueva")) {
			//NewRequestViewImpl newRequest = new NewRequestViewImpl();
			tbRequestNew.removeAllComponents();
			tbRequestNew.addComponent(newRequestView);
		}
		else if (caption.equals("Plantilla")) {
			//TemplateRequestViewImpl templateRequest = new TemplateRequestViewImpl();
			tbRequestTemplate.removeAllComponents();
			tbRequestTemplate.addComponent(templateRequestView);			
		}
	}
}
