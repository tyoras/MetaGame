/**
 * 
 */
package yoan.game.util.errors;

import yoan.game.engines.ModuleType;
import yoan.game.util.logs.Log;

/**
 * Gestion des erreurs
 * @author yoan
 */
public final class GameErrors {
	/** Non instanciable */
	private GameErrors(){}
	
	/**
	 * Lève une erreur devant être traitée par un module
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : message de l'erreur
	 * @throws GameException : une exception non bloquante
	 */
	public static void throwError(ModuleType origine, String message) throws GameException {
		GameException gex = new GameException(origine, message);
		gex.setBloquant(false);
		Log.error(origine, message);
		throw gex;
	}
	
	/**
	 * Lève une erreur ne pouvant être traitée
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : message de l'erreur
	 * @throws GameException : une exception bloquante
	 */
	public static void throwFatalError(ModuleType origine, String message) throws GameException {
		GameException gex = new GameException(origine, message);
		gex.setBloquant(true);
		Log.fatal(origine, message);
		throw gex;
	}
}
