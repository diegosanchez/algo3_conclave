package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Impersonalizador {

    private final ArrayList<String> idsValidos;

    public Impersonalizador() {
        this.idsValidos = new ArrayList<String>();
        this.idsValidos.add("id1");
        this.idsValidos.add("id2");
        this.idsValidos.add("id3");
        this.idsValidos.add("id4");
        this.idsValidos.add("id5");
        this.idsValidos.add("id6");
    }

    public void validar(String id0, String id1) {
        List <String> idsParaValidate = Arrays.asList(id0, id1);
        for(String id : idsParaValidate) {
            this.idsValidos.stream()
                    .filter(unIdValido -> unIdValido.compareToIgnoreCase(id) == 0)
                    .findFirst().orElseThrow();
        }
    }

}
