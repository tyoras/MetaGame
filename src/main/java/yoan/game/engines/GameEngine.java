/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;
import yoan.game.util.logs.Log;

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
		super(parent, ModuleType.GAME);
		Log.info(getType(), "création du GameEngine");
	}
}