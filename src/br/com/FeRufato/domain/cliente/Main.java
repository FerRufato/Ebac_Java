package br.com.FeRufato.domain.cliente;

import br.com.FeRufato.domain.interfaces.ICarro;
import br.com.FeRufato.domain.interfaces.IFabricaDeCarros;
import fabricas.FabricaFord;
import fabricas.FabricaToyota;

public class Main {
    public static void main(String[] args) {
        // Criando a fábrica Toyota
        IFabricaDeCarros fabricaToyota = new FabricaToyota();
        ICarro toyotaSedan = fabricaToyota.criarSedan();
        System.out.println(toyotaSedan.ligarMotor());
        System.out.println(toyotaSedan.desligarMotor());
        System.out.println("Marca: " + toyotaSedan.obterMarca());

        ICarro toyotaSUV = fabricaToyota.criarSUV();
        System.out.println(toyotaSUV.ligarMotor());
        System.out.println(toyotaSUV.desligarMotor());
        System.out.println("Marca: " + toyotaSUV.obterMarca());

        // Criando a fábrica Ford
        IFabricaDeCarros fabricaFord = new FabricaFord();
        ICarro fordSedan = fabricaFord.criarSedan();
        System.out.println(fordSedan.ligarMotor());
        System.out.println(fordSedan.desligarMotor());
        System.out.println("Marca: " + fordSedan.obterMarca());

        ICarro fordSUV = fabricaFord.criarSUV();
        System.out.println(fordSUV.ligarMotor());
        System.out.println(fordSUV.desligarMotor());
        System.out.println("Marca: " + fordSUV.obterMarca());
    }
}
