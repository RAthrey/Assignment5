import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {
    public static double[][] readFile(File file) throws FileNotFoundException {
    	Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            rows++;
            scanner.nextLine();
        }
        scanner.close();
        double[][] result = new double[rows][];
        scanner = new Scanner(file);
        int row = 0;
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            double[] rowArray = new double[line.length];
            for (int i = 0; i < line.length; i++) {
                rowArray[i] = Double.parseDouble(line[i]);
            }
            result[row] = rowArray;
            row++;
        }
        scanner.close();

        return result;
    }

    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                writer.print(array[i][j]);
                if (j < array[i].length - 1) {
                    writer.print(" ");
                }
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }
        return total;
    }

    public static double getAverage(double[][] array) {
    	int count = 0;
        double total = getTotal(array);
        for (int i = 0; i < array.length; i++) {
            count += array[i].length;
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
    	double rowTotal = 0;
        for (int i = 0; i < data[row].length; i++) {
            rowTotal += data[row][i];
        }
        return rowTotal;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double columnTotal = 0;
        for (int i = 0; i < data.length; i++) {
            if (col< data[i].length) { 
                columnTotal += data[i][col];
            }
        }	
        return columnTotal;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
            }
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
    	int maxIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > data[row][maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static double getLowestInRow(double[][] data, int row) {
    	double min = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
            }
        }
        return min;
    }

    public static int getLowestInRowrow(double[][] data, int row) {
    	int minIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < data[row][minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double getHighestInColumn(double[][] data, int col) {
    	double max = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        int maxIndex = -1;
        double max = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min =100000;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
    	int minIndex=-1;
        double min = 100000;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double getHighestInArray(double[][] data) {
    	double max = data[0][0];
        for (int j = 0; j < data.length; j++) {
            for (int i = 0; i < data[j].length; i++) {
                if (data[j][i] > max) {
                    max = data[j][i];
                }
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
    	double min = data[0][0];
        for (int j = 0; j < data.length; j++) {
            for (int i = 0; i < data[j].length; i++) {
                if (data[j][i] < min ) {
                    min = data[j][i];
                }
            }
        }
        return min;
    }
}
