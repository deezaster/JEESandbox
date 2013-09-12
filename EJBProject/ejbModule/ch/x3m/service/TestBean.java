package ch.x3m.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ch.x3m.dto.PersonDTO;
import ch.x3m.eao.Eao;
import ch.x3m.entity.Person;
import ch.x3m.util.Conversion;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@LocalBean
@WebService
public class TestBean implements TestBeanInterface {

	@EJB
	Eao eao;

	@EJB
	Conversion conv;

	/**
	 * Default constructor.
	 */
	public TestBean() {

	}

	@Override
	public long orderCount() {
		return eao.countOrders();
	}

	@Override
	public List<PersonDTO> allPersons() {

		List<PersonDTO> result = new ArrayList<PersonDTO>();
		List<Person> allPersons = eao.allPersons();
		for (Person p : allPersons) {
			PersonDTO pi = conv.fromEntity(p);
			result.add(pi);
		}
		return result;
	}

}
