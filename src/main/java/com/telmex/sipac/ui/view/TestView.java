package com.telmex.sipac.ui.view;

import java.util.List;
import com.telmex.sipac.backend.data.entity.Customer;

public interface TestView {

	public void showMessage(String value);
	public void fillGrid(List<Customer> customerList);

	interface TestViewListener {
		void buttonClick(String btnCaption);
	}

	public void addListener(TestViewListener listener);

}
