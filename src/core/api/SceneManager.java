package core.api;

import java.util.Map.Entry;

import scenes.api.Scene;
import scenes.api.ScenePanel;

public interface SceneManager {

    Entry<ScenePanel,Scene> getActualScene();
    boolean sceneChanged();
  
}
