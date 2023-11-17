package vuletic.ana.spa2.zadatak1;

import java.util.ArrayList;
import java.util.Arrays;

import org.svetovid.*;
import org.svetovid.io.SvetovidReader;
import org.svetovid.io.SvetovidWriter;

public class Main {

	// Fajlovi se nalaze u <project root>/res folderu!
	private static final String prefix = "res/";
	private static Film[] filmovi;
	
	public static String ucitajImeFajla() {
		return Svetovid.in.readLine("Unesite ime fajla\n>");
	}
	
	public static Film[] ucitajFilmove(SvetovidReader reader) {
		int duzina = reader.readInt();
		Film[] filmovi = new Film[duzina];
		int procitanih = 0;
		while (procitanih < duzina && reader.hasMore()) {
			int id = reader.readInt();
			String naziv = reader.readLine();
			String reditelj = reader.readLine();
			filmovi[procitanih] = new Film(id, naziv, reditelj);
			++procitanih;
		}
		return filmovi;
	}
	
	public static void ispisatiFilmove(SvetovidWriter writer, Film[] filmovi) {
		writer.println(filmovi.length);
		for (int i = 0; i < filmovi.length; ++i) {
			writer.println(filmovi[i].getId());
			writer.println(filmovi[i].getNaziv());
			writer.println(filmovi[i].getReditelj());
		}
	}
	
	public static void main(String[] args) {
		final String imeFajla = prefix + ucitajImeFajla();
		if (!Svetovid.testIn(imeFajla)) {
			Svetovid.out.println("Fajl ne postoji!");
			return;
		}
		
		SvetovidReader reader = Svetovid.in(imeFajla);
		Svetovid.out.println("Uspesno pronadjen fajl.");
		
		filmovi = ucitajFilmove(reader);
		Svetovid.out.println("Uspesno ucitani filmovi.");
		reader.close();
		reader = null;
		
		// Prvi metod sortiranja
		Arrays.sort(filmovi);
		Svetovid.out.println("Uspesno sortirani filmovi.");
		
		// Drugi metod sortiranja
		
		
		final String rezultatFajl = prefix + "ispis.txt";
		if (!Svetovid.testOut(rezultatFajl)) {
			Svetovid.out.println("Nije moguce ispisati rezultat.");
			return;
		}
		
		SvetovidWriter writer = Svetovid.out(rezultatFajl);
		ispisatiFilmove(writer, filmovi);
		Svetovid.out.println("Uspesno ispisani filmovi.");
		writer.close();
		writer = null;
	}

}
