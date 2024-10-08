import java.util.Scanner;

class Finder {

    private FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * It performs the search algorithm according to the given strategy
     */
    public int find(int[] numbers) {
        return this.strategy.getResult(numbers);
    }
}

interface FindingStrategy {

    /**
     * Returns search result
     */
    int getResult(int[] numbers);

}

class MaxFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        // Initialize max with the first element of the array
        int max = numbers[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < numbers.length; i++) {
            // If the current element is larger than max, update max
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Return the largest element found
        return max;
    }
}

class MinFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return Integer.MAX_VALUE;
        }

        // Initialize min with the first element of the array
        int min = numbers[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < numbers.length; i++) {
            // If the current element is smaller than min, update min
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        // Return the smallest element found
        return min;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers = null;

        if ("EMPTY".equals(elements[0])) {
            numbers = new int[0];   
        } else {
            numbers = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
        }

        final String type = scanner.nextLine();

        Finder finder = null;

        switch (type) {
            case "MIN":
                finder = new Finder(new MinFindingStrategy());
                break;
            case "MAX":
                finder = new Finder(new MaxFindingStrategy());
                break;
            default:
                break;
        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}
