package entities;

import java.util.Objects;

public class Cube implements Shape {
    private final double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getVolume() {
        return Math.pow(sideLength, 3);
    }

    public double getSideLength() {
        return sideLength;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "sideLength=" + sideLength +
                '}';
    }
}
