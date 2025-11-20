import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        while (true) {
            System.out.print("Enter array size (for NxN array): ");
            try {
                N = Integer.parseInt(sc.nextLine());
                if (N > 1) break;
                else System.out.println("Please enter a number greater than 1.");
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a valid integer.");
            }
        }

        // Create NxN grid
        int[][] grid = new int[N][N];
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = (r.nextInt(10) + 1) * 2;
            }
        }
        System.out.println("\nGenerated 2D array:");
        printGrid(grid, -1);
        int X = 0;
        while (true) {
            System.out.print("\nEnter a number to highlight (even number 2-20): ");
            try {
                X = Integer.parseInt(sc.nextLine());
                if (X >= 2 && X <= 20 && X % 2 == 0) break;
                else System.out.println("Enter a valid even number (2–20).");
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("\nArray with " + X + " highlighted:");
        int count = printGrid(grid, X);

        // Print count
        System.out.println("\nNumber " + X + " appeared " + count + " time(s)");
    }
    public static int printGrid(int[][] grid, int highlight) {
        int N = grid.length;
        int count = 0;
        System.out.print("   ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%02d  ", i);
        }
        System.out.println();
        printBorder(N);
        for (int i = 0; i < N; i++) {
            System.out.printf("%02d |", i);
            for (int j = 0; j < N; j++) {
                int val = grid[i][j];
                if (val == highlight) {
                    System.out.printf("[%02d]|", val);
                    count++;
                } else {
                    System.out.printf(" %02d |", val);
                }
            }
            System.out.println();
            printBorder(N);
        }

        return count;
    }
    public static void printBorder(int N) {
        System.out.print("   +");
        for (int i = 0; i < N; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }
}
