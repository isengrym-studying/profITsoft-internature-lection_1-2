import entities.Cube;
import entities.Cylinder;
import entities.Shape;
import entities.Sphere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilsTest {
    @Test
    public void testGetPositiveDescWithCorrectInput() {
        Integer[] source = new Integer[] {1, 5, 7, 9, -2, 1, -1, -2, 0, 5, 2, 8, 5, 9, -5, 6, 0, 0, -1, -2, -2};
        Integer[] expected = new Integer[] {9, 9, 8, 7, 6, 5, 5, 5, 2, 1, 1, 0, 0, 0};
        Integer[] actual = Utils.getOnlyPositiveDESC(source);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetPositiveDescWithEmptyInput() {
        Integer[] source = new Integer[0];
        Integer[] expected = new Integer[0];
        Integer[] actual = Utils.getOnlyPositiveDESC(source);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetPositiveDescWithNullInput() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Utils.getOnlyPositiveDESC(null));
    }

    @Test
    public void testGetMostUsedHashtagsCorrectInput() {
        List<String> source = Arrays.asList(
                "one #two three four #five #six seven",
                "#one two #three #three #three four #five #six seven",
                "one #two three #three four #five #six seven",
                "one two three three four #five #six seven",
                "one two three three #four #five #six #seven"
        );
        List<String> expected = Arrays.asList("#five", "#six", "#three", "#two", "#one");
        List<String> actual = Utils.getMostUsedHashtags(source, 5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetMostUsedHashtagsEmptyInput() {
        List<String> source = Collections.emptyList();
        List<String> expected = Collections.emptyList();
        List<String> actual = Utils.getMostUsedHashtags(source, 5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetMostUsedHashtagsNullInput() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Utils.getMostUsedHashtags(null, 5));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Utils.getMostUsedHashtags(new ArrayList<>(), -5));
    }

    @Test
    public void testGetShapesSortedByVolumeCorrectInput() {
        Shape smallCube = new Cube(5);
        Shape bigCube = new Cube(30);
        Shape sphere = new Sphere(14.5);
        Shape smallCylinder = new Cylinder(5, 5);
        Shape bigCylinder = new Cylinder(10, 20);
        List<Shape> source = Arrays.asList(smallCube, bigCube, sphere, smallCylinder, bigCylinder);

        List<Shape> expected = Arrays.asList(smallCube, smallCylinder, bigCylinder, sphere, bigCube);
        List<Shape> actual = Utils.getShapesSortedByVolume(source);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetShapesSortedByVolumeEmptyInput() {
        List<Shape> source = Collections.emptyList();
        List<Shape> expected = Collections.emptyList();
        List<Shape> actual = Utils.getShapesSortedByVolume(source);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetShapesSortedByVolumeNullInput() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Utils.getShapesSortedByVolume(null));
    }

}
