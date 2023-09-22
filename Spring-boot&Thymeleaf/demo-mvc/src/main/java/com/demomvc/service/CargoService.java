package com.demomvc.service;

import com.demomvc.domain.Cargo;
import com.demomvc.util.Paginacao;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);
    void editar(Cargo cargo);
    void excluir(Long id);
    Cargo buscaPorId(Long id);
    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);

    Paginacao<Cargo> buscaPagina(int pagina);
}
