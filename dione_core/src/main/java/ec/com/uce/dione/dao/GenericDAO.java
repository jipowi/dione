package ec.com.uce.dione.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ec.com.uce.dione.comun.DioneException;

/**
 * 
 * <b> Permite utilizar un solo DAO para la capa de datos en la aplicación contiene metodos CRUD genericos </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Oct 12, 2014
 * @since JDK1.6
 */
public interface GenericDAO<T, ID extends Serializable> {

	public T findById(ID id);

	public List<T> findAll();

	public List<T> findByNamedQuery(String queryName, Object... params);

	public List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params);

	public T update(T entity) throws DioneException;

	public void delete(T entity) throws DioneException;

	public void delete(ID id) throws DioneException;

	public void persist(T entity) throws DioneException;

}
