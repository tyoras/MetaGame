/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;

/**
 * Le moteur de son
 * Gère le son du jeu
 * @author yoan
 */
public abstract class SoundEngine extends Engine {

	public SoundEngine(Game parent){
		super(parent, Module.SOUND);
	}
}