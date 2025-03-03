package br.com.FeRufato.domain.modelos;

import br.com.FeRufato.domain.interfaces.ICarro;

public class ToyotaSUV implements ICarro {

    @Override
    public String ligarMotor() {
        return "Ligando motor do Toyota SUV";
    }

    @Override
    public String desligarMotor() {
        return "Desligando motor do Toyota SUV";
    }

    @Override
    public String obterMarca() {
        return "Toyota";
    }

}
