package astrihale.SPA2.DrugiZadatak;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
class Student implements Comparable<Student> {

    // Interna logika koja odredjuje na koji nacin radi `compareTo` metoda.
    private static int sortOption = 1;

    // Setter za tu vrednost
    public static void setOpcijuSortiranja(int sortOption) {
        Student.sortOption = sortOption;
    }

    // Interna polja klase Student
    private final String ime;
    private final String prezime;
    private final int godinaUpisa;

    // Defaultni konstruktor koji zahteva sve vrednosti
    public Student(String ime, String prezime, int godinaUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaUpisa = godinaUpisa;
    }

    // Defaultni getteri za sve vrednosti
    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    @Override
    public int compareTo(Student o) {
        switch (sortOption) {
            case 1:
                return ime.compareTo(o.ime);
            case 2:
                int godinaDiff = Integer.compare(godinaUpisa, o.godinaUpisa);
                return godinaDiff == 0 ? prezime.compareTo(o.prezime) : godinaDiff;
            case 3:
                return Integer.compare(o.ime.length() + o.prezime.length(), ime.length() + prezime.length());
            default:
                throw new IllegalStateException("Korisnik mora da odabere izbor rada za sortiranje.");
        }
    }

    public static Student[] ucitajSveIzFajla(String putanja) throws IOException {
        // Proveriti da fajl postoji i otvoriti reader
        BufferedReader reader = new BufferedReader(new FileReader(new File(putanja)));

        // Inicijalizovati listu
        int brojStudenata = Integer.parseInt(reader.readLine());
        Student[] studenti = new Student[brojStudenata];

        // Procitati sve studente
        for (int i = 0; i < brojStudenata; i++) {
            String prezime = reader.readLine();
            String ime = reader.readLine();
            int godinaRodjenja = Integer.parseInt(reader.readLine());
            studenti[i] = new Student(ime, prezime, godinaRodjenja);
        }

        // Zatvoriti reader i vratiti sve studente
        reader.close();
        return studenti;
    }

    public static void snimiSveUFajl(Student[] studenti, String putanja) throws IOException {
        // Proveriti da fajl postoji i da otvorimo writer
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(putanja)));

        // Napisati header - broj studenata
        writer.write(studenti.length + "\n");

        // Napisati tri linije za svakog studenta
        for (Student student : studenti) {
            writer.write(student.getPrezime() + "\n");
            writer.write(student.getIme() + "\n");
            writer.write(student.getGodinaUpisa() + "\n");
        }

        // Zatvoriti writer
        writer.close();
    }
}
