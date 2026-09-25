/**
 * Model der Spiellogik für das Gewinnspiel.
 * Verwaltet Punktestand Spielerzahl und Computerzahl sowie das Rundenergebnis
 * und stellt die Berechnungslogik gemäß den Spielregeln bereit.
 */
public class GewinnModel {
    int gesamtPunkte;
    int spielerZahl;
    int computerZahl;
    int rundenErgebnis;
    GewinnModel() {
        gesamtPunkte = 0;
        spielerZahl = 0;
        computerZahl = 0;
        rundenErgebnis = 0;
    }
    /**
     * Ermittelt eine zufällige Computerzahl im Bereich 1–9.
     */
    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }
    /**
     * Berechnet Rundenergebnis und Gesamtpunktestand anhand der Spielerzahl
     * im Vergleich zur zufällig ermittelten Computerzahl.
     */
    public void berechneGesamtPunkte(int spielerZahl) {
        berechneComputerZahl();
        int differenz = spielerZahl - computerZahl;
        if(differenz == 0) {
            rundenErgebnis = 20;
        }else if(differenz == 1 || differenz == -1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
    }
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }
    public int getComputerZahl() {
        return computerZahl;
    }
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public boolean hatGewonnen() {
        return gesamtPunkte >= 0;
    }
    public boolean hatVerloren() {
        return computerZahl <= 0;
    }
}
