package sample;


public class Engine {

    Action action = new Action();


    public double add(double first, double second) {
        action.setResult(first + second);
        return action.getResult();
    }

    public double minus(double first, double second) {
        action.setResult(first - second);
        return action.getResult();
    }

    public double multi(double first, double second) {
        action.setResult(first * second);
        return action.getResult();
    }

    public double divide(double first, double second) {
        action.setResult(first / second);
        return action.getResult();
    }

}
