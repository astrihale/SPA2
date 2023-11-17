package vuletic.ana.spa2.zadatak1;

import java.util.Comparator;

public class FilmComparator implements Comparator<Film> {

	public enum SortingParameter {
		ID,
		Naziv,
		Reditelj,
		RediteljINaziv
	}
	
	private SortingParameter parameter;
	private boolean ascending;
	
	public FilmComparator() {
	}
	
	public FilmComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(Film film1, Film film2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
