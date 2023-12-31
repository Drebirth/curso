package com.demomvc.util;

import java.util.List;

public class Paginacao<T> {

    private int tamanho;
    private int pagina;
    private long totalDePaginas;
    private List<T> registros;

    public Paginacao(int tamanho, int pagina, long totalDePaginas, List<T> registros) {
        this.tamanho = tamanho;
        this.pagina = pagina;
        this.totalDePaginas = totalDePaginas;
        this.registros = registros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public long getTotalDePaginas() {
        return totalDePaginas;
    }

    public List<T> getRegistros() {
        return registros;
    }
}
