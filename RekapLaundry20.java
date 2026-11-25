import java.util.Scanner;

public class RekapLaundry20 {

    public static void inputData(int[][] data, String[] layanan, int jmlHari, Scanner sc) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan: " + layanan[i]);
            for (int j = 0; j < jmlHari; j++) {
                System.out.print("  Hari ke-" + (j + 1) + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilTabel(int[][] data, String[] layanan, int[] harga, int jmlHari) {
        System.out.println("\n==================== REKAP BERAT CUCIAN (KG) ====================");
        System.out.printf("%-15s | %-10s", "Layanan", "Harga/kg");
        for (int j = 0; j < jmlHari; j++) {
            System.out.printf(" | %-9s", "Hari ke-" + (j + 1));
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s | Rp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < jmlHari; j++) {
                System.out.printf(" | %-9d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================================================");
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    public static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int totalSekarang = totalPerLayanan(data, i);
            if (totalSekarang > maxBerat) {
                maxBerat = totalSekarang;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan total berat tertinggi: " + layanan[idxMax] + " (" + maxBerat + " kg)");
    }

    public static int hariTersibuk(int[][] data) {
        int idxHariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (j == 0 || totalHari > maxBeratHari) {
                maxBeratHari = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    public static void hitungDanTampilPendapatan(int[][] data, String[] layanan, int[] harga, int jmlHari) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN (" + jmlHari + " HARI) ===");
        int totalSemuaPendapatan = 0;

        for (int i = 0; i < layanan.length; i++) {
            int beratLayanan = totalPerLayanan(data, i);
            int pendapatan = beratLayanan * harga[i];
            totalSemuaPendapatan += pendapatan;
            System.out.printf("%-15s: %d kg x Rp%,d = Rp%,d\n", layanan[i], beratLayanan, harga[i], pendapatan);
        }
        System.out.printf("Total Pendapatan Keseluruhan: Rp%,d\n", totalSemuaPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jmlHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jmlLayanan];
        int[] harga = new int[jmlLayanan];
        int[][] dataCucian = new int[jmlLayanan][jmlHari];

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.println("\nData Layanan ke-" + (i + 1));
            System.out.print("  Nama layanan : ");
            layanan[i] = sc.nextLine();
            System.out.print("  Harga per kg : ");
            harga[i] = sc.nextInt();
            sc.nextLine(); 
        }

        inputData(dataCucian, layanan, jmlHari, sc);
        tampilTabel(dataCucian, layanan, harga, jmlHari);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(dataCucian, i) + " kg");
        }

        tampilLayananTertinggi(dataCucian, layanan);
        int idxSibuk = hariTersibuk(dataCucian);
        System.out.println("Hari tersibuk: Hari ke-" + (idxSibuk + 1));

        hitungDanTampilPendapatan(dataCucian, layanan, harga, jmlHari);

        sc.close();
    }
}