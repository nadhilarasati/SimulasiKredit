import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double pinjaman ;
        double sukuBunga;
        int tenor;
        double biayaAdmin;
        
        System.out.print("Masukan nilai pinjaman: ");
        pinjaman = sc.nextDouble();
        //pinjaman = 320000000;
        System.out.print("Masukan nilai suku bunga: ");
        sukuBunga = sc.nextDouble();
        //sukuBunga = 16.8;
        System.out.print("Masukan nilai tenor: ");
        tenor = sc.nextInt();
        //tenor=12;
        System.out.print("Masukan nilai biaya admin: ");
        biayaAdmin = sc.nextDouble();
        //biayaAdmin=100000;
        
        System.out.println("");
        System.out.println("");
        PenghitungKredit pk = new PenghitungKredit(pinjaman,sukuBunga,tenor,biayaAdmin);
        System.out.println(pk.simulasi());
    }
}
