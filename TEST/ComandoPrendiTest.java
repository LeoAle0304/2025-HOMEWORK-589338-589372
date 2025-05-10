import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;

public class ComandoPrendiTest {
    private Partita partita;
    private ComandoPrendi comandoPrendi;
    private TestIO testIO;

    @Before
    public void setUp() {
        partita = new Partita();
        comandoPrendi = new ComandoPrendi();
        testIO = new TestIO();
        comandoPrendi.setIO(testIO);
    }

    @Test
    public void testPrendiAttrezzoDallaStanza() {
        Stanza stanza = partita.getStanzaCorrente();
        Attrezzo attrezzo = new Attrezzo("Martello", 2);
        stanza.addAttrezzo(attrezzo);
        comandoPrendi.setParametro("Martello");
        comandoPrendi.esegui(partita);
        Borsa borsa = partita.getGiocatore().getBorsa();
        assertEquals(attrezzo, borsa.getAttrezzo("Martello"));
    }

    @Test
    public void testAttrezzoNonPresenteInStanza() {
        comandoPrendi.setParametro("Libro");
        comandoPrendi.esegui(partita);
        assertEquals("Attrezzo Libro non presente nella stanza", testIO.getUltimoMessaggioMostrato());
    }

    @Test
    public void testBorsaPiena() {
        Borsa borsa = partita.getGiocatore().getBorsa();
        for (int i = 0; i < 9; i++) {
            borsa.addAttrezzo(new Attrezzo("Attrezzo" + i, 1));
        }
        comandoPrendi.setParametro("NuovoAttrezzo");
        comandoPrendi.esegui(partita);
        assertEquals("Non c'è più spazio per nuovi attrezzi nella borsa", testIO.getUltimoMessaggioMostrato());
    }

    // Classe test implementata senza utilizzare MockIO
    private class TestIO implements IO {
        private String ultimoMessaggioMostrato;

        @Override
        public void mostraMessaggio(String messaggio) {
            this.ultimoMessaggioMostrato = messaggio;
        }

        @Override
        public String leggiRiga() {
            // Non necessario per questi test
            return null;
        }

        public String getUltimoMessaggioMostrato() {
            return this.ultimoMessaggioMostrato;
        }
    }
}
