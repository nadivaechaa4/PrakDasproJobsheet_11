import java.util.Scanner;

public class RekapLaundry20 {

    public static void inputData(int[][] data, String[] layanan, String[] hari, Scanner sc) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan: " + layanan[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.println("\n==================== REKAP BERAT CUCIAN (KG) ====================");
        System.out.printf("%-15s | %-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf(" | %-6s", h);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s | Rp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf(" | %-6d", data[i][j]);
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

    public static void hitungDanTampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN (6 HARI) ===");
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

        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] dataCucian = new int[layanan.length][hari.length];

        inputData(dataCucian, layanan, hari, sc);

        tampilTabel(dataCucian, layanan, harga, hari);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(dataCucian, i) + " kg");
        }

        tampilLayananTertinggi(dataCucian, layanan);
        int idxSibuk = hariTersibuk(dataCucian);
        System.out.println("Hari tersibuk: " + hari[idxSibuk]);

        hitungDanTampilPendapatan(dataCucian, layanan, harga);

        sc.close();
    }
}