package dk.sdu.cbse.common.data;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private int displayWidth  = 800 ;
    private int displayHeight = 800;
    private final GameKeys keys = new GameKeys();
    private List<String> labels = new ArrayList<>();

    public GameKeys getKeys() {
        return keys;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }
    public void addLabel(String label){
        labels.add(label);
    }

    public List<String> getLabels(){
        return labels;
    }
}
