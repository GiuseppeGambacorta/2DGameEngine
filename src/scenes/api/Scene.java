package scenes.api;

import java.util.List;

import model.api.GameObject;

public interface Scene {

    public void updateState(int dt);
    public List<GameObject> getSceneEntities();
}
