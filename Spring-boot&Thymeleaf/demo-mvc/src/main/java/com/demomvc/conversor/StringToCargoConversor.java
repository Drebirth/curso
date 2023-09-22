package com.demomvc.conversor;

import com.demomvc.domain.Cargo;
import com.demomvc.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

    @Autowired
    private CargoService service;
    @Override
    public Cargo convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscaPorId(id);
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Cargo, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
