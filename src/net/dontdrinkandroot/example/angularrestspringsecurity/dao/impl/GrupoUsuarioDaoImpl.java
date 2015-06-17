package net.dontdrinkandroot.example.angularrestspringsecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.GrupoUsuarioDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.impl.DaoGenericoImpl;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;

@Repository
public class GrupoUsuarioDaoImpl extends DaoGenericoImpl<GrupoUsuario, Long> implements
	GrupoUsuarioDao {

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(GrupoUsuarioDaoImpl.class);

    @PersistenceContext(unitName = "tecnibraPU")
    private EntityManager entityManager;

    @PersistenceUnit(unitName = "tecnibraPU")
    private EntityManagerFactory factory;

    @Override
    public GrupoUsuario buscaPorNome(String name) {
	try {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<GrupoUsuario> query = cb.createQuery(GrupoUsuario.class);
	    Root<GrupoUsuario> root = query.from(GrupoUsuario.class);
	    query.where(cb.equal(cb.lower(root.<String> get("name")), name.toLowerCase()));
	    List<GrupoUsuario> grupoUsuario = entityManager.createQuery(query).getResultList();
	    return !grupoUsuario.isEmpty() ? grupoUsuario.get(0) : null;
	} catch (Exception ex) {
	    log.error(ex);
	} finally {
	}
	return null;
    }

}
