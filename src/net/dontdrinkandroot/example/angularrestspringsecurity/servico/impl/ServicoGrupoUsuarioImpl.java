package net.dontdrinkandroot.example.angularrestspringsecurity.servico.impl;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.GrupoUsuarioDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.ServicoGrupoUsuario;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico.impl.ServicoGenericoImpl;

/**
 * Dao do perfil de acesso.
 * @author Lessandro
 */
@Service
public class ServicoGrupoUsuarioImpl extends ServicoGenericoImpl<GrupoUsuario, Long>
	implements ServicoGrupoUsuario {

    private static final long serialVersionUID = 1L;
    private GrupoUsuarioDao accessProfileDao;
    private static Log log = LogFactory.getLog(ServicoGrupoUsuarioImpl.class);

    public ServicoGrupoUsuarioImpl() {
    }

    @Inject
    public ServicoGrupoUsuarioImpl(GrupoUsuarioDao accessProfileDao) {
	this.accessProfileDao = accessProfileDao;
	super.setGenericDAO(accessProfileDao);
    }

    @Override
    public GrupoUsuario buscaPorNome(String name) {
	GrupoUsuario accessProfile = this.accessProfileDao.buscaPorNome(name);
	return accessProfile;
    }
}
