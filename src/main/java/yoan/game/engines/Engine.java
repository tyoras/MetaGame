/**
 * 
 */
package yoan.game.engines;

import java.util.LinkedList;
import java.util.Queue;

import yoan.game.Game;
import yoan.game.engines.events.EngineEvent;

/**
 * Classe de base des moteurs du jeux
 * @author yoan
 */
public abstract class Engine {
	/** Le jeu auquel le moteur apartient */
	protected Game game;
	/** Le nom du moteur */
	protected final Module name;
	/** La liste des évenements à traiter */
	protected Queue<EngineEvent> eventsQueue= new LinkedList<EngineEvent>();

	
	/**
	 * Constructeur 
	 * @param parent : le jeu auquel appartient le moteur
	 * @param engineID : l'identifiant du moteur
	 */
	public Engine(Game parent, Module engineID){
		game= parent;
		name= engineID;
	}

	/**
	 * Ajoute un event à traiter par le moteur
	 * @param event : l'event à ajouter
	 */
	public void pushEvent(EngineEvent event){
		if(event != null) 
			eventsQueue.add(event);
	}

	/**
	 * Traite les évenements
	 */
	public void processQueue(){
		while(!this.eventsQueue.isEmpty()){
			//on retire l'event de la queue
			EngineEvent event= (EngineEvent) eventsQueue.remove();
			//puis on le traite
			processEvent(event);
		}
	}
	
	/**
	 * Traitement à effectuer pendant la frame
	 */
	public abstract void frame();

	/**
	 * Traitement d'un event par le moteur
	 * @param paramEngineEvent : l'évent à traiter
	 */
	protected abstract void processEvent(EngineEvent paramEngineEvent);
}