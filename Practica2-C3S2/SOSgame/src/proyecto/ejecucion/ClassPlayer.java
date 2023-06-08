package proyecto.ejecucion;

import javax.swing.*;

public class ClassPlayer {

    private String player;
    private boolean isHuman;

    public ClassPlayer( String player, boolean isHuman) {

        this.player = player;
        this.isHuman= isHuman;
    }
    public boolean getisHuman(){
        return isHuman;
    }
    public String getPlayer() {
        return player;
    }
}
