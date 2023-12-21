import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Individual implements Comparable<Individual> {
    public String[][] chromosome;
    public KoordinatAngka[] koordinatAngka;
    public int fitness;
    public Random myRand;
    public double parentProbability;

    public Individual(Random myRand) {
        this.myRand = myRand;
        String optionValue = "abu,hitam";
        String[] option = optionValue.split(",");
        this.chromosome = new String[5][5];
        for (int i = 0; i < this.chromosome.length; i++) {
            for (int j = 0; j < this.chromosome[i].length; j++) {
                String warna = option[this.myRand.nextInt(option.length)];
                this.chromosome[i][j] = warna;
            }
        }
        this.fitness = 0;
        this.parentProbability = 0;
        this.koordinatAngka = koordinatAngka;
    }

    public Individual(Random myRand, KoordinatAngka[] koordinatAngka) {
        this.myRand = myRand;
        this.fitness = 0;
        this.parentProbability = 0;
        this.koordinatAngka = koordinatAngka;
    }

    public int setFitness(String[][] inputMosaic, KoordinatAngka[] koordinats, int maxFitness) {
        int fitnessAngka = 0;
        for (KoordinatAngka koordinat : koordinats) {
            int tempHitam = 0;
            int numRows = this.chromosome.length;
            int numCols = this.chromosome[0].length;

            // Define relative indices for neighbors (horizontal, vertical, and diagonal)
            int[][] directions = {
                    { -1, -1 }, { -1, 0 }, { -1, 1 },
                    { 0, -1 }, { 0, 0 }, { 0, 1 },
                    { 1, -1 }, { 1, 0 }, { 1, 1 }
            };

            for (int[] direction : directions) {
                int newRow = koordinat.baris + direction[0];
                int newCol = koordinat.kolom + direction[1];

                // Check if the new indices are within bounds
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                    String neighborValue = this.chromosome[newRow][newCol];
                    // System.out.println(neighborValue);

                    if (neighborValue.equals("hitam")) {
                        tempHitam += 1;
                    }
                }
            }
            if (tempHitam > koordinat.angka) {
                this.fitness = -1;
            }
            // } else if (tempHitam < koordinat.angka) {
            // this.fitness += 0;
            // }
            else if (tempHitam == koordinat.angka) {
                this.fitness += 1;
            }
        }
        // System.out.println(this.fitness);
        if (this.fitness > koordinats.length) {
            return this.fitness = -1;
        } else
            return this.fitness;
        // return this.fitness;
    }

    public void doMutation() {
        for (int i = 0; i < this.chromosome.length; i++) {
            for (int j = 0; j < this.chromosome[0].length; j++) {
                if (this.chromosome[i][j] == "hitam") {
                    this.chromosome[i][j] = "abu";
                } else {
                    this.chromosome[i][j] = "hitam";
                }
            }
        }
    }

    public Individual doCrossOver(Individual other) {
        int panjangBaris = this.chromosome.length;
        int panjangKolom = this.chromosome[0].length;
        int indexBarisPivot = this.myRand.nextInt(panjangBaris);

        String[][] chromosomeChild1 = new String[5][5];
        String[][] chromosomeChild2 = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                chromosomeChild1[i][j] = "abu";
                chromosomeChild2[i][j] = "abu";
            }
        }

        Individual child1 = new Individual(this.myRand, this.koordinatAngka);
        Individual child2 = new Individual(this.myRand, this.koordinatAngka);

        child1.chromosome = chromosomeChild1;
        child2.chromosome = chromosomeChild2;
        for (int i = 0; i < panjangBaris; i++) {
            for (int j = 0; j < panjangKolom; j++) {
                if (i <= indexBarisPivot) {
                    child1.chromosome[i][j] = this.chromosome[i][j];
                    child2.chromosome[i][j] = other.chromosome[i][j];
                }
                if (i > indexBarisPivot) {
                    child1.chromosome[i][j] = other.chromosome[i][j];
                    child2.chromosome[i][j] = this.chromosome[i][j];
                }
            }
        }
        int choose = this.myRand.nextInt(2);
        if (choose == 0)
            return child1;
        else
            return child2;
    }

    @Override
    public int compareTo(Individual other) {
        if (this.fitness > other.fitness)
            return -1;
        else if (this.fitness < other.fitness)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        String res = new String(this.chromosome + " " + this.printArray(this.chromosome) + " " + this.fitness);
        return res;
    }

    public static String printArray(String[][] chromosome) {
        String res = "";
        for (int i = 0; i < chromosome.length; i++) {
            for (int j = 0; j < chromosome[0].length; j++) {
                res += (chromosome[i][j] + " ");
            }
            res += '\n';
        }
        return res;
    }
}
