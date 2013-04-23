/**
 * 
 */
package yoan.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yoan.game.engines.Engine;
import yoan.game.engines.ModuleType;
import yoan.game.engines.events.EngineEvent;
import yoan.game.util.errors.GameException;
import yoan.game.util.interfaces.Module;
import yoan.game.util.logs.Log;

/**
 * Classe de base du jeu
 * @author yoan
 */
public abstract class Game<E extends EngineEvent> extends Module {
	
	/** Indique si le jeu est démarré */
	private boolean running= false;
	/** Le type de module */
	protected final ModuleType type = ModuleType.MAIN;
	/** Map des modules du jeu */
	protected Map<ModuleType, Engine<E>> modules;
	
	/**
	 * Constructeur par défaut du jeu
	 */
	public Game(){
		this.modules= new HashMap<ModuleType, Engine<E>>();
	}

	/**
	 * Traitement d'initialisation des moteurs
	 * @param initArgs : paramètres d'initialisation
	 */
	public void initEngines(Map<ModuleType, String[]> initArgs) throws GameException {
		Log.info(getType(), "Init des moteurs");
		if (initArgs != null) {
        	Collection<Engine<E>> listModule= modules.values();
        	//pour tout les moteurs 
        	for(Engine<E> module : listModule){
        		//on récupère les arguments correspondant à ce module
        		String[] args = initArgs.get(module.getType());
        		//et on l'initialise avec
        		module.init(args);
        	}
		}
	}

	/**
	 * Lance le jeu
	 * @throws GameException 
	 */
	public void run() throws GameException{
		boolean gameRunning= isRunning();
		List<Engine<E>> listModule= new ArrayList<Engine<E>>(modules.values());
		int nbModule = listModule.size();
		int i =0;
		//tant que le jeu est dans l'état "Démarré"
		while(gameRunning){
			//on exécute les frames de chacun des modules
			for(i=0; i<nbModule; i++){
				listModule.get(i).frame();
			}
			//on met à jour l'état du jeu
			gameRunning= isRunning();
		}
	}
	
	/**
	 * Arrête le jeu
	 */
	public void stop(){
		setRunning(false);
		Log.info(getType(), "Stop!");
	}
	
	//TODO implémenter la pause
	
	/**
	 * @return the running
	 */
	public synchronized boolean isRunning(){
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public synchronized void setRunning(boolean running){
		this.running= running;
	}

	/**
	 * @return the modules
	 */
	public Map<ModuleType, Engine<E>> getModules(){
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(Map<ModuleType, Engine<E>> modules){
		this.modules= modules;
	}

	/**
	 * @return the type
	 */
	public ModuleType getType(){
		return type;
	}
}