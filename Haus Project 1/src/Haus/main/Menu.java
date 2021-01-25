package Haus.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Haus.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx, my, 268, 100, 100, 64)) {
				//game.gameState = STATE.Game;
				//handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			    //handler.clearEnemys();
			    //for(int i = 0; i < 10; i++)
			    //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			    game.gameState = STATE.Select;
			    return;
			}
			
			//help button
			if(mouseOver(mx, my, 268, 200, 100, 64)) {
				game.gameState = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my, 268, 300, 100, 64)) {
				System.exit(1);
			}
			
		}
		
		if(game.gameState == STATE.Select) {
			//normal button
			if(mouseOver(mx, my, 268, 100, 100, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			    handler.clearEnemys();
			    //for(int i = 0; i < 10; i++)
			    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			    
			    game.diff = 0;
			}
			
			//hard button
			if(mouseOver(mx, my, 268, 200, 100, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			    handler.clearEnemys();
			    //for(int i = 0; i < 10; i++)
			    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			    
			    game.diff = 1;
			}
			
			//back button
			if(mouseOver(mx, my, 268, 300, 100, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}	
		//back4help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 268, 300, 100, 64)) {
				game.gameState = STATE.Menu;
				return;
			}	
		}
		//retry
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 268, 300, 100, 64)) {
				game.gameState = STATE.Menu;
			}
		}					
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 35);
			Font fnt2 = new Font("arial", 1, 25);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("HAUS's tASTY MENU", 148, 50);
			
			g.setColor(Color.white);
			g.drawRect(268, 100, 100, 64);
			g.setFont(fnt2);
			g.drawString("Play", 290, 140);
			
			g.setColor(Color.white);
			g.drawRect(268, 200, 100, 64);
			g.setFont(fnt2);
			g.drawString("HELLp", 280, 240);
			
			g.setColor(Color.white);
			g.drawRect(268, 300, 100, 64);
			g.setFont(fnt2);
			g.drawString("Quit", 290, 340);
		}else if(game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 35);
			Font fnt2 = new Font("arial", 1, 25);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("HELLp", 258, 50);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("The arrows are the keys to success", 120, 200);
			
			g.drawRect(268, 300, 100, 64);
			g.setFont(fnt2);
			g.drawString("Back", 290, 340);
		}else if(game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 35);
			Font fnt2 = new Font("arial", 1, 25);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 228, 50);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("You lost with a score of:  " + hud.getScore(), 150, 200);
			
			g.drawRect(268, 300, 100, 64);
			g.setFont(fnt2);
			g.drawString("Retry", 288, 340);
		}if(game.gameState == STATE.Select) {
			Font fnt = new Font("arial", 1, 35);
			Font fnt2 = new Font("arial", 1, 25);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 148, 50);
			
			g.setColor(Color.white);
			g.drawRect(268, 100, 100, 64);
			g.setFont(fnt2);
			g.drawString("Normal", 275, 140);
			
			g.setColor(Color.white);
			g.drawRect(268, 200, 100, 64);
			g.setFont(fnt2);
			g.drawString("Hard", 288, 240);
			
			g.setColor(Color.white);
			g.drawRect(268, 300, 100, 64);
			g.setFont(fnt2);
			g.drawString("Back", 290, 340);			
		}
	}

}
