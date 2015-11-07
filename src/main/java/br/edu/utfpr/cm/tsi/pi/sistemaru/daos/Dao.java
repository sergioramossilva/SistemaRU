package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import java.util.List;

public interface Dao<E, I> {

	public void save(E entity);

	public void delete(E entity);

	public E findById(I id);

	public List<E> getAll();
}