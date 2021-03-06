package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class JpaDao<E, I> implements Dao<E, I> {

	private static final long serialVersionUID = 1L;

	private static final String UNIT_NAME = "SistemaRU";

	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager manager;
	private Class<E> entityClass;

	@Override
	public void save(E entity) {

		try {
			
			Field chave = entity.getClass().getDeclaredField("id");
			chave.setAccessible(true);
			Object valorChave = chave.get(entity);
			
			if (valorChave == null) {
				manager.persist(entity);
			} else {
				manager.merge(entity);
			}

		} catch (Exception ex) {

			ex.getMessage();
		}
	}

	@Override
	public void delete(E entity) {
		manager.remove(manager.merge(entity));
	}

	@Override
	public E findById(I id) {
		return manager.find(entityClass, id);
	}

	@Override
	public List<E> getAll() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<E> query = builder.createQuery(entityClass);
		query.select(query.from(entityClass));
		TypedQuery<E> typedQuery = manager.createQuery(query);
		return typedQuery.getResultList();
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
}