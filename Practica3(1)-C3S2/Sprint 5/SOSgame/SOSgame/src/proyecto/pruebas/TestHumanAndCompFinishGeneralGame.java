package proyecto.pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import proyecto.ejecucion.*;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class TestHumanAndCompFinishGeneralGame {
    private ClassScore score;
    private ClassPlayer player1;
    private ClassPlayer player2;
    private ClassGeneralGame general;

    @Before
    public void setUp() throws Exception {
        score = new ClassScore();
        player1 = new ClassPlayer("BLUE", true);
        player2 = new ClassPlayer("RED", false);
        general = new ClassGeneralGame(score);



    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void SOS_WinBlue_Human_Compu(){


        ClassScore.info = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ClassScore.setInfo(i,j,-1);

            }
        }
        ClassScore.setInfo(0,0,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",0,0,ClassScore.info));
        ClassScore.setInfo(0,1,0);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("O",0,1,ClassScore.info));
        ClassScore.setInfo(0,2,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",0,2,ClassScore.info));
        ClassScore.setInfo(1,0,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",1,0,ClassScore.info));
        ClassScore.setInfo(1,1,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",1,1,ClassScore.info));
        ClassScore.setInfo(1,2,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",1,2,ClassScore.info));
        ClassScore.setInfo(2,0,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",2,0,ClassScore.info));
        ClassScore.setInfo(2,1,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",2,1,ClassScore.info));
        ClassScore.setInfo(2,2,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",2,2,ClassScore.info));


        general.resultGeneralGameLogico();



        assertEquals("BLUE IS THE WINNER", ClassScore.GameFinal.BLUE_WIN,general.getGameFinal());
    }
    @Test
    public void SOS_WinRed_Human_Compu(){
        ClassScore.info = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ClassScore.setInfo(i,j,-1);

            }
        }
        ClassScore.setInfo(0,0,0);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",0,0,ClassScore.info));
        ClassScore.setInfo(0,1,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("O",0,1,ClassScore.info));
        ClassScore.setInfo(0,2,0);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",0,2,ClassScore.info));
        ClassScore.setInfo(1,0,0);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",1,0,ClassScore.info));
        ClassScore.setInfo(1,1,0);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",1,1,ClassScore.info));
        ClassScore.setInfo(1,2,0);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",1,2,ClassScore.info));
        ClassScore.setInfo(2,0,0);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",2,0,ClassScore.info));
        ClassScore.setInfo(2,1,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",2,1,ClassScore.info));
        ClassScore.setInfo(2,2,0);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",2,2,ClassScore.info));


        general.resultGeneralGameLogico();



        assertEquals("RED IS THE WINNER", ClassScore.GameFinal.RED_WIN,general.getGameFinal());

    }
    @Test
    public void SOS_Draw_Human_Compu(){
        ClassScore.info = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ClassScore.setInfo(i,j,-1);

            }
        }
        ClassScore.setInfo(0,0,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",0,0,ClassScore.info));
        ClassScore.setInfo(1,1,0);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("O",1,1,ClassScore.info));
        ClassScore.setInfo(2,2,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",2,2,ClassScore.info));
        ClassScore.setInfo(2,0,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",2,0,ClassScore.info));
        ClassScore.setInfo(0,2,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",0,2,ClassScore.info));
        ClassScore.setInfo(0,1,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",0,1,ClassScore.info));
        ClassScore.setInfo(2,1,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",2,1,ClassScore.info));
        ClassScore.setInfo(1,0,1);
        score.setScorePlayer1(score.getScorePlayer1()+score.scoreSOS("S",1,1,ClassScore.info));
        ClassScore.setInfo(1,2,1);
        score.setScorePlayer2(score.getScorePlayer2()+score.scoreSOS("S",1,2,ClassScore.info));


        general.resultGeneralGameLogico();



        assertEquals("EMPATE", ClassScore.GameFinal.DRAW,general.getGameFinal());


    }
}
