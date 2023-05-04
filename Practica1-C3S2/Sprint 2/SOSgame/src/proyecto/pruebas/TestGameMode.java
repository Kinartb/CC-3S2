package proyecto.pruebas;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.GuiSOS;
import proyecto.Board;

import javax.swing.*;

public class TestGameMode {
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void SOS_GameModeSimpleGame(){
        game.NuevoTableroSimple();
        assertEquals("Simple Game",game.getModeGame());

    }

    @Test
    public void SOS_GameModeGeneralGame(){
        game.NuevoTableroGeneral();
        assertEquals("General Game",game.getModeGame());

    }
}
