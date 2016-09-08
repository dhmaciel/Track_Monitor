package com.dmobile.trackmonitor.Model;

/**
 * Created by Douglas on 07/09/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Motorista {

    @SerializedName("RegistroMotoristaId")
    @Expose
    private String registroMotoristaId;
    @SerializedName("Nome")
    @Expose
    private String nome;
    @SerializedName("Telefone")
    @Expose
    private String telefone;
    @SerializedName("Cpf")
    @Expose
    private String cpf;
    @SerializedName("DataCadastro")
    @Expose
    private String dataCadastro;
    @SerializedName("Ativo")
    @Expose
    private Boolean ativo;
    @SerializedName("ValidationResult")
    @Expose
    private Object validationResult;

    /**
     * No args constructor for use in serialization
     *
     */
    public Motorista() {
    }

    /**
     *
     * @param ativo
     * @param telefone
     * @param cpf
     * @param nome
     * @param validationResult
     * @param dataCadastro
     * @param registroMotoristaId
     */
    public Motorista(String registroMotoristaId, String nome, String telefone, String cpf, String dataCadastro, Boolean ativo, Object validationResult) {
        this.registroMotoristaId = registroMotoristaId;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        this.validationResult = validationResult;
    }

    /**
     *
     * @return
     * The registroMotoristaId
     */
    public String getRegistroMotoristaId() {
        return registroMotoristaId;
    }

    /**
     *
     * @param registroMotoristaId
     * The RegistroMotoristaId
     */
    public void setRegistroMotoristaId(String registroMotoristaId) {
        this.registroMotoristaId = registroMotoristaId;
    }

    /**
     *
     * @return
     * The nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     * The Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     * The telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     * The Telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     * The cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     * The Cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     * The dataCadastro
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     *
     * @param dataCadastro
     * The DataCadastro
     */
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     *
     * @return
     * The ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     *
     * @param ativo
     * The Ativo
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     *
     * @return
     * The validationResult
     */
    public Object getValidationResult() {
        return validationResult;
    }

    /**
     *
     * @param validationResult
     * The ValidationResult
     */
    public void setValidationResult(Object validationResult) {
        this.validationResult = validationResult;
    }

}