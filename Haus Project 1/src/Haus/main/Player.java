package Haus.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
	
		x = Game.clamp(x, 0, Game.WIDTH - 36);
		y = Game.clamp(y, 0, Game.WIDTH - 230);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.BossEnemy  || tempObject.getId() == ID.OpSmartEnemy || tempObject.getId() == ID.BeastEnemy) {  //tempObject is now basic enemy
				if(getBounds().intersects(tempObject.getBounds())) {
				    //collision code
				    HUD.HEALTH -= 0.5;
				}
			}
			
		}
	}

	public void render(Graphics g) {
		if(id == ID.Player) g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	

}
