package mot;

public class GenerateurMot {
    private LectureFichier monFichier;

    private String mot;
    private String ligne;

    public GenerateurMot() {
        this.monFichier = new LectureFichier();
        mot = monFichier.lireMotAleatoire();

    }

    public String getMot() {
        return mot;
    }

    public static void main(String[] args) {
        GenerateurMot generateur = new GenerateurMot();

        String ligne = generateur.monFichier.getLigne();
        System.out.println("ligne correspondant : " + ligne);

        // Exemple d'utilisation de lireMot
        String motAleatoire = generateur.getMot();
        System.out.println("Mot aleatoire : " + motAleatoire);
    }
}
