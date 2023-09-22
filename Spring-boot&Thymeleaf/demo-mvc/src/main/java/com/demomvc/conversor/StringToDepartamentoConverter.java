package com.demomvc.conversor;

import com.demomvc.domain.Departamento;
import com.demomvc.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;
    @Override
    public Departamento convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscaPorId(id);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Departamento, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
