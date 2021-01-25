package Haus.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BeastEnemy extends GameObject{

	private Handler handler;
	private HUD hud;
	private GameObject player;
	Random r = new Random();
	
	public BeastEnemy(int x, int y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		
		this.handler = handler;
		this.hud = hud;
		
		for(int i=0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x+64, (int)y+64, 128, 128);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = ((-1/distance) * diffX * (5/2));
		velY = ((-1/distance) * diffY * (5/2));
			
		int spawn = r.nextInt(10);
		if(spawn == 0) handler.addObject(new BossEnemyBullet((int)x, (int)y, ID.BasicEnemy, handler));
		
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 128) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 128, 128, 0.04f, handler));
		
		if(hud.getLevel() == 25) {
	        velX = ((-1/distance) * diffX * 3);
	        velY = ((-1/distance) * diffY * 3);
		}    
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 128, 128);
	}

}
