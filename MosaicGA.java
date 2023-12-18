import java.util.Random;

public class MosaicGA {
    Random myRand;
    public int maxPopulationSize;
    public double elitismPct;
    public double mutationRate;
    public double crossoverRate;
    public int totalGeneration;
    Mosaic mosaic;
    int maxFitness;

    public MosaicGA(Random MyRand, int totalGeneration, int maxPopulationSize,
    double elitismPct, double mutationRate, double crossoverRate, Mosaic mosaic, int maxFitness) { 
        this.myRand = MyRand;
        this.totalGeneration = totalGeneration;
        this.maxPopulationSize = maxPopulationSize;
        this.elitismPct = elitismPct;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.mosaic = mosaic;
        this.maxFitness = maxFitness;
    }

    public Individual run(){
        int generation = 1;
        Population currentPopulation = new Population(MyRand,this.mosaic, this.maxFitness, this.maxPopulationSize, this.elitismPct);
    }
}
