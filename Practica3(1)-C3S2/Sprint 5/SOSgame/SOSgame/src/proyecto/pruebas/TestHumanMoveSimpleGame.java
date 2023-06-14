package proyecto.pruebas;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.ejecucion.ClassPlayer;
import proyecto.ejecucion.GuiSOS;

import javax.swing.*;

public class TestHumanMoveSimpleGame {
    private ClassPlayer player1;
    private ClassPlayer player2;
    private ClassPlayer currentPlayer;
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
        player1 = new ClassPlayer("BLUE", true);
        player2 = new ClassPlayer("RED", true);
        currentPlayer = player1;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void SOS_MoveSimple_Humans(){

        int[][] info = new int[3][3];
        JButton[][] Slots = new JButton[3][3];


        for(int i=0;i< info.length;i++){
            for(int j=0;j< info.length;j++){
                info[i][j]= -1;
                JButton slot = new JButton();
                Slots[i][j] = slot;
            }
        }
        game.bluePlayer();
        info[0][0]=0;
        game.redPlayer();
        info[0][1]=1;

        assertEquals("RED",game.getTurn());
    }
}
