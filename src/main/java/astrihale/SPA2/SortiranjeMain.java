package astrihale.SPA2;

import java.io.*;
import java.util.Arrays;

class Student implements Comparable<Student> {
    private String ime;
    private String prezime;
    private int godinaUpisa;

    public Student(String ime, String prezime, int godinaUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaUpisa = godinaUpisa;
    }

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
        int godinaCompare = Integer.compare(godinaUpisa, o.godinaUpisa);
        int prezimeCompare = prezime.compareTo(o.prezime);
        int imeCompare = ime.compareTo(o.ime);
        return godinaCompare != 0 ? godinaCompare : (prezimeCompare != 0 ? prezimeCompare : imeCompare);
    }
}

class SortiranjeMain {

    public static Student[] ucitajStudenteIzFajla(String putanja) {
        try {
            // Proverimo da fajl postoji
            File file = new File(putanja);
            if (!file.exists()) {
                return null;
            }

            // Napravimo BufferedReader i krenemo liniju po liniju da citamo
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int brojStudenata = Integer.parseInt(reader.readLine());
            Student[] studenti = new Student[brojStudenata];
            for (int i = 0; i < brojStudenata; i++) {
                String prezime = reader.readLine();
                String ime = reader.readLine();
                int godinaRodjenja = Integer.parseInt(reader.readLine());
                studenti[i] = new Student(ime, prezime, godinaRodjenja);
            }
            return studenti;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean snimiStudenteUFajl(Student[] studenti, String putanja) {
        try {
            // Proverimo da fajl postoji
            File file = new File(putanja);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return false;
                }
            }

            // Napravimo BufferedWriter i pisemo svakog studenta u istom formotu
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(studenti.length + "\n");
            for (Student student : studenti) {
                writer.write(student.getPrezime() + "\n");
                writer.write(student.getIme() + "\n");
                writer.write(student.getGodinaUpisa() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Prestanemo odmah ako ne znamo koji fajl treba
        if (args.length < 2) {
            throw new IllegalArgumentException("Niste prosledili argumente za putanje do fajlova.");
        }

        // Ucitamo studente iz fajla
        System.out.println("Radimo sa fajlom '" + args[0] + "'.");
        Student[] studenti = ucitajStudenteIzFajla(args[0]);
        if (studenti == null) {
            throw new IllegalStateException("Fajl za ucitavanje nije validan.");
        }

        Arrays.sort(studenti);

        System.out.println("Snimamo u fajl '" + args[1] + "'.");
        if (!snimiStudenteUFajl(studenti, args[1])) {
            System.out.println("Studenti nisu uspesno snimljeni u fajl.");
            return;
        }
        System.out.println("Uspesno snimljeno sve u fajl '" + args[1] + "'.");
    }
}