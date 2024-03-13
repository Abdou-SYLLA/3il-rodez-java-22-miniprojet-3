package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * La classe PenduView représente la vue du jeu du Pendu, qui gère l'affichage graphique et les interactions avec l'utilisateur.
 */
public class PenduView {
    private JFrame frame; // Fenêtre principale du jeu
    private JLabel motAfficheLabel; // Étiquette pour afficher le mot à deviner
    private JLabel motProposerLabel; // Étiquette pour afficher les lettres proposées
    private JLabel tentativesLabel; // Étiquette pour afficher le nombre de tentatives restantes
    private JTextField lettreTextField; // Champ de texte pour saisir une lettre
    private JButton propositionButton; // Bouton pour proposer une lettre
    private JButton recommencerButton; // Bouton pour recommencer une partie

    /**
     * Constructeur de la classe PenduView. Initialise les composants graphiques de la vue.
     */
    public PenduView() {
        // Initialisation de la fenêtre principale
        frame = new JFrame("Jeu du Pendu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400); // Ajustement de la taille de la fenêtre
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Création des composants graphiques
        Font labelFont = new Font("Arial", Font.BOLD, 24); // Police de caractères
        motAfficheLabel = new JLabel();
        motAfficheLabel.setFont(labelFont);
        motAfficheLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(motAfficheLabel, gbc);

        gbc.gridy++;
        tentativesLabel = new JLabel();
        tentativesLabel.setFont(labelFont);
        tentativesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(tentativesLabel, gbc);

        gbc.gridy++;
        lettreTextField = new JTextField(10);
        frame.add(lettreTextField, gbc);

        gbc.gridy++;
        propositionButton = new JButton("Proposer");
        frame.add(propositionButton, gbc);

        gbc.gridy++;
        motProposerLabel = new JLabel();
        motProposerLabel.setFont(labelFont);
        motProposerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(motProposerLabel, gbc);

        gbc.gridy++;
        recommencerButton = new JButton("Recommencer");
        frame.add(recommencerButton, gbc);

        frame.setVisible(true);

        // Ajout du KeyListener pour détecter la touche "Entrée"
        lettreTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Déclencher l'événement du bouton Proposer
                    propositionButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    /**
     * Méthode pour récupérer la fenêtre principale du jeu.
     *
     * @return La fenêtre principale du jeu
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Méthode pour récupérer la lettre proposée par l'utilisateur.
     *
     * @return La lettre proposée
     */
    public String getLettreProposee() {
        return lettreTextField.getText().toLowerCase();
    }

    /**
     * Méthode pour mettre à jour l'affichage du mot à deviner.
     *
     * @param motAffiche Le mot à deviner
     */
    public void setMotAffiche(String motAffiche) {
        motAfficheLabel.setText("Mot à deviner: " + motAffiche);
    }

    /**
     * Méthode pour mettre à jour l'affichage du nombre de tentatives restantes.
     *
     * @param tentativesRestantes Le nombre de tentatives restantes
     */
    public void setTentativesRestantes(int tentativesRestantes) {
        tentativesLabel.setText("Tentatives restantes: " + tentativesRestantes);
    }

    /**
     * Méthode pour mettre à jour l'affichage des lettres proposées par l'utilisateur.
     *
     * @param lettresProposees La liste des lettres proposées
     */
    public void setLettresProposees(List<Character> lettresProposees) {
        // Affichage des lettres proposées dans l'étiquette correspondante
        StringBuilder letters = new StringBuilder();
        for (Character c : lettresProposees) {
            letters.append(c).append(" ");
        }
        motProposerLabel.setText("Lettres proposées: " + letters);
    }

    /**
     * Méthode pour afficher un message à l'utilisateur dans une boîte de dialogue.
     *
     * @param message Le message à afficher
     */
    public void afficherMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    /**
     * Méthode pour ajouter un auditeur d'événements au bouton "Proposer".
     *
     * @param listener L'auditeur d'événements à ajouter
     */
    public void ajouterPropositionListener(ActionListener listener) {
        propositionButton.addActionListener(listener);
    }

    /**
     * Méthode pour ajouter un auditeur d'événements au bouton "Recommencer".
     *
     * @param listener L'auditeur d'événements à ajouter
     */
    public void ajouterRecommencerListener(ActionListener listener) {
        recommencerButton.addActionListener(listener);
    }
}
