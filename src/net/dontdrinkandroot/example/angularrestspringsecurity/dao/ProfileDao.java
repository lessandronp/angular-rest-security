package net.dontdrinkandroot.example.angularrestspringsecurity.dao;

import net.dontdrinkandroot.example.angularrestspringsecurity.dao.generico.DaoGenerico;
import net.dontdrinkandroot.example.angularrestspringsecurity.entity.GrupoUsuario;

public interface ProfileDao extends DaoGenerico<GrupoUsuario, Long> {

	/**
	 * Find profile by name.
	 * @param name Name
	 * @return {@Profile}
	 */
	GrupoUsuario findByName(String name);
}
