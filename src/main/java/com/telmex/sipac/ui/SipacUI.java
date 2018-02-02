package com.telmex.sipac.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.telmex.sipac.presenter.MainPresenter;
import com.telmex.sipac.ui.view.MainView;
import com.telmex.sipac.ui.view.complain.ComplainView;
import com.telmex.sipac.ui.view.dangerWork.DangerousWorkView;
import com.telmex.sipac.ui.view.dashboard.DashboardView;
import com.telmex.sipac.ui.view.exitPass.ExitPassView;
import com.telmex.sipac.ui.view.request.HomeRequestView;
import com.telmex.sipac.ui.view.request.NewRequestView;
import com.telmex.sipac.ui.view.request.SearchRequestView;
import com.telmex.sipac.ui.view.request.TemplateRequestView;
import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Viewport("width=device-width, initial-scale=1.0,user-scalable=no")
public class SipacUI extends UI {

	@Autowired
	MainView mainView;
	@Autowired
	DashboardView dashboardView;
	@Autowired
	HomeRequestView homeRequestView;
	@Autowired
	ExitPassView exitPassView;
	@Autowired
	ComplainView complainView;
	@Autowired
	DangerousWorkView dangerousWorkView;	
	
	private VerticalLayout root;

	private Navigator navigator;

	public Navigator getNavigator() {
		return this.navigator;
	}

	@Override
	protected void init(VaadinRequest request) {
		// Este es el punto de entrada a la aplicación. 
		// Permite hacer un mapeo uno a uno con el browser

		// Se dividen las actividades a realizar
		setupLayout();
		addMainView();

		// Limpiar botones al inicio
		//setDefaultThemeToButtons();

		// Se inicializa el Presenter para MainView
		new MainPresenter(mainView);
		mainView.sendMessageToSubscribers();
	}

	private void setupLayout() {
		// Se define el layout más simple y que servirá de base
		root = new VerticalLayout();

		// Se define el contenido de nuestro UI, es decir, define el contenido del
		// browser al layout pricipal
		// La ventana del navegador puede contener solo un componente
		root.setSizeFull();
		root.setMargin(false);
		root.setSpacing(false);

		setContent(root);
	}

	private void addMainView() {
		// Agrega la vista/layout a la forma principal
		root.addComponent(mainView);

		// Se define la navegación del sitio
		// final Navigator navigator = new Navigator(this, mainView.getContent());
		navigator = new Navigator(this, mainView.getContent());
		navigator.addView("dashboard", dashboardView);
		navigator.addView("request", homeRequestView);
		navigator.addView("exitPass", exitPassView);
		navigator.addView("complain", complainView);
		navigator.addView("dangerousWork", dangerousWorkView);
		navigator.addView("", dashboardView);
	}

	private void setDefaultThemeToButtons() {
		// Falta validar cómo acceder a los controles
		/*btnHome.setStyleName("quiet small");
		btnRequest.setStyleName("quiet small");
		btnExitPass.setStyleName("quiet small");
		btnComplain.setStyleName("quiet small");
		btnDangerWork.setStyleName("quiet small");*/
	}

}
