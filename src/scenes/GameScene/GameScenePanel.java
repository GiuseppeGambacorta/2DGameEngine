package scenes.GameScene;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import scenes.api.*;
import model.api.*;

import common.*;
import input.Controller;
import input.MoveDown;
import input.MoveLeft;
import input.MoveRight;
import input.MoveUp;
import model.impl.*;

public class GameScenePanel extends JPanel implements PanelScene, KeyListener{
    	final private int centerX;
    	final private int centerY;
		final private Scene scene;
		private Controller ctrl;
    	
    	public GameScenePanel (final Scene scene, final int w, final int h){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
			this.scene = scene;


			this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow();

        }
        
        public void paint(final Graphics g){
    		Graphics2D g2 = (Graphics2D) g;
    		JButton button = new JButton();

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

	

		@Override
		public void addNotify() {
			super.addNotify();
			requestFocusInWindow();
		}


		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_UP){
	     		scene.addCommand(new MoveUp());
	     	} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
	     		 		scene.addCommand(new MoveDown());
	     	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	     		 		scene.addCommand(new MoveRight());		
	     	} else if (e.getKeyCode() ==  KeyEvent.VK_LEFT){
	     	 		scene.addCommand(new MoveLeft());
	     	}
		}



	
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
					
    	}

}