import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.Giocatore;


public class TestGiocatore {

	private Giocatore giocatoreTest;

    @Before
    public void setGiocatore() {
        giocatoreTest = new Giocatore();
    }

    @Test
    public void testGetBorsa() {
        assertNotNull(giocatoreTest.getBorsa());
    }

    @Test
    public void testGetCfu() {
        assertEquals(20, giocatoreTest.getCfu());
    }

    @Test
    public void testSetCfu() {
        giocatoreTest.setCfu(10);
        assertEquals(10, giocatoreTest.getCfu());
    }
}
