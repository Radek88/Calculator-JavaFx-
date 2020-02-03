package sample.model;

public class Divide implements MathActionStrategy {
    @Override
    public double calculate(double first, double second) {
        return first / second;
    }
}
