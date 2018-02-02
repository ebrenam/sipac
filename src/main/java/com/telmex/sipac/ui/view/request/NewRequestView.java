package com.telmex.sipac.ui.view.request;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.telmex.sipac.backend.data.entity.Request;
import com.telmex.sipac.ui.view.catalog.ActivitiesView;
import com.telmex.sipac.ui.view.catalog.BuildingsView;
import com.telmex.sipac.ui.view.catalog.EmployeesView;
import com.vaadin.data.Binder;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

@SpringComponent
public class NewRequestView extends NewRequest implements NewRequestEvents, View {

	@Autowired
	ActivitiesView activitiesView;	
	@Autowired
	BuildingsView buildingsView;
	@Autowired
	EmployeesView employeesView;
	
	private static final Logger log = LoggerFactory.getLogger(NewRequestView.class);
	private Notification alertMessage;
	private Window modalWindow;
	
	// Binder para validaciones 
	private Binder<Request> binder = new Binder<Request>();
	
	@PostConstruct
	public void init() {
		log.info("Inicializa layout NewRequest");
		
		// Se agregan validadares a la forma		
		addValidators();		
		
		// Botón continuar
		btnContinue.addClickListener(e -> validateForm(e));
		
		// Botón agregar actividades
		btnAddActivities.addClickListener(e -> addActivities(e));
		
		// Botón agregar edificios
		btnAddBuildings.addClickListener(e -> addBuildings(e));

		// Botón agregar empleados
		btnAddEmployees.addClickListener(e -> addEmployees(e));
	}

	private void addValidators() {
		// https://vaadin.com/docs/framework/datamodel/datamodel-forms.html

		// ------------------------------------------------------------------------
		// Validadores para la sección Datos Personales
		// ------------------------------------------------------------------------
		binder.forField(txtWorkDescription)
        .asRequired("El campo es requerido")
        // .withValidator(workDescription -> workDescription.length() > 0, "El campo debe tener al menos x longitud")
        .bind(Request::getWorkDescription, Request::setWorkDescription);

		binder.forField(txtStartDate)
		.asRequired("El campo es requerido")
		.bind(Request::getStartDateTime, Request::setStartDateTime);

		binder.forField(txtEndDate)
		.asRequired("El campo es requerido")
		.bind(Request::getEndDateTime, Request::setEndDateTime);

		// ------------------------------------------------------------------------		
		// Validadores para la sección Lugar
		// ------------------------------------------------------------------------
		// Se debe incluir los datos del grid		
	}
	
	private void addActivities(ClickEvent e) {
		log.info("addActivities");
		
		modalWindow = new Window("Consulta de actividades");
		modalWindow.setWidth("850px");
		modalWindow.setHeight("570px");
		modalWindow.setModal(true);
		modalWindow.setResizable(false);
                
		// Se asigna el layout de catálogo de actividades
        modalWindow.setContent(activitiesView);
        
        // Validar si esta es la forma adecuada de mostrar la ventana       
        UI.getCurrent().addWindow(modalWindow);
        //this.getUI().getUI().addWindow(modalWindow);
        
        // Si desea cerrar la ventana cuando se pierde el foco de la misma, se implementan las siguientes lineas
        //modalWindow.focus();
        //modalWindow.addBlurListener(eb -> blurEvent(eb));
	}
	
	//private void blurEvent(BlurEvent eb) {
	//	modalWindow.close();
	//}

	private void addBuildings(ClickEvent e) {
		log.info("addBuildings");
		
		if (txtAreaOrPlace.isEmpty()) {
			// Mostrar el mensaje de alerta
			alertMessage = new Notification(
		    "Importante",
		    "Favor proporcione un lugar o área para iniciar la búsqueda.",
		    Notification.Type.WARNING_MESSAGE);
		
			txtAreaOrPlace.focus();
			alertMessage.show(Page.getCurrent());	
		} else
		{
			//Se obtiene el valor de búsqueda y se elimina de la caja de texto
			String searchValue = txtAreaOrPlace.getValue();
			txtAreaOrPlace.setValue("");
			
			modalWindow = new Window("Consulta de edificios");
			modalWindow.setWidth("850px");
			modalWindow.setHeight("570px");
			modalWindow.setModal(true);
			modalWindow.setResizable(false);
			
			// Se asigna el layout de catálogo de edificios
	        modalWindow.setContent(buildingsView);
	        
	        // Validar si esta es la forma adecuada de mostrar la ventana       
	        UI.getCurrent().addWindow(modalWindow);
	        //this.getUI().getUI().addWindow(modalWindow);
		}		
	}
	
	private void addEmployees(ClickEvent e) {
		log.info("addEmployees");
		
		modalWindow = new Window("Consulta de empleados");
		modalWindow.setWidth("850px");
		modalWindow.setHeight("570px");
		modalWindow.setModal(true);
		modalWindow.setResizable(false);
                
		// Se asigna el layout de catálogo de empleados
        modalWindow.setContent(employeesView);
        
        // Validar si esta es la forma adecuada de mostrar la ventana       
        UI.getCurrent().addWindow(modalWindow);
        //this.getUI().getUI().addWindow(modalWindow);
	}
		
	private void validateForm(ClickEvent e) {
		log.info("validateForm");

		// Iniciar la validación de los campos de la forma
		binder.validate();

		log.info(txtWorkDescription.getValue());
		//log.info(startDate.getValue());
		
		log.info("después de validateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		
 
		
		// Crear notificación con parámetros por defecto
		/*alertMessage = new Notification(
			    "Campos requeridos",
			    "Favor de llevar todos los campos requeridos.",
			    Notification.Type.WARNING_MESSAGE);
		
		*/
		// Definir característiscas del mensaje
		//alertMessage.setDelayMsec(20000);
		//alertMessage.setPosition(Position.BOTTOM_RIGHT);
		//alertMessage.setStyleName("mystyle");
		//alertMessage.setIcon(new ThemeResource("img/reindeer.png"));
		
		// Mostrar el mensaje
		//alertMessage.show(Page.getCurrent());		
	}

}
