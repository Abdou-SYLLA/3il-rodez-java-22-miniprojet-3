package affichage;

import mot.GenerateurMot;

public class PenduModel {
    private GenerateurMot motSecret;
    private StringBuilder motAffiche;
    private int tentativesRestantes;

    public PenduModel() {
        motSecret = new GenerateurMot();
        initialiserMotAffiche();
        tentativesRestantes = 7;
    }

    private void initialiserMotAffiche() {
        motAffiche = new StringBuilder();
        for (int i = 0; i < motSecret.getMot().length(); i++) {
            motAffiche.append('_');
        }
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
        return motAffiche.toString().equals(motSecret);
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
}

