package mot;

/**
 * La classe GenerateurMot est responsable de la génération aléatoire d'un mot à deviner pour le jeu du Pendu.
 */
public class GenerateurMot {
    private LectureFichier monFichier; // Objet permettant de lire un mot aléatoire à partir d'un fichier

    private String mot; // Le mot généré aléatoirement à deviner
    private String ligne; // La ligne lue depuis le fichier

    /**
     * Constructeur de la classe GenerateurMot. Initialise l'objet LectureFichier et génère un mot aléatoire.
     */
    public GenerateurMot() {
        this.monFichier = new LectureFichier(); // Initialisation de l'objet LectureFichier
        mot = monFichier.lireMotAleatoire(); // Génération du mot aléatoire à deviner
        ligne = monFichier.getLigne();
    }

    /**
     * Méthode pour récupérer le mot à deviner.
     *
     * @return Le mot à deviner
     */
    public String getMot() {
        return mot;
    }

    public String getLigne() {
        return ligne;
    }
}
