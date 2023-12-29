package input;

import model.api.GameObject;
import common.V2d;


public class MoveDown implements Command {
	@Override
	public void execute(GameObject obj) {
		
		obj.setVel(new V2d(0,-1));
	}

}
