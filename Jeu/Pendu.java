package Jeu;

import affichage.PenduController;
import affichage.PenduModel;
import affichage.PenduView;

/**
 * La classe Pendu est la classe principale du jeu du Pendu. Elle initialise le modèle, la vue et le contrôleur du jeu.
 */
public class Pendu {
    /**
     * Méthode principale qui lance le jeu du Pendu.
     *
     * @param args Les arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        PenduModel model = new PenduModel(); // Initialisation du modèle
        PenduView view = new PenduView(); // Initialisation de la vue
        PenduController controller = new PenduController(model, view); // Initialisation du contrôleur
    }
}
