package scenes.AnotherScene;

import java.util.ArrayList;
import java.util.List;

import common.P2d;
import common.V2d;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.Scene;
import core.api.*;

public class AnotherScene implements Scene {

    final private List<GameObject> objects;

    public AnotherScene(){
        objects = new ArrayList<GameObject>();
        objects.add(new Ball(new P2d(-1,-1), new V2d(1,0)));
    }

    @Override
    public void updateState(final int dt) {
        objects.forEach(obj -> { 
            obj.updateState(dt);
        });

    }

    @Override
    public List<GameObject> getSceneEntities() {
        return new ArrayList<>(objects);
        
    }

    
}
