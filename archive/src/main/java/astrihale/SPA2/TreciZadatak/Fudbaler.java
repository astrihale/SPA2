package astrihale.SPA2.TreciZadatak;

import org.svetovid.io.SvetovidReader;

import java.io.*;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class Fudbaler extends InfoTip {

    private String punoIme;
    private String pozicija;
    private int godinaRodjenja;
    private boolean prvaPostava;

    public Fudbaler() {
    }

    public Fudbaler(String punoIme, String pozicija, int godinaRodjenja, boolean prvaPostava) {
        this.punoIme = punoIme;
        this.pozicija = pozicija;
        this.godinaRodjenja = godinaRodjenja;
        this.prvaPostava = prvaPostava;
    }

    @Override
    public InfoTip ucitaj(SvetovidReader r) {
        String punoIme = r.readLine();
        String pozicija = r.readLine();
        int godinaRodjenja = r.readInt();
        boolean prvaPostava = r.readLine().equals("da");
        return new Fudbaler(punoIme, pozicija, godinaRodjenja, prvaPostava);
    }

    public String getPunoIme() {
        return punoIme;
    }

    public String getPozicija() {
        return pozicija;
    }

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public boolean isPrvaPostava() {
        return prvaPostava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fudbaler fudbaler = (Fudbaler) o;
        return prvaPostava == fudbaler.prvaPostava &&
                godinaRodjenja == fudbaler.godinaRodjenja &&
                Objects.equals(punoIme, fudbaler.punoIme) &&
                Objects.equals(pozicija, fudbaler.pozicija);
    }

    @Override
    public int hashCode() {
        int sum = 0;
        sum += punoIme != null ? punoIme.hashCode() : 0;
        sum += pozicija != null ? pozicija.hashCode() : 0;
        sum += Integer.toString(godinaRodjenja).hashCode();
        sum *= prvaPostava ? -1 : 1;
        return sum;
    }

    public static Fudbaler[] ucitajSveIzFajla(String putanja) throws IOException {
        // Proveriti da fajl postoji i otvoriti reader
        BufferedReader reader = new BufferedReader(new FileReader(new File(putanja)));

        // Inicijalizovati listu
        int brojFudbalera = Integer.parseInt(reader.readLine());
        Fudbaler[] fudbaleri = new Fudbaler[brojFudbalera];

        // Procitati sve studente
        for (int i = 0; i < brojFudbalera; i++) {
            String punoIme = reader.readLine();
            String pozicija = reader.readLine();
            int godinaRodjenja = Integer.parseInt(reader.readLine());
            boolean prvaPostava = reader.readLine().equals("da");
            fudbaleri[i] = new Fudbaler(punoIme, pozicija, godinaRodjenja, prvaPostava);
        }

        // Zatvoriti reader i vratiti sve studente
        reader.close();
        return fudbaleri;
    }

    public static void snimiSveUFajl(Fudbaler[] fudbaleri, String putanja) throws IOException {
        // Proveriti da fajl postoji i da otvorimo writer
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(putanja)));

        // Napisati header - broj studenata
        writer.write(fudbaleri.length + "\n");

        // Napisati tri linije za svakog studenta
        for (Fudbaler fudbaler : fudbaleri) {
            writer.write(fudbaler.getPunoIme() + "\n");
            writer.write(fudbaler.getPozicija() + "\n");
            writer.write(fudbaler.getGodinaRodjenja() + "\n");
            writer.write((fudbaler.isPrvaPostava() ? "da" : "ne") + "\n");
        }

        // Zatvoriti writer
        writer.close();
    }
}
