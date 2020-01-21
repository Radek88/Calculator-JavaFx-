package sample;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.scene.control.Button;



public class Action {
    private double data1;
    private double data2;
    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private MathematicAction action;

    public double getData1() {
        return data1;
    }

    public void setData1(double data1) {
        this.data1 = data1;
    }

    public double getData2() {
        return data2;
    }

    public void setData2(double data2) {
        this.data2 = data2;
    }

    public MathematicAction getAction() {
        return action;
    }

    public void setAction(MathematicAction action) {
        this.action = action;
    }
}
