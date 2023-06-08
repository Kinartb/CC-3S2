package proyecto.ejecucion;
import javax.swing.*;

public class ClassGeneralGame extends ClassScore {

    ClassScore score ;
    public ClassGeneralGame(ClassScore score){

             this.score = score;
    }
    public void resultGeneralGameLogico() {
        if (score.getScorePlayer1() < score.getScorePlayer2()) {
            JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.BLUE_WIN);
        } else if (score.getScorePlayer2() < score.getScorePlayer1()) {
            JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.RED_WIN);
        } else {
            JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.DRAW);
        }
    }
}


