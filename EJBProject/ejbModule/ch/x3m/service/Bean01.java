package ch.x3m.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ch.x3m.entity.Order;
import ch.x3m.entity.service.OrderService;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@LocalBean
@WebService
public class Bean01 implements Bean01Interface {

	@EJB
	OrderService srvc;

	/**
	 * Default constructor.
	 */
	public Bean01() {

	}

	@Override
	public Long countOrders() {

		return srvc.countOrders();
	}

	@Override
	public List<String> getAllOrders() {

		List<String> orders = new ArrayList<>();
		for (Order o : srvc.getAllOrders()) {
			System.out.println("All Order:" + o.getOrdernr() + " - " + o.getTitle());
			orders.add("Nr: " + o.getOrdernr() + " / Title: " + o.getTitle());
		}
		return orders;
	}

	@Override
	public List<String> findOrdersByTitle(String title) {

		List<String> orders = new ArrayList<>();

		List<Order> rows = srvc.findByTitle(title);
		for (Order o : rows) {
			System.out.println("Order: " + o.getTitle());
			orders.add("Nr: " + o.getOrdernr() + " / Title: " + o.getTitle());
		}
		return orders;
	}

}
