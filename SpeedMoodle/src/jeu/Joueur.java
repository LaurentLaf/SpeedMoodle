package jeu;

public class Joueur {
	//Constante classe Joueur
	private final String nom;
	private int PENALITE = 3;
	private int penalite = 0;
	
	//Accesseurs
	public String getNom() {
		return nom;
	}
	
	public void annulerPenalite() {
		this.penalite=0;
	}
	
	public void ajoutePenalite() {
		
	}
	
	public boolean sansPenalite() {
		return true;
	}
	
	public void oterEventuellementUnePenalite() {
		
	}
	
	//Constructeur
	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	
	
}
