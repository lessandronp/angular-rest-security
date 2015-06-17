package net.dontdrinkandroot.example.angularrestspringsecurity.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
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

import net.dontdrinkandroot.example.angularrestspringsecurity.entity.converter.StatusQuestionTypeConverter;

@Entity(name = "permissaoGrupo")
@Table(name = "tb_permissoesgrupo")
public class PermissaoGrupo implements Serializable {
   

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "permissaoGrupoSeq", sequenceName = "PERMISSAO_GRP_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoGrupoSeq")
    @Column(name = "codigopermgrp", nullable = false, updatable = false)
    private Long codigo;

    @JoinColumn(name = "codigogrp", referencedColumnName = "codigogrp", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GrupoUsuario grupoUsuario;
    
    @JoinColumn(name = "codigotela", referencedColumnName = "codigotela", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tela tela;
    
    @Column(name = "permgrpincluir", nullable = false, columnDefinition = "char(1)")
    @Convert(converter = StatusQuestionTypeConverter.class)
    private StatusQuestionType permiteIncluir = StatusQuestionType.NO;

    @Column(name = "permgrpalterar", nullable = false, columnDefinition = "char(1)")
    @Convert(converter = StatusQuestionTypeConverter.class)
    private StatusQuestionType permiteAlterar = StatusQuestionType.NO;
    
    @Column(name = "permgrpconsultar", nullable = false, columnDefinition = "char(1)")
    @Convert(converter = StatusQuestionTypeConverter.class)
    private StatusQuestionType permiteConsultar = StatusQuestionType.NO;

    @Column(name = "permgrpexcluir", nullable = false, columnDefinition = "char(1)")
    @Convert(converter = StatusQuestionTypeConverter.class)
    private StatusQuestionType permiteExcluir = StatusQuestionType.NO;
    
    @Column(name = "permgrpprocessar", nullable = false, columnDefinition = "char(1)")
    @Convert(converter = StatusQuestionTypeConverter.class)
    private StatusQuestionType permiteProcessar = StatusQuestionType.NO;

    @Column(name = "datainc", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Column(name = "dataalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Column(name = "usualt")
    private Long codigoUsuarioAlteracao;

    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public StatusQuestionType getPermiteIncluir() {
        return permiteIncluir;
    }

    public void setPermiteIncluir(StatusQuestionType permiteIncluir) {
        this.permiteIncluir = permiteIncluir;
    }

    public StatusQuestionType getPermiteAlterar() {
        return permiteAlterar;
    }

    public void setPermiteAlterar(StatusQuestionType permiteAlterar) {
        this.permiteAlterar = permiteAlterar;
    }

    public StatusQuestionType getPermiteConsultar() {
        return permiteConsultar;
    }

    public void setPermiteConsultar(StatusQuestionType permiteConsultar) {
        this.permiteConsultar = permiteConsultar;
    }

    public StatusQuestionType getPermiteExcluir() {
        return permiteExcluir;
    }

    public void setPermiteExcluir(StatusQuestionType permiteExcluir) {
        this.permiteExcluir = permiteExcluir;
    }

    public StatusQuestionType getPermiteProcessar() {
        return permiteProcessar;
    }

    public void setPermiteProcessar(StatusQuestionType permiteProcessar) {
        this.permiteProcessar = permiteProcessar;
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
}
