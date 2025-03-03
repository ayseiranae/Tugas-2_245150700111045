import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

class Pegawai {
    private String nama;
    private String jabatan;
    private double gajiPokok;
    private double tunjangan;
    private double potongan;
    private double bonus;
    
    private final Locale rupiahLocale = new Locale.Builder().setLanguage("id").setRegion("ID").build();
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(rupiahLocale);

    public LocalDateTime now = LocalDateTime.now();
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
    private String tanggalWaktu;

    public Pegawai() {
        this.nama = "";
        this.jabatan = "";
        this.gajiPokok = 0;
        this.tunjangan = 0;
        this.potongan = 0;
        this.bonus = 0;
        this.tanggalWaktu = now.format(formatter);
    }

    public Pegawai(String nama, String jabatan, double gajiPokok, double tunjangan, double potongan, double bonus) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
        this.potongan = potongan;
        this.bonus = bonus;
        this.tanggalWaktu = now.format(formatter);
    }

    public double hitungGajiTotal() {
        return gajiPokok + tunjangan + bonus - potongan;
    }


    void justify(String label, String value) {
        int width = 50;
        int separator = 15;
        System.out.print(String.format("%-" + separator + "s: %" + (width - separator - 2) + "s\n", label, value));
    }

    void center(String text) {
        int tengah = (50 - text.length()) / 2;        
        for (int i = 0; i < tengah; i++) {
            System.out.print(" ");
        }        
        System.out.println(text);
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("__________________________________________________");
        justify("Time", tanggalWaktu);
        justify("Nama Pegawai ", nama);
        justify("Jabatan ", jabatan);
        justify("Gaji Pokok ", currencyFormat.format(gajiPokok));
        justify("Tunjangan ", currencyFormat.format(tunjangan));
        justify("Potongan : ", currencyFormat.format(potongan));
        justify("Bonus : ", currencyFormat.format(bonus));
        justify("Total Gaji : ", currencyFormat.format(hitungGajiTotal()));
        System.out.println("__________________________________________________");
        System.out.println();
    }

    public void tambahBonus(double tambahanBonus) {
        this.bonus += tambahanBonus;
        System.out.println("Bonus sebesar " + currencyFormat.format(tambahanBonus) + " diwehno meneh");
    }
}
