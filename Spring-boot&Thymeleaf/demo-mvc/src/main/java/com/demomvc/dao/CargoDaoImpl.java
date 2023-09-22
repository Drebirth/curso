package com.demomvc.dao;

import com.demomvc.domain.Cargo;

import com.demomvc.util.Paginacao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo,Long> implements CargoDao {

    public Paginacao<Cargo> buscaPaginada(int pagina){
        int tamanho =5;
        int inicio = (pagina - 1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho-1)) / tamanho;

        return new Paginacao<>(pagina,tamanho,totalDePaginas,cargos);
    }

    public long count(){
        return getEntityManager()
                .createQuery("select count(*) from Cargo", Long.class)
                .getSingleResult();
    }
}
