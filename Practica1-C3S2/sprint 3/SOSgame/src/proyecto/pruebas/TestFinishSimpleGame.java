package proyecto.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.GuiSOS;
import proyecto.Board;

import javax.swing.*;

public class TestFinishSimpleGame {
    private GuiSOS game;

    @Before
    public void setUp() throws Exception {
        game = new GuiSOS();

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
        info[2][2]=1;
        info[1][1]=0;
        info[0][0]=1;
        assertEquals("BLUE IS THE WINNER",1,game.SOS("S", 0, 0, info, Slots, 0));
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
        info[1][0]=1;
        info[1][2]=0;
        info[2][2]=1;
        info[0][2] =1;

        assertEquals("RED IS THE WINNER",1,  game.SOS("S", 0, 2, info, Slots, 1));

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
        info[0][0]=0;
        info[0][1]=0;
        info[0][2]=0;
        info[1][0]=0;
        info[1][1]=0;
        info[1][2]=0;
        info[2][0]=0;
        info[2][1]=0;
        info[2][2]=0;

        assertEquals("DRAW",0,  game.SOS("O", 2, 2, info, Slots, 0));


    }
}
