package affichage;

import mot.GenerateurMot;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe PenduModel représente le modèle du jeu du Pendu, qui gère la logique métier du jeu.
 */
public class PenduModel {
    private GenerateurMot motSecret; // Le mot secret à deviner
    private StringBuilder motAffiche; // Le mot affiché avec les lettres trouvées

    private List<Character> lettresProposees; // Les lettres déjà proposées par le joueur
    private List<String> motsProposes; // La liste des mots déjà proposés par le joueur
    private int tentativesRestantes; // Le nombre de tentatives restantes pour deviner le mot

    /**
     * Constructeur de la classe PenduModel. Initialise une nouvelle partie.
     */
    public PenduModel() {
        nouvellePartie(); // Initialisation d'une nouvelle partie
        lettresProposees = new ArrayList<>();
        motsProposes = new ArrayList<>(); // Initialisation de la liste des mots déjà proposés
    }

    /**
     * Initialise un nouveau mot à deviner.
     */
    private void initialiserMotAffiche() {
        motAffiche = new StringBuilder();

        // Initialise le mot à deviner avec des underscores pour chaque lettre
        for (int i = 0; i < motSecret.getMot().length(); i++) {
            motAffiche.append("_");
        }

        // Supprime le dernier espace pour que le dernier caractère ne soit pas suivi d'un espace
        motAffiche.setLength(motAffiche.length());
    }

    /**
     * Démarre une nouvelle partie en initialisant un nouveau mot à deviner et en réinitialisant les tentatives.
     */
    public void nouvellePartie() {
        motSecret = new GenerateurMot();
        initialiserMotAffiche();
        tentativesRestantes = 7; // Réinitialisation du nombre de tentatives
    }

    /**
     * Vérifie si la lettre proposée par le joueur est correcte et met à jour le mot à deviner en conséquence.
     *
     * @param lettre La lettre proposée par le joueur
     * @return true si la lettre est correcte, sinon false
     */
    public boolean estLettreCorrecte(char lettre) {
        boolean lettreTrouvee = false;
        for (int i = 0; i < motSecret.getMot().length(); i++) {
            if (motSecret.getMot().charAt(i) == lettre) {
                motAffiche.setCharAt(i, lettre);
                lettreTrouvee = true;
            }
        }
        if (!lettreTrouvee) {
            tentativesRestantes--; // Décrémente le nombre de tentatives restantes si la lettre est incorrecte
        }
        return lettreTrouvee;
    }

    /**
     * Ajoute une lettre proposée à la liste des lettres déjà proposées.
     *
     * @param lettre La lettre proposée
     */
    public void ajouterLettreProposee(char lettre) {
        lettresProposees.add(lettre);
    }

    /**
     * Vérifie si une lettre a déjà été proposée par le joueur.
     *
     * @param lettre La lettre à vérifier
     * @return true si la lettre a déjà été proposée, sinon false
     */
    public boolean lettreDejaProposee(char lettre) {
        return lettresProposees.contains(lettre);
    }

    /**
     * Vérifie si le joueur a gagné la partie en trouvant le mot.
     *
     * @return true si le joueur a gagné, sinon false
     */
    public boolean estPartieGagnee() {
        return motAffiche.toString().equals(motSecret.getMot());
    }

    /**
     * Vérifie si le joueur a perdu la partie en épuisant toutes les tentatives.
     *
     * @return true si le joueur a perdu, sinon false
     */
    public boolean estPartiePerdue() {
        return tentativesRestantes <= 0;
    }

    /**
     * Récupère le mot à deviner avec les lettres déjà trouvées.
     *
     * @return Le mot à deviner avec les lettres trouvées
     */
    public String getMotAffiche() {
        return motAffiche.toString();
    }

    /**
     * Récupère le nombre de tentatives restantes.
     *
     * @return Le nombre de tentatives restantes
     */
    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    /**
     * Récupère la liste des lettres déjà proposées par le joueur.
     *
     * @return La liste des lettres déjà proposées
     */
    public List<Character> getLettresProposees() {
        return lettresProposees;
    }

    /**
     * Récupère le mot secret à deviner.
     *
     * @return Le mot secret
     */
    public String getMotSecret() {
        return motSecret.getMot();
    }

    /**
     * Réinitialise le jeu pour démarrer une nouvelle partie.
     */
    public void recommencerPartie() {
        nouvellePartie();
    }

    /**
     * Ajoute un mot à la liste des mots déjà proposés par le joueur.
     *
     * @param mot Le mot à ajouter
     */
    public void ajouterMotPropose(String mot) {
        motsProposes.add(mot);
    }

    /**
     * Récupère la liste des mots déjà proposés par le joueur.
     *
     * @return La liste des mots déjà proposés
     */
    public List<String> getMotsProposes() {
        return motsProposes;
    }
}
