package sample;

import java.beans.EventHandler;

public class Engine {
    double returned;
    Action action = new Action();


    public double add(double first, double second){
        action.setResult(first + second);
        return action.getResult();
    }
    public void minus(double first, double second){
        returned = action.getData1() - action.getData2();
        action.setResult(returned);
    }
    public void multi(double first, double second){
        returned = action.getData1() - action.getData2();
        action.setResult(returned);
    }
    public void divide(double first, double second){
        returned = action.getData1() - action.getData2();
        action.setResult(returned);
    }

}
