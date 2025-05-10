import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Stanza bloccata", "chiave", "nord");
        stanzaAdiacente = new Stanza("Stanza adiacente");
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneBloccata() {
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneNonBloccata() {
        stanzaBloccata.impostaStanzaAdiacente("sud", stanzaAdiacente);
        assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("sud"));
    }
    
    @Test
    public void testGetAttrezzoInesistente() {
        Attrezzo attrezzoDiTest = new Attrezzo("attrezzoDiTest", 1);
        stanzaBloccata.addAttrezzo(attrezzoDiTest);
        assertNull(stanzaBloccata.getAttrezzo("inesistente"));      
    }
}

