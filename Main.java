import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        System.out.println("Target: 9");
        Random init = new Random();
        for (int ct=1;ct<=loop;ct++) {
            long seed = init.nextLong();
			System.out.println(seed);
			Random gen = new Random(seed);
	    	int maxCapacity=0, totalGeneration=0, maxPopulationSize=0;
	    	double crossoverRate=0.0, mutationRate=0.0, elitismPct=0.0;
            try{
                sc = new Scanner(new File("input.txt"));
	        	maxCapacity = sc.nextInt();
            }catch (FileNotFoundException e){e.printStackTrace();}
        }
    }
}