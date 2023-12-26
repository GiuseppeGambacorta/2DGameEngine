package scenes.MenuScene;

import java.util.ArrayList;
import java.util.List;

import common.P2d;
import common.V2d;
import core.api.SceneCommunicator;
import core.api.SceneManager;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.Menu;

public class MenuScene implements Menu {


    final private SceneCommunicator manager;
    public MenuScene(final SceneCommunicator manager){
        this.manager = manager;
    }

    @Override
    public void updateState(final int dt) {
    
    }

    @Override
    public List<GameObject> getSceneEntities() {
        return null;
    }

    @Override
    public void buttonClicked() {
        manager.startGame();
    }


    
}
