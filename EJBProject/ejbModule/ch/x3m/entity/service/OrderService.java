package ch.x3m.entity.service;

import java.util.List;
import javax.ejb.Stateless;
import ch.x3m.entity.Order;
import ch.x3m.persistence.JPAPersistenceService;

@Stateless
public class OrderService extends JPAPersistenceService<String, Order> {

	@SuppressWarnings("unchecked")
	public List<Order> findByTitle(String ordernr) {
		return em.createNamedQuery(Order.FIND_BY_ORDERNR).setParameter("ordernr", ordernr).getResultList();
	}

	public Long countOrders() {
		return getTotalResult(Order.TOTAL_RESULT);
	}

	public List<Order> getAllOrders() {
		return findAll(Order.GET_ALL);
	}

}
