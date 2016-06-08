package jeu;

import java.util.ArrayList;
import java.util.List;

public class PaquetCarte {

	//CONSTANTE PaquetCarte
	private static final int NBR_CARTE = 72;

	//Variable classe PaquetCarte
	private List<Carte> cartes = new ArrayList<Carte>();
	private Joueur joueur;
	
	//Redéfinition des méthodes de base ajout et size pour cartes (type liste)
	public void add(Carte c) {
		cartes.add(c);
	}
	public int size() {
		return cartes.size();
	}
	
	public Carte get(int index) {
		return cartes.get(index);
	}
	public String getNomJoueur() {
		return joueur.getNom();
	}

	
	public boolean sansPenalite() {
		return joueur.sansPenalite();
	}
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Carte remove(int arg0) {
		//retourne la carte enlevée à liste de cartes
		return cartes.remove(arg0);
	}
	
	public boolean gagne() {
		return !cartes.isEmpty() && cartes.get(0).isVide();
	}

	public void gererErreur(PaquetCarte paquet2) {
		this.joueur.ajoutePenalite();
		paquet2.joueur.oterEventuellementUnePenalite();
	}
	
	public Carte testerCarteSommet(int positionCarte, Carte sommet, PaquetCarte autrePaquet) {
		Carte carteRetournee = null;
		if (this.get(positionCarte).estCompatible(sommet)) {
			carteRetournee = this.remove(positionCarte);
			autrePaquet.joueur.oterEventuellementUnePenalite();
		}
		return carteRetournee;
	}

	//Premier constructeur de paquetCarte
	public PaquetCarte(Joueur joueur) {
		this.joueur=joueur;
		boolean paquetPlein = false;
		while (!paquetPlein) {
			int i = 0;
			while ((!paquetPlein) && (i != Carte.NBR_COULEUR)) {
				int j = 0;
				while ((!paquetPlein) && (j != Carte.NBR_VALEUR)) {
					int k=0;
					while ((!paquetPlein) && (k != Carte.NBR_MOTIF)) {
						Carte c = new Carte(i,Symbol.get(k),j);
						this.add(c);
						paquetPlein = (this.size()==PaquetCarte.NBR_CARTE*2);
						k++;
					}
					j++;
				}
				i++;
			}
		}
		this.supprimerDuPaquet(PaquetCarte.NBR_CARTE);
		//Mélanger les cartes après leur génération
		java.util.Collections.shuffle(cartes);
	}

	//Fonction pour supprimer des cartes aléatoirement et les mettre dans le sous paquet
		private List<Carte> supprimerDuPaquet(int nbCartes) {
			List<Carte> supprimees = new ArrayList<Carte>(nbCartes);
			for (int i = 0; i < nbCartes; i++) {
				int positionAleatoire = (int) (Math.random()*this.size());
				supprimees.add(this.remove(positionAleatoire));
			}
			return supprimees;
		}
	
	//Deuxième constructeur de paquetCarte
	public PaquetCarte(PaquetCarte p, int nbCartes) {
		super();
		if (p.size()>=nbCartes) {
			this.joueur = p.joueur;
			this.cartes = p.supprimerDuPaquet(nbCartes);
		}
		else {
			System.err.println("Le paquet ne contient pas assez de cartes ("+nbCartes+" souhaitée vs "+p.size()+"cartes en tout");
		}
	}

	@Override
	public String toString() {
		String message = "";
		for (Carte carte : cartes) {
			message += carte+"\n";
		}
		return message;
	}
}
