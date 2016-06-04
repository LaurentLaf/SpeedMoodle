package jeu;

public class Joueur {
	//Constante classe Joueur
	private final String nom;
	private static final int PENALITE = 3;
	private int penalite = 0;
	
	//Accesseurs
	public String getNom() {
		return nom;
	}
	
	//Méthodes de pénalités
	public void annulerPenalite() {
		this.penalite=0;
	}
	
	public void ajoutePenalite() {
		this.penalite=Joueur.PENALITE;
	}
	
	public boolean sansPenalite() {
		return (penalite==0);
	}
	
	public void oterEventuellementUnePenalite() {
		if (penalite>0) {
			penalite--;
		}
	}
	
	//Constructeur
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	
	
}
