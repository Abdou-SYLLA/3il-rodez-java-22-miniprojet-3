package test;

import mot.LectureFichier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe LectureFichierTest contient les méthodes de test pour la classe LectureFichier.
 */
class LectureFichierTest {

    /**
     * Test de la méthode getNbLignes.
     */
    @Test
    void getNbLignes() {
        // Création d'un objet LectureFichier pour effectuer le test
        LectureFichier lectureFichier = new LectureFichier();

        // Vérification que le nombre de lignes est supérieur à zéro
        assertTrue(lectureFichier.getNbLignes() > 0, "Le nombre de lignes doit être supérieur à zéro.");
    }
}
