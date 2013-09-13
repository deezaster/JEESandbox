package ch.x3m.service;

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
public class TestBean implements TestBeanInterface {

	@EJB
	OrderService srvc;

	/**
	 * Default constructor.
	 */
	public TestBean() {

	}

	@Override
	public Long countOrders() {
		List<Order> orders = srvc.findByTitle("def");
		for (Order o : orders) {
			System.out.println("Order: " + o.getTitle());
		}

		for (Order o : srvc.getAllOrders()) {
			System.out.println("All Order:" + o.getOrdernr() + " - " + o.getTitle());
		}
		return srvc.countOrders();
	}

}
