package ch.x3m.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * The persistent class for the orders database table.
 * 
 */
@NamedNativeQuery(name = "qCountOrders", query = "select count(*) As Cnt from orders")
@Entity
@Table(name = "orders")
public class Order extends ch.x3m.entity.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ordernr;

	private String title;

	// bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

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