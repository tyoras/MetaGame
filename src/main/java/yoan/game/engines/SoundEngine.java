/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;

/**
 * Le moteur de son
 * Gère le son du jeu
 * @author yoan
 */
public abstract class SoundEngine<E extends EngineEvent> extends Engine<E> {

	public SoundEngine(Game<E> parent){
		super(parent, Module.SOUND);
	}
}