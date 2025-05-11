package ar.edu.uba.fi;

import java.util.Arrays;
import java.util.List;

public class Conclave {
    private Cardenal[] cardenales;
    private final List<Regla> reglas;

    public Conclave(Impersonalizador impersonalizador, Cardenal... cardenales) {
        this.cardenales = cardenales;
        this.reglas = Arrays.asList(
            new ReglaDosTercios(this.cardenales),
            new ReglaIdsValido(impersonalizador, cardenales),
            new ReglaUnanimidad(cardenales)
        );
    }
    public Object verificar() {
        for(Regla r : this.reglas) {
            Object resultado = r.verificar();
            if (resultado.equals(new HumoNegro())) {
                return new HumoNegro();
            }
        }

        return new HumoBlanco();
    }

}
