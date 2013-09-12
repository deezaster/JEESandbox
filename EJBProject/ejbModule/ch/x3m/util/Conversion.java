package ch.x3m.util;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ch.x3m.dto.PersonDTO;
import ch.x3m.eao.Eao;
import ch.x3m.entity.Order;
import ch.x3m.entity.Person;

/**
 * Session Bean implementation class Conversion
 */
@Stateless
public class Conversion {

	@EJB
	Eao eao;

	public Conversion() {
	}

	public PersonDTO fromEntity(Person p) {

		PersonDTO result = new PersonDTO();
		result.setNachname(p.getNachname());
		result.setVorname(p.getVorname());
		result.setId(p.getId());
		List<String> orders = new ArrayList<String>();
		for (Order order : p.getOrders()) {
			orders.add(order.getTitle());
		}
		result.setOrders(orders);
		return result;
	}

}
