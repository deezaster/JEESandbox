package ch.x3m.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
public class Person extends ch.x3m.entity.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nachname;

	private String vorname;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "person")
	private Set<Order> orders;

	public Person() {
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setPerson(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setPerson(null);

		return order;
	}

}