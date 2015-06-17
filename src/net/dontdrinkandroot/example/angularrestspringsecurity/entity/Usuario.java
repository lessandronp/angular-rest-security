package net.dontdrinkandroot.example.angularrestspringsecurity.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario implements Cloneable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "usuarioSeq", sequenceName = "USUARIO_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSeq")
    @Column(name = "codigousu", nullable = false, updatable = false)
    private Long codigo;
    
    @Column(name = "nomeusu", nullable = false, length = 255)
    private String nome;

    @Column(name = "loginusu", length = 20, nullable = false)
    private String login;

    @Column(name = "senhausu", length = 32, nullable = false)
    private String senha;

    @Transient
    private String senhaConfirmacao;

    @Column(name = "cargousu", length = 50, nullable = false)
    private String cargo;

    @Column(name = "datainc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Column(name = "dataalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Column(name = "usualt")
    private Long codigoUsuarioAlteracao;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "codigogrp", referencedColumnName = "codigogrp", nullable = false)
    private GrupoUsuario grupoUsuario;

    @Override
    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }

    @Override
    public String getUsername() {
	return login;
    }

    @Override
    public String getPassword() {
	return senha;
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
	return Boolean.TRUE;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
	return Boolean.TRUE;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
	return Boolean.TRUE;
    }

    @Transient
    @Override
    public boolean isEnabled() {
	return Boolean.TRUE;
    }

    @Transient
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();
	permissions.add(new SimpleGrantedAuthority(grupoUsuario.getAuthority()));
	return permissions;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
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

    public String getCargo() {
        return cargo;
    }

    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
