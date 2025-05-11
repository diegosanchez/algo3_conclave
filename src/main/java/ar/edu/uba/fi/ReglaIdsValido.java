package ar.edu.uba.fi;

import java.util.NoSuchElementException;

public class ReglaIdsValido implements Regla {
    private Impersonalizador i;
    private Cardenal[] cardenales;

    public ReglaIdsValido(Impersonalizador i, Cardenal... cardenales) {

        this.i = i;
        this.cardenales = cardenales;
    }

    public Object verificar() {
        try {
            for(Cardenal c : this.cardenales) {
                c.validarIds(i);
            }
        } catch (NoSuchElementException e) {
            return new HumoNegro();
        }

        return new HumoBlanco();

    }
}
