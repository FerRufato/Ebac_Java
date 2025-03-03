package br.com.FeRufato.domain.modelos;

import br.com.FeRufato.domain.interfaces.ICarro;

public class FordSUV implements ICarro {
    public String ligarMotor() {
        return "Ligando motor do Ford SUV";
    }

    public String desligarMotor() {
        return "Desligando motor do Ford SUV";
    }

    public String obterMarca() {
        return "Ford";
    }
}
