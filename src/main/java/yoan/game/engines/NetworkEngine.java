/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;

/**
 * Le moteur réseau du jeu
 * gère les communication réseau du jeu
 * @author yoan
 */
public abstract class NetworkEngine<E extends EngineEvent> extends Engine<E> {
	
	public NetworkEngine(Game<E> parent){
		super(parent, Module.NETWORK);
	}
}