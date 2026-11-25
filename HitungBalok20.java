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
        int[][] ukuranBalok = {
            {4, 3, 5},
            {6, 4, 2},
            {5, 5, 5}
        };

        for (int i = 0; i < ukuranBalok.length; i++) {
            int p = ukuranBalok[i][0];
            int l = ukuranBalok[i][1];
            int t = ukuranBalok[i][2];

            int lp = hitungLuasPermukaanBalok(p, l, t);
            int vol = hitungVolume(t, p, l);

            System.out.println("Balok ke-" + (i + 1) + " (" + p + "x" + l + "x" + t + ")");
            System.out.println("  Luas Permukaan : " + lp);
            System.out.println("  Volume         : " + vol);
        }
    }
}