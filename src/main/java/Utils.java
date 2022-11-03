import entities.Shape;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {
    public static Integer[] getOnlyPositiveDESC(Integer[] sourceArray) {
        if (sourceArray == null)
            throw new IllegalArgumentException();

        Integer[] sourceArraySorted = Arrays.stream(sourceArray)
                .filter(i -> i >= 0)
                .sorted()
                .toArray(Integer[]::new);

        Arrays.sort(sourceArraySorted, Collections.reverseOrder());
        return sourceArraySorted;
    }

    public static List<String> getMostUsedHashtags(List<String> strings, int limit) {
        if (strings == null || limit < 0)
            throw new IllegalArgumentException();

        Map<String, Long> map = strings.stream()
                .map(str -> {
                    String[] words = str.split(" ");
                    return Arrays.stream(words).distinct().toArray();
                })
                .flatMap(Arrays::stream)
                .map(String::valueOf)
                .filter(word -> word.charAt(0) == '#')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static List<Shape> getShapesSortedByVolume(List<Shape> shapes) {
        if (shapes == null || shapes.contains(null))
            throw new IllegalArgumentException();

        return shapes.stream()
                .sorted(Comparator.comparing(Shape::getVolume))
                .collect(Collectors.toList());
    }
}