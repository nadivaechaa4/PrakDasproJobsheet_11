public class PengunjungCafe20 {

    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");
        for (int i = 0; i < namaPengunjung.length; i++) {
            System.out.println("- " + namaPengunjung[i]);
        }
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung("Ali", "Budi", "Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");

        System.out.println("Total 1 item : Rp" + hitungTotalBelanja(15000));
        System.out.println("Total 3 item : Rp" + hitungTotalBelanja(15000, 20000, 12000));
        System.out.println("Total 5 item : Rp" + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}