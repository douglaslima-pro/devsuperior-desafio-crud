package edu.douglaslima.desafiocrud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * This interface is a generic type that contains essential operations for a persisted entity.
 * </p>
 * <p>
 * Implementations of {@code EntityService} must override its methods so it can implement the logic of CRUD operations.
 * </p>
 * <p>
 * <strong>Note:</strong> The {@code EntityService} interface is a generic type that holds the DTO (Data Transfer Object) and the entity's ID type information so its methods should receive and return data of the same type.
 * </p>
 * 
 * @author Douglas Lima
 *
 * @param <T> The DTO type
 * @param <ID> The entity's ID type
 */
public interface EntityService<T, ID> {
	
	T insert(T t);
	
	T findById(ID id);
	
	Page<T> findAll(Pageable pageable);
	
	T update(ID id, T t);
	
	void delete(ID id);

}
