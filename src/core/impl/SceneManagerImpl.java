package core.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import core.api.SceneCommunicator;
import core.api.SceneManager;
import scenes.AnotherScene.AnotherScene;
import scenes.AnotherScene.AnotherScenePanel;
import scenes.GameScene.GameScene;
import scenes.GameScene.GameScenePanel;
import scenes.MenuScene.MenuPanel;
import scenes.MenuScene.StartMenu;
import scenes.api.MenuScene;
import scenes.api.Scene;
import scenes.api.PanelScene;
import java.util.Random;

public class SceneManagerImpl implements SceneManager, SceneCommunicator {

    final private Map<PanelScene, Scene> scenePanelMap;

    final private StartMenu menuScene = new StartMenu(this);
    final private Scene gameScene = new GameScene();
    final private Scene anotherScene = new AnotherScene();

    final private PanelScene menuScenePanel = new MenuPanel(menuScene, 600, 600);
    final private PanelScene gameScenePanel = new GameScenePanel(gameScene, 600, 600);
    final private PanelScene anotherScenePanel = new AnotherScenePanel(anotherScene, 600, 600);
		
    private Scene currentScene;
	private PanelScene currentPanel;

    private boolean changed;

    public SceneManagerImpl(){

        scenePanelMap = new HashMap<>();

        scenePanelMap.put(menuScenePanel, menuScene);
        scenePanelMap.put(gameScenePanel, gameScene);
        scenePanelMap.put(anotherScenePanel, anotherScene);

        currentScene = menuScene;
        currentPanel = menuScenePanel;
		

    }

    @Override
    public Entry<PanelScene,Scene>  getActualScene(){
        return scenePanelMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(currentPanel))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean sceneChanged() {
        boolean temp = changed;
        if(changed){
            changed = false;
        }
        return temp;
    }


    @Override
    public void startGame() {

        var random = new Random();
        changed = true;
       
        currentScene = gameScene;
        currentPanel = gameScenePanel;
      

    }
    
}
