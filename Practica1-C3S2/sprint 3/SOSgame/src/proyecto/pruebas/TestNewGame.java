package proyecto.pruebas;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.GuiSOS;
import proyecto.Board;
import javax.swing.JButton;
import javax.swing.JFrame;
public class TestNewGame {
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void ButtonNewGame(){
        game.init_Tablero();
        assertTrue(game.getIniGame());

    }
}

