/**
 * 
 */
package yoan.game.util.interfaces;

import yoan.game.engines.ModuleType;
import yoan.game.util.errors.GameErrors;
import yoan.game.util.errors.GameException;
import yoan.game.util.logs.Log;

/**
 * Interface décrivant les modules
 * @author yoan
 */
public abstract class Module {
	/**
	 * Récupère le type de module
	 * @return type
	 */
	public abstract ModuleType getType();
	
	public void init(String... initArgs) throws GameException {
		Log.info(getType(), "Init du module");
		//On teste si les arguments d'initialisation sont correctes
		boolean argsOk = checkInitArgs(initArgs);
		if (!argsOk){
			GameErrors.throwFatalError(getType(), "Wrong init args!"); 
		}
	}
	
	/** Vérifie les arguments d'initialisation du module
	 * @param initArgs : paramètres d'initialisation à vérifier
	 * @return boolean 
	 */
	protected abstract boolean checkInitArgs(String... initArgs);
}
