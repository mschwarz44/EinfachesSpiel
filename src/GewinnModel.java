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
        return false;
    }
    public boolean hatVerloren() {
        return false;
    }
}
