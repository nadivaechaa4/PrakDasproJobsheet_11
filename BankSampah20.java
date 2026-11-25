import java.util.Scanner;

public class BankSampah20 {

    public static double[] inputSetoran(int n) {
        Scanner input = new Scanner(System.in);
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = input.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n=== DAFTAR SETORAN SAMPAH ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.printf("Nasabah ke-%d: %.2f kg\n", (i + 1), setoran[i]);
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int indeksMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksMax]) {
                indeksMax = i;
            }
        }
        return indeksMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hargaPerKg = 3000;

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah nasabah harus lebih dari 0.");
            sc.close();
            return;
        }

        double[] dataSetoran = inputSetoran(n);
        tampilSetoran(dataSetoran);

        System.out.println("\n=== SALDO SETIAP NASABAH (Rp3.000/kg) ===");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.printf("Nasabah ke-%d: Rp%,.2f\n", (i + 1), saldo);
        }

        double totalBerat = totalSetoran(dataSetoran);
        int idxTerbanyak = nasabahTerbanyak(dataSetoran);

        System.out.println("\n=== RINGKASAN ===");
        System.out.printf("Total berat setoran seluruh nasabah: %.2f kg\n", totalBerat);
        System.out.printf("Nasabah dengan setoran terbanyak: Nasabah ke-%d (%.2f kg)\n",
                (idxTerbanyak + 1), dataSetoran[idxTerbanyak]);

        sc.close();
    }
}