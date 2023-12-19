import java.util.Random;

public class ArrayMerger {
    String angka; // angka dari 0 sampai 9
    String warna; // hitam atau abu
    String value_fitness; // -1, 0, 1 atau null, akan null jika attribute angka null

    public ArrayMerger(String angka, String warna, String value_fitness) {
        if (angka == null) {
            throw new IllegalArgumentException("Angka cannot be null");
        }
        this.angka = angka;
        this.warna = warna;
        this.value_fitness = value_fitness;
    }

    public void setWarna(String newWarna) {
        this.warna = newWarna;
    }

    public String getAngka() {
        return angka;
    }

    public String getWarna() {
        return warna;
    }

    public String getValueFitness() {
        return value_fitness;
    }

    public void printBoxInfo() {
        System.out.println("Angka: " + angka + ", Warna: " + warna + ", Value Fitness: " + value_fitness);
    }

    public static ArrayMerger[][] generateNewArray(ArrayMerger[][] firstArray, ArrayMerger[][] secondArray,
            int randomNumber) {
        int numRowsFirst = randomNumber + 1;
        int numRowsSecond = secondArray.length - (randomNumber + 1);
        int numColumns = firstArray[0].length;

        ArrayMerger[][] newArray = new ArrayMerger[numRowsFirst + numRowsSecond][numColumns];

        // Copy rows from the second array until the randomNumber
        for (int i = 0; i <= randomNumber; i++) {
            newArray[i] = secondArray[i].clone();
        }

        // Copy rows from the first array starting from randomNumber + 1
        for (int i = 0; i < numRowsSecond; i++) {
            newArray[numRowsFirst + i] = firstArray[randomNumber + 1 + i].clone();
        }

        return newArray;
    }

    public static ArrayMerger[][] generateNewOtherArray(ArrayMerger[][] firstArray, ArrayMerger[][] secondArray,
            int randomNumber) {
        int numRowsFirst = randomNumber + 1;
        int numRowsSecond = secondArray.length - (randomNumber + 1);
        int numColumns = firstArray[0].length;

        ArrayMerger[][] newArray = new ArrayMerger[numRowsFirst + numRowsSecond][numColumns];

        // Copy rows from the second array until the randomNumber
        for (int i = 0; i <= randomNumber; i++) {
            newArray[i] = firstArray[i].clone();
        }

        // Copy rows from the first array starting from randomNumber + 1
        for (int i = 0; i < numRowsSecond; i++) {
            newArray[numRowsFirst + i] = secondArray[randomNumber + 1 + i].clone();
        }

        return newArray;
    }

    public static void main(String[] args) {
        // Example 2D arrays of MosaicBox
        ArrayMerger[][] array1 = {
                { new ArrayMerger("1", "hitam", "-1"), new ArrayMerger("2", "abu", "1") },
                { new ArrayMerger("3", "hitam", "0"), new ArrayMerger("4", "hitam", null) },
                { new ArrayMerger("5", "hitam", "1"), new ArrayMerger("6", "abu", "-1") }
        };

        ArrayMerger[][] array2 = {
                { new ArrayMerger("1", "abu", "0"), new ArrayMerger("2", "hitam", "1") },
                { new ArrayMerger("3", "abu", null), new ArrayMerger("4", "abu", "-1") },
                { new ArrayMerger("5", "abu", "0"), new ArrayMerger("6", "hitam", "1") }
        };

        // Generate a random number within the range of row indices
        Random random = new Random();
        int numRowsSecondArray = array2.length - 1;
        int randomNumber = random.nextInt(numRowsSecondArray);

        // Generate new array based on the random number
        ArrayMerger[][] newArray = generateNewArray(array1, array2, randomNumber);
        ArrayMerger[][] newOtherArray = generateNewOtherArray(array1, array2, randomNumber);

        // Display the new array
        System.out.println("New Array:");
        for (ArrayMerger[] row : newArray) {
            for (ArrayMerger box : row) {
                box.printBoxInfo();
            }
        }
        System.out.println("New Other Array:");
        for (ArrayMerger[] row : newOtherArray) {
            for (ArrayMerger box : row) {
                box.printBoxInfo();
            }
        }
    }
}