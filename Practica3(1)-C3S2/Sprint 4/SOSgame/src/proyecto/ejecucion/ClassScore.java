package proyecto.ejecucion;

public class ClassScore {
    public static int[][] info ;
    private final int[] positionSOS=new int[6];
    private int scorePlayer1;
    private int scorePlayer2;
    private static int cantSOS;

    public ClassScore() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
       // cantSOS=0;

    }
    public int[] getPositionSOS(){return positionSOS;}
    public enum GameFinal {BLUE_WIN, DRAW, RED_WIN}
    private GameFinal finalResult ;
    public int getScorePlayer1() {
        return scorePlayer1;
    }
    public int getScorePlayer2() {
        return scorePlayer2;
    }
    public void setScorePlayer1(int score) {scorePlayer1 = score;}
    public void setScorePlayer2(int score) {
        scorePlayer2 = score;
    }
    public GameFinal getGameFinal() {
        return finalResult;
    }
    public void setGameFinal(GameFinal finalResult)
    {
        this.finalResult = finalResult;
    }
    public static void setInfo(int i, int j, int valor){ info[i][j]=valor;}

    public int scoreSOS(String letter, int i, int j, int[][] info){
        cantSOS=0;
        if (letter.equals("S")){
            if(i <= info.length-3 && j <= info.length-3){
                if( info[i][j]==1 && info[i+1][j+1]==0 && info[i+2][j+2]==1 ) {
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i+1;
                    positionSOS[3] = j+1;
                    positionSOS[4] = i+2;
                    positionSOS[5] = j+2;
                }
            }if(j <= info.length-3){
                if( info[i][j]==1 && info[i][j+1]==0 && info[i][j+2]==1){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i;
                    positionSOS[3] = j+1;
                    positionSOS[4] = i;
                    positionSOS[5] = j+2;
                }
            }if(i <= info.length-3){
                if(info[i][j]==1 && info[i+1][j]==0 && info[i+2][j]==1){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i+1;
                    positionSOS[3] = j;
                    positionSOS[4] = i+2;
                    positionSOS[5] = j;
                }
            }if(i>=2 && j>=2){
                if(info[i][j]==1 && info[i-1][j-1]==0 && info[i-2][j-2]==1 ){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i-1;
                    positionSOS[3] = j-1;
                    positionSOS[4] = i-2;
                    positionSOS[5] = j-2;
                }
            }if(j>=2){
                if(info[i][j]==1 && info[i][j-1]==0 && info[i][j-2]==1){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i;
                    positionSOS[3] = j-1;
                    positionSOS[4] = i;
                    positionSOS[5] = j-2;
                }
            }if(i>=2 && j<= info.length-3){
                if(info[i][j]==1 && info[i-1][j+1]==0 && info[i-2][j+2]==1){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i-1;
                    positionSOS[3] = j+1;
                    positionSOS[4] = i-2;
                    positionSOS[5] = j+2;
                }
            }if(j>=2 && i <= info.length-3){
                if( info[i][j]==1 && info[i+1][j-1]==0 && info[i+2][j-2]==1 ){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i+1;
                    positionSOS[3] = j-1;
                    positionSOS[4] = i+2;
                    positionSOS[5] = j-2;
                }
            }if(i>=2){
                if(info[i][j]==1 && info[i-1][j]==0 && info[i-2][j]==1){
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j;
                    positionSOS[2] = i-1;
                    positionSOS[3] = j;
                    positionSOS[4] = i-2;
                    positionSOS[5] = j;
                }
            }

        }if(letter.equals("O")){

            if(i>=1 && j>=1 && i <= info.length-2 && j <= info.length-2) {

                if (info[i + 1][j - 1] == 1 && info[i][j] == 0 && info[i - 1][j + 1] == 1) {
                    cantSOS++;
                    positionSOS[0] = i+1;
                    positionSOS[1] = j-1;
                    positionSOS[2] = i;
                    positionSOS[3] = j;
                    positionSOS[4] = i-1;
                    positionSOS[5] = j+1;

                }
            }if(i>=1 && j>=1 && i <= info.length-2 && j <= info.length-2){
                if (info[i - 1][j - 1] == 1 && info[i][j] == 0 && info[i + 1][j + 1] == 1) {
                    cantSOS++;
                    positionSOS[0] = i-1;
                    positionSOS[1] = j-1;
                    positionSOS[2] = i;
                    positionSOS[3] = j;
                    positionSOS[4] = i+1;
                    positionSOS[5] = j+1;
                }
            }
            if(j>= 1 && j <= info.length-2) {
                if (info[i][j - 1] == 1 && info[i][j] == 0 && info[i][j + 1] == 1) {
                    cantSOS++;
                    positionSOS[0] = i;
                    positionSOS[1] = j-1;
                    positionSOS[2] = i;
                    positionSOS[3] = j;
                    positionSOS[4] = i;
                    positionSOS[5] = j+1;
                }
            }
            if(i>=1 &&  i <= info.length-2) {
                if (info[i - 1][j] == 1 && info[i][j] == 0 && info[i + 1][j] == 1) {
                    cantSOS++;
                    positionSOS[0] = i-1;
                    positionSOS[1] = j;
                    positionSOS[2] = i;
                    positionSOS[3] = j;
                    positionSOS[4] = i+1;
                    positionSOS[5] = j;
                }
            }
            return cantSOS;
        }
        return cantSOS;
    }

    public static int getcantSOS() {
        return cantSOS;
    }

    public boolean fullScreen(int[][] info){
        for(int i=0;i< info.length;i++){
            for(int j=0;j< info.length;j++){
                if (info[i][j]==-1){
                    return false;
                }
            }
        }
        return true;
    }
}

