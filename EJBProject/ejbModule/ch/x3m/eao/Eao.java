package ch.x3m.eao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.x3m.entity.Person;

@Stateless
@LocalBean
public class Eao {

	@PersistenceContext
	EntityManager em;

	private static final Logger logger = Logger.getLogger("ch.x3m.eao.Eao");

	/**
	 * Default constructor.
	 */
	public Eao() {
		// TODO Auto-generated constructor stub
	}

	public long countOrders() {

		logger.log(Level.DEBUG, "Here 1");

		Person p = new Person();
		// p.setId("12345678901234567890");
		p.setVorname("Barbara2");
		p.setNachname("Mehr Theiler");
		em.persist(p);

		long result;
		Query q = em.createNamedQuery("qCountOrders");
		// Query q = em.createQuery("select count(o) from Order o");
		result = (Long) q.getSingleResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Person> allPersons() {
		List<Person> result;
		Query q = em.createQuery("select p from Person p");
		result = (List<Person>) q.getResultList();
		return result;
	}

}
