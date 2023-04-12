package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 4;
		velY = 18;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (x <= 0 || x >= Game.WIDTH - 36) velX *= -1;
		if (y <= 0 || y >= Game.HEIGHT - 58) velY *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.08f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y, 16, 16);
		
	}

}
