package sample.model;

public class Substract implements MathActionStrategy {
    @Override
    public double calculate(double first, double second) {
        return first - second;
    }
}
