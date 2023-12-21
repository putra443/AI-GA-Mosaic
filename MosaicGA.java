import java.util.ArrayList;
import java.util.Random;

public class MosaicGA {
    Random MyRand;
    public int maxPopulationSize;
    public double elitismPct;
    public double crossoverRate;
    public double mutationRate;
    public int totalGeneration;
    String[][] inputMosaic;
    KoordinatAngka[] koordinatAngka;

    public MosaicGA(Random MyRand, int totalGeneration, int maxPopulationSize, double elitismPct,
                    double crossoverRate, double mutationRate, String[][] inputMosaic,KoordinatAngka[] koordinatAngka) {
        this.MyRand = MyRand;
        this.totalGeneration = totalGeneration;
        this.maxPopulationSize = maxPopulationSize;
        this.elitismPct = elitismPct;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.inputMosaic = inputMosaic;
        this.koordinatAngka = koordinatAngka;
    }
    public Individual run() {
        int generation = 1;
        Population currentPop = new Population(MyRand,this.inputMosaic, this.maxPopulationSize, this.elitismPct, this.koordinatAngka);
        currentPop.randomPopulation();
        currentPop.computeAllFitnesses();
        //System.out.println(currentPop);
        while (terminate(generation)==false) {
        	//System.out.println("Gen : "+generation+" Best: "+currentPop.getBestIdv().fitness);
            Population newPop = currentPop.getNewPopulationWElit();
            //System.out.println(newPop);
            while (newPop.isFilled()==false) {
            	//System.out.println("fill");
                Individual[] parents = currentPop.selectParent();
                //System.out.println(parents[0]);
                //System.out.println(parents[1]);
                if (this.MyRand.nextDouble()<this.crossoverRate) {
                	//System.out.println("crossed");
                    Individual child = parents[0].doCrossOver(parents[1]);
                    if (this.MyRand.nextDouble()<this.mutationRate) {
                        //System.out.println("mutate");
                        child.doMutation();
                    }
                    newPop.addIndividual(child);
                }
                //else System.out.println("not crossed");
            }
            generation++;
            currentPop = newPop;
            currentPop.computeAllFitnesses();
            //System.out.println(currentPop);
            //report pop
        }
        return currentPop.getBestIdv();
    }

    public boolean terminate(int generation){
        if (generation >= this.totalGeneration) return true;
        else return false;
        //or by running time
        //or population not changed
    }
}
