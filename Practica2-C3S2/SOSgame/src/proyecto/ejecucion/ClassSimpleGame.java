package proyecto.ejecucion;
import proyecto.ejecucion.ClassScore;

import javax.swing.*;

public class ClassSimpleGame extends ClassScore {

    ClassScore score;

    public ClassSimpleGame(ClassScore score) {

        this.score = score;
    }

    public void resultSimpleGameLogico(int[][] info, ClassPlayer currentPlayer) {
        if (!fullScreen(info)) {
            if (currentPlayer.getPlayer().equals("BLUE") && getcantSOS() != 0) {
                JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                setGameFinal(GameFinal.BLUE_WIN);
            }
            if (currentPlayer.getPlayer().equals("RED") && getcantSOS() != 0) {
                JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                setGameFinal(GameFinal.RED_WIN);
            }
        }
        if (fullScreen(info)) {
            JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.DRAW);
        }
    }
}



