package net.dontdrinkandroot.example.angularrestspringsecurity.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.ProfileDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.impl.DaoGenericoImpl;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;

@Repository
public class ProfileDaoImpl extends DaoGenericoImpl<GrupoUsuario, Long>
	implements ProfileDao {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "tecnibraPU")
    private EntityManager entityManager;

    @PersistenceUnit(unitName = "tecnibraPU")
    private EntityManagerFactory factory;

    @Override
    public GrupoUsuario findByName(String name) {
	try {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<GrupoUsuario> query = cb
		    .createQuery(GrupoUsuario.class);
	    Root<GrupoUsuario> root = query.from(GrupoUsuario.class);
	    query.where(cb.equal(cb.lower(root.<String> get("name")),
		    name.toLowerCase()));
	    return entityManager.createQuery(query).getSingleResult();
	} catch (Exception ex) {
	    return null;
	} finally {
	}
    }
}
