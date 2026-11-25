import java.util.Scanner;

public class KubusLimas20 {

    public static int luasPersegi(int s) {
        return s * s;
    }

    public static int volumeKubus(int s) {
        return s * s * s;
    }

    public static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    public static double volumeLimasPersegi(int s, int t) {
        return (luasPersegi(s) * t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU PERHITUNGAN BANGUN RUANG ===");
            System.out.println("1. Volume Kubus");
            System.out.println("2. Luas Permukaan Kubus");
            System.out.println("3. Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-3): ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi kubus: ");
                    int sVol = sc.nextInt();
                    System.out.println("Volume Kubus = " + volumeKubus(sVol));
                    break;
                case 2:
                    System.out.print("Masukkan panjang sisi kubus: ");
                    int sLuas = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(sLuas));
                    break;
                case 3:
                    System.out.print("Masukkan panjang sisi alas limas: ");
                    int sLimas = sc.nextInt();
                    System.out.print("Masukkan tinggi limas: ");
                    int tLimas = sc.nextInt();
                    System.out.printf("Volume Limas Persegi = %.2f\n", volumeLimasPersegi(sLimas, tLimas));
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}