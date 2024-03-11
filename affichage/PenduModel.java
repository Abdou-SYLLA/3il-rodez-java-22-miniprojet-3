package affichage;

import mot.GenerateurMot;

public class PenduModel {
    private GenerateurMot motSecret;
    private StringBuilder motAffiche;
    private int tentativesRestantes;

    public PenduModel() {
        nouvellePartie();
    }

    private void initialiserMotAffiche() {
        motAffiche = new StringBuilder();

        for (int i = 0; i < motSecret.getMot().length(); i++) {
            motAffiche.append("_ ");
        }

        // Supprime le dernier espace pour que le dernier caractère ne soit pas suivi d'un espace
        motAffiche.setLength(motAffiche.length() - 1);
    }


    public void nouvellePartie() {
        motSecret = new GenerateurMot();
        initialiserMotAffiche();
        tentativesRestantes = 7;
    }

    public boolean estLettreCorrecte(char lettre) {
        boolean lettreTrouvee = false;
        for (int i = 0; i < motSecret.getMot().length(); i++) {
            if (motSecret.getMot().charAt(i) == lettre) {
                motAffiche.setCharAt(i, lettre);
                lettreTrouvee = true;
            }
        }
        if (!lettreTrouvee) {
            tentativesRestantes--;
        }
        return lettreTrouvee;
    }

    public boolean estPartieGagnee() {
        return motAffiche.toString().equals(motSecret.getMot());
    }

    public boolean estPartiePerdue() {
        return tentativesRestantes <= 0;
    }

    public String getMotAffiche() {
        return motAffiche.toString();
    }

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public String getMotSecret() {
        return motSecret.getMot();
    }
}
