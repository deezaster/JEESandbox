package ch.x3m.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface OrderManager extends Serializable {

	public Long countOrders();

	public List<String> getAllOrders();

	public List<String> findOrdersByTitle(String title);

}
