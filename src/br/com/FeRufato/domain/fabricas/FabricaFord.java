package fabricas;

import br.com.FeRufato.domain.modelos.FordSUV;
import br.com.FeRufato.domain.modelos.FordSedan;
import br.com.FeRufato.domain.interfaces.ICarro;
import br.com.FeRufato.domain.interfaces.IFabricaDeCarros;

public class FabricaFord implements IFabricaDeCarros {
    @Override
    public ICarro criarSedan() {
        return new FordSedan();
    }

    @Override
    public ICarro criarSUV() {
        return new FordSUV();
    }
}
