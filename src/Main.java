import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 2, 3, 5, 10, 1, 8, 4, 6, 9, 7);

        System.out.println("Original list: " + numbers);

        // 1. Filtering integers
        // Keep only numbers that are even AND greater than 4, then collect them into a list
        List<Integer> evenGreaterThanFour = numbers.stream()
                .filter(number -> number % 2 == 0)
                .filter(number -> number > 4)
                .collect(Collectors.toList());
        System.out.println("1. Even numbers > 4: " + evenGreaterThanFour);

        // 2. Transforming integers
        // Square each number, remove duplicate squares, sort from lowest to highest
        List<Integer> squaredDistinctSorted = numbers.stream()
                .map(number -> number * number)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("2. Squared, distinct, sorted: " + squaredDistinctSorted);

        // 3. Sorting and pagination
        // Remove duplicates, sort from highest to lowest, then take the first 3 (page 1)
        List<Integer> topThree = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("3a. Three largest distinct: " + topThree);

        // Same as above, but skip the first 3 and take the next 3 (page 2)
        List<Integer> nextThree = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(3)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("3b. Next three largest distinct: " + nextThree);

        // 4. Numeric aggregation
        // summaryStatistics() calculates sum, average, min, max and count in one pass
        printStatistics("4a. Statistics", numbers);

        // Empty list: count is 0, so we print a message instead of misleading min/max values
        printStatistics("4b. Statistics (empty list)", new ArrayList<>());
    }

    private static void printStatistics(String label, List<Integer> numbers) {
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            System.out.println(label + ": list is empty, nothing to calculate");
            return;
        }

        System.out.println(label + ": sum=" + stats.getSum()
                + ", average=" + stats.getAverage()
                + ", min=" + stats.getMin()
                + ", max=" + stats.getMax()
                + ", count=" + stats.getCount());
    }
}
