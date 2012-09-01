/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;

/**
 * Le moteur réseau du jeu
 * gère les communication réseau du jeu
 * @author yoan
 */
public abstract class NetworkEngine extends Engine {
	
	public NetworkEngine(Game parent){
		super(parent, Module.NETWORK);
	}
}