import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        Random init = new Random();
        KoordinatAngka[] koordinatAngka = new KoordinatAngka[11];
        System.out.println("Target: " + koordinatAngka.length);
        for (int i = 0; i < koordinatAngka.length; i++) {
            int angka = sc.nextInt();
            int baris = sc.nextInt();
            int kolom = sc.nextInt();
            koordinatAngka[i] = new KoordinatAngka(angka, baris, kolom);
        }
        int totalGeneration = 0, maxPopulationSize = 0;
        double crossoverRate = 0.0, mutationRate = 0.0, elitismPct = 0.0;
        totalGeneration = sc.nextInt();
        maxPopulationSize = sc.nextInt();
        crossoverRate = sc.nextDouble();
        mutationRate = sc.nextDouble();
        elitismPct = sc.nextDouble();
        for (int ct = 1; ct <= loop; ct++) {
            long seed = init.nextLong();
            // System.out.println(seed);
            Random gen = new Random(seed);

            String[][] inputMosaic = new String[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    inputMosaic[i][j] = "abu";
                }
            }

            int maxFitness = koordinatAngka.length;
            MosaicGA ga = new MosaicGA(gen, totalGeneration, maxPopulationSize, elitismPct, crossoverRate, mutationRate,
                    inputMosaic, koordinatAngka);
            Individual res = ga.run();
            // System.out.println(Individual.printArray(res.chromosome));
            double finalFitness = (1.0 * res.fitness / maxFitness);
            // if ((res.fitness) == 11) {
            // System.out.println(Individual.printArray(res.chromosome));
            // }
            System.out.printf("%2d: Acc = %.3f (%d) (%d) Seed: %d\n", ct, finalFitness,
                    res.fitness, maxFitness, seed);
            // System.out.println("Hasil array : ");
            // System.out.println(Individual.printArray(res.chromosome));
        }
    }
}
