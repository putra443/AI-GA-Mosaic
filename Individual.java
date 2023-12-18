/*
kelas individual untuk : 
Mewakili individu dalam populasi.
Setiap individu memiliki kromosom biner, nilai kebugaran (fitness), dan properti lainnya.
Berisi metode untuk menetapkan nilai kebugaran, melakukan mutasi, dan crossover (crossover dua titik dilakukan).
*/

import java.util.Random;

import javax.swing.text.html.Option;

public class Individual implements Comparable <Individual>{
    public MosaicBox[][] chromosome;
    public int fitness;
    public Random Myrand;
    public double parentProbability;

    //individual ini buat random pertama value warnanya antara abu sama hitam
    public Individual(Random myRand){
        String optionValue = "abu,hitam";
        String [] option = optionValue.split(",");
        this.Myrand = myRand;
        for(int i=0;i<this.chromosome.length;i++){
            for (int j=0;j<chromosome[i].length;j++){
                this.chromosome[i][j].warna = option[this.Myrand.nextInt(option.length)];
            }
        }
        this.fitness = 0;
        this.parentProbability = 0;
    }

    public Individual(Random myRand, MosaicBox[][] chromosome){
        this.Myrand = myRand;
        this.chromosome = chromosome;
        this.fitness = 0;
        this.parentProbability = 0;
    }
    //setFitness bikin algoritma buat cek 9 kotak radiusnya, kudu mikir jadi 
    //gw tinggalin dulu
    public int setFitness(int maxFitness){
        int currFitness =0;
        for(int i=0;i<chromosome.length;i++){
            for (int j=0;j<this.chromosome[i].length;j++){
                if(this.chromosome[i][j].angkaIsNull!=true){
                    
                }
            }
        }
    }
    //buat algoritma buat crossover kaya cara yang uda di sepakatin, random angka
    //buat milih baris, trus dari nol sampe baris itu diambil dari child 1, kebawahnya
    //diambil dari child 2
    public Individual doCrossOver(Individual other){
        int indexBaris = this.Myrand.nextInt(5);
        


    }
    @Override
    public int compareTo(Individual other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
}
