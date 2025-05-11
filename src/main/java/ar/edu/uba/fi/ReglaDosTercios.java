package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReglaDosTercios implements Regla {
    private List<Cardenal> cardenales;
    private ArrayList<Integer> votos;

    public ReglaDosTercios(Cardenal... cardenals) {
        this.cardenales = new ArrayList<>(Arrays.stream(cardenals).toList());
        this.votos = new ArrayList<>(this.cardenales.stream().map(v -> 0).toList());
    }

    public Object verificar() {
        Cardenal first = this.cardenales.stream().findFirst().orElseThrow();
        List<String> listaDeVotados = first.listaDeVotos(this.cardenales);

        for (Cardenal c : this.cardenales) {
            double votosRecibidos = c.contarEn(listaDeVotados);
            double proporcion = votosRecibidos / listaDeVotados.size();
            if (proporcion >= 2.0/3.0) {
                return new HumoBlanco();
            }
        }

        return new HumoNegro();
    }


}
