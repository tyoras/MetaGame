/**
 * 
 */
package yoan.game.engines;

import java.util.LinkedList;
import java.util.Queue;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;
import yoan.game.util.errors.GameErrors;
import yoan.game.util.errors.GameException;
import yoan.game.util.interfaces.Module;
import yoan.game.util.logs.Log;

/**
 * Classe de base des moteurs du jeux
 * @author yoan
 */
public abstract class Engine<E extends EngineEvent> extends Module {
	/** Le jeu auquel le moteur apartient */
	protected Game<E> game;
	/** Le type du moteur */
	protected final ModuleType type;
	/** La liste des évenements à traiter */
	protected Queue<E> eventsQueue= new LinkedList<E>();

	
	/**
	 * Constructeur 
	 * @param parent : le jeu auquel appartient le moteur
	 * @param engineID : l'identifiant du moteur
	 */
	public Engine(Game<E> parent, ModuleType engineID){
		game= parent;
		type= engineID;
	}
	
	/**
	 * Traitement d'initialisation du moteur
	 * @param initArgs : paramètres d'initialisation
	 */
	public void initEngine(String... initArgs) throws GameException {
		Log.info(getType(), "Init du moteur");
		//On teste si les arguments d'initialisation sont correctes
		boolean argsOk = checkInitArgs(initArgs);
		if (!argsOk){
			GameErrors.throwFatalError(getType(), "Wrong init args!"); 
		}
	}

	/**
	 * Ajoute un event à traiter par le moteur
	 * @param event : l'event à ajouter
	 */
	public void pushEvent(E event){
		if(event != null) 
			eventsQueue.add(event);
	}

	/**
	 * Traite les évenements
	 */
	public void processQueue() throws GameException {
		while(!this.eventsQueue.isEmpty()){
			//on retire l'event de la queue
			E event= (E) eventsQueue.remove();
			//puis on le traite
			processEvent(event);
		}
	}
	
	/**
	 * Traitement à effectuer pendant la frame
	 */
	public abstract void frame() throws GameException;

	/**
	 * Traitement d'un event par le moteur
	 * @param paramEngineEvent : l'évent à traiter
	 */
	protected abstract void processEvent(E paramEngineEvent) throws GameException;

	/**
	 * @return the game
	 */
	public Game<E> getGame(){
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game<E> game){
		this.game= game;
	}

	/**
	 * @return the type
	 */
	public ModuleType getType(){
		return type;
	}
}