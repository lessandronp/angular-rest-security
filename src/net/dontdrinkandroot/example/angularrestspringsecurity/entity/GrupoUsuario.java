package net.dontdrinkandroot.example.angularrestspringsecurity.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_grupousuario")
public class GrupoUsuario implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "grupoUsuarioSeq", sequenceName = "GRUPO_USUARIO_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupoUsuarioSeq")
    @Column(name = "codigogrp", nullable = false, updatable = false)
    private Long codigo;

    @Column(name = "nomegrp", nullable = false, length = 20)
    private String nome;

    @Column(name = "datainc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Column(name = "dataalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Column(name = "usualt")
    private Long codigoUsuarioAlteracao;
    
    @OneToMany(mappedBy = "grupoUsuario", fetch = FetchType.LAZY)
    private Collection<PermissaoGrupo> permissoesGrupo; 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Long getCodigoUsuarioAlteracao() {
        return codigoUsuarioAlteracao;
    }

    public void setCodigoUsuarioAlteracao(Long codigoUsuarioAlteracao) {
        this.codigoUsuarioAlteracao = codigoUsuarioAlteracao;
    }

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public String getAuthority() {
	return this.nome;
    }

    public Collection<PermissaoGrupo> getPermissoesGrupo() {
        return permissoesGrupo;
    }

    public void setPermissoesGrupo(Collection<PermissaoGrupo> permissoesGrupo) {
        this.permissoesGrupo = permissoesGrupo;
    }
}
