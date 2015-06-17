package net.dontdrinkandroot.example.angularrestspringsecurity.servico.impl;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.PermissaoGrupoDao;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.PermissaoGrupo;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.ServicoPermissaoGrupo;
import net.dontdrinkandroot.example.angularrestspringsecurity.servico.generico.impl.ServicoGenericoImpl;

public class ServicoPermissaoGrupoImpl extends ServicoGenericoImpl<PermissaoGrupo, Long> 
	implements ServicoPermissaoGrupo {

    private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(ServicoPermissaoGrupoImpl.class);

    public ServicoPermissaoGrupoImpl() {
    }

    @Inject
    public ServicoPermissaoGrupoImpl(PermissaoGrupoDao permissaoGrupoDao) {
	super.setGenericDAO(permissaoGrupoDao);
    }


}
