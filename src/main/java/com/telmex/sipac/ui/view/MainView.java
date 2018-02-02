package com.telmex.sipac.ui.view;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
public class MainView extends Main implements MainEvents {

	/* Solo el presenter registrara 1 listener... */
	List<MainListener> listeners = new ArrayList<MainListener>();
	
	private static final Logger log = LoggerFactory.getLogger(MainView.class);
	private String normalStyle = "quiet tiny";
	private String primaryStyle = "primary tiny";
	
	@PostConstruct
	public void init() {	
		log.info("Inicializa layout Main");
				
		// Definir listeners para los botones
		btnDashboard.addClickListener(e -> loadDashboardLayout(e));
		btnRequest.addClickListener(e -> loadRequestLayout(e));
		btnExitPass.addClickListener(e -> loadExitPassLayout(e));
		btnComplain.addClickListener(e -> loadComplainLayout(e));
		btnDangerousWork.addClickListener(e -> loadDangerousWorkLayout(e));			
	}
	
	private void loadDashboardLayout(ClickEvent e) {
		UI.getCurrent().getNavigator().navigateTo("dashboard");
		setDefaultThemeToButtons();
		btnDashboard.setStyleName(primaryStyle);
	}

	private void loadRequestLayout(ClickEvent e) {
		UI.getCurrent().getNavigator().navigateTo("request");
		setDefaultThemeToButtons();
		btnRequest.setStyleName(primaryStyle);
	}

	private void loadExitPassLayout(ClickEvent e) {
		UI.getCurrent().getNavigator().navigateTo("exitPass");
		setDefaultThemeToButtons();
		btnExitPass.setStyleName(primaryStyle);
	}

	private void loadComplainLayout(ClickEvent e) {
		UI.getCurrent().getNavigator().navigateTo("complain");
		setDefaultThemeToButtons();
		btnComplain.setStyleName(primaryStyle);
	}

	private void loadDangerousWorkLayout(ClickEvent e) {
		UI.getCurrent().getNavigator().navigateTo("dangerousWork");
		setDefaultThemeToButtons();
		btnDangerousWork.setStyleName(primaryStyle);		
	}

	/**
	 * Obtiene el objeto content que es el layout donde se muestran las pantallas del sistema 
	 */
	public VerticalLayout getContent() {
		return content;
	}
	
	private void setDefaultThemeToButtons() {
		btnDashboard.setStyleName(normalStyle);
		btnRequest.setStyleName(normalStyle);
		btnExitPass.setStyleName(normalStyle);
		btnComplain.setStyleName(normalStyle);
		btnDangerousWork.setStyleName(normalStyle);
	}

	
	
	/**
	 * Se lanza la petición para que sea ejecutada por el Presenter
	 */
	public void sendMessageToSubscribers(){
		log.info("sendMessageToSubscribers");
		
		// Se simula el valor a enviar
		String id = "000001";
		
		for (MainListener listener : listeners)
			listener.processGetUserName(id);
	}
	
	@Override
	public void addListener(MainListener listener) {
		listeners.add(listener);		
	}

	@Override
	public void updateGetUserName(String userName) {
		// Asignar el nombre del usuario		
		lblUserName.setValue(userName);
	}

}
