package input;

import model.api.GameObject;
import common.V2d;


public class MoveLeft implements Command {
	@Override
	public void execute(GameObject obj) {
		
		obj.setVel(new V2d(-1,0));
	}

}
