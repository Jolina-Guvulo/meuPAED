package pt.ulusofona.deisi.aedProj2020;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static pt.ulusofona.deisi.aedProj2020.Main.getMovies;

public class TestMovie {

    Movie filme1 = new Movie(603, "The Matrix", "30-03-1999");
    Movie filme2 = new Movie(10428, "Hackers", "14-09-1995");

    @Test
    public void testMovie_01() {
        String esperado = "603 | The Matrix | 30-03-1999";
        String obtido = filme1.toString();

        assertEquals(esperado, obtido);
    }

    @Test
    public void teste_02() {
        String esperado = "10428 | Hackers | 14-09-1995";
        String obtido = filme2.toString();
        assertEquals(esperado, obtido);
    }

    @Test
    public void getSizeMovies() {
        int esperado = 6;
        int obtido = getMovies().size();
        assertEquals(esperado, obtido);
    }

}
