package model.api;

import common.*;

public interface GameObject {
    public void setPos(P2d pos);
    public void setVel(V2d vel);
    public void updateState(int dt);
    public P2d getCurrentPos();
    public V2d getCurrentVel();
}
