package Haus.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud, Game game){
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
    public void tick(){
    	scoreKeep++;
    	
    	if(scoreKeep >= 250) {
    		scoreKeep = 0;
    		hud.setLevel(hud.getLevel() + 1);
    		
    		if(game.diff == 0)
    		{    
    			if(hud.getLevel() == 2) {
        			handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
        		}else if(hud.getLevel() == 3) {
        			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        		}else if(hud.getLevel() == 4) {
        			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        		}else if(hud.getLevel() == 5) {
        			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
        		}else if(hud.getLevel() == 6) {
        			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
        			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
        		}else if(hud.getLevel() == 7) {
        			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        		}else if(hud.getLevel() == 8) {
        			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
        		}else if(hud.getLevel() == 9) {
        			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
        		}else if(hud.getLevel() == 10) {
                	handler.clearEnemys();
        			handler.addObject(new BossEnemy((Game.WIDTH / 24), -156, ID.BossEnemy, handler));
        			handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));
        			handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));
                }else if(hud.getLevel() == 15) {
                    handler.clearEnemys();
                	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                }else if(hud.getLevel() == 16) { 
                	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                }else if(hud.getLevel() == 17) {
                	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                }else if(hud.getLevel() == 18) {
                	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                }else if(hud.getLevel() == 19) {
                	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                }else if(hud.getLevel() == 21) {
                	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));    
                }else if(hud.getLevel() == 23) {
                	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler)); 
                }else if(hud.getLevel() == 24) {
                	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud)); 
                }else if(hud.getLevel() == 25) {
                	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler)); 
                }else if(hud.getLevel() == 26) {
                	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud)); 
                }else if(hud.getLevel() == 27) {
                	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
                }
             }else if(game.diff == 1)
    		 {
    		    if(hud.getLevel() == 2) {
    	        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
    			}else if(hud.getLevel() == 3) {
 	    			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
 	    			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
 	    		}else if(hud.getLevel() == 4) {
 	    			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
 	    			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
 	    			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HardEnemy, handler));
 	    		}else if(hud.getLevel() == 5) {
 	    			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
 	    		}else if(hud.getLevel() == 6) {
 	    			handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
 	    			handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
 	    		}else if(hud.getLevel() == 7) {
 	    			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	    		}else if(hud.getLevel() == 8) {
 	    			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	    			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
 	    		}else if(hud.getLevel() == 9) {
 	    			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	    		}else if(hud.getLevel() == 10) {
 	            	handler.clearEnemys();
 	    			handler.addObject(new BossEnemy((Game.WIDTH / 24), -156, ID.BossEnemy, handler));
 	    			handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));
 	    			handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));
 	            }else if(hud.getLevel() == 15) {
 	                handler.clearEnemys();
 	            	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	            	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	            	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	            }else if(hud.getLevel() == 16) { 
 	            	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
 	            	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
 	            }else if(hud.getLevel() == 17) {
 	            	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
 	            	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	            }else if(hud.getLevel() == 18) {
 	            	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
 	            	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
 	            	handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
 	            }else if(hud.getLevel() == 19) {
 	            	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
 	            	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
 	            }else if(hud.getLevel() == 21) {
 	            	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler));    
 	            }else if(hud.getLevel() == 23) {
 	            	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler)); 
 	            }else if(hud.getLevel() == 25) {
 	            	handler.addObject(new OpSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.OpSmartEnemy, handler)); 	
 	            }else if(hud.getLevel() == 26) {
                 	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud)); 
                }else if(hud.getLevel() == 27) {
                	handler.addObject(new BeastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BeastEnemy, handler, hud));
 	            }
    		 }
        }
    }
}
