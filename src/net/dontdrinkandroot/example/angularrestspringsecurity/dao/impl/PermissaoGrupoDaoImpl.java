package net.dontdrinkandroot.example.angularrestspringsecurity.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.PermissaoGrupoDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.impl.DaoGenericoImpl;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.PermissaoGrupo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PermissaoGrupoDaoImpl extends DaoGenericoImpl<PermissaoGrupo, Long> implements
	PermissaoGrupoDao {

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(PermissaoGrupoDaoImpl.class);

    @PersistenceContext(unitName = "tecnibraPU")
    private EntityManager entityManager;

    @PersistenceUnit(unitName = "tecnibraPU")
    private EntityManagerFactory factory;


}
