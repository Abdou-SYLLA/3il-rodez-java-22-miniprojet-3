package affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe PenduController représente le contrôleur du jeu du Pendu, qui gère les interactions entre le modèle (PenduModel)
 * et la vue (PenduView).
 */
public class PenduController {
    private PenduModel model; // Le modèle du jeu
    private PenduView view; // La vue du jeu

    /**
     * Constructeur de la classe PenduController.
     *
     * @param model Le modèle du jeu
     * @param view La vue du jeu
     */
    public PenduController(PenduModel model, PenduView view) {
        this.model = model;
        this.view = view;

        // Initialisation de la vue avec les données du modèle
        view.setMotAffiche(model.getMotAffiche());
        view.setTentativesRestantes(model.getTentativesRestantes());

        // Ajout des auditeurs d'événements pour les boutons "Proposition" et "Recommencer"
        view.ajouterPropositionListener(new PropositionListener());
        view.ajouterRecommencerListener(new RecommencerListener());
    }

    /**
     * Classe interne pour gérer l'événement de proposition d'une lettre.
     */
    private class PropositionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String lettreProposee = view.getLettreProposee();
            if (lettreProposee.length() == 1 && Character.isLetter(lettreProposee.charAt(0))) {
                char lettre = lettreProposee.charAt(0);
                boolean lettreCorrecte = model.estLettreCorrecte(lettre);

                // Mise à jour de la vue avec les nouvelles données du modèle
                view.setMotAffiche(model.getMotAffiche());
                view.setTentativesRestantes(model.getTentativesRestantes());
                model.ajouterLettreProposee(lettre);
                view.setLettresProposees(model.getLettresProposees());

                // Affichage des messages de fin de partie si nécessaire
                if (model.estPartieGagnee()) {
                    view.afficherMessage("Félicitations, vous avez gagné !");
                } else if (model.estPartiePerdue()) {
                    view.afficherMessage("Désolé, vous avez perdu. Le mot était : " + model.getMotSecret());
                }
            } else {
                view.afficherMessage("Veuillez entrer une seule lettre valide.");
            }
        }
    }

    /**
     * Classe interne pour gérer l'événement de recommencer une partie.
     */
    private class RecommencerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.recommencerPartie(); // Réinitialiser le modèle pour recommencer une nouvelle partie
            view.setMotAffiche(model.getMotAffiche());
            view.setTentativesRestantes(model.getTentativesRestantes());
            model.clear();
            view.clear();
            // Réinitialiser l'affichage des lettres proposées
        }
    }
}
