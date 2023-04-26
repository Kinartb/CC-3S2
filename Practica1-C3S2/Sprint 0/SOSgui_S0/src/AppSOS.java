import javax.swing.*;

public class AppSOS {
    private JRadioButton sRadioButton;
    private JRadioButton oRadioButton;
    private JRadioButton simpleGameRadioButton;
    private JRadioButton generalGameRadioButton;
    private JFormattedTextField a8FormattedTextField;
    private JRadioButton sRadioButton1;
    private JRadioButton oRadioButton1;
    private JButton newGameButton;
    private JFormattedTextField blueOrRedFormattedTextField;
    private JPanel Tablero;
    private JPanel Pantalla;

    public static void main(String[] args){
        JFrame frame = new JFrame("SOS game");
        frame.setContentPane(new AppSOS().Pantalla);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
