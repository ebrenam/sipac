package com.telmex.sipac.ui.view.dangerWork;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class DangerousWorkView extends DangerousWork implements DangerousWorkEvents, View {
	
	private static final Logger log = LoggerFactory.getLogger(DangerousWorkView.class);
	
	@PostConstruct
	public void init() {
		log.info("Inicializa layout DangerousWork");
	}
	
}
