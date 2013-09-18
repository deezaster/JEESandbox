package ch.x3m.service;

import static org.junit.Assert.assertEquals;
import java.util.List;
import javax.naming.InitialContext;
import org.junit.Before;
import org.junit.Test;
import ch.x3m.beans.OrderManager;

public class TestBean01 {

	private OrderManager serviceBean;

	@Before
	public void setUp() throws Exception {

		//		serviceBean =
		//				(OrderManager) new InitialContext(Util.getInitProperties())
		//						.lookup("java:global/EARApp/EJBProject/OrderManagerBean"
		//								+ "!ch.x3m.beans.OrderManager");

		serviceBean =
				(OrderManager) new InitialContext()
						.lookup("java:global/EARApp/EJBProject/OrderManagerBean"
								+ "!ch.x3m.beans.OrderManager");

	}

	@Test
	public void countOrders() {
		long cnt = serviceBean.countOrders().longValue();
		assertEquals("count Orders", 2, cnt);
	}

	@Test
	public void getAllOrders() {
		List<String> orders = serviceBean.getAllOrders();
		assertEquals("get all Orders", 1, orders.size());
	}

}
