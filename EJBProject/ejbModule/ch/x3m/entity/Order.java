package ch.x3m.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the 'orders' database table.
 * 
 */
@NamedNativeQuery(name = "qCountOrders", query = "select count(*) As Cnt from orders")
@NamedQueries({
		@NamedQuery(name = Order.TOTAL_RESULT, query = "select count(o) from Order o"),
		@NamedQuery(name = Order.FIND_BY_ORDERNR, query = "select o from Order o where o.ordernr = :ordernr")
})
@Entity
@Table(name = "orders")
public class Order extends ch.x3m.entity.Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Names of named queries
	 */
	public static final String GET_ALL = "Order.getAll";
	public static final String TOTAL_RESULT = "Order.totalResult";
	public static final String FIND_BY_ORDERNR = "Order.findByOrderNr";

	/*
	 * Entity fields
	 */
	private String ordernr;
	private String title;

	/*
	 * Associations
	 */
	// bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	/**
	 * Constructor
	 */
	public Order() {
	}

	public String getOrdernr() {
		return this.ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}