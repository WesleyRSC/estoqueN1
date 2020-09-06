/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoquen1.model;

import java.time.LocalDate;

/**
 *
 * @author fh139
 */
public class ProdutoModel {


    private int codItem;
    private LocalDate dataCompra;
    private String localCompra;
    private String tipo;
    private String marca;
    private String caracteristicas;
    private String tamanho;
    private String cor;
    private float valorEtiqueta;
    private float valorPago;
    private float valorMargem;
    private float preco;
    
    
    /**
     * @return the codItem
     */
    public int getCodItem() {
        return codItem;
    }

    /**
     * @param codItem the codItem to set
     */
    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    /**
     * @return the dataCompra
     */
    public LocalDate getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the localCompra
     */
    public String getLocalCompra() {
        return localCompra;
    }

    /**
     * @param localCompra the localCompra to set
     */
    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the caracteristicas
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the valorEtiqueta
     */
    public float getValorEtiqueta() {
        return valorEtiqueta;
    }

    /**
     * @param valorEtiqueta the valorEtiqueta to set
     */
    public void setValorEtiqueta(float valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    /**
     * @return the valorPago
     */
    public float getValorPago() {
        return valorPago;
    }

    /**
     * @param valorPago the valorPago to set
     */
    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    /**
     * @return the valorMargem
     */
    public float getValorMargem() {
        return valorMargem;
    }

    /**
     * @param valorMargem the valorMargem to set
     */
    public void setValorMargem(float valorMargem) {
        this.valorMargem = valorMargem;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
