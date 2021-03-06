package br.edu.utfpr.cm.tsi.pi.sistemaru.daos;

import java.io.Serializable;
import java.util.List;

public interface Dao<E, I> extends Serializable {

	public void save(E entity);

	public void delete(E entity);

	public E findById(I id);

	public List<E> getAll();
}