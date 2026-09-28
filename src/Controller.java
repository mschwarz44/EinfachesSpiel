import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller verbindet Model (Spiellogik) und View (Swing-GUI).
 * Reagiert auf Benutzereingaben und aktualisiert die Anzeige entsprechend.
 */
public class Controller {

    private final GewinnModel gewinnModel;
    private final View view;

    public Controller() {
        gewinnModel = new GewinnModel();
        view = new View();

        addListeners();
    }

    public static void main(String[] args) {
        new Controller();
    }
    /**
     * Fügt Listener für Eingabe und "Noch einmal!"-Button hinzu.
     */
    private void addListeners() {
        view.addEingabeListener(e -> spielerZahlEingegeben());
        view.addNochEinmalListener(e -> nochEinmalEingabe());
    }
    private void nochEinmalEingabe() {
        view.resetRund();
    }

    /**
     * Liest die Spielerzahl ein und startet bei gültiger Eingabe eine Runde.
     */
    private void spielerZahlEingegeben() {
        int spielerZahl = leseSpielerZahl();

        if(spielerZahl == -1) {
            return;
        }

        gewinnModel.berechneGesamtPunkte(spielerZahl);
        aktualisiereView();
    }
    /**
     * Liest und validiert die Eingabe (Zahl 1-9), sonst -1.
     */
    private int leseSpielerZahl() {
        String eingabe = view.getSpielerEingabe().trim();

        try {
            int zahl = Integer.parseInt(eingabe);

            if (zahl < 1 || zahl > 9) {
                return -1;
            }

            return zahl;

        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void aktualisiereView() {
        view.setComputerZahl(gewinnModel.getComputerZahl());
        view.setRundenErgebnis(gewinnModel.getRundenErgebnis());
        view.setGesamtpunkte(gewinnModel.getGesamtPunkte());
    }
}
