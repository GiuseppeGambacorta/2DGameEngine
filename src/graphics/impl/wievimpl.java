package graphics.impl;

import java.util.List;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

import common.P2d;
import graphics.api.wiev;
import model.api.GameObject;
import model.api.Scene;
import model.impl.Ball;

public class wievimpl implements wiev{

    private JFrame frame;
    private ScenePanel panel;
    private Scene scene;

    public wievimpl(final Scene scene,final String gameName,final int weight, final int height){
        frame = new JFrame(gameName);
    	frame.setSize(weight,height);
    	frame.setMinimumSize(new Dimension(weight,height));
        frame.setResizable(false);
        // frame.setUndecorated(true); // Remove title bar
        this.scene = scene;
        panel = new ScenePanel(weight,height);
        frame.getContentPane().add(panel);
        frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(WindowEvent ev){
				System.exit(-1);
			}
		});
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void render() {
        try {
	    	SwingUtilities.invokeAndWait(() -> {
	    		frame.repaint();
	    	});
    	} catch (Exception ex){
    		ex.printStackTrace();
    	}
        
    }


    public class ScenePanel extends JPanel {
    	final private int centerX;
    	final private int centerY;
    	
    	public ScenePanel(final int w, final int h){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
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
    
}
