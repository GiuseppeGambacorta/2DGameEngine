package model.impl;

import common.P2d;
import common.V2d;
import model.api.GameObject;

public class GameObjectImpl implements GameObject {
    
    private P2d pos;
	private V2d vel;
	
	protected GameObjectImpl(final P2d pos, final V2d vel){
		this.pos = pos;
		this.vel = vel;
	}
	
	public void setPos(final P2d pos){
		this.pos = pos;
	}

	public void setVel(final V2d vel){
		this.vel = vel;
	}
	
    public void updateState(final int dt){
		this.pos = this.pos.sum(vel.mul(0.001*dt));
	}
	
	public P2d getCurrentPos(){
		return pos;
	}
	
	public V2d getCurrentVel(){
		return vel;
	}
}
