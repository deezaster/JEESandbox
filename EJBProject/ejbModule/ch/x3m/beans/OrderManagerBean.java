package ch.x3m.beans;

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
public class OrderManagerBean implements OrderManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	OrderService srvc;

	/**
	 * Default constructor.
	 */
	public OrderManagerBean() {

	}

	@Override
	public Long countOrders() {

		return srvc.countOrders();
	}

	@Override
	public List<String> getAllOrders() {

		List<String> orders = new ArrayList<>();
		for (Order o : srvc.getAllOrders()) {
			System.out.println("All Orders:" + o.getOrdernr() + " - " + o.getTitle());
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
