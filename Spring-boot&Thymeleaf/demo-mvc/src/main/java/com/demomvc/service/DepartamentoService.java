package com.demomvc.service;

import com.demomvc.domain.Departamento;

import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento departamento);
    void editar(Departamento departamento);
    void excluir(Long id);
    Departamento buscaPorId(Long id);
    List<Departamento> buscarTodos();

    boolean departamentoTemCargos(Long id);
}
