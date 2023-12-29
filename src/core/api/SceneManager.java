package core.api;

import java.util.Map.Entry;

import scenes.api.Scene;
import scenes.api.PanelScene;

public interface SceneManager {

    Entry<PanelScene,Scene> getActualScene();
    boolean sceneChanged();
  
}
