package proyecto.pruebas;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import proyecto.ejecucion.GuiSOS;

public class TestSizeBoard {
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
    }
    /*
    @After
    public void tearDown() throws Exception {
    }
    */

    //AC 1.1
    @Test
    public void CorrectN(){
        assertEquals(3,game.SizeN(3));
    }
    //AC 1.2
    @Test
    public void WrongN1(){
            assertEquals(3,game.SizeN(2));
    }
    //AC 1.2
    @Test
    public void WrongN2(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            if(game.SizeN(-1)!=-1){
                throw new IllegalArgumentException("La dimension debe estar entre 3 y 16");
            };
        });
        assertEquals("La dimension debe estar entre 3 y 16", exception.getMessage());
    }
}
