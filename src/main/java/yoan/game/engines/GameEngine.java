/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;

/**
 * Le moteur du jeu
 * gère les règles du jeu
 * @author yoan
 */
public abstract class GameEngine<E extends EngineEvent> extends Engine<E> {
	
	/**
	 * Contructeur du moteur de jeu
	 * @param parent : le jeu
	 */
	public GameEngine(Game<E> parent){
		super(parent, Module.GAME);
	}
}