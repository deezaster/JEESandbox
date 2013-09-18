package com.example.vaadin7;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import ch.x3m.beans.OrderManager;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadin7")
public class Vaadin7UI extends UI {

	private OrderManager bean;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Vaadin7UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		try {
			bean =
					(OrderManager) new InitialContext()
							.lookup("java:global/EARApp/EJBProject/OrderManagerBean"
									+ "!ch.x3m.beans.OrderManager");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Count Orders");
		button.addClickListener(new Button.ClickListener() {

			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label(+bean.countOrders() + " Orders found"));
			}
		});
		layout.addComponent(button);
	}

}