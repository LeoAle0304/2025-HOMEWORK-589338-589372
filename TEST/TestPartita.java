import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;



public class TestPartita {
    
    private Partita partita;
    private Stanza stanzaVincente;
    
    @Before
    public void setUp() {
        partita = new Partita();
        stanzaVincente = partita.getStanzaVincente();
    }

    @Test
    public void testVinta_StanzaVincente() {
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.vinta());
    }

    @Test
    public void testVinta_StanzaNonVincente() {
        assertFalse(partita.vinta());
    }

    @Test
    public void testNonVinta() {
        assertFalse(partita.isFinita());
    }

    @Test
    public void testIsFinita_NonFinita() {
        assertFalse(partita.isFinita());
    }

    @Test
    public void testIsFinita_Vinta() {
        partita.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.isFinita());
    }

    @Test
    public void testIsFinita_ZeroCfu() {
        partita.setCfu(0);
        assertTrue(partita.isFinita());
    }


    @Test
    public void testGetCfu() {
        assertEquals(20, partita.getCfu());
    }

    @Test
    public void testSetCfu() {
        int nuovoCfu = 15;
        partita.setCfu(nuovoCfu);
        assertEquals(nuovoCfu, partita.getCfu());
    }
}