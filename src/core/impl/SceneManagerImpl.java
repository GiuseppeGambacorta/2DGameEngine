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
import scenes.MenuScene.MenuScene;
import scenes.api.Menu;
import scenes.api.Scene;
import scenes.api.ScenePanel;
import java.util.Random;

public class SceneManagerImpl implements SceneManager, SceneCommunicator {

    final private Map<ScenePanel, Scene> scenePanelMap;

    final private Menu menuScene = new MenuScene(this);
    final private Scene gameScene = new GameScene();
	final private Scene anotherScene = new AnotherScene();

    final private ScenePanel menuScenePanel = new MenuPanel(menuScene, 600, 600);
    final private ScenePanel gameScenePanel = new GameScenePanel(gameScene, 600, 600);
    final private ScenePanel anotherScenePanel = new AnotherScenePanel(anotherScene, 600, 600);
		
    private Scene currentScene;
	private ScenePanel currentPanel;

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
    public Entry<ScenePanel,Scene>  getActualScene(){
        return scenePanelMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(currentPanel))
                .findFirst()
                .orElse(null);
    }




    @Override
    public void startGame() {

        var random = new Random();
        changed = true;
        if (random.nextInt(1, 3) == 1){
            currentScene = gameScene;
            currentPanel = gameScenePanel;
        } else {
            currentScene = anotherScene;
            currentPanel = anotherScenePanel;
        }

    }

    @Override
    public boolean sceneChanged() {
        return changed;
        
    }
    
}
