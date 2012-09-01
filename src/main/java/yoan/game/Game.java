/**
 * 
 */
package yoan.game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import yoan.game.engines.Engine;
import yoan.game.engines.Module;

/**
 * Classe de base du jeu
 * @author yoan
 */
public abstract class Game {
	
	/** Indique si le jeu est démarré */
	private boolean running= false;
	/** Map des modules du jeu */
	protected Map<Module, Engine> modules;
	
	/**
	 * Constructeur par défaut du jeu
	 */
	public Game(){
		this.modules= new HashMap<Module, Engine>();
	}

	/**
	 * Traitement d'initialisation des modules
	 */
	public abstract void initModules();

	/**
	 * Lance le jeu
	 */
	public void run(){
		boolean gameRunning= isRunning();
		//tant que le jeu est dans l'état "Démarré"
		while(gameRunning){
			Collection<Engine> listModule= modules.values();
			//on exécute les frames de chacun des modules
			for(Engine module : listModule){
				module.frame();
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
	}

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
	public Map<Module, Engine> getModules(){
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(Map<Module, Engine> modules){
		this.modules= modules;
	}
}