package net.dontdrinkandroot.example.angularrestspringsecurity.dao;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.DaoGenerico;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;

/**
 * Interface do perfil de acesso.
 * @author Lessandro
 */
public interface GrupoUsuarioDao extends DaoGenerico<GrupoUsuario, Long> {

    /**
     * Recupera o perfil de acesso pelo nome
     * @param name Nome
     * @return Perfil de acesso
     */
    GrupoUsuario buscaPorNome(String name);

}
