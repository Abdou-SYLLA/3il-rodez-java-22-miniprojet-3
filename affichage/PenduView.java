package affichage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PenduView {
    private JFrame frame;
    private JLabel motAfficheLabel;
    private JLabel tentativesLabel;
    private JTextField lettreTextField;
    private JButton propositionButton;

    public PenduView() {
        frame = new JFrame("Jeu du Pendu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        motAfficheLabel = new JLabel();
        tentativesLabel = new JLabel();
        lettreTextField = new JTextField(0);
        propositionButton = new JButton("Proposer");

        frame.add(motAfficheLabel);
        frame.add(tentativesLabel);
        frame.add(lettreTextField);
        frame.add(propositionButton);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getLettreProposee() {
        return lettreTextField.getText().toLowerCase();
    }

    public void setMotAffiche(String motAffiche) {
        motAfficheLabel.setText("Mot à deviner: " + motAffiche);
    }

    public void setTentativesRestantes(int tentativesRestantes) {
        tentativesLabel.setText("Tentatives restantes: " + tentativesRestantes);
    }

    public void afficherMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void ajouterPropositionListener(ActionListener listener) {
        propositionButton.addActionListener(listener);
    }
}
