package ch.x3m.service;

import javax.ejb.Remote;

@Remote
public interface TestBeanInterface {

	public Long countOrders();

}
