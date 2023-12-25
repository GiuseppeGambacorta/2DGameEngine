package graphics.impl;

import java.util.List;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.*;

import common.P2d;
import graphics.api.View;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.Scene;
import scenes.api.ScenePanel;

public class wievimpl implements View{

    private JFrame frame;
    private ScenePanel panel;

    public wievimpl(final ScenePanel scenePanel,final String gameName,final int weight, final int height){
        frame = new JFrame(gameName);
    	frame.setSize(weight,height);
    	frame.setMinimumSize(new Dimension(weight,height));
        frame.setResizable(false);
        // frame.setUndecorated(true); // Remove title bar
        
        panel = scenePanel;
        frame.getContentPane().add((Component) panel);
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


    
    
}
