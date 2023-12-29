package scenes.api;

import java.util.List;

import input.Command;
import model.api.GameObject;

public interface Scene {

    public void updateState(int dt);
    public List<GameObject> getSceneEntities();
    public void addCommand(Command cmd);
    public void executeCommands();
}
