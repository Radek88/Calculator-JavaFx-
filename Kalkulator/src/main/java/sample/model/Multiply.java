package sample.model;

public class Multiply implements MathActionStrategy {
    @Override
    public double calculate(double first, double second) {
        return first * second;
    }
}
