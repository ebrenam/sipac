package com.telmex.sipac.ui.view.request;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class SearchRequestView extends SearchRequest implements SearchRequestEvents, View {

	private static final Logger log = LoggerFactory.getLogger(SearchRequestView.class);
			
	@PostConstruct
	public void init() {
		log.info("Inicializa layout SearchRequest");
	}

}
