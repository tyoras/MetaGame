/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;

/**
 * Le moteur graphique
 * gère les graphismes du jeu
 * @author yoan
 */
public abstract class GraphicEngine extends Engine {
	
	/**
	 * Constructeur du moteur graphique 
	 * @param parent : le jeu
	 */
	public GraphicEngine(Game parent){
		super(parent, Module.GRAPHIC);
	}
}