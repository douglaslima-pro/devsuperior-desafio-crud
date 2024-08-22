package edu.douglaslima.desafiocrud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Essential operations for an entity service implementation.
 * @author Douglas Lima
 *
 * @param <T> The entity type
 * @param <ID> The entity's ID type
 */
public interface EntityService<T, ID> {
	
	T insert(T t);
	
	T findById(ID id);
	
	Page<T> findAll(Pageable pageable);
	
	T update(ID id, T t);
	
	void delete(ID id);

}
