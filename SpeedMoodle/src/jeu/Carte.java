package jeu;

import java.awt.Color;

public class Carte {
	
	//CONSTANTES classe Carte
	public static final int NBR_COULEUR = 5;
	public static final int NBR_MOTIF = 5;
	public static final int NBR_VALEUR = 5;
	
	private Color couleur;
	private Symbol motif;
	private int valeur;
	private boolean vide;
	
	//Accesseurs
	public Color getCouleur() {
		return couleur;
	}
	public Symbol getMotif() {
		return motif;
	}
	public int getValeur() {
		return valeur;
	}
	public boolean isVide() {
		return vide;
	}
	
	//Constructeur de carte vide
	public Carte() {
		this.vide = true;
		this.forceVide();
	}

	//Constructeur des autres cartes
	public Carte(int couleur, Symbol motif, int valeur) {
		//Test à ôter à la livraison
		if ((couleur>NBR_COULEUR) || (valeur > NBR_VALEUR)) {
			System.out.println("couleur ou valeur de carte non valide");
			this.forceVide();
		}
		else {
			this.vide = false;
			
			this.couleur = Carte.getColor(couleur);
			this.motif = motif;
			this.valeur = valeur;
		}
	}
	
	private void forceVide() {
		this.couleur = Color.darkGray;
		this.motif = Symbol.VIDE;
		this.valeur = -1;
	}
	private static Color getColor(int couleur) {
		Color color = null; 
		switch (couleur) {
		case 1:color=Color.blue; break;
		case 2:color=Color.orange; break;
		case 3:color=Color.cyan; break;
		case 4:color=Color.black; break;
		case 5:color=Color.lightGray; break;
		default:color=Color.darkGray; break;
		}
		return color;
	}
	
	public boolean estCompatible(Carte c2) {
		return (
				(!this.isVide() && !c2.isVide()) 
				&& ( 
				(this.couleur.equals(c2.couleur)) || (this.motif.equals(c2.motif)) || (this.valeur == c2.valeur))
				);
	}
	
	@Override
	public String toString() {
		return "Carte [couleur : "+ couleur +" , motif : "+motif+", valeur "+valeur;
	}
	
	
	
	
	
	
}
