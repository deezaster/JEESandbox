package ch.x3m.persistence;

import java.util.List;

public interface PersistenceService<K, E> {

	E save(E entity);

	E update(E entity);

	void remove(E entity);

	E findById(K id);

	List<E> findAll(String queryName);

	Long getTotalResult(String queryName);

}
