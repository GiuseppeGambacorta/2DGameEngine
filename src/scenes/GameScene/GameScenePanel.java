package scenes.GameScene;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.List;

import scenes.api.*;
import model.api.*;

import common.*;
import model.impl.*;

public class GameScenePanel extends JPanel implements ScenePanel{
    	final private int centerX;
    	final private int centerY;
		final private Scene scene;
    	
    	public GameScenePanel (final Scene scene, final int w, final int h){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
			this.scene = scene;
        }
        
        public void paint(final Graphics g){
    		Graphics2D g2 = (Graphics2D) g;
    		
    		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    		g2.clearRect(0,0,this.getWidth(),this.getHeight());
            
    		List<GameObject> entities = scene.getSceneEntities();
			Stroke strokeBall = new BasicStroke(4f);
			Stroke strokePick = new BasicStroke(8f);
			
			entities.stream().forEach( e -> {
    			P2d pos = e.getCurrentPos();
    			int x = (int) Math.round(centerX + pos.getX() * 100);
    			int y = (int) Math.round(centerY - pos.getY() * 100);
    			if (e instanceof Ball){
    				g2.setColor(Color.BLUE);
    				g2.setStroke(strokeBall);
    				g2.drawOval(x-20, y-20, 40, 40);
                }
    		});
            
        }
    }