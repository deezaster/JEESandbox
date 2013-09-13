package ch.x3m.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ch.x3m.entity.Entity;

public abstract class JPAPersistenceService<K, E extends Entity> implements PersistenceService<K, E> {

	protected Class<E> entityClass;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}

	@Override
	public E save(final E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(final E entity) {
		return em.merge(entity);
	}

	@Override
	public void remove(final E entity) {
		em.remove(em.merge(entity));
	}

	@Override
	public E findById(final K id) {
		return em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll(String queryName) {
		return em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public Long getTotalResult(String queryName) {
		return (Long) em.createNamedQuery(queryName).getSingleResult();
	}

}