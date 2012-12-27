/**
 * 
 */
package yoan.game.util.errors;

import yoan.game.engines.ModuleType;
import yoan.game.util.logs.Log;

/**
 * @author yoan
 *
 */
public class GameException extends Exception {  
	private static final long serialVersionUID= -6014168968453054680L;
	/** Le module à l'origine de l'erreur */
	private ModuleType moduleOrigine;
	/** Indique si l'exception levée est bloquante ou à traiter */
	private boolean bloquant = false;
	
	/** 
	* Crée une nouvelle instance de GameException 
	*/  
	public GameException() {}
	
	/** 
	* Crée une nouvelle instance de GameException 
	* @param origine Type de module à l'origine de l'exception
	* @param message Le message détaillant exception 
	*/  
	public GameException(ModuleType origine, String message) {  
		super(Log.completeMsg(origine, message));
		moduleOrigine = origine;
	}  
	
	/** 
	* Crée une nouvelle instance de GameException
	* @param origine Type de module à l'origine de l'exception
	* @param cause L'exception à l'origine de cette exception 
	*/  
	public GameException(ModuleType origine, Throwable cause) {  
		super(cause); 
		moduleOrigine = origine;
	}  
	
	/** 
	* Crée une nouvelle instance de GameException 
	* @param origine Type de module à l'origine de l'exception
	* @param message Le message détaillant exception 
	* @param cause L'exception à l'origine de cette exception 
	*/  
	public GameException(ModuleType origine, String message, Throwable cause) {  
		super(Log.completeMsg(origine, message), cause); 
		moduleOrigine = origine;
	}

	/**
	 * @return the moduleOrigine
	 */
	public ModuleType getModuleOrigine(){
		return moduleOrigine;
	}

	/**
	 * @param origine the origine to set
	 */
	public void setModuleOrigine(ModuleType origine){
		this.moduleOrigine= origine;
	}

	/**
	 * @return the bloquant
	 */
	public boolean isBloquant(){
		return bloquant;
	}

	/**
	 * @param bloquant the bloquant to set
	 */
	public void setBloquant(boolean bloquant){
		this.bloquant= bloquant;
	} 
}