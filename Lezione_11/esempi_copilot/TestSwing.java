import javax.swing.*;
import java.awt.*;

/**
 * Esempio semplice di applicazione Swing in VS Code
 */
public class TestSwing {
    public static void main(String[] args) {
        // Crea la finestra principale
        JFrame frame = new JFrame("Test Swing - VS Code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Crea un pannello
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Crea una label
        JLabel label = new JLabel("Swing funziona in VS Code!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Crea un bottone
        JButton button = new JButton("Clicca qui!");
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, 
                "Hai cliccato il bottone!", 
                "Messaggio", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        
        // Aggiungi componenti al pannello
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        
        // Aggiungi il pannello alla finestra
        frame.add(panel);
        
        // Centra la finestra sullo schermo
        frame.setLocationRelativeTo(null);
        
        // Rendi visibile la finestra
        frame.setVisible(true);
        
        System.out.println("Applicazione Swing avviata!");
    }
}
