/**
 * 
 */
package ec.com.uce.dione.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.DocenteDocumentoDao;
import ec.com.uce.dione.entities.DocumentoDocente;

/**
 * <b> Implementacion de la interfaz para realizar operaciones sobre la tabla Cumplimiento. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,29/12/2014
 * @since JDK1.6
 */
@Stateless
public class DocenteDocumentoDaoImpl extends GenericDAOImpl<DocumentoDocente, Integer> implements DocenteDocumentoDao {

	Logger log = Logger.getLogger(DocenteDocumentoDaoImpl.class);

	@PersistenceContext(unitName = "dione_core")
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.uce.dione.dao.DocenteDocumentoDao#consultarDocumentos(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoDocente> consultarDocumentos(Integer idDocente) throws DioneException {
		try {
			Query query = em.createNamedQuery("DocumentoDocente.findByDocente");
			query.setParameter("idDocente", idDocente);
			List<DocumentoDocente> documentos = query.getResultList();

			return documentos;

		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> consultarDocumentos", ex);
			throw new DioneException(ex);
		}
	}

}
