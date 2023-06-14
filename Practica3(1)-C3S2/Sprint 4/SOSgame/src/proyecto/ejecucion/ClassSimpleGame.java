package proyecto.ejecucion;
import proyecto.ejecucion.ClassScore;

import javax.swing.*;

public class ClassSimpleGame extends ClassScore {

    ClassScore score ;
    public  ClassSimpleGame(ClassScore score){

        this.score = score;
    }
    public void resultSimpleGameLogico(int[][] info, ClassPlayer currentPlayer) {
        if (!fullScreen(info)) {
            if (currentPlayer.getPlayer().equals("BLUE") && score.getcantSOS() != 0) {
                JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                setGameFinal(GameFinal.BLUE_WIN);
            }
            if (currentPlayer.getPlayer().equals("RED") && score.getcantSOS() != 0) {
                JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                setGameFinal(GameFinal.RED_WIN);
            }
        }
        if (fullScreen(info)) {
            JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.DRAW);
        }
    }



        public void simpleGameLogico(String letter, int fil, int col, int[][] info, ClassPlayer currentPLayer) {
            if (scoreSOS(letter, fil, col, info) != 0) {
                resultSimpleGameLogico(info, currentPLayer);
            } else {
                resultSimpleGameLogico(info, currentPLayer);
            }
            GuiSOS.cambiarTurno();
        }
}


