package scenes.MenuScene;

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



public class MenuPanel extends JPanel implements PanelScene, KeyListener{
    	final private int centerX;
    	final private int centerY;
		final private MenuScene scene;
		

    	
    	public MenuPanel (final MenuScene scene, final int w, final int h){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
			this.scene = scene;


			this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow();

			JButton bottone = new JButton("ciao");
			bottone.addActionListener( e -> {
					// Code to execute when the button is clicked
					System.out.println("Button clicked!");
					scene.buttonClicked();
				
			});
			this.add(bottone);
        }
        
        public void paint(final Graphics g){
    		super.paint(g);
            
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