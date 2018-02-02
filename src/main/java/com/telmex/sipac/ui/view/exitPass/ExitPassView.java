package com.telmex.sipac.ui.view.exitPass;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class ExitPassView extends ExitPass implements ExitPassEvents, View {

	private static final Logger log = LoggerFactory.getLogger(ExitPassView.class);
	
	@PostConstruct
	public void init() {
		log.info("Inicializa layout ExitPass");
	}
	
}
