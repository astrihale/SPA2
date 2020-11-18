package astrihale.SPA2.TreciZadatak;

import java.io.IOException;
import java.util.Arrays;

public class TreciZadatak {

    public static void main(String[] args) {
        // Proveriti odmah da su svi argumenti prosledjeni
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Niste prosledili argumente za putanje do oba fajla.");
        }

        // Procesirati sve odmah
        String putanjaZa2019 = args[0];
        String putanjaZa2020 = args[1];


        // Ucitaj fudbalere
        Fudbaler[] fudbaleri2019;
        Fudbaler[] fudbaleri2020;
        try {
            fudbaleri2019 = Fudbaler.ucitajSveIzFajla(putanjaZa2019);
            fudbaleri2020 = Fudbaler.ucitajSveIzFajla(putanjaZa2020);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Fajl koji je prosledjen za citanje nije dostupan!");
        }

        StatSet<Fudbaler> setFudbalera = new StatSet<>();
        setFudbalera.addAll(Arrays.asList(fudbaleri2019));
        setFudbalera.printStats();
    }
}
