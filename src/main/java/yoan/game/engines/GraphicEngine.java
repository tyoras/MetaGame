/**
 * 
 */
package yoan.game.engines;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;

/**
 * Le moteur graphique
 * gère les graphismes du jeu
 * @author yoan
 */
public abstract class GraphicEngine<E extends EngineEvent> extends Engine<E> {
	
	/**
	 * Constructeur du moteur graphique 
	 * @param parent : le jeu
	 */
	public GraphicEngine(Game<E> parent){
		super(parent, Module.GRAPHIC);
	}
}