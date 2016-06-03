package jeu;

public enum Symbol {
	maison, etoile, diamant, ballon, arbre, fanion, VIDE;
	
	private static final Symbol[] LES_SYMBOLES = Symbol.values();
	public static final int NBR_SYMBOLE = LES_SYMBOLES.length;
	
	public String toString() {
		String chaine = "";

		switch (this) {
		case maison:chaine="maison"; break;
		case etoile:chaine="etoile"; break;
		case diamant:chaine="diaman"; break;
		case ballon:chaine="ballon"; break;
		case arbre:chaine="arbres"; break;
		case fanion:chaine="fanion"; break;
		case VIDE:chaine=" VIDE "; break;
		default:chaine="******";
			break;
		}
		
		return chaine;
	}

	public static Symbol get(int i) {
		return LES_SYMBOLES[i];
	}
}
