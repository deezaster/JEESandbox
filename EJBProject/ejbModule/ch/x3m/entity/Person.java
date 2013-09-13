package ch.x3m.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the 'person' database table.
 * 
 */
@NamedQueries({
		@NamedQuery(name = Person.GET_ALL, query = "select p from Person p"),
		@NamedQuery(name = Person.TOTAL_RESULT, query = "select count(p) from Person p")
})
@Entity
public class Person extends ch.x3m.entity.Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Names of named queries
	 */
	public static final String GET_ALL = "Person.findAll";
	public static final String TOTAL_RESULT = "Person.totalResult";

	/*
	 * Entity fields
	 */
	private String nachname;
	private String vorname;

	/*
	 * Associations
	 */
	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "person")
	private Set<Order> orders;

	/**
	 * Constructor
	 */
	public Person() {
	}

	/**
	 * 
	 * @return Nachname
	 */
	public String getNachname() {
		return this.nachname;
	}

	/**
	 * 
	 * @param nachname
	 *           Nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * 
	 * @return Vorname
	 */
	public String getVorname() {
		return this.vorname;
	}

	/**
	 * 
	 * @param vorname
	 *           Vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * 
	 * @return Orders
	 */
	public Set<Order> getOrders() {
		return this.orders;
	}

	/**
	 * 
	 * @param orders
	 *           Orders
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	/**
	 * Adds an Order
	 * 
	 * @param order
	 *           Order
	 * @return Order
	 */
	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setPerson(this);

		return order;
	}

	/**
	 * Removes an Order
	 * 
	 * @param order
	 *           Order
	 * @return Order
	 */
	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setPerson(null);

		return order;
	}

}