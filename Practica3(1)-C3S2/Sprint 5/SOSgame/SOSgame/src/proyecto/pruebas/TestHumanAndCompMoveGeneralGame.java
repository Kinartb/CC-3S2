package proyecto.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proyecto.ejecucion.ClassPlayer;
import proyecto.ejecucion.GuiSOS;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class TestHumanAndCompMoveGeneralGame {
    private ClassPlayer player1;
    private ClassPlayer player2;
    private ClassPlayer currentPlayer;
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
        player1 = new ClassPlayer("BLUE", false);
        player2 = new ClassPlayer("RED", true);
        currentPlayer = player1;
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void SOS_MoveGeneral_Humans_and_Computer(){

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
        info[0][0]=1;
        game.redPlayer();
        info[0][1]=0;
        game.bluePlayer();
        info[0][2]=1;
        game.bluePlayer();
        info[1][2]=1;

        assertEquals("BLUE",game.getTurn());
    }
}
