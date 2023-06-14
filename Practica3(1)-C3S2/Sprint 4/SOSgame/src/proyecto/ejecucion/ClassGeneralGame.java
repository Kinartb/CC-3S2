package proyecto.ejecucion;
import javax.swing.*;

public class ClassGeneralGame extends ClassScore {

    ClassScore score ;
    public ClassGeneralGame(ClassScore score){

             this.score = score;
    }
    public void resultGeneralGameLogico() {
        if (score.getScorePlayer1() < score.getScorePlayer2()) {
            JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.RED_WIN);
        } else if (score.getScorePlayer2() < score.getScorePlayer1()) {
            JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.BLUE_WIN);
        } else {
            JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
            setGameFinal(GameFinal.DRAW);
        }
    }
        public void generalGame(String letter, int fil, int col, int[][] info, ClassPlayer currentPlayer) {
            if (currentPlayer.getPlayer().equals("BLUE")) {
                score.setScorePlayer2(getScorePlayer2() + scoreSOS(letter, fil, col, info));
            } else if (currentPlayer.getPlayer().equals("RED")) {
                score.setScorePlayer1(getScorePlayer1() + scoreSOS(letter, fil, col, info));
            }
            if (fullScreen(info)) {
                resultGeneralGameLogico();
            }
            if (scoreSOS(letter, fil, col, info) != 0) {
                GuiSOS.cambiarTurno();
            }
            GuiSOS.cambiarTurno();
        }
    }


