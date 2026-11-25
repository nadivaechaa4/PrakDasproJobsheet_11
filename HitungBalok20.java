import java.util.Scanner;

public class HitungBalok20 {

    static int hitungLuas(int pjg, int lb) {
        return pjg * lb;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        return hitungLuas(a, b) * tinggi;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Balok ke-" + i + " ===");
            System.out.print("Masukkan panjang : ");
            int p = input.nextInt();

            System.out.print("Masukkan lebar   : ");
            int l = input.nextInt();

            System.out.print("Masukkan tinggi  : ");
            int t = input.nextInt();

            int luasPermukaan = hitungLuasPermukaanBalok(p, l, t);
            int volume = hitungVolume(t, p, l);

            System.out.println("Luas Permukaan Balok ke-" + i + " : " + luasPermukaan);
            System.out.println("Volume Balok ke-" + i + "         : " + volume);
            System.out.println();
        }

        input.close();
    }
}