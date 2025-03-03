package fabricas;

import br.com.FeRufato.domain.interfaces.ICarro;
import br.com.FeRufato.domain.interfaces.IFabricaDeCarros;
import br.com.FeRufato.domain.modelos.ToyotaSUV;
import br.com.FeRufato.domain.modelos.ToyotaSedan;

public class FabricaToyota implements IFabricaDeCarros {
    @Override
    public ICarro criarSedan() {
        return new ToyotaSedan();
    }

    @Override
    public ICarro criarSUV() {
        return new ToyotaSUV();
    }
}
