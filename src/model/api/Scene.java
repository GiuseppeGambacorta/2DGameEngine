package model.api;

import java.util.List;

public interface Scene {

    public void updateState(int dt);
    public List<GameObject> getSceneEntities();
}
