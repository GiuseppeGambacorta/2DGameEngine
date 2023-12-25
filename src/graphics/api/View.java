package graphics.api;

import scenes.api.ScenePanel;

public interface View {
    public void render();
    public void setPanelScene(ScenePanel scenepanel);
}
