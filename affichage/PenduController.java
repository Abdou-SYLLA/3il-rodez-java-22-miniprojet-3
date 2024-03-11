package affichage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenduController {
    private PenduModel model;
    private PenduView view;

    public PenduController(PenduModel model, PenduView view) {
        this.model = model;
        this.view = view;

        view.setMotAffiche(model.getMotAffiche());
        view.setTentativesRestantes(model.getTentativesRestantes());

        view.ajouterPropositionListener(new PropositionListener());
    }

    private class PropositionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String lettreProposee = view.getLettreProposee();
            if (lettreProposee.length() == 1 && Character.isLetter(lettreProposee.charAt(0))) {
                char lettre = lettreProposee.charAt(0);
                boolean lettreCorrecte = model.estLettreCorrecte(lettre);

                view.setMotAffiche(model.getMotAffiche());
                view.setTentativesRestantes(model.getTentativesRestantes());

                if (model.estPartieGagnee()) {
                    view.afficherMessage("Félicitations, vous avez gagné !");
                    view.getFrame().dispose();
                } else if (model.estPartiePerdue()) {
                    view.afficherMessage("Désolé, vous avez perdu. Le mot était : " + model.getMotSecret());
                    view.getFrame().dispose();
                }
            } else {
                view.afficherMessage("Veuillez entrer une seule lettre valide.");
            }
        }
    }

    public static void main(String[] args) {
        PenduModel model = new PenduModel();
        PenduView view = new PenduView();
        PenduController controller = new PenduController(model, view);
    }
}
