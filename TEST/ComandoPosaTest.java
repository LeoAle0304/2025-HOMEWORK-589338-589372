import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;

public class ComandoPosaTest {
    private Partita partita;
    private ComandoPosa comandoPosa;
    private TestIO testIO;

    @Before
    public void setUp() {
        partita = new Partita();
        comandoPosa = new ComandoPosa();
        testIO = new TestIO();
        comandoPosa.setIO(testIO);
    }

    @Test
    public void testPosaAttrezzoNellaStanza() {
        Stanza stanza = partita.getStanzaCorrente();
        Attrezzo attrezzo = new Attrezzo("Martello", 2);
        Borsa borsa = partita.getGiocatore().getBorsa();
        borsa.addAttrezzo(attrezzo);
        comandoPosa.setParametro("Martello");
        comandoPosa.esegui(partita);
        assertEquals(attrezzo, stanza.getAttrezzo("Martello"));
    }

    @Test
    public void testAttrezzoNonPresenteInBorsa() {
        comandoPosa.setParametro("Libro");
        comandoPosa.esegui(partita);
        assertEquals("Attrezzo Libro non presente nella borsa", testIO.getUltimoMessaggioMostrato());
    }

    @Test
    public void testStanzaPiena() {
        Stanza stanza = partita.getStanzaCorrente();
        Attrezzo attrezzo1 = new Attrezzo("Libro", 2);
        Attrezzo attrezzo2 = new Attrezzo("Penna", 1);
        stanza.addAttrezzo(attrezzo1);
        stanza.addAttrezzo(attrezzo2);
        Borsa borsa = partita.getGiocatore().getBorsa();
        borsa.addAttrezzo(new Attrezzo("Martello", 2));
        comandoPosa.setParametro("Martello");
        comandoPosa.esegui(partita);
        assertEquals("Non c'è più spazio per nuovi attrezzi nella stanza", testIO.getUltimoMessaggioMostrato());
    }

   
    private class TestIO implements IO {
        private String ultimoMessaggioMostrato;

        @Override
        public void mostraMessaggio(String messaggio) {
            this.ultimoMessaggioMostrato = messaggio;
        }

        @Override
        public String leggiRiga() {
            return null;
        }

        public String getUltimoMessaggioMostrato() {
            return this.ultimoMessaggioMostrato;
        }
    }
}
