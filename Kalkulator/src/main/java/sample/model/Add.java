package sample.model;

public class Add implements MathActionStrategy {
    @Override
    public double calculate(double first, double second) {
        return first + second;
    }
}
