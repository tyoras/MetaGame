/**
 * 
 */
package yoan.game;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Logger de l'application
 * @author yoan
 */
public final class Log {
	//le logger basique
	static Logger logger= Logger.getLogger("MetaGame");

	static{
		//configuration du logger au démarrage
		BasicConfigurator.configure();
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Category#debug(java.lang.Object)
	 */
	public void debug(String message){
		logger.debug(message);
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Category#error(java.lang.Object)
	 */
	public void error(String message){
		logger.error(message);
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Category#fatal(java.lang.Object)
	 */
	public void fatal(String message){
		logger.fatal(message);
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Category#info(java.lang.Object)
	 */
	public void info(String message){
		logger.info(message);
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Logger#trace(java.lang.Object)
	 */
	public void trace(String message){
		logger.trace(message);
	}

	/**
	 * @param message
	 * @see org.apache.log4j.Category#warn(java.lang.Object)
	 */
	public void warn(String message){
		logger.warn(message);
	}

}