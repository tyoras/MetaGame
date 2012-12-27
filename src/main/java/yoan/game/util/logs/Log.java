/**
 * 
 */
package yoan.game.util.logs;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import yoan.game.engines.ModuleType;

/**
 * Logger de l'application
 * @author yoan
 */
public final class Log {
	/** le logger basique */
	private static Logger logger= Logger.getLogger("MetaGame");

	static{
		//configuration du logger au démarrage
		BasicConfigurator.configure();
	}

	/**
	 * Trace un message au niveau DEBUG
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @see org.apache.log4j.Category#debug(java.lang.Object)
	 */
	public static void debug(ModuleType origine, String message){
		logger.debug(completeMsg(origine, message));
	}

	/**
	 * Trace un message au niveau ERROR
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @see org.apache.log4j.Category#error(java.lang.Object)
	 */
	public static void error(ModuleType origine, String message){
		logger.error(completeMsg(origine, message));
	}

	/**
	 * Trace un message au niveau FATAL
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @see org.apache.log4j.Category#fatal(java.lang.Object)
	 */
	public static void fatal(ModuleType origine, String message){
		logger.fatal(completeMsg(origine, message));
	}

	/**
	 * Trace un message au niveau INFO
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @see org.apache.log4j.Category#info(java.lang.Object)
	 */
	public static void info(ModuleType origine, String message){
		logger.info(completeMsg(origine, message));
	}

	/**
	 * Trace un message au niveau TRACE
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @see org.apache.log4j.Logger#trace(java.lang.Object)
	 */
	public static void trace(ModuleType origine, String message){
		logger.trace(completeMsg(origine, message));
	}

	/**
	 * Trace un message au niveau WARN
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message
	 * @see org.apache.log4j.Category#warn(java.lang.Object)
	 */
	public static void warn(ModuleType origine, String message){
		logger.warn(completeMsg(origine, message));
	}

	/**
	 * Complète un message en fonction de son origine
	 * @param origine : type de module à l'origine de l'erreur
	 * @param message : le message à transmettre
	 * @return message complété
	 */
	public static String completeMsg(ModuleType origine, String message) {
		StringBuilder msg = new StringBuilder("");
		
		//récupération de l'origine
		if (origine != null) {
			msg.append("["+origine+"] ");
		} else {
			msg.append("[ORIGINE INCONNUE] ");
		}
		
		if (StringUtils.isNotBlank(message)) {
			msg.append(message);
		} else {
			msg.append("pas de message défini...");
		}
		return msg.toString();
	}
}