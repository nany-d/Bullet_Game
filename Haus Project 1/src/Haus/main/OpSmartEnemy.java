package Haus.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class OpSmartEnemy extends GameObject{

	private Handler handler;
	private GameObject player;
	
	public OpSmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i=0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = ((-1/distance) * diffX * 2);
		velY = ((-1/distance) * diffY * 2);
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.yellow, 32, 32, 0.02f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}