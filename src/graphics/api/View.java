package graphics.api;

import scenes.api.PanelScene;

public interface View {
    public void render();
    public void setPanelScene(PanelScene scenepanel);
}
