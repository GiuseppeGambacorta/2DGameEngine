package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.*;


import graphics.api.View;
import graphics.impl.wievimpl;
import model.api.*;
import scenes.GameScene.GameScene;
import scenes.GameScene.GameScenePanel;
import scenes.MenuScene.MenuScene;
import scenes.MenuScene.MenuScenePanel;
import scenes.api.Scene;
import scenes.api.ScenePanel;;

public class GameEngine  {

	final private long period = 20; /* 20 ms = 50 frame al secondo */
	final private Logger logger = Logger.getLogger("GameEngine");
	
	final private Map<Scene, ScenePanel> scenePanelMap;
	private Scene currentScene;
	private ScenePanel currentPanel;
	final private View window;

	public GameEngine(){
		scenePanelMap = new HashMap<>();

        Scene gameScene = new GameScene();
		Scene menuScene = new MenuScene();

        ScenePanel gameScenePanel = new GameScenePanel(gameScene, 600, 600);
		ScenePanel menuScenePanel = new MenuScenePanel(menuScene, 600, 600);

		System.out.println(menuScene.getSceneEntities());
		System.out.println(gameScene.getSceneEntities());

        scenePanelMap.put(gameScene, gameScenePanel);
		scenePanelMap.put(menuScene, menuScenePanel);

        currentScene = gameScene;
        currentPanel = gameScenePanel;

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

}
