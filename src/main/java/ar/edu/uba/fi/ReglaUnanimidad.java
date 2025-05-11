package ar.edu.uba.fi;

import java.util.List;
import java.util.stream.Collectors;

public class ReglaUnanimidad implements Regla {
    private List<Cardenal> cardenales;

    public ReglaUnanimidad(Cardenal... cardenales) {

        this.cardenales = List.of(cardenales);
    }

    public Object verificar() {
        Cardenal first = this.cardenales.stream().findFirst().orElseThrow();
        List<String> listaDeVotados = first.listaDeVotos(this.cardenales);

        for (Cardenal c : this.cardenales) {
            double votosRecibidos = c.contarEn(listaDeVotados);
            double proporcion = votosRecibidos / listaDeVotados.size();

            if (proporcion >= 1) {
                return new HumoNegro();
            }
        }

        return new HumoBlanco();

    }


}
