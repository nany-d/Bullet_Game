package Haus.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemy extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	private int timer = 100;
	private int timer2 = 50;
	
	public BossEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x+64, (int)y+64, 128, 128);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer --;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0)
		{
			if(velX == 0) velX = 2;
			
			if(velX > 0)
			velX += 0.01f;
			else if(velX < 0)
			velX -= 0.01f;
			
			velX = Game.clamp(velX, -20, 20);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new BossEnemyBullet((int)x, (int)y, ID.BasicEnemy, handler));
		}
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 128) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 128, 128, 0.08f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 128, 128);
	}

}

