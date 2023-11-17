package vuletic.ana.spa2.zadatak1;

public class Film implements Comparable<Film> {

	private int id;
	private String naziv;
	private String reditelj;
	
	public Film(int id, String naziv, String reditelj) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.reditelj = reditelj;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getReditelj() {
		return reditelj;
	}

	@Override
	public int compareTo(Film rValue) {
		if (reditelj == rValue.reditelj)
			return naziv.compareTo(rValue.naziv);
		return reditelj.compareTo(rValue.reditelj);
	}
}
