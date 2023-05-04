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
    public JPanel Pantalla;
    JButton[][] Slots; //Es un arreglo de botones
    int[][] info;
    private int player;
    public String letra;
    private boolean aux = false;
    private int cont1=0;
    private int cont2=0;

    public enum GameFinal {BLUE_WIN, DRAW, RED_WIN}
    private GameFinal finalResult ;
    private String turn;

    private String modeGame;

    private boolean iniGame = false;



    public GuiSOS() {


        Tablero.setLayout(new GridLayout());
        SizeOfGameN.setValue(8);
        SizeOfGameN.setColumns(10);
        simpleGameRadioButton.setSelected(true);//Por defecto que este activado
        buttonGroupSG.add(simpleGameRadioButton);
        buttonGroupSG.add(generalGameRadioButton);
        turnOFF_playerBR();

        ButtonGame();

    }
    public void ButtonGame(){

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
                //Luego
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
    public void NuevoTableroGeneral() {
        modeGame = "General Game";
        PlayersTurn.setText("Blue");
        simpleGameRadioButton.setEnabled(false);
        generalGameRadioButton.setEnabled(false);
        init_Tablero();
    }

    public void turnOFF_playerBR(){//Cuando alguien gana o hay empate o eligio dimension fuer del rango
        SRedPlayer.setEnabled(false);
        ORedPlayer.setEnabled(false);
        SBluePlayer.setEnabled(false);
        OBluePlayer.setEnabled(false);
    }
    public void bluePlayer(){//desabilita- la redPlayer

        SRedPlayer.setEnabled(false);
        ORedPlayer.setEnabled(false);
        SBluePlayer.setEnabled(true);
        OBluePlayer.setEnabled(true);
        turn = "Blue turn";

    }
    public void redPlayer(){//desabilita la bluePlayer

        SBluePlayer.setEnabled(false);
        OBluePlayer.setEnabled(false);
        SRedPlayer.setEnabled(true);
        ORedPlayer.setEnabled(true);
        turn = "Red turn";
    }

    public String getTurn(){ return turn; }
    public String getModeGame(){ return  modeGame; }

    public boolean getIniGame(){return iniGame;}
    public boolean fullScreen(int[][] matriz){
        for(int i=0;i< matriz.length;i++){
            for(int j=0;j< matriz.length;j++){
                if (info[i][j]==-1){
                    return false;
                }
            }
        }
        return true;
    }



    public int SOS(String letter, int i, int j, int[][] info, JButton[][] Slots, int jugador){
        int k=0;
        Color color = null;
        if (jugador==0){
                color= Color.BLUE;
        }
        else{
            color=Color.RED;
        }

        if (letter.equals("S")){
            if(i <= info.length-3 && j <= info.length-3){
                if( info[i][j]==1 && info[i+1][j+1]==0 && info[i+2][j+2]==1 ) {
                    k = k + 1;
                    Slots[i][j].setBackground(color);        // S
                    Slots[i + 1][j + 1].setBackground(color);//    O
                    Slots[i + 2][j + 2].setBackground(color);//       S
                }
            }if(j <= info.length-3){
                if( info[i][j]==1 && info[i][j+1]==0 && info[i][j+2]==1){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i][j+1].setBackground(color);
                    Slots[i][j+2].setBackground(color);
                }
            }if(i <= info.length-3){
                if(info[i][j]==1 && info[i+1][j]==0 && info[i+2][j]==1){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i+1][j].setBackground(color);
                    Slots[i+2][j].setBackground(color);
                }
            }if(i>=2 && j>=2){
                if(info[i][j]==1 && info[i-1][j-1]==0 && info[i-2][j-2]==1 ){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i-1][j-1].setBackground(color);
                    Slots[i-2][j-2].setBackground(color);
                }
            }if(j>=2){
                if(info[i][j]==1 && info[i][j-1]==0 && info[i][j-2]==1){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i][j-1].setBackground(color);
                    Slots[i][j-2].setBackground(color);
                }
            }if(i>=2 && j<= info.length-3){
                if(info[i][j]==1 && info[i-1][j+1]==0 && info[i-2][j+2]==1){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i-1][j+1].setBackground(color);
                    Slots[i-2][j+2].setBackground(color);
                }
            }if(j>=2 && i <= info.length-3){
                if( info[i][j]==1 && info[i+1][j-1]==0 && info[i+2][j-2]==1 ){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i+1][j-1].setBackground(color);
                    Slots[i+2][j-2].setBackground(color);
                }
            }if(i>=2){
                if(info[i][j]==1 && info[i-1][j]==0 && info[i-2][j]==1){
                    k=k+1;
                    Slots[i][j].setBackground(color);
                    Slots[i-1][j].setBackground(color);
                    Slots[i-2][j].setBackground(color);
                }
            }

        }if(letter.equals("O")){

            if(i>=1 && j>=1 && i <= info.length-2 && j <= info.length-2) {

                if (info[i + 1][j - 1] == 1 && info[i][j] == 0 && info[i - 1][j + 1] == 1) {
                    k = k + 1;

                    Slots[i - 1][j + 1].setBackground(color);  //        S
                    Slots[i][j].setBackground(color);          //     O
                    Slots[i + 1][j - 1].setBackground(color);  // S

                }
            }if(i>=1 && j>=1 && i <= info.length-2 && j <= info.length-2){
                if (info[i - 1][j - 1] == 1 && info[i][j] == 0 && info[i + 1][j + 1] == 1) {
                    k = k + 1;
                    Slots[i - 1][j - 1].setBackground(color); //  S
                    Slots[i][j].setBackground(color);         //     O
                    Slots[i + 1][j + 1].setBackground(color); //        S
                }
            }
            if(j>= 1 && j <= info.length-2) {
                if (info[i][j - 1] == 1 && info[i][j] == 0 && info[i][j + 1] == 1) {
                    k = k + 1;
                    Slots[i][j - 1].setBackground(color);
                    Slots[i][j].setBackground(color);
                    Slots[i][j + 1].setBackground(color);
                    // S    O    S
                }
            }
            if(i>=1 &&  i <= info.length-2) {
                if (info[i - 1][j] == 1 && info[i][j] == 0 && info[i + 1][j] == 1) {
                    k = k + 1;
                    Slots[i - 1][j].setBackground(color); // S
                    Slots[i][j].setBackground(color);     // O
                    Slots[i + 1][j].setBackground(color); // S
                }
            }
            return k;
        }
        return k;
    }
    public void Game(JButton slot, int n, int[][] info,JButton[][] Slots){

        slot.addActionListener(new ActionListener() { // casillero del tablero
            public void actionPerformed(ActionEvent e) {
                if (letra != null) {
                    String texto = slot.getText();
                  //  System.out.println(slot.getText());
                    // Cambiar el texto del botón a "S" o "O"
                    if (texto.equals("")) {
                        //System.out.println(player);

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
                           // player=0;
                        }

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

                    if (slot.getText().equals("S")){
                        info[fil][col] = 1;
                    }if(slot.getText().equals("O")){
                        info[fil][col] = 0;
                    }
                    if (simpleGameRadioButton.isSelected()) {
                        if (SOS(slot.getText(), fil, col, info, Slots, player) != 0) {

                            if (player == 0) {
                                JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                                setGameFinal(GameFinal.BLUE_WIN);
                            } else {

                                JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                                setGameFinal(GameFinal.RED_WIN);
                            }
                            turnOFF_playerBR();
                        }
                        else {

                            if (fullScreen(info)) {
                                JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
                                setGameFinal(GameFinal.DRAW);
                                turnOFF_playerBR();
                            }
                        }
                        player = (player + 1) % 2 ;
                    }
                    if(generalGameRadioButton.isSelected()){

                        if (player==0) {
                            cont2 = (SOS(slot.getText(), fil, col, info, Slots, player)) + cont2;
                            if(SOS(slot.getText(), fil, col, info, Slots, player)!=0){
                                bluePlayer();
                            }

                        }else if(player==1) {
                            cont1 = (SOS(slot.getText(), fil, col, info, Slots, player)) + cont1;
                            if(SOS(slot.getText(), fil, col, info, Slots, player)!=0){
                                redPlayer();
                            }
                        }
                        if(fullScreen(info)) {
                            if (cont1 < cont2) {
                                JOptionPane.showMessageDialog(null, "BLUE IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                                turnOFF_playerBR();
                            } else if (cont2 < cont1) {
                                JOptionPane.showMessageDialog(null, "RED IS THE WINNER", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
                                turnOFF_playerBR();
                            } else {
                                JOptionPane.showMessageDialog(null, "DRAW", "Play one more time", JOptionPane.INFORMATION_MESSAGE);
                                turnOFF_playerBR();
                            }
                        }
                        if (SOS(slot.getText(), fil, col, info, Slots, player) != 0) {
                            player=player-1;
                        }
                        player = (player + 1) % 2;
                    }
                }
                SRedPlayer.setSelected(false);
                ORedPlayer.setSelected(false);
                SBluePlayer.setSelected(false);
                OBluePlayer.setSelected(false);
                letra = null;
            }

        });

    }

    public int SizeN(int n){
        if (n < 3 || n > 16) {
            JOptionPane.showMessageDialog(null, "La dimension debe estar entre 3 y 16", "Error", JOptionPane.ERROR_MESSAGE);
            SizeOfGameN.setEnabled(false);
            return n+1;//Solo es para que se cumpla la condicion dentro de init_tablero
        }else{
            return n;
        }

    }
    public GameFinal getGameFinal() {
        return finalResult;
    }
    public void setGameFinal(GameFinal finalResult)
    {
        this.finalResult = finalResult;
    }
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
           // System.out.println(info.length);
            SizeOfGameN.setEnabled(false);

           // simpleGameRadioButton.setEnabled(false);
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
                    bluePlayer(); //Colocamos esta instruccion para que el jugador Blue empiece primero

                    Game(slot,n,info,Slots);

                    Tablero.add(slot);
                    StartGame.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            turnOFF_playerBR();
                        }
                    });

                }

            }

            Tablero.revalidate();
            Tablero.repaint();
        }
    }

}
