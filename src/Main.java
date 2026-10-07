import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 2, 3, 5, 10, 1, 8, 4);

        System.out.println("Original list: " + numbers);

        // Scenario:
        // You want to remove elements that meet a certain requirement

        System.out.print("Filter (even numbers): ");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Scenario
        // You want to augment values under a certain degree

        System.out.print("Map (square each number): ");
        numbers.stream()
                .map(number -> number * number)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Scenario
        // You want to arange the list from lowest to highest

        System.out.print("Sorted (ascending): ");
        numbers.stream()
                .sorted()
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Scenario
        // You want to unique instances of a value

        System.out.print("Distinct (remove duplicates): ");
        numbers.stream()
                .distinct()
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        // Scnario
        // You want a sum of all values

        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Reduce (sum): " + sum);
    }
}