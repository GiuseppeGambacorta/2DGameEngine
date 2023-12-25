package core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;


import graphics.api.View;
import graphics.impl.wievimpl;
import model.api.*;
import scenes.GameScene.GameScene;
import scenes.GameScene.GameScenePanel;
import scenes.api.Scene;
import scenes.api.ScenePanel;;

public class GameEngine  {

	final private long period = 20; /* 20 ms = 50 frame al secondo */
	final private Logger logger = Logger.getLogger("GameEngine");
	
	final private List<Scene> scenes;
	final private List<ScenePanel> panels;
	private Scene currentScene;
	private ScenePanel currentPanel;
	final private View window;

	public GameEngine(){
		scenes = new ArrayList<>();
		scenes.add(new GameScene());
		currentScene = scenes.get(0);

		panels = new ArrayList<>();
		panels.add(new GameScenePanel(currentScene, 600, 600));
		currentPanel = panels.get(0);
		
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
