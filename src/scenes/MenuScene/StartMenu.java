package scenes.MenuScene;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import common.P2d;
import common.V2d;
import core.api.SceneCommunicator;
import core.api.SceneManager;
import input.Command;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.MenuScene;

public class StartMenu implements MenuScene {


    final private SceneCommunicator manager;
    final private List<Command> comands = new LinkedList<>();
    public StartMenu(final SceneCommunicator manager){
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

   
    @Override
    public void addCommand(Command cmd) {
        comands.add(cmd);
      
    }

    @Override
    public void executeCommands(){
        if (!comands.isEmpty()){
            comands.forEach( string -> System.out.println(string));
            comands.clear();
        }
    }


    
}
