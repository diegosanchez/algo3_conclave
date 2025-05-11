package ar.edu.uba.fi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cardenal {
    public Cardenal voto;
    public String id;

    public Cardenal(String id) {
        this.id = id;

        this.voto = null;
    }

    public void votar(Cardenal candidato) {

        this.voto = candidato;
    }

    public List<String> listaDeVotos(List<Cardenal> cardenales) {
        return cardenales.stream()
                .map(c -> c.voto.id)
                .collect(Collectors.toList());

    }

    public double contarEn(List<String> listaDeVotados) {
        return listaDeVotados.stream()
                .filter(idDeLista -> idDeLista.equals(id))
                .count();
    }

    public void validarIds(Impersonalizador i) {

        i.validar(id, voto.id);
    }

}
