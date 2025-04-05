import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;


	public class TestBorsa {
	    private Borsa borsaTest;

	    @Before
	    public void setBorsa() {
	        borsaTest = new Borsa();
	    }

	    @Test
	    public void testAddAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("attrezzo1", 5);
	        assertTrue(borsaTest.addAttrezzo(attrezzo));
	    }

	    @Test
	    public void testGetPesoMax() {
	        assertEquals(10, borsaTest.getPesoMax());
	    }

	    @Test
	    public void testGetAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("attrezzo1", 5);
	        borsaTest.addAttrezzo(attrezzo);
	        assertEquals(attrezzo, borsaTest.getAttrezzo("attrezzo1"));
	    }

	    @Test
	    public void testGetPeso() {
	        Attrezzo attrezzo1 = new Attrezzo("attrezzo1", 5);
	        Attrezzo attrezzo2 = new Attrezzo("attrezzo2", 3);
	        borsaTest.addAttrezzo(attrezzo1);
	        borsaTest.addAttrezzo(attrezzo2);
	        assertEquals(8, borsaTest.getPeso());
	    }

	    @Test
	    public void testIsEmpty() {
	        assertTrue(borsaTest.isEmpty());
	    }

	    @Test
	    public void testHasAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("attrezzo1", 5);
	        borsaTest.addAttrezzo(attrezzo);
	        assertTrue(borsaTest.hasAttrezzo("attrezzo1"));
	    }

	    @Test
	    public void testRemoveAttrezzo() {
	        Attrezzo attrezzo = new Attrezzo("attrezzo1", 5);
	        borsaTest.addAttrezzo(attrezzo);
	        assertEquals(attrezzo, borsaTest.removeAttrezzo("attrezzo1"));
	    }
	}



