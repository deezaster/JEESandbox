package ch.x3m.service;

import java.util.List;
import javax.ejb.Remote;
import ch.x3m.dto.PersonDTO;

@Remote
public interface TestBeanInterface {

	public long orderCount();

	public List<PersonDTO> allPersons();
}
