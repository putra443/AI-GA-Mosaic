import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class Population {
    public ArrayList<Individual> population;
    private int maxPopulationSize;
    private int populationSize = 0;
    public double elitismPct;
    int maxFitness;
    int sumRank = 0;
    Random MyRand;

    public Population(Random MyRand,  int maxFitness, int maxPopulationSize,
            double elitismPct) {
        this.MyRand = MyRand;
        this.maxPopulationSize = maxPopulationSize;
        this.population = new ArrayList<Individual>();
        this.elitismPct = elitismPct;
        this.maxFitness = maxFitness;
        for (int i = 1; i <= this.maxPopulationSize; i++)
            this.sumRank = this.sumRank + i;

    }

    public void randomPopulation() {
        for (int i = 0; i < this.maxPopulationSize; i++) {
            this.addIndividual(new Individual(this.MyRand));
        }
    }

    public boolean addIndividual(Individual newIdv) {
        if (this.populationSize >= this.maxPopulationSize)
            return false;
        this.population.add(newIdv);
        this.populationSize++;
        return true;
    }

    public void computeAllFitnesses() {
        for (int i = 0; i < this.populationSize; i++) {
            ((Individual) this.population.get(i)).setFitness(maxFitness);
        }
        this.population.sort((idv1, idv2) -> idv1.compareTo(idv2));
    }

    public Population getNewPopulationWElit() {
        Population newPop = new Population(this.MyRand,  this.maxFitness, this.populationSize,
                this.elitismPct);
        int n = (int) (this.elitismPct * this.maxPopulationSize);
        // System.out.println(n);
        // System.out.println(this.population.size());
        for (int i = 0; i < n; i++) {
            // System.out.println(i);
            boolean res = newPop.addIndividual(this.population.get(i));
        }
        return newPop;
    }

    public boolean isFilled() {
        return this.maxPopulationSize == this.populationSize;
    }

    /*
     * public Individual[] selectParent() { //rank selection
     * Individual[] parents = new Individual[2];
     * this.population.sort((idv1,idv2) -> idv1.compareTo(idv2));
     * int top = this.population.size()+1;
     * for (int i=0;i<this.population.size();i++) {
     * ((Individual)this.population.get(i)).parentProbability =
     * (1.0*top)/this.sumRank;
     * }
     * for (int n = 0;n<2;n++) {
     * int i=-1;
     * double prob = this.MyRand.nextDouble();
     * double sum = 0.0;
     * do {
     * i++;
     * sum = sum + this.population.get(i).parentProbability;
     * } while(sum<prob);
     * parents[n] = this.population.get(i);
     * }
     * return parents;
     * }
     */

    public Individual[] selectParent() { // roulette wheel
        Individual[] parents = new Individual[2];
        // this.population.sort((idv1,idv2) -> idv1.compareTo(idv2));
        int top = this.population.size() + 1;
        long sumfitness = 0;
        for (int i = 0; i < this.population.size(); i++) {
            sumfitness = sumfitness + this.population.get(i).fitness;
        }
        // System.out.println(sumfitness);
        for (int i = 0; i < this.population.size(); i++) {
            ((Individual) this.population.get(i)).parentProbability = (1.0 * this.population.get(i).fitness)
                    / sumfitness;
        }
        for (int n = 0; n < 2; n++) {
            int i = -1;
            double prob = this.MyRand.nextDouble();
            double sum = 0.0;
            do {
                i++;
                sum = sum + this.population.get(i).parentProbability;
            } while (sum < prob);
            parents[n] = this.population.get(i);
        }
        return parents;
    }

    public Individual getBestIdv() {
        // int top = this.population.size()+1;
        return this.population.get(0);
    }

    @Override
    public String toString() {
        String res = new String();
        for (int i = 0; i < this.population.size(); i++) {
            res = res + new String(this.population.get(i) + "\n");
        }
        return res;
    }
}