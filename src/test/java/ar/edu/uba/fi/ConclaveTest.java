package ar.edu.uba.fi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ConclaveTest {

    @Test
    public void caso01() {
        Cardenal id1 = new Cardenal("id1");
        Cardenal id9 = new Cardenal("id9");

        id1.votar(id9);

        Impersonalizador i = new Impersonalizador();
        ReglaIdsValido vi = new ReglaIdsValido(i, id1, id9);

        Object resultado = vi.verificar();

        Assertions.assertEquals(new HumoNegro(), resultado);
    }

    @Test
    public void caso02() {
        Cardenal id1 = new Cardenal("id1");
        Cardenal id2 = new Cardenal("id2");
        Cardenal id3 = new Cardenal("id3");
        Cardenal id4 = new Cardenal("id4");
        Cardenal id5 = new Cardenal("id5");
        Cardenal id6 = new Cardenal("id6");

        id1.votar(id6);
        id2.votar(id6);
        id3.votar(id6);
        id4.votar(id6);
        id5.votar(id6);
        id6.votar(id6);

        ReglaUnanimidad rv = new ReglaUnanimidad(id1, id2, id3, id4, id5, id6);

        Object resultado = rv.verificar();

        Assertions.assertEquals(new HumoNegro(), resultado);
    }

    @Test
    public void caso03() {
        Cardenal id1 = new Cardenal("id1");
        Cardenal id2 = new Cardenal("id2");
        Cardenal id3 = new Cardenal("id3");
        Cardenal id4 = new Cardenal("id4");
        Cardenal id5 = new Cardenal("id5");
        Cardenal id6 = new Cardenal("id6");

        id1.votar(id6);
        id2.votar(id6);
        id3.votar(id6);
        id4.votar(id6);
        id5.votar(id4);
        id6.votar(id1);

        Conclave c = new Conclave(new Impersonalizador(), id1, id2, id3, id4, id5, id6);

        Object resultado = c.verificar();

        Assertions.assertEquals(new HumoBlanco(), resultado);
    }

    @Test
    public void noSeCumplenLosDosTercios() {
        Cardenal id1 = new Cardenal("id1");
        Cardenal id2 = new Cardenal("id2");
        Cardenal id3 = new Cardenal("id3");
        Cardenal id4 = new Cardenal("id4");
        Cardenal id5 = new Cardenal("id5");
        Cardenal id6 = new Cardenal("id6");

        id1.votar(id2);
        id2.votar(id6);
        id3.votar(id6);
        id4.votar(id6);
        id5.votar(id4);
        id6.votar(id1);

        ReglaDosTercios c = new ReglaDosTercios(id1, id2, id3, id4, id5, id6);

        Object resultado = c.verificar();

        Assertions.assertEquals(new HumoNegro(), resultado);
    }
}
