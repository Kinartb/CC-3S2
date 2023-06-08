package proyecto.ejecucion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
//
import java.io.FileWriter;
import java.io.IOException;
//

public class GuiSOS extends JFrame {

    private JRadioButton simpleGameRadioButton;
    private JRadioButton generalGameRadioButton;
    private ButtonGroup buttonGroupSG = new ButtonGroup();
    private ButtonGroup buttonGroupSO = new ButtonGroup();
    private ButtonGroup buttonChooseGroupHPBlue = new ButtonGroup();
    private ButtonGroup buttonChooseGroupHPRed = new ButtonGroup();
    private JFormattedTextField SizeOfGameN;
    private JRadioButton SBluePlayer;
    private JRadioButton OBluePlayer;
    private JRadioButton SRedPlayer;
    private JRadioButton ORedPlayer;
    private JButton StartGame ;
    private JFormattedTextField PlayersTurn;
    private JPanel Tablero;
    public JPanel Pantalla;
    private JRadioButton HumanRed;
    private JRadioButton ComputerRed;
    private JRadioButton HumanBlue;
    private JRadioButton ComputerBlue;
    JButton[][] Slots; //Es un arreglo de botones

    private ClassScore score = new ClassScore();
    //private ClassGeneralGame scoregeneral = new ClassGeneralGame();
    ClassScore.GameFinal finalResult = score.getGameFinal();


    /////////////////////////////////////////////////////
   // int[][] info;
    private int player;
    public String letra;
    private String turn;
/////////////////////////////////////////////////////
    private boolean aux = false;
    private String modeGame;

    private boolean iniGame = false;
    private static ClassPlayer player1;
    private static ClassPlayer player2;
    private static ClassPlayer currentPlayer;
    private boolean aleatorioRealizado = false;
    private FileWriter fileWriter;

    public GuiSOS() {
        Tablero.setLayout(new GridLayout());
        SizeOfGameN.setValue(8);
        SizeOfGameN.setColumns(10);
        simpleGameRadioButton.setSelected(true);//Por defecto que este activado
        HumanBlue.setSelected(true);//Por defecto que este activado
        HumanRed.setSelected(true);//Por defecto que este activado
        buttonGroupSG.add(simpleGameRadioButton);
        buttonGroupSG.add(generalGameRadioButton);
        buttonChooseGroupHPBlue.add(HumanBlue);
        buttonChooseGroupHPRed.add(HumanRed);
        buttonChooseGroupHPBlue.add(ComputerBlue);
        buttonChooseGroupHPRed.add(ComputerRed);
        turnOFF_playerBR();
        ButtonGame();
    }
    public void ButtonGame(){
        StartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (aux) {
                    aux=false;
                    buttonGroupSG.clearSelection();
                    buttonChooseGroupHPBlue.clearSelection();
                    buttonChooseGroupHPRed.clearSelection();
                    SizeOfGameN.setEnabled(true);
                    StartGame.setText("Start");
                    simpleGameRadioButton.setEnabled(true);
                    generalGameRadioButton.setEnabled(true);
                    HumanBlue.setEnabled(true);
                    HumanRed.setEnabled(true);
                    ComputerBlue.setEnabled(true);
                    ComputerRed.setEnabled(true);
                } else {
                    aux=true;
                    StartGame.setText("New Game");
                    simpleGameRadioButton.setEnabled(true);
                    generalGameRadioButton.setEnabled(true);
                    HumanBlue.setEnabled(true);
                    HumanRed.setEnabled(true);
                    ComputerBlue.setEnabled(true);
                    ComputerRed.setEnabled(true);
                }
                //Luego
                if ((HumanBlue.isSelected() || ComputerBlue.isSelected()) &&
                        (HumanRed.isSelected() || ComputerRed.isSelected())) {
                    if (simpleGameRadioButton.isSelected()) {
                        NuevoTableroSimple();
                    } else if (generalGameRadioButton.isSelected()) {
                        NuevoTableroGeneral();
                    }
                }
            }
        });
    }
    public void NuevoTableroSimple(){
        modeGame = "Simple Game";
        PlayersTurn.setText("Blue");
        simpleGameRadioButton.setEnabled(false);
        generalGameRadioButton.setEnabled(false);
        HumanBlue.setEnabled(false);
        HumanRed.setEnabled(false);
        ComputerBlue.setEnabled(false);
        ComputerRed.setEnabled(false);
        init_Tablero();
    }
    public void NuevoTableroGeneral() {
        modeGame = "General Game";
        PlayersTurn.setText("Blue");
        simpleGameRadioButton.setEnabled(false);
        generalGameRadioButton.setEnabled(false);
        HumanBlue.setEnabled(false);
        HumanRed.setEnabled(false);
        ComputerBlue.setEnabled(false);
        ComputerRed.setEnabled(false);
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
        turn = player1.getPlayer();
    }
    public void redPlayer(){//desabilita la bluePlayer

        SBluePlayer.setEnabled(false);
        OBluePlayer.setEnabled(false);
        SRedPlayer.setEnabled(true);
        ORedPlayer.setEnabled(true);
        turn = player2.getPlayer();
    }
    public static void cambiarTurno() {
        // Cambiar al siguiente jugador
        if (currentPlayer == player2) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }
    public  void cambiarTurnoPrueba(ClassPlayer player1, ClassPlayer player2) {
        // Cambiar al siguiente jugador
        if (currentPlayer == player2) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }
    public ClassPlayer getCurrentPlayer(){
        return currentPlayer;
    }
    public String getTurn(){
        return turn;
    }
    public String getModeGame(){
        return  modeGame;
    }
    public boolean getIniGame(){
        return iniGame;
    }

    public static int[] obtenerPosicionesVacias(int[][] info) {
        ArrayList<Integer> posicionVacia = new ArrayList<>();
        int n = info.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (info[i][j] == -1) {
                    posicionVacia.add(i);
                    posicionVacia.add(j);
                }
            }
        }
        // Convertir la ArrayList a un arreglo de int[]
        int[] arregloposicionVacia = new int[posicionVacia.size()];
        for (int i = 0; i < posicionVacia.size(); i++) {
            arregloposicionVacia[i] = posicionVacia.get(i);
        }
        return arregloposicionVacia;
    }

    public int SOS_GUI(String letter, int i, int j, int[][] info, JButton[][] Slots, ClassPlayer currentPlayer){
        Color color = null;
        if (currentPlayer.getPlayer().equals("BLUE")){
                color= Color.BLUE;
        }
        else{
            color=Color.RED;
        }
        if(score.scoreSOS(letter,i,j,info) > 0) {
            painterSOS(score,color,Slots);
        }
        return score.scoreSOS(letter,i,j,info) ;
    }
    private void painterSOS(ClassScore scoreSOS, Color color, JButton[][] Slots ){
        Slots[scoreSOS.getPositionSOS()[0]][scoreSOS.getPositionSOS()[1]].setBackground(color);
        Slots[scoreSOS.getPositionSOS()[2]][scoreSOS.getPositionSOS()[3]].setBackground(color);
        Slots[scoreSOS.getPositionSOS()[4]][scoreSOS.getPositionSOS()[5]].setBackground(color);
    }

    private void simpleGame(int fil, int col, int[][] info, JButton slot, JButton[][] Slots, ClassPlayer currentPlayer) {
        if (SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer) != 0) {
            ClassSimpleGame scorePrueba = new ClassSimpleGame(score);
            scorePrueba.resultSimpleGameLogico(info, currentPlayer);
            turnOFF_playerBR();
        } else {
            ClassSimpleGame scorePrueba = new ClassSimpleGame(score);
            scorePrueba.resultSimpleGameLogico(info, currentPlayer);
        }
        cambiarTurno();
    }
    private void generalGame(int fil, int col, int[][] info, JButton slot, JButton[][] Slots, ClassPlayer currentPlayer) {
        if (currentPlayer.getPlayer().equals("BLUE")) {
            
            score.setScorePlayer2(score.getScorePlayer2() + SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer));
            if (SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer) != 0) {
                bluePlayer();
            }
        } else if (currentPlayer.getPlayer().equals("RED")) {
            score.setScorePlayer1(score.getScorePlayer1() + SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer));
            if (SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer) != 0) {
                redPlayer();
            }
        }
        if (score.fullScreen(info)) {
            ClassGeneralGame scorePrueba = new ClassGeneralGame(score);
            scorePrueba.resultGeneralGameLogico();
            turnOFF_playerBR();
        }
        if (SOS_GUI(slot.getText(), fil, col, info, Slots, currentPlayer) != 0) {
            cambiarTurno();
        }
        cambiarTurno();
    }
    public void Game(JButton slot, int n, int[][] info,JButton[][] Slots){

        slot.addActionListener(new ActionListener() { // casillero del tablero
            public void actionPerformed(ActionEvent e) {

                String texto = null;
                int fil = -1;
                int col = -1;
                if (letra != null) {
                    if (currentPlayer.getisHuman() == true) {
                        texto = slot.getText();
                        //  System.out.println(slot.getText());
                        // Cambiar el texto del botón a "S" o "O"
                        if (texto.equals("")) {
                            //System.out.println(player
                            slot.setText(letra);
                            slot.setEnabled(false);

                            if (currentPlayer.getPlayer().equals("BLUE")) {
                                PlayersTurn.setText(currentPlayer.getPlayer());
                                redPlayer();
                                buttonGroupSO.clearSelection();
                            } else {
                                PlayersTurn.setText(currentPlayer.getPlayer());
                                bluePlayer();
                                buttonGroupSO.clearSelection();
                                // player=0;
                            }
                        }
                        for (int x = 0; x < n; x++) {
                            for (int y = 0; y < n; y++) {
                                if (Slots[x][y] == slot) {
                                    fil = x;
                                    col = y;
                                    break;
                                }
                            }
                        }

                        if (slot.getText().equals("S")) {
                            ClassScore.setInfo(fil, col, 1);
                        }
                        if (slot.getText().equals("O")) {
                            ClassScore.setInfo(fil, col, 0);
                        }
                        writeMatrizInfo(info);
                        writeTurno(currentPlayer);
                        writeGanadorOEmpate();
                        if (simpleGameRadioButton.isSelected()) {
                            writeGanadorOEmpate();
                            writeMatrizInfo(info);
                            simpleGame(fil, col, info, slot, Slots, currentPlayer);
                        }
                        if (generalGameRadioButton.isSelected()) {
                            writeMatrizInfo(info);
                            generalGame(fil, col, info, slot, Slots, currentPlayer);
                        }
                    }
                    else if (currentPlayer.getisHuman() == false ) {
                        int [] almacen = obtenerPosicionesVacias(info); // 10
                        int longitud = almacen.length; //10= 2(5)
                        Random random = new Random();
                        Random letraran = new Random();
                        int indicador = random.nextInt(longitud / 2);//0,1,2,3,4
                        int fila = almacen[indicador * 2];// almacen[0,2,4,6,8]
                        int columna = almacen[indicador * 2 + 1];// almacen[1,3,5,7,9]
                        int letraaux = letraran.nextInt(2);
                        if (letraaux == 1) {
                            letra = "S";
                        } else {
                            letra = "O";
                        }
                        JButton botonAleatorio= Slots[fila][columna];
                        texto=botonAleatorio.getText();
                        if (texto.equals("")) {
                            botonAleatorio.setText(letra);
                            botonAleatorio.setEnabled(false);
                            fil = fila;
                            col = columna;
                            if (currentPlayer.getPlayer().equals("BLUE")) {
                                PlayersTurn.setText(currentPlayer.getPlayer());
                                redPlayer();
                                buttonGroupSO.clearSelection();
                            } else {
                                PlayersTurn.setText(currentPlayer.getPlayer());
                                bluePlayer();
                                buttonGroupSO.clearSelection();
                                // player=0;
                            }

                        }
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                if (Slots[i][j] == botonAleatorio) {
                                    fil = i;
                                    col = j;
                                    break;
                                }
                            }
                        }
                        if (botonAleatorio.getText().equals("S")) {
                            ClassScore.setInfo(fil, col, 1);
                        }
                        if (botonAleatorio.getText().equals("O")) {
                            ClassScore.setInfo(fil, col, 0);
                        }
                        writeMatrizInfo(ClassScore.info);
                        writeTurno(currentPlayer);
                        writeGanadorOEmpate();
                        if (simpleGameRadioButton.isSelected()) {
                            writeMatrizInfo(info);
                            simpleGame(fil, col, info, botonAleatorio, Slots, currentPlayer);
                        }
                        if (generalGameRadioButton.isSelected()) {
                            writeMatrizInfo(info);
                            generalGame(fil, col, info, botonAleatorio, Slots, currentPlayer);
                        }
                    }
                }

                SRedPlayer.setSelected(false);
                ORedPlayer.setSelected(false);
                SBluePlayer.setSelected(false);
                OBluePlayer.setSelected(false);
                letra =null;

            }
        });


    }
    public int SizeN(int n){
        if (n < 3 || n > 16) {
            JOptionPane.showMessageDialog(null, "La dimension debe estar entre 3 y 16",
                    "Error", JOptionPane.ERROR_MESSAGE);
            SizeOfGameN.setEnabled(false);
            return n+1;//Solo es para que se cumpla la condicion dentro de init_tablero
        }else{
            return n;
        }
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
            try {
                fileWriter = new FileWriter("JuegoSOSregistro.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (HumanBlue.isSelected()) {
                player1 = new ClassPlayer("BLUE", true);
            } else if (ComputerBlue.isSelected()) {
                player1 = new ClassPlayer("BLUE", false);
            }
            if (HumanRed.isSelected()) {
                player2 = new ClassPlayer("RED", true);
            } else if (ComputerRed.isSelected()) {
                player2 = new ClassPlayer("RED", false);
            }
            writeSeparador();
            writeIniciarArchivo(player1,player2);
            writeLongitudTablero(n);
            writeTipoDeJuego(modeGame);
            writeSeparador();
            currentPlayer=player1;
            Tablero.setLayout(new GridLayout(n, n));
            Slots = new JButton[n][n];
            ClassScore.info = new int[n][n];
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
                public void actionPerformed(ActionEvent e) {letra = "O";}
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
                    ClassScore.setInfo(i,j,-1);//vacios
                    bluePlayer();
                    //Colocamos esta instruccion para que el jugador Blue empiece primero
                    Game(slot,n,ClassScore.info,Slots);


                    Tablero.add(slot);
                    StartGame.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            turnOFF_playerBR();
                        }
                    });
                }

            }
            writeSeparador();



            Tablero.revalidate();
            Tablero.repaint();
        }

    }
    private void writeIniciarArchivo(ClassPlayer player1,ClassPlayer player2){
        try{
            if(player1.getisHuman()==true) {
                fileWriter.write("Player "+player1.getPlayer() +" es un humano" + "\n");
            }else if(player1.getisHuman()==false){
                fileWriter.write("Player "+player1.getPlayer() +" es una  maquina" + "\n");
            }
            if(player2.getisHuman()==true) {
                fileWriter.write("Player "+player2.getPlayer() +" es un humano" + "\n");
            }else if(player2.getisHuman()==false){
                fileWriter.write("Player "+player2.getPlayer() +" es una  maquina" + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void writeLongitudTablero(int n ){
        try{
            fileWriter.write(" El tablero es de dimension: "+n+ "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void writeTurno(ClassPlayer currentPlayer){
        try{
            fileWriter.write("El turno actual es de: " + currentPlayer.getPlayer() + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void writeTipoDeJuego(String modeGame){
        try{
            if(modeGame == "Simple Game") {
                fileWriter.write("El modo de juego es "+ modeGame +"\n");
            }else if(modeGame == "General Game"){
                fileWriter.write("El modo de juego es "+ modeGame +"\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void writeMatrizInfo(int [][]info){
        try{
            fileWriter.write("El tablero: "+"\n");
            for (int i = 0; i < info.length; i++) {
                for (int j = 0; j < info[i].length; j++) {
                    if(info[i][j]==-1){
                        fileWriter.write(" - " + "  ");
                    }if(info[i][j]==0){
                        fileWriter.write(" O " + "  ");
                    }if(info[i][j]==1){
                        fileWriter.write(" S " + "  ");
                    }
                }
                fileWriter.write("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void writeGanadorOEmpate(){
        try{
            fileWriter.write(" El ganador es: "+ finalResult +"\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void writeSeparador(){
        try{
            fileWriter.write("//////////////////////////////////////////////////"+"\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void CerrarArchivoWriter() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
