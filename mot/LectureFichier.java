package mot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * La classe LectureFichier est responsable de la lecture d'un fichier de mots pour générer un mot aléatoire.
 */
public class LectureFichier {
    private final String cheminDuFichier = "mots.txt"; // Chemin vers le fichier de mots
    private int nbLignes; // Nombre de lignes dans le fichier
    private BufferedReader lecteur; // Lecteur pour lire le fichier
    private Random random; // Générateur de nombres aléatoires

    private  String ligne; // Ligne lue depuis le fichier

    /**
     * Constructeur de la classe LectureFichier. Initialise le lecteur de fichier et le générateur de nombres aléatoires.
     */
    public LectureFichier() {
        initialiserLecteurEtNbLignes();
        this.random = new Random(); // Initialisation du générateur de nombres aléatoires
    }

    /**
     * Méthode pour récupérer la dernière ligne lue depuis le fichier.
     *
     * @return La dernière ligne lue
     */
    public String getLigne() {
        return ligne;
    }

    /**
     * Initialise le lecteur de fichier et détermine le nombre de lignes dans le fichier.
     */
    private void initialiserLecteurEtNbLignes() {
        try {
            this.lecteur = new BufferedReader(new FileReader(cheminDuFichier));
            int compteurLignes = 0;

            // Compte le nombre de lignes dans le fichier
            while (lecteur.readLine() != null) {
                compteurLignes++;
            }

            nbLignes = compteurLignes;

            // Réinitialise le lecteur au début du fichier après la première lecture
            this.lecteur.close();
            this.lecteur = new BufferedReader(new FileReader(cheminDuFichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour récupérer le nombre de lignes dans le fichier.
     *
     * @return Le nombre de lignes dans le fichier
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Méthode pour récupérer le lecteur de fichier.
     *
     * @return Le lecteur de fichier
     */
    public BufferedReader getLecteur() {
        return lecteur;
    }

    /**
     * Méthode pour lire un mot aléatoire depuis le fichier.
     *
     * @return Un mot aléatoire lu depuis le fichier
     */
    public String lireMotAleatoire() {
        try {
            int ligneAleatoire = random.nextInt(nbLignes) + 1;
            int numeroActuel = 0;
            String ligne;

            // Parcourir le fichier jusqu'à la ligne aléatoire
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
