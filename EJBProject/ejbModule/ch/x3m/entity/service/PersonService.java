package ch.x3m.entity.service;

import java.util.List;
import javax.ejb.Stateless;
import ch.x3m.entity.Person;
import ch.x3m.persistence.JPAPersistenceService;

@Stateless
public class PersonService extends JPAPersistenceService<String, Person> {

	public Long countOrders() {
		return getTotalResult(Person.TOTAL_RESULT);
	}

	public List<Person> selectAll() {
		return findAll(Person.GET_ALL);
	}
}
