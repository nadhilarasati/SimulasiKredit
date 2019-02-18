
public interface Kredit {
	public double pokok(); //ngitung biaya pokok
	public double bunga(int bulan, double pokok); //ngitung besarnya bunga
	public double cicilan(double pokok, double bunga, double admin); //ngitung biaya cicilan
	public String simulasi(); //simulator menghitung kredit
}
