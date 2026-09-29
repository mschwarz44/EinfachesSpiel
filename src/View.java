import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View der Swing-GUI für das Zahlen-Gewinnspiel.
 * Zeigt Rundenergebnis, Gesamtpunkte, Spielereingabe und Computerzahl an.
 */
public class View extends JFrame {
    private JLabel labelRundenErgebnis;
    private JLabel labelGesamtPunkte;
    private JTextField textSpielerZahl;
    private JTextField textComputerZahl;
    private JButton btnNochEinmal;
    public View() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fettFont = new Font("SansSerif", Font.BOLD, 14);
        Font grossFont = new Font("SansSerif", Font.BOLD, 28);

        //Oberer Leiste
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        topPanel.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        topPanel.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        labelRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        labelGesamtPunkte =  new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        labelRundenErgebnis.setFont(fettFont);
        labelGesamtPunkte.setFont(fettFont);
        labelRundenErgebnis.setOpaque(true);
        labelGesamtPunkte.setOpaque(true);
        labelRundenErgebnis.setBackground(Color.WHITE);
        labelGesamtPunkte.setBackground(Color.WHITE);

        topPanel.add(labelRundenErgebnis);
        topPanel.add(labelGesamtPunkte);
        add(topPanel, BorderLayout.NORTH);

        //Mittler Bereich
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel beschriftungPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        beschriftungPanel.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        beschriftungPanel.add(new JLabel("Computer:", SwingConstants.CENTER));

        textSpielerZahl = new JTextField();
        textComputerZahl = new JTextField();
        textComputerZahl.setEditable(false);
        textComputerZahl.setBackground(Color.WHITE);
        textSpielerZahl.setFont(grossFont);
        textComputerZahl.setFont(grossFont);
        textSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        textComputerZahl.setHorizontalAlignment(JTextField.CENTER);

        JPanel feldPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        feldPanel.add(textSpielerZahl);
        feldPanel.add(textComputerZahl);

        centerPanel.add(beschriftungPanel, BorderLayout.NORTH);
        centerPanel.add(feldPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        //Unter Leiste
        btnNochEinmal = new JButton("Noch einmal!");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnNochEinmal);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void addEingabeListener(ActionListener listener) {
        textSpielerZahl.addActionListener(listener);
    }
    public void addNochEinmalListener(ActionListener listener) {
        btnNochEinmal.addActionListener(listener);
    }
    public String getSpielerEingabe() {
        return textSpielerZahl.getText();
    }
    public void setComputerZahl(int Zahl) {
        textComputerZahl.setText(String.valueOf(Zahl));
    }
    public void setRundenErgebnis(int zahl) {
        labelRundenErgebnis.setText(zahl > 0 ? "+" + zahl : String.valueOf(zahl));
    }
    public void setGesamtpunkte(int zahl) {
        labelGesamtPunkte.setText(String.valueOf(zahl));
    }
    public void resetRund() {
        setRundenErgebnisFarbe(Color.WHITE);
        setGesamtpunkteFarbe(Color.WHITE);
        textSpielerZahl.setText("");
        textComputerZahl.setText("");
        labelRundenErgebnis.setText("Tippe eine Zahl von 1 bis 9");
    }
    public void setRundenErgebnisFarbe(Color farbe) {
        labelRundenErgebnis.setBackground(farbe);
    }
    public void setGesamtpunkteFarbe(Color farbe) {
        labelGesamtPunkte.setBackground(farbe);
    }
}