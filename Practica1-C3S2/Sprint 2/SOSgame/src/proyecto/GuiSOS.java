package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiSOS extends JFrame {
    private int n;
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
    JButton[][] Slots;
    int[][] info;
    int player;
    String letra;



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
                StartGame.setText("New Game");
                if(simpleGameRadioButton.isSelected()) {
                    NuevoTableroSimple();
                } else if (generalGameRadioButton.isSelected()) {
                    NuevoTableroGeneral();
                    
                }
            }
        });

    }
    public void NuevoTableroSimple(){
        PlayersTurn.setText("Blue");
        init_Tablero();

        /*SBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bluePlayer();
            }
        });
        OBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bluePlayer();
            }
        });
        SRedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redPlayer();
            }
        });
        ORedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redPlayer();
            }
        });*/
    }

    public void NuevoTableroGeneral(){
        PlayersTurn.setText("Blue");
        init_Tablero();
        /*
        SBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bluePlayer();
            }
        });
        OBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bluePlayer();
            }
        });
        SRedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redPlayer();
            }
        });
        ORedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redPlayer();
            }
        });
    */
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

    public void init_Tablero(){
        SBluePlayer.setEnabled(true);
        OBluePlayer.setEnabled(true);
        SRedPlayer.setEnabled(true);
        ORedPlayer.setEnabled(true);
        Tablero.removeAll();
        n=((Integer)SizeOfGameN.getValue());

        SizeOfGameN.setEnabled(false);
        //simpleGameRadioButton.setVisible(false);
        simpleGameRadioButton.setEnabled(false);
        buttonGroupSO.add(SBluePlayer);
        buttonGroupSO.add(OBluePlayer);
        buttonGroupSO.add(SRedPlayer);
        buttonGroupSO.add(ORedPlayer);
        SBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letra="S";
            }
        });
        SRedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letra="S";
            }
        });
        OBluePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letra="O";
            }
        });
        ORedPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                letra="O";
            }
        });
        Tablero.setLayout(new GridLayout(n,n));
        Slots=new JButton[n][n];
        info=new int[n][n];
        player=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JButton slot = new JButton();
                slot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                Slots[i][j] = slot;
                info[i][j] = -1;
                slot.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (letra != null){
                            String texto = slot.getText();
                            // Cambiar el texto del botón a "S" o "O"
                            if (texto.equals("")) {
                                slot.setText(letra);
                                slot.setEnabled(false);
                                if (player == 0) {
                                    PlayersTurn.setText("Red");
                                    redPlayer();

                                } else {
                                    PlayersTurn.setText("Blue");
                                    bluePlayer();

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
                    }

                });
                Tablero.add(slot);
            }
        }

        Tablero.revalidate();
        Tablero.repaint();
    }

}
