package net.dontdrinkandroot.example.angularrestspringsecurity.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.NewsEntryDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.impl.DaoGenericoImpl;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.NewsEntry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class NewsEntryDaoImpl extends DaoGenericoImpl<NewsEntry, Long> implements NewsEntryDao {

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(NewsEntryDaoImpl.class);

    @PersistenceContext(unitName = "tecnibraPU")
    private EntityManager entityManager;

    @PersistenceUnit(unitName = "tecnibraPU")
    private EntityManagerFactory factory;

}
