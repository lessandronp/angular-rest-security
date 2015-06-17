package net.dontdrinkandroot.example.angularrestspringsecurity.servico;

import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico.ServicoGenerico;

/**
 * Interface de serviço do perfil de acesso.
 * @author Lessandro
 */
public interface ServicoGrupoUsuario extends ServicoGenerico<GrupoUsuario, Long> {
    
    /**
     * Recupera o perfil de acesso pelo nome
     * @param name Nome
     * @return Perfil de acesso
     */
    public GrupoUsuario buscaPorNome(String name);

}
