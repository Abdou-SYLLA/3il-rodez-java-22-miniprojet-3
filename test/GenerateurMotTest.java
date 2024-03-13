package test;

import mot.GenerateurMot;
import mot.LectureFichier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe GenerateurMotTest contient les méthodes de test pour la classe GenerateurMot.
 */
class GenerateurMotTest {

    /**
     * Test de la méthode getMot.
     */
    @Test
    void getMot() {
        // Création d'un objet GenerateurMot pour effectuer le test
        GenerateurMot generateurMot = new GenerateurMot();

        // Récupération du mot généré
        String motGenere = generateurMot.getMot();

        String ligneLue = generateurMot.getLigne();

        // Vérification que le mot généré n'est pas nul
        assertNotNull(motGenere, "Le mot généré ne doit pas être nul.");

        // Vérification que le mot généré est bien le premier mot de la ligne lue
        assertTrue(ligneLue.startsWith(motGenere), "Le mot généré doit être le premier mot de la ligne lue.");
    }
}
