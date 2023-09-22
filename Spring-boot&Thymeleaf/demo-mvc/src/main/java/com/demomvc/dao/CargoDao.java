package com.demomvc.dao;

import com.demomvc.domain.Cargo;
import com.demomvc.util.Paginacao;


import java.util.List;

public interface CargoDao {

    void save(Cargo cargo);
    void update(Cargo cargo);
    void delete(Long id);
    Cargo findById(Long id);
    List<Cargo> findAll();

    Paginacao<Cargo> buscaPaginada(int pagina);
}
