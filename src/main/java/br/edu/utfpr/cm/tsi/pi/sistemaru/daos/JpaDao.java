package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class JpaDao<T, I> {

	@PersistenceContext
	protected EntityManager manager;
	private final Class<T> entityClass;

	public JpaDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T objeto) {

		try {

			Field chave = objeto.getClass().getDeclaredField("id");
			chave.setAccessible(true);
			Object valorChave = chave.get(objeto);

			if (valorChave == null) {

				manager.persist(objeto);
			} else {

				manager.merge(objeto);
			}
		} catch (Exception ex) {

			ex.getMessage();
		}
	}

	public void delete(T objeto) {

		manager.remove(manager.merge(objeto));
	}

	public T findById(I id) {

		return manager.find(entityClass, id);
	}

	public List<T> getAll() {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);
		query.select(root);
		TypedQuery<T> typedQuery = manager.createQuery(query);
		return typedQuery.getResultList();

	}
}