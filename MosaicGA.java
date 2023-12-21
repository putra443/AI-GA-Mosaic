import java.util.Random;

public class MosaicGA {
    Random myRand;
    public int maxPopulationSize;
    public double elitismPct;
    public double mutationRate;
    public double crossoverRate;
    public int totalGeneration;
    int maxFitness;

    public MosaicGA(Random myRand, int totalGeneration, int maxPopulationSize,
    double elitismPct, double mutationRate, double crossoverRate, MosaicBox[][] mosaic, int maxFitness) { 
        this.myRand = myRand;
        this.totalGeneration = totalGeneration;
        this.maxPopulationSize = maxPopulationSize;
        this.elitismPct = elitismPct;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.maxFitness = maxFitness;
    }

    public Individual run(){
        int generation = 1;
        Population currentPopulation = new Population(myRand, this.maxFitness, this.maxPopulationSize, this.elitismPct);
        currentPopulation.randomPopulation();
        currentPopulation.computeAllFitnesses();
        while (terminate(generation)==false) {
        	//System.out.println("Gen : "+generation+" Best: "+currentPop.getBestIdv().fitness);
            Population newPop = currentPopulation.getNewPopulationWElit();
            //System.out.println(newPop);
            while (newPop.isFilled()==false) {
            	//System.out.println("fill");
                Individual[] parents = currentPopulation.selectParent();
                //System.out.println(parents[0]);
                //System.out.println(parents[1]);
                if (this.myRand.nextDouble()<this.crossoverRate) {
                	//System.out.println("crossed");
                    Individual child = parents[0].doCrossOver(parents[1]);
                    if (this.myRand.nextDouble()<this.mutationRate) {
                        //System.out.println("mutate");
                        child.doMutation();
                    }
                    newPop.addIndividual(child);
                }
                //else System.out.println("not crossed");
            }
            generation++;
            currentPopulation = newPop;
            currentPopulation.computeAllFitnesses();
            //System.out.println(currentPop);
            //report pop
        }
        return currentPopulation.getBestIdv();
    }

    public boolean terminate(int generation){
        if (generation >= this.totalGeneration) return true;
        else return false;
        //or by running time
        //or population not changed
    }
}
