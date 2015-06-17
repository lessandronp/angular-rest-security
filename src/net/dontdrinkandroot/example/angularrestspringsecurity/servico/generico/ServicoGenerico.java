package net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico;

import java.io.Serializable;
import java.util.List;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.DaoGenerico;
import net.dontdrinkandroot.example.angularrestspringsecurity.exceptions.UniqueKeyException;

import org.hibernate.criterion.Criterion;

/**
 *
 * @author Lessandro
 */
public interface ServicoGenerico<T, ID extends Serializable> {

    /**
     * Recupera pelo Id
     * @param id Identificador
     * @return Entidade
     */
    T buscaPorId(ID id);

    /**
     * Recupera todos os objetos.
     * @return Objetos
     */
    List<T> buscaTodos();

    /**
     * Persiste a entidade
     * @param entity Entidade
     * @return Entidade
     * @throws Exception 
     * @throws UniqueKeyException 
     */
    T salva(T entity) throws UniqueKeyException, Exception;

    /**
     * Atualiza a entidade
     * @param entity Entidade
     * @return Entidade
     * @throws Exception 
     * @throws UniqueKeyException 
     */
    T atualiza(T entity) throws UniqueKeyException, Exception;

    /**
     * Remove a entidade
     * @param entity Entidade
     * @throws Exception 
     */
    void remove(T entity) throws Exception;
    
    /**
     * Recupera a entidade por critérios.
     * @param criterion Critérios
     * @return Entidade
     */
    T buscaPorCriterio(Criterion... criterion);
    
    /**
     * Seta o Dao da entidade específica para o Dao genérico.
     * @param genericDAO Dao da entidade específica
     */
    void setGenericDAO(DaoGenerico<T, ID> genericDAO);

    /**
     * Persiste uma lista de entidades.
     * @param entities Entidades
     * @return Entidades persistidas
     * @throws UniqueKeyException 
     * @throws Exception 
     */
    List<T> salva(List<T> entities) throws UniqueKeyException, Exception;

    /**
     * Atualiza o objeto na memória com o banco.
     * @param entity Entidade
     * @return Entidade
     */
    T atualizaObjeto(T entity);
}
