/**
 * 
 */
package yoan.game.engines;

/**
 * Enum des différents types de module
 * @author yoan
 */
public enum ModuleType {
	/** Gestion des mécanismes du jeu */
	GAME, 
	/** Gestion de l'affichage */
	GRAPHIC, 
	/** Module principal du jeu */
	MAIN,
	/** Gestion des communication */
	NETWORK, 
	/** Gestion d'autres composants */
	OTHER, 
	/** Gestion du son */
	SOUND;
}
