package mot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LectureFichier {
    private final String cheminDuFichier = "mots.txt";
    private int nbLignes;
    private BufferedReader lecteur;
    private Random random;

    private  String ligne;

    public LectureFichier() {
        initialiserLecteurEtNbLignes();
        this.random = new Random();
    }

    public String getLigne() {
        return ligne;
    }

    private void initialiserLecteurEtNbLignes() {
        try {
            this.lecteur = new BufferedReader(new FileReader(cheminDuFichier));
            int compteurLignes = 0;

            while (lecteur.readLine() != null) {
                compteurLignes++;
            }

            nbLignes = compteurLignes;

            // Réinitialiser le lecteur au début du fichier après la première lecture
            this.lecteur.close();
            this.lecteur = new BufferedReader(new FileReader(cheminDuFichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public BufferedReader getLecteur() {
        return lecteur;
    }

    public String lireMotAleatoire() {
        try {
            int ligneAleatoire = random.nextInt(nbLignes) + 1;
            int numeroActuel = 0;
            String ligne;

            while ((ligne = lecteur.readLine()) != null) {
                numeroActuel++;
                if (numeroActuel == ligneAleatoire) {
                    this.ligne = ligne;
                    String[] mots = ligne.split("\\s+");
                    if (mots.length > 0) {
                        return mots[0];
                    } else {
                        return null;
                    }
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
