package proyecto.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proyecto.ejecucion.ClassPlayer;

import static org.junit.Assert.assertEquals;

public class TestWhoIam {
    private ClassPlayer player1;
    private ClassPlayer player2;


    @Before
    public void setUp() throws Exception {
        player1 = new ClassPlayer("BLUE", false);
        player2 = new ClassPlayer("RED", true);

    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void Choose_Computer(){

        assertEquals(false,player1.getisHuman());
    }
    @Test
    public void Choose_Human(){

        assertEquals(true,player2.getisHuman());

    }
    @Test
    public void Choose_Blue(){
        assertEquals("BLUE",player1.getPlayer());
    }
    @Test
    public void Choose_Red(){
        assertEquals("RED",player2.getPlayer());
    }
}
