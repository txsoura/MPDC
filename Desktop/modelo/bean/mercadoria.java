/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author victor tesoura jr
 */
public class mercadoria {

    int codigo, navio, responsavel, quantidade;
    String situacao, tipo, chegada, partida;

    public mercadoria() {

    }

    public mercadoria(int codigo, int navio, int responsavel, int quantidade, String situacao, String tipo, String chegada, String partida) {
        this.codigo = codigo;
        this.navio = navio;
        this.responsavel = responsavel;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.tipo = tipo;
        this.chegada = chegada;
        this.partida = partida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNavio() {
        return navio;
    }

    public void setNavio(int navio) {
        this.navio = navio;
    }

    public int getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(int responsavel) {
        this.responsavel = responsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

}
