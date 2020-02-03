package sample.model;

public class NumberMemory {
    private double numberValue;
    private String action;

    public double getNumberValue() {
        return numberValue;
    }

    public String getAction() {
        return action;
    }

    public NumberMemory(double numberValue, String action) {
        this.numberValue = numberValue;
        this.action = action;
    }
}
