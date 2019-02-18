public class PenghitungKredit implements Kredit{
    
    private final double pinjaman ;
    private final double sukuBunga;
    private final double tenor;
    private final double biayaAdmin;
    
    public PenghitungKredit(double p, double sb, int t, double ba){
        this.pinjaman = p;
        this.sukuBunga = sb;
        this.tenor = t;
        this.biayaAdmin = ba;
    }
    
    /**
     * Menghitung biaya pokok
     * @return value pokok tipe double
     */
    @Override
    public double pokok(){
        double valuePokok;
        valuePokok = this.pinjaman/this.tenor;
        return valuePokok;
    }
    
    /**
     * Menghitung biaya pokok
     * @param bulanKe
     * @param pokok
     * @return value pokok tipe double
     */
    @Override
    public double bunga(int bulanKe, double pokok){
        double valueBunga;
        valueBunga = ((this.pinjaman-(bulanKe*pokok))*(this.sukuBunga/100))/12;
        return valueBunga;    
    }
    
    /**
     * Menghitung biaya cicilan
     * @param pokok
     * @param bunga
     * @param admin
     * @return value pokok tipe double
     */
    @Override
    public double cicilan(double pokok, double bunga, double admin){
        return pokok+bunga+admin;
    }
        
    /**
     * Simulator untuk menghitung Kredit Efektif
     * @return String dengan format output menyerupai tabel
     */
    @Override
    public String simulasi(){
        String output = "Periode | Angsuran Bunga | Angsuran Pokok | Biaya Admin | Total Angsuran | Sisa Pinjaman";
        output +="\n"+"----------------------------------------------------------------------------------------";
        double tempPokok;
        double tempBunga;
        double tempTotalAngsuran;
        double tempSisaPinjaman = this.pinjaman;
        
        double totalAngsuranBunga=0.0;
        double totalAngsuranPokok=0.0;
        double totalBiayaAdmin=0.0;
        double totalAngsuran=0.0;
        
        for (int i = 0; i < this.tenor; i++) {
            tempPokok = this.pokok();                        
            tempBunga = this.bunga(i,tempPokok);            
            tempTotalAngsuran = this.cicilan(tempPokok,tempBunga,this.biayaAdmin);            
            tempSisaPinjaman = tempSisaPinjaman - tempPokok;   
            
            totalAngsuranBunga+=tempBunga;
            totalAngsuranPokok+=tempPokok;
            totalBiayaAdmin+=this.biayaAdmin;
            totalAngsuran+=tempTotalAngsuran;
            
            output += "\n"+(i+1)+"       | "+String.format("%.2f",tempBunga)+"     | "+String.format("%.2f",tempPokok)+"   | "+String.format("%.2f",this.biayaAdmin)+"    | "+String.format("%.2f",tempTotalAngsuran)+"    | "+String.format("%.2f",tempSisaPinjaman);
        }       
        output +="\n"+"----------------------------------------------------------------------------------------";
        output += "\n"+"TOTAL   | "+String.format("%.2f",totalAngsuranBunga)
                +"    | "+String.format("%.2f",totalAngsuranPokok)
                +"  | "+String.format("%.2f",totalBiayaAdmin)
                +"   | "+String.format("%.2f",totalAngsuran)
                +"   | ";
        
        return output;
    }
            
            
}

