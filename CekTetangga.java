
public class CekTetangga {
    // Function to check neighbors of a cell in a 2D array
    public static void checkNeighbors(String[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Define relative indices for neighbors (horizontal, vertical, and diagonal)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},  {0,0},   {0, 1},
            {1, -1}, {1, 0},  {1, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check if the new indices are within bounds
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols) {
                String neighborValue = matrix[newRow][newCol];
                System.out.println("Neighbor at (" + newRow + ", " + newCol + "): " + neighborValue);
            }
        }
    }

    public static void main(String[] args) {
        // Example 2D array
        String[][] matrix = {
            {"abu" ,"abu" ,"hitam" ,"abu", "hitam"}, 
            {"abu" ,"abu" ,"hitam" ,"abu", "abu"},
            {"abu" ,"hitam" ,"abu" ,"hitam", "abu"},
            {"hitam", "abu", "abu" ,"hitam" ,"hitam"},
            {"abu","abu", "hitam", "abu", "hitam"}
        };

        // Check neighbors of cell at row 0, column 0 (value 1)
        checkNeighbors(matrix, 0, 2);
    }
}



