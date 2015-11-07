package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaDao<E, I> implements Dao<E, I> {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;
	private Class<E> entityClass;

	@Override
	public void save(E entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public E findById(I id) {

		return manager.find(this.getEntityClass(), id);
	}

	@Override
	public List<E> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManager getManager() {
		return manager;
	}

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

}