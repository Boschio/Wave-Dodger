package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = {false, false, false, false};
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// key events for player 1
				
				if (key == KeyEvent.VK_W) { tempObject.setVelY(-10); keyDown[0] = true; }
				if (key == KeyEvent.VK_A) { tempObject.setVelX(-10); keyDown[1] = true; }
				if (key == KeyEvent.VK_S) { tempObject.setVelY(10); keyDown[2] = true; }
				if (key == KeyEvent.VK_D) { tempObject.setVelX(10); keyDown[3] = true; }
			}
			
			if(tempObject.getId() == ID.Player2) {
				// key events for player 2
				// TODO Refactor to correct movement bug
				if (key == KeyEvent.VK_UP) tempObject.setVelY(-10);
				if (key == KeyEvent.VK_LEFT) tempObject.setVelY(-10);
				if (key == KeyEvent.VK_DOWN) tempObject.setVelY(10);
				if (key == KeyEvent.VK_RIGHT) tempObject.setVelY(10);
			}
			
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// key events for player 1
				
				if (key == KeyEvent.VK_W) keyDown[0] = false;
				if (key == KeyEvent.VK_A) keyDown[1] = false;
				if (key == KeyEvent.VK_S) keyDown[2] = false;
				if (key == KeyEvent.VK_D) keyDown[3] = false;
				
				// Vertical Movement
				if (!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
				
				// Horizontal Movement
				if (!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);
			}
			
			if(tempObject.getId() == ID.Player2) {
				// key events for player 2
				// TODO Refactor to correct movement bug
				if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			}
			
		}
	}
	
}
