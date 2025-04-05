import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

	public class TestLabirinto {
	    private Labirinto labirintoTest;

	    @Before
	    public void inizializzaLabirinto() {
	        labirintoTest = new Labirinto();
	    }

	    @Test
	    public void testGetStanzaVincente() {
	        Stanza stanzaVincente = labirintoTest.getStanzaVincente();
	        assertNotNull(stanzaVincente);
	        assertEquals("Biblioteca", stanzaVincente.getNome());
	    }

	    @Test
	    public void testSetStanzaCorrente() {
	        Stanza stanza = new Stanza("Atrio");
	        labirintoTest.setStanzaCorrente(stanza);
	        assertEquals(stanza, labirintoTest.getStanzaCorrente());
	    }

	    @Test
	    public void testGetStanzaCorrente() {
	        Stanza stanza = labirintoTest.getStanzaCorrente();
	        assertNotNull(stanza);
	        assertEquals("Atrio", stanza.getNome());
	    }
}
