package input;


import model.api.GameObject;

public interface Command {

	void execute(GameObject obj);
}
