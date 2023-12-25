package scenes.MenuScene;

import java.util.ArrayList;
import java.util.List;

import common.P2d;
import common.V2d;
import core.api.Mediator;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.Menu;

public class MenuScene implements Menu {


    final private Mediator engine;
    public MenuScene(final Mediator engine){
        this.engine = engine;
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
        engine.dosomething();
    }


    
}
