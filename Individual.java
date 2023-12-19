/*
kelas individual untuk : 
Mewakili individu dalam populasi.
Setiap individu memiliki kromosom biner, nilai kebugaran (fitness), dan properti lainnya.
Berisi metode untuk menetapkan nilai kebugaran, melakukan mutasi, dan crossover (crossover dua titik dilakukan).
*/

import java.util.Random;

import javax.swing.text.html.Option;

public class Individual implements Comparable<Individual> {
    public MosaicBox[][] chromosome;
    public int fitness;
    public Random Myrand;
    public double parentProbability;

    // individual ini buat random pertama value warnanya antara abu sama hitam
    public Individual(Random myRand) {
        String optionValue = "abu,hitam";
        String[] option = optionValue.split(",");
        this.Myrand = myRand;
        for (int i = 0; i < this.chromosome.length; i++) {
            for (int j = 0; j < chromosome[i].length; j++) {
                this.chromosome[i][j].warna = option[this.Myrand.nextInt(option.length)];
            }
        }
        this.fitness = 0;
        this.parentProbability = 0;
    }

    public Individual(Random myRand, MosaicBox[][] chromosome) {
        this.Myrand = myRand;
        this.chromosome = chromosome;
        this.fitness = 0;
        this.parentProbability = 0;
    }

    // setFitness bikin algoritma buat cek 9 kotak radiusnya, kudu mikir jadi
    // gw tinggalin dulu
    public int setFitness(int maxFitness) {
        int currFitness = 0;
        for (int i = 0; i < chromosome.length; i++) {
            for (int j = 0; j < this.chromosome[i].length; j++) {
                if (this.chromosome[i][j].angka != null) {
                    int numRows = this.chromosome.length;
                    int numCols = this.chromosome[0].length;
                    int counterHitam = 0;
                    int[][] directions = {
                            { -1, -1 }, { -1, 0 }, { -1, 1 },
                            { 0, -1 }, { 0, 1 },
                            { 1, -1 }, { 1, 0 }, { 1, 1 }
                    };

                    for (int[] direction : directions) {
                        int newRow = i + direction[0];
                        int newCol = j + direction[1];

                        if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                            String warnaTetangga = this.chromosome[newRow][newCol].warna;
                            if (warnaTetangga == "hitam") {
                                counterHitam++;
                            }
                        }
                    }
                    if (counterHitam > Integer.parseInt(this.chromosome[i][j].angka)) {
                        this.chromosome[i][j].value_fitness = "-1";
                        currFitness += Integer.parseInt(this.chromosome[i][j].value_fitness);
                    } else if (counterHitam < Integer.parseInt(this.chromosome[i][j].angka)) {
                        this.chromosome[i][j].value_fitness = "0";
                        currFitness += Integer.parseInt(this.chromosome[i][j].value_fitness);
                    } else {
                        this.chromosome[i][j].value_fitness = "1";
                        currFitness += Integer.parseInt(this.chromosome[i][j].value_fitness);
                    }
                }
            }
        }
        return currFitness;
    }

    // buat algoritma buat crossover kaya cara yang uda di sepakatin, random angka
    // buat milih baris, trus dari nol sampe baris itu diambil dari child 1,
    // kebawahnya
    // diambil dari child 2
    public Individual doCrossOver(Individual other) {
        int panjangBaris = this.chromosome.length;
        int panjangKolom = this.chromosome[0].length;
        int indexBarisPivot = this.Myrand.nextInt(panjangBaris);

        MosaicBox[][] chromosomeChild1 = new MosaicBox[panjangBaris][panjangKolom];
        MosaicBox[][] chromosomeChild2 = new MosaicBox[panjangBaris][panjangKolom];

        Individual child1 = new Individual(this.Myrand, chromosomeChild1);
        Individual child2 = new Individual(this.Myrand, chromosomeChild2);

        for (int i = 0; i < panjangBaris; i++) {
            for (int j = 0; j < panjangKolom; i++) {
                if(child1 )
            }
        }

    }

    @Override
    public int compareTo(Individual other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
