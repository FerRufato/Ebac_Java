package br.com.FeRufato.domain.modelos;

import br.com.FeRufato.domain.interfaces.ICarro;

public class FordSedan implements ICarro {


    @Override
    public String ligarMotor() {
        return "Ligando motor do Ford Sedan";
    }

    @Override
    public String desligarMotor() {
        return "Desligando motor do Ford Sedan";
    }

    @Override
    public String obterMarca() {
        return "Ford";
    }


}
