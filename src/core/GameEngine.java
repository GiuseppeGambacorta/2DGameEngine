package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.logging.*;

import graphics.api.View;
import graphics.impl.wievimpl;
import scenes.api.*;
import core.api.*;
import core.impl.SceneManagerImpl;

public class GameEngine  {

	final private long period = 20; /* 20 ms = 50 frame al secondo */
	final private Logger logger = Logger.getLogger("GameEngine");
	
	private final SceneManager sceneManager;
	private Scene currentScene;
	private ScenePanel currentPanel;
	final private View window;

	public GameEngine(){

		
		sceneManager = new SceneManagerImpl();
		setScene();
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

		if (sceneManager.sceneChanged()){
			setActualSceneToView();
		}

	}
	
	protected void render(){
		window.render();
	}


	private void setScene(){
		var current = this. sceneManager.getActualScene();
		this.currentScene = current.getValue();
		this.currentPanel = current.getKey();
	}

	private void setActualSceneToView(){
		setScene();
		this.window.setPanelScene(currentPanel);
	}


	

}
