package graphics.impl;

import java.util.List;
import java.util.Objects;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.*;

import common.P2d;
import graphics.api.View;
import input.Controller;
import model.api.GameObject;
import model.impl.Ball;
import scenes.api.PanelScene;
import scenes.api.Scene;


public class wievimpl implements View{

    private JFrame frame;
    private PanelScene panel;


    public wievimpl(final PanelScene scenePanel,final String gameName,final int weight, final int height){
        frame = new JFrame(gameName);
    	frame.setSize(weight,height);
    	frame.setMinimumSize(new Dimension(weight,height));
        frame.setResizable(false);
        // frame.setUndecorated(true); // Remove title bar
        
      
        setPanelScene(scenePanel);
       
       
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


    @Override
    public void setPanelScene(final PanelScene scenePanel){

        if (!Objects.isNull(this.panel)){
          frame.getContentPane().remove((Component) this.panel );
        }

        this.panel = scenePanel;
        frame.getContentPane().add((Component) panel);
        frame.pack();
        frame.validate();
    }

 



    

    


    
    
}
