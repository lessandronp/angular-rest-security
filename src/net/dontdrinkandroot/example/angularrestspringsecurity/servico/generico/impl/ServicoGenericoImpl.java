package net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.DaoGenerico;
import net.dontdrinkandroot.example.angularrestspringsecurity.exceptions.UniqueKeyException;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico.ServicoGenerico;

/**
 * 
 * @author Lessandro
 */
@Service
public abstract class ServicoGenericoImpl<T, ID extends Serializable> implements
	ServicoGenerico<T, ID>, Serializable {

    private static final long serialVersionUID = 3894526035597481019L;
    protected DaoGenerico<T, ID> genericDAO;
    private static Log log = LogFactory.getLog(ServicoGenericoImpl.class);
    

    @Override
    public void setGenericDAO(DaoGenerico<T, ID> genericDAO) {
	this.genericDAO = genericDAO;
    }

    public ServicoGenericoImpl() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) throws Exception {
	try {
	    genericDAO.delete(entity);
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    throw new Exception(ex.getMessage());
	}
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T buscaPorId(ID id) {
	try {
	    return (T) genericDAO.findById(id);
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	}
	return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> buscaTodos() {
	try {
	    return genericDAO.findAll();
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	}
	return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T buscaPorCriterio(Criterion... criterion) {
	try {
	    return genericDAO.findByCriterion(criterion);
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	}
	return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T salva(T entity) throws UniqueKeyException, Exception {
	try {
	    genericDAO.save(entity);
	    return entity;
	} catch (UniqueKeyException e) {
	    log.error(e.getMessage());
	    throw new UniqueKeyException(e.getMessage());
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    throw new Exception(ex.getMessage());
	}
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<T> salva(List<T> entities) throws UniqueKeyException, Exception {
	try {
	    for (T entity : entities) {
		genericDAO.save(entity);
	    }
	} catch (UniqueKeyException e) {
	    log.error(e.getMessage());
	    throw new UniqueKeyException(e.getMessage());
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    throw new Exception(ex.getMessage());
	}
	return entities;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T atualiza(T entity) throws UniqueKeyException, Exception {
	try {
	    genericDAO.update(entity);
	    return entity;
	} catch (UniqueKeyException e) {
	    log.error(e.getMessage());
	    throw new UniqueKeyException(e.getMessage());
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    throw new Exception(ex.getMessage());
	}
    }
    
    @Override
    public T atualizaObjeto(T entity) {
	try {
	    genericDAO.refresh(entity);
	} catch (Exception e) {
	    log.error(e.getMessage());
	}
	return entity;
    }

}
