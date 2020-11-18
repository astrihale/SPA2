package astrihale.SPA2.DrugiZadatak;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("SpellCheckingInspection")
class DrugiZadatak {
    public static void main(String[] args) {
        // Proveriti odmah da su svi argumenti prosledjeni
        if (args.length < 3) {
            throw new IllegalArgumentException(
                    "Niste prosledili argumente za putanju fajla za citanje/pisanje i mod rada.");
        }

        // Procesirati odmah sve argumente
        String fajlZaCitanje = args[0];
        String fajlZaPisanje = args[1];
        try {
            int modSortiranja = Integer.parseInt(args[2]);

            // Namestiti rad sortiranja
            if (modSortiranja < 1 || modSortiranja > 3) {
                throw new IllegalArgumentException("Broj koji ste prosleditili mora biti 1, 2 ili 3.");
            }

            // Namestiti opciju sortiranja
            Student.setOpcijuSortiranja(modSortiranja);
        } catch (NumberFormatException exception) {
            // Uhvatiti ukoliko broj ne moze da se parsira
            throw new IllegalArgumentException("Morate proslediti validan broj (1, 2, 3) kao treci argument!");
        }

        try {
            // Ucitati sve studente iz fajla
            Student[] studenti = Student.ucitajSveIzFajla(fajlZaCitanje);

            // Sortiraj sve studente, stanje je vec namesteno
            Arrays.sort(studenti);

            // Zapisi sve studente nazad
            Student.snimiSveUFajl(studenti, fajlZaPisanje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
