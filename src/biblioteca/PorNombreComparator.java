package biblioteca;

import java.util.Comparator;

public class PorNombreComparator implements Comparator<Prestamo> {

	@Override
	public int compare(Prestamo o1, Prestamo o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}


}
