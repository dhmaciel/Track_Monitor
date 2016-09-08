package com.dmobile.trackmonitor.Model;

/**
 * Created by Douglas on 07/09/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Viagem {

    @SerializedName("ViagemId")
    @Expose
    private String viagemId;
    @SerializedName("Origem")
    @Expose
    private String origem;
    @SerializedName("Destino")
    @Expose
    private String destino;
    @SerializedName("PreviaoEmbarque")
    @Expose
    private String previaoEmbarque;
    @SerializedName("PrevisaoEntrega")
    @Expose
    private String previsaoEntrega;
    @SerializedName("KmEstimado")
    @Expose
    private Integer kmEstimado;

    /**
     * No args constructor for use in serialization
     *
     */
    public Viagem() {
    }

    /**
     *
     * @param previaoEmbarque
     * @param destino
     * @param viagemId
     * @param previsaoEntrega
     * @param origem
     * @param kmEstimado
     */
    public Viagem(String viagemId, String origem, String destino, String previaoEmbarque, String previsaoEntrega, Integer kmEstimado) {
        this.viagemId = viagemId;
        this.origem = origem;
        this.destino = destino;
        this.previaoEmbarque = previaoEmbarque;
        this.previsaoEntrega = previsaoEntrega;
        this.kmEstimado = kmEstimado;
    }

    /**
     *
     * @return
     * The viagemId
     */
    public String getViagemId() {
        return viagemId;
    }

    /**
     *
     * @param viagemId
     * The ViagemId
     */
    public void setViagemId(String viagemId) {
        this.viagemId = viagemId;
    }

    /**
     *
     * @return
     * The origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     *
     * @param origem
     * The Origem
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     *
     * @return
     * The destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     *
     * @param destino
     * The Destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     *
     * @return
     * The previaoEmbarque
     */
    public String getPreviaoEmbarque() {
        return previaoEmbarque;
    }

    /**
     *
     * @param previaoEmbarque
     * The PreviaoEmbarque
     */
    public void setPreviaoEmbarque(String previaoEmbarque) {
        this.previaoEmbarque = previaoEmbarque;
    }

    /**
     *
     * @return
     * The previsaoEntrega
     */
    public String getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    /**
     *
     * @param previsaoEntrega
     * The PrevisaoEntrega
     */
    public void setPrevisaoEntrega(String previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    /**
     *
     * @return
     * The kmEstimado
     */
    public Integer getKmEstimado() {
        return kmEstimado;
    }

    /**
     *
     * @param kmEstimado
     * The KmEstimado
     */
    public void setKmEstimado(Integer kmEstimado) {
        this.kmEstimado = kmEstimado;
    }

}
