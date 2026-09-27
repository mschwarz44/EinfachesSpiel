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

        //Oberer Leiste
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("RundenErgebnis:", SwingConstants.CENTER));
        topPanel.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        labelRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        labelGesamtPunkte =  new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        labelRundenErgebnis.setOpaque(true);
        labelGesamtPunkte.setOpaque(true);
        labelGesamtPunkte.setBackground(Color.WHITE);

        topPanel.add(labelRundenErgebnis);
        topPanel.add(labelGesamtPunkte);
        add(topPanel, BorderLayout.NORTH);

        //Mittler Bereich
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));
        centerPanel.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        centerPanel.add(new JLabel("Computer:", SwingConstants.CENTER));

        textSpielerZahl = new JTextField();
        textComputerZahl = new JTextField();
        textComputerZahl.setEditable(false);


        centerPanel.add(textSpielerZahl);
        centerPanel.add(textComputerZahl);
        add(centerPanel, BorderLayout.CENTER);

        //Unter Leiste
        btnNochEinmal = new JButton("Noch einmal!");
        add(btnNochEinmal, BorderLayout.SOUTH);

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
        labelRundenErgebnis.setText(String.valueOf(zahl));
    }
    public void setGesamtpunkte(int zahl) {
        labelGesamtPunkte.setText(String.valueOf(zahl));
    }
    public void resetRund() {
        textSpielerZahl.setText("");
        textComputerZahl.setText("");
        labelRundenErgebnis.setText("Tippe eine Zahl von 1 bis 9");
    }
}
