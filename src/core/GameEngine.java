package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.*;


import graphics.api.View;
import graphics.impl.wievimpl;
import model.api.*;
import scenes.AnotherScene.AnotherScene;
import scenes.AnotherScene.AnotherScenePanel;
import scenes.GameScene.GameScene;
import scenes.GameScene.GameScenePanel;
import scenes.MenuScene.*;
import scenes.api.*;
import core.api.*;

public class GameEngine implements Mediator {

	final private long period = 20; /* 20 ms = 50 frame al secondo */
	final private Logger logger = Logger.getLogger("GameEngine");
	
	final private Map<ScenePanel, Scene> scenePanelMap;
	final private List<ScenePanel> listScene;
	private Scene currentScene;
	private ScenePanel currentPanel;
	final private View window;

	public GameEngine(){
		scenePanelMap = new HashMap<>();
		listScene = new ArrayList<>();

		Menu menuScene = new MenuScene(this);
        Scene gameScene = new GameScene();
		Scene anotherScene = new AnotherScene();
		

		ScenePanel menuScenePanel = new MenuPanel(menuScene, 600, 600);
        ScenePanel gameScenePanel = new GameScenePanel(gameScene, 600, 600);
		ScenePanel anotherScenePanel = new AnotherScenePanel(anotherScene, 600, 600);
		
        scenePanelMap.put(menuScenePanel, menuScene);
		scenePanelMap.put(gameScenePanel, gameScene);
		scenePanelMap.put(anotherScenePanel, anotherScene);
		

		listScene.add(menuScenePanel);
		listScene.add(gameScenePanel);
		listScene.add(anotherScenePanel);

		currentScene = menuScene;
		currentPanel = menuScenePanel;
		
	
		window = new wievimpl(currentPanel, "engine", 600, 600);
	}
	
	public void mainLoop(){
		long lastTime = System.currentTimeMillis();
		while(true){
			long current = System.currentTimeMillis();
			int elapsed = (int)(current - lastTime);
			processInput();
			updateGame(elapsed);
			render();
			waitForNextFrame(current);
			lastTime = current;
		}
	}

	protected void waitForNextFrame(final long current){
		final long dt = System.currentTimeMillis() - current;
		if (dt < period){
			try {
				Thread.sleep(period-dt);
			} catch (Exception ex){}
		}
	}
	
	protected void processInput(){
		logger.log(Level.INFO, "..process input..");
	}
	
	protected void updateGame(final int elapsed){
		currentScene.updateState(elapsed);
	}
	
	protected void render(){
		window.render();
	}


	@Override
	public void dosomething(){
		var random = new Random();
		currentPanel = listScene.get(random.nextInt(1, 3));
		currentScene = scenePanelMap.get(currentPanel);

		window.setPanelScene(currentPanel);
		
	
	}

}
