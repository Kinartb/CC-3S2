package proyecto;


import javax.swing.*;

public class Board {

    public static void main(String[] args){
        JFrame frame = new JFrame("SOS game");
        frame.setContentPane(new GuiSOS().Pantalla);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,600);
        frame.setLocation(500,100);
        frame.setVisible(true);
    }
}