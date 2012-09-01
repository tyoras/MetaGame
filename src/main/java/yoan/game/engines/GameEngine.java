/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;

/**
 * Le moteur du jeu
 * gère les règles du jeu
 * @author yoan
 */
public abstract class GameEngine extends Engine {
	
	/**
	 * Contructeur du moteur de jeu
	 * @param parent : le jeu
	 */
	public GameEngine(Game parent){
		super(parent, Module.GAME);
	}
}