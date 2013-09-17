package ch.x3m.service;

import static org.junit.Assert.assertEquals;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBean01 {

	private static EJBContainer ejbContainer;
	private static Context ctx;

	@BeforeClass
	public static void setUpClass() throws Exception {

		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		ejbContainer.close();
	}

	@Test
	public void test() throws NamingException {
		Bean01Interface bean = (Bean01Interface) ctx.lookup("java:global/classes/Bean01");
		long cnt = bean.countOrders().longValue();
		assertEquals(3, cnt);
	}

}
