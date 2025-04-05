import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;



public class StanzaTest {
	Stanza stanza;
	Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		stanza = new Stanza("Stanza");
		attrezzo = new Attrezzo("osso", 1);
	}
	
	 @Test
	    public void testGetStanzaAdiacente() {
	        Stanza stanzaAdiacente = new Stanza("Aula");
	        stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
	        assertEquals(stanzaAdiacente, stanza.getStanzaAdiacente("nord"));
	    }

	 @Test
	    public void testNotGetStanzaAdiacente() {
	        assertNull(stanza.getStanzaAdiacente("nord"));
	    }
	  
	 @Test
	    public void testGetStanzaAdiacenteDirezioneNulla() {
	      Stanza stanzaAdiacente = new Stanza("Aula");
	      stanza.impostaStanzaAdiacente("nord", stanzaAdiacente);
	      assertNull(stanza.getStanzaAdiacente("sud"));
	  }
	 
	  
	 @Test
	    public void testAddAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("osso", 1);
	        assertTrue(stanza.addAttrezzo(attrezzo));
	    }
	  
	 @Test
	    public void testRemoveAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("osso", 1);
	        stanza.addAttrezzo(attrezzo);
	        assertTrue(stanza.removeAttrezzo(attrezzo));
	    }
	  
	 @Test
	    public void testGetNome() {
	        assertEquals("osso", attrezzo.getNome());
	    }

	 @Test
	    public void testGetPeso() {
	        assertEquals(1, attrezzo.getPeso());
	    }
	 
	 @Test
	    public void testNomeDiverso() {
	        Attrezzo attrezzo2 = new Attrezzo("lanterna", 3);
	        assertFalse(attrezzo.equals(attrezzo2));
	    }

	 @Test
	    public void testPesoDiverso() {
	        Attrezzo attrezzo2 = new Attrezzo("lanterna", 3);
	        assertFalse(attrezzo.equals(attrezzo2));
	    }
	 
}
