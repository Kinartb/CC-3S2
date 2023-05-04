package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiSOS extends JFrame {

    private JRadioButton simpleGameRadioButton;
    private JRadioButton generalGameRadioButton;

    private ButtonGroup buttonGroupSG = new ButtonGroup();
    private ButtonGroup buttonGroupSO = new ButtonGroup();
    private JFormattedTextField SizeOfGameN;
    private JRadioButton SBluePlayer;
    private JRadioButton OBluePlayer;
    private JRadioButton SRedPlayer;
    private JRadioButton ORedPlayer;
    private JButton StartGame ;
    private JFormattedTextField PlayersTurn;
    private JPanel Tablero;
    JPanel Pantalla;
    JButton[][] Slots; //Es un arreglo de botones
    int[][] info;
    int player;
    private String letra;
    private boolean aux;
    private boolean iniGame = false;
    private String modeGame;

    public int SizeN(int n){
        if (n < 3 || n > 16) {
            JOptionPane.showMessageDialog(null, "La dimension debe estar entre 3 y 16", "Error", JOptionPane.ERROR_MESSAGE);
            SizeOfGameN.setEnabled(false);
            return n+1;//Solo es para que se cumpla la condicion dentro de init_tablero
        }else{
            return n;
        }

    }


    public GuiSOS() {
        /*NewGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"prueba");
            }
        });*/

        Tablero.setLayout(new GridLayout());
        SizeOfGameN.setValue(8);
        SizeOfGameN.setColumns(10);
        simpleGameRadioButton.setSelected(true);//Por defecto que este activado
        buttonGroupSG.add(simpleGameRadioButton);
        buttonGroupSG.add(generalGameRadioButton);
        SBluePlayer.setEnabled(false);
        OBluePlayer.setEnabled(false);
        SRedPlayer.setEnabled(false);
        ORedPlayer.setEnabled(false);
        StartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (aux) {
                    aux=false;
                    buttonGroupSG.clearSelection();
                    SizeOfGameN.setEnabled(true);
                    StartGame.setText("Start");
                    simpleGameRadioButton.setEnabled(true);
                    generalGameRadioButton.setEnabled(true);


                } else {
                    aux=true;
                    StartGame.setText("New Game");
                    simpleGameRadioButton.setEnabled(true);
                    generalGameRadioButton.setEnabled(true);

                }
                if (simpleGameRadioButton.isSelected()) {

                    NuevoTableroSimple();
                } else if (generalGameRadioButton.isSelected()) {

                    NuevoTableroGeneral();

                }
            }
        });

    }
    public void NuevoTableroSimple(){
        modeGame = "Simple Game";
        PlayersTurn.setText("Blue");
        simpleGameRadioButton.setEnabled(false);
        generalGameRadioButton.setEnabled(false);
        init_Tablero();

    }
    public void NuevoTableroGeneral(){
        modeGame = "General Game";
        PlayersTurn.setText("Blue");
        simpleGameRadioButton.setEnabled(false);
        generalGameRadioButton.setEnabled(false);
        init_Tablero();
    }


    public void bluePlayer(){

        SRedPlayer.setEnabled(false);
        ORedPlayer.setEnabled(false);
        SBluePlayer.setEnabled(true);
        OBluePlayer.setEnabled(true);

    }


    public void redPlayer(){

        SBluePlayer.setEnabled(false);
        OBluePlayer.setEnabled(false);
        SRedPlayer.setEnabled(true);
        ORedPlayer.setEnabled(true);
    }

    public boolean getIniGame(){return iniGame;}

    public String getModeGame(){ return  modeGame; }

    public void init_Tablero() {
        iniGame = true;
        SBluePlayer.setEnabled(true);
        OBluePlayer.setEnabled(true);
        SRedPlayer.setEnabled(true);
        ORedPlayer.setEnabled(true);
        Tablero.removeAll();
        int n = ((Integer) SizeOfGameN.getValue());
        if(SizeN(n)==n){
            Tablero.setLayout(new GridLayout(n, n));
            Slots = new JButton[n][n];
            info = new int[n][n];
            SizeOfGameN.setEnabled(false);

            //simpleGameRadioButton.setVisible(false);
            simpleGameRadioButton.setEnabled(false);

            buttonGroupSO.add(SBluePlayer);
            buttonGroupSO.add(OBluePlayer);
            buttonGroupSO.add(SRedPlayer);
            buttonGroupSO.add(ORedPlayer);

            SBluePlayer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    letra = "S";
                }
            });
            SRedPlayer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    letra = "S";
                }
            });
            OBluePlayer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    letra = "O";
                }
            });
            ORedPlayer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    letra = "O";
                }
            });
            player = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    JButton slot = new JButton();//Es un boton
                    // slot.setForeground(Color.BLACK);
                    // slot.setBackground(Color.ORANGE);
                    slot.setFont(new Font("cooper black", Font.BOLD, 40));
                    slot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    Slots[i][j] = slot;
                    info[i][j] = -1;//vacios
                    bluePlayer();
                    slot.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (letra != null) {
                                String texto = slot.getText();
                                // Cambiar el texto del botón a "S" o "O"
                                if (texto.equals("")) {
                                    slot.setText(letra);
                                    slot.setEnabled(false);
                                    if (player == 0) {
                                        PlayersTurn.setText("Red");
                                        redPlayer();
                                        buttonGroupSO.clearSelection();
                                    } else {
                                        PlayersTurn.setText("Blue");
                                        bluePlayer();
                                        buttonGroupSO.clearSelection();
                                    }
                                    player = (player + 1) % 2;
                                }

                                int fil = -1;
                                int col = -1;
                                for (int i = 0; i < n; i++) {
                                    for (int j = 0; j < n; j++) {
                                        if (Slots[i][j] == slot) {
                                            fil = i;
                                            col = j;
                                            break;
                                        }
                                    }
                                }
                                info[fil][col] = 1;

                            }
                            SRedPlayer.setSelected(false);
                            ORedPlayer.setSelected(false);
                            SBluePlayer.setSelected(false);
                            OBluePlayer.setSelected(false);
                            letra = null;
                        }

                    });
                    Tablero.add(slot);

                }

            }

            Tablero.revalidate();
            Tablero.repaint();
        }
    }

}
