package proyecto.pruebas;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.ejecucion.ClassPlayer;
import proyecto.ejecucion.GuiSOS;

import javax.swing.*;

public class TestHumanFinishGeneralGame {
    private GuiSOS game;
    private ClassPlayer player1;
    private ClassPlayer player2;
    private ClassPlayer currentPlayer;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();
        player1 = new ClassPlayer("BLUE", true);
        player2 = new ClassPlayer("RED", true);
        currentPlayer = player1;
        game.NuevoTableroGeneral();

    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void SOS_WinBlue(){
        int[][] info = new int[3][3];
        JButton[][] Slots = new JButton[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                info[i][j]= -1;
                JButton slot = new JButton();
                Slots[i][j] = slot;
            }
        }
        info[0][0]=1; info[0][1]=0; info[0][2]=1;
        info[1][0]=1; info[1][1]=1; info[1][2]=1;
        info[2][0]=1; info[2][1]=1; info[2][2]=1;

        //assertEquals("BLUE IS THE WINNER",1,game.SOS_GUI("S", 2, 2, info, Slots, currentPlayer));
    }
    @Test
    public void SOS_WinRed(){
        int[][] info = new int[3][3];
        JButton[][] Slots = new JButton[3][3];

        for(int i=0;i< info.length;i++){
            for(int j=0;j< info.length;j++){
                info[i][j]= -1;
                JButton slot = new JButton();
                Slots[i][j] = slot;
            }
        }
        info[0][0]=0; info[0][1]=1; info[0][2]=0;
        info[1][0]=0; info[1][1]=0; info[1][2]=0;
        info[2][0]=0; info[2][1]=1; info[2][2]=0;
        //assertEquals("RED IS THE WINNER",1,  game.SOS_GUI("S", 2, 2, info, Slots, currentPlayer));

    }
    @Test
    public void SOS_Draw(){
        int[][] info = new int[3][3];
        JButton[][] Slots = new JButton[3][3];

        for(int i=0;i< info.length;i++){
            for(int j=0;j< info.length;j++){
                info[i][j]= -1;
                JButton slot = new JButton();
                Slots[i][j] = slot;
            }
        }
        info[0][0]=0; info[0][1]=0; info[0][2]=0;
        info[1][0]=0; info[1][1]=0; info[1][2]=0;
        info[2][0]=0; info[2][1]=0; info[2][2]=0;
        assertEquals("DRAW",0,  game.SOS_GUI("O", 2, 2, info, Slots, currentPlayer));


    }
}