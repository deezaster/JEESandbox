package ch.x3m.service;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface Bean01Interface {

	public Long countOrders();

	public List<String> getAllOrders();

	public List<String> findOrdersByTitle(String title);

}
