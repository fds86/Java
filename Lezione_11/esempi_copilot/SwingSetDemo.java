import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * SwingSet Demo - Mostra i principali componenti Swing
 * Versione semplificata per VS Code
 */
public class SwingSetDemo extends JFrame {
    
    public SwingSetDemo() {
        super("SwingSet Demo - Componenti Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        
        // Crea il pannello principale con tab
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Tab 1: Bottoni
        tabbedPane.addTab("Bottoni", createButtonPanel());
        
        // Tab 2: Input
        tabbedPane.addTab("Input", createInputPanel());
        
        // Tab 3: Liste e Combo
        tabbedPane.addTab("Liste", createListPanel());
        
        // Tab 4: Tabelle
        tabbedPane.addTab("Tabelle", createTablePanel());
        
        // Tab 5: Dialoghi
        tabbedPane.addTab("Dialoghi", createDialogPanel());
        
        // Tab 6: Layout
        tabbedPane.addTab("Layout", createLayoutPanel());
        
        add(tabbedPane);
        setLocationRelativeTo(null);
    }
    
    // Tab 1: Pannello Bottoni
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JButton normale
        JButton button = new JButton("Bottone Normale");
        button.addActionListener(e -> showMessage("Hai cliccato il bottone normale!"));
        
        // JButton con icona
        JButton iconButton = new JButton("Con Icona", UIManager.getIcon("FileView.computerIcon"));
        iconButton.addActionListener(e -> showMessage("Bottone con icona!"));
        
        // JToggleButton
        JToggleButton toggleButton = new JToggleButton("Toggle Button");
        toggleButton.addActionListener(e -> {
            if (toggleButton.isSelected()) {
                toggleButton.setText("Toggle: ON");
            } else {
                toggleButton.setText("Toggle: OFF");
            }
        });
        
        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Casella di spunta", true);
        
        // JRadioButton
        JRadioButton radio1 = new JRadioButton("Opzione 1", true);
        JRadioButton radio2 = new JRadioButton("Opzione 2");
        JRadioButton radio3 = new JRadioButton("Opzione 3");
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        
        JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);
        radioPanel.setBorder(BorderFactory.createTitledBorder("Radio Buttons"));
        
        panel.add(button);
        panel.add(iconButton);
        panel.add(toggleButton);
        panel.add(checkBox);
        panel.add(radioPanel);
        
        return panel;
    }
    
    // Tab 2: Pannello Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JTextField
        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textFieldPanel.add(new JLabel("Campo di testo:"));
        JTextField textField = new JTextField(20);
        textFieldPanel.add(textField);
        
        // JPasswordField
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);
        
        // JTextArea
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.setBorder(BorderFactory.createTitledBorder("Area di testo"));
        JTextArea textArea = new JTextArea(5, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textAreaPanel.add(scrollPane);
        
        // JSpinner
        JPanel spinnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        spinnerPanel.add(new JLabel("Spinner:"));
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinnerPanel.add(spinner);
        
        // JSlider
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.setBorder(BorderFactory.createTitledBorder("Slider"));
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel sliderValue = new JLabel("Valore: 50");
        slider.addChangeListener(e -> sliderValue.setText("Valore: " + slider.getValue()));
        sliderPanel.add(slider);
        sliderPanel.add(sliderValue);
        
        panel.add(textFieldPanel);
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(textAreaPanel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(spinnerPanel);
        panel.add(sliderPanel);
        
        return panel;
    }
    
    // Tab 3: Pannello Liste e ComboBox
    private JPanel createListPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // JList
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("JList"));
        String[] items = {"Java", "Python", "JavaScript", "C++", "C#", "Ruby", "Go", "Rust"};
        JList<String> list = new JList<>(items);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScroll = new JScrollPane(list);
        listPanel.add(listScroll);
        
        // JComboBox
        JPanel comboPanel = new JPanel();
        comboPanel.setLayout(new BoxLayout(comboPanel, BoxLayout.Y_AXIS));
        comboPanel.setBorder(BorderFactory.createTitledBorder("JComboBox"));
        
        String[] languages = {"Italiano", "English", "Español", "Français", "Deutsch"};
        JComboBox<String> combo = new JComboBox<>(languages);
        
        JLabel comboLabel = new JLabel("Selezionato: " + combo.getSelectedItem());
        combo.addActionListener(e -> comboLabel.setText("Selezionato: " + combo.getSelectedItem()));
        
        comboPanel.add(combo);
        comboPanel.add(Box.createVerticalStrut(10));
        comboPanel.add(comboLabel);
        
        panel.add(listPanel);
        panel.add(comboPanel);
        
        return panel;
    }
    
    // Tab 4: Pannello Tabelle
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Dati della tabella
        String[] columnNames = {"Nome", "Cognome", "Età", "Città"};
        Object[][] data = {
            {"Mario", "Rossi", 30, "Roma"},
            {"Luigi", "Verdi", 25, "Milano"},
            {"Anna", "Bianchi", 35, "Napoli"},
            {"Paolo", "Neri", 28, "Torino"},
            {"Sara", "Gialli", 32, "Firenze"}
        };
        
        JTable table = new JTable(data, columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableScroll = new JScrollPane(table);
        
        panel.add(tableScroll, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Tab 5: Pannello Dialoghi
    private JPanel createDialogPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Message Dialog
        JButton messageButton = new JButton("Message Dialog");
        messageButton.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, "Questo è un messaggio informativo", 
                "Info", JOptionPane.INFORMATION_MESSAGE));
        
        // Confirm Dialog
        JButton confirmButton = new JButton("Confirm Dialog");
        confirmButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, "Sei sicuro?", 
                "Conferma", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                showMessage("Hai confermato!");
            }
        });
        
        // Input Dialog
        JButton inputButton = new JButton("Input Dialog");
        inputButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Inserisci il tuo nome:", 
                "Input", JOptionPane.QUESTION_MESSAGE);
            if (name != null && !name.isEmpty()) {
                showMessage("Ciao " + name + "!");
            }
        });
        
        // Option Dialog
        JButton optionButton = new JButton("Option Dialog");
        optionButton.addActionListener(e -> {
            String[] options = {"Opzione 1", "Opzione 2", "Opzione 3"};
            int choice = JOptionPane.showOptionDialog(this, "Scegli un'opzione:",
                "Scelta", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
            if (choice >= 0) {
                showMessage("Hai scelto: " + options[choice]);
            }
        });
        
        // File Chooser
        JButton fileButton = new JButton("File Chooser");
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                showMessage("File selezionato: " + fileChooser.getSelectedFile().getName());
            }
        });
        
        // Color Chooser
        JButton colorButton = new JButton("Color Chooser");
        colorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Scegli un colore", Color.BLUE);
            if (color != null) {
                colorButton.setBackground(color);
            }
        });
        
        panel.add(messageButton);
        panel.add(confirmButton);
        panel.add(inputButton);
        panel.add(optionButton);
        panel.add(fileButton);
        panel.add(colorButton);
        
        return panel;
    }
    
    // Tab 6: Pannello Layout
    private JPanel createLayoutPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        borderPanel.add(new JButton("NORTH"), BorderLayout.NORTH);
        borderPanel.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("WEST"), BorderLayout.WEST);
        borderPanel.add(new JButton("EAST"), BorderLayout.EAST);
        borderPanel.add(new JLabel("CENTER", SwingConstants.CENTER), BorderLayout.CENTER);
        
        // FlowLayout
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        flowPanel.add(new JButton("Uno"));
        flowPanel.add(new JButton("Due"));
        flowPanel.add(new JButton("Tre"));
        flowPanel.add(new JButton("Quattro"));
        
        // GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBorder(BorderFactory.createTitledBorder("GridLayout 3x3"));
        for (int i = 1; i <= 9; i++) {
            gridPanel.add(new JButton("" + i));
        }
        
        // BoxLayout
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
        boxPanel.add(new JButton("Primo"));
        boxPanel.add(Box.createVerticalStrut(10));
        boxPanel.add(new JButton("Secondo"));
        boxPanel.add(Box.createVerticalStrut(10));
        boxPanel.add(new JButton("Terzo"));
        
        panel.add(borderPanel);
        panel.add(flowPanel);
        panel.add(gridPanel);
        panel.add(boxPanel);
        
        return panel;
    }
    
    // Metodo helper per mostrare messaggi
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public static void main(String[] args) {
        // Usa il Look and Feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Esegui sulla Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            SwingSetDemo demo = new SwingSetDemo();
            demo.setVisible(true);
        });
    }
}
