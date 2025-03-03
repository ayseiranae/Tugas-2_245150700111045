import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Berapa orang yang mau dikasih gajinya bang?");
        int jumlahPegawai = sc.nextInt();
        sc.nextLine();

        Pegawai[] pegawaiList = new Pegawai[jumlahPegawai];

        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Siape yg mau digaji nih?");
            String nama = sc.nextLine();
            System.out.println("Apa jabatannye?");
            String jabatan = sc.nextLine();
            System.out.println("Gaji pokoknya berape?");
            int gajiPokok = sc.nextInt();
            sc.nextLine();
            System.out.println("Berape tunjangannya?");
            int tunjangan = sc.nextInt();
            sc.nextLine();
            System.out.println("Udah ngutang berapa dia haha?");
            int potongan = sc.nextInt();
            sc.nextLine();
            System.out.println("Kasih bonusan?");
            int bonus = sc.nextInt();
            sc.nextLine();
            System.out.println("Kasih bonusan lagi kaga? (Y/N)");
            String bonusan = sc.nextLine();
            if (bonusan.equalsIgnoreCase("Y")) {
                System.out.println("Berapa bonusnya?");
                double bonusnye = sc.nextDouble();
                sc.nextLine();
                pegawaiList[i] = new Pegawai(nama, jabatan, gajiPokok, tunjangan, potongan, bonus);
                pegawaiList[i].tambahBonus(bonusnye);
                pegawaiList[i].displayInfo();
            } else if (bonusan.equalsIgnoreCase("N")) {
                System.out.println("Gajinya udah cukup deh");
                pegawaiList[i] = new Pegawai(nama, jabatan, gajiPokok, tunjangan, potongan, bonus);
                pegawaiList[i].displayInfo();
            }
        }
        sc.close();
    }
}
