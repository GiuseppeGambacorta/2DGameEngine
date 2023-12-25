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

public class prova extends JPanel implements ScenePanel{
    	final private int centerX;
    	final private int centerY;
		final private Scene scene;
    	
    	public prova (final Scene scene, final int w, final int h){
            setSize(w,h);
            centerX = w/2;
            centerY = h/2;
			this.scene = scene;

			JButton bottone = new JButton("ciao");
			this.add(bottone);
        }
        
        public void paint(final Graphics g){
    		super.paint(g);
            
        }
    }