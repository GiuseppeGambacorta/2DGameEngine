package scenes.GameScene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.P2d;
import common.V2d;
import input.Command;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.Scene;

public class GameScene implements Scene{

    final private List<GameObject> objects;
    final private List<Command> comands = new LinkedList<>();
    final private GameObject ball;
    public GameScene(){
        objects = new ArrayList<GameObject>();
        ball = new Ball(new P2d(-1,-1), new V2d(0,0));
        objects.add(ball);
    }

    @Override
    public void updateState(final int dt) {
        objects.forEach(obj -> obj.updateState(dt));
    }

    @Override
    public List<GameObject> getSceneEntities() {
        return new ArrayList<>(objects);
        
    }

    @Override
    public void addCommand(Command cmd) {
        comands.add(cmd);
      
    }

    @Override
    public void executeCommands(){
        if (!comands.isEmpty()){
            comands.forEach( cmd -> cmd.execute(ball));
            comands.clear();
        }
    }
}

  

    

