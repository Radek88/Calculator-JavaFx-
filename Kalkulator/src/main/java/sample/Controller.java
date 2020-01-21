package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {
    Action action = new Action();
    Engine engine = new Engine();
    String s;


    @FXML
    private Button add;

    @FXML
    private Button result;


    @FXML
    private Button minus;

    @FXML
    private Button multi;

    @FXML
    private Button divide;

    @FXML
    private TextField textfield;


    @FXML
    private Button one;

    @FXML
    private Button four;

    @FXML
    private Button seven;

    @FXML
    private Button two;

    @FXML
    private Button five;

    @FXML
    private Button eigth;

    @FXML
    private Button three;

    @FXML
    private Button six;

    @FXML
    private Button nine;

    @FXML
    private Button c;

    @FXML
    void initialize() {
        add.setOnAction(event -> actionHandler(event));
        minus.setOnAction(event -> actionHandler(event));
        multi.setOnAction(event -> actionHandler(event));
        divide.setOnAction(event -> actionHandler(event));
        result();
    }

    public void actionHandler(javafx.event.ActionEvent event) {
        try {

            action.setData1(Double.parseDouble(textfield.getText()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No value provided");
        }
        if (event.getSource().equals(add)) {
            action.setAction(MathematicAction.ADD);
        }
        else if (event.getSource().equals(minus)) {
            action.setAction(MathematicAction.SUBSTRACT);
        }
        else if (event.getSource().equals(multi)) {
            action.setAction(MathematicAction.MULTIPLE);
        }
        else if (event.getSource().equals(divide)) {
            action.setAction(MathematicAction.DIVIDE);
        }
        textfield.clear();
    }
    public void result(){
        result.setOnAction(event -> {
            try {
                action.setData2(Double.parseDouble(textfield.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No value provided");
            }
            textfield.clear();
            switch (action.getAction()) {
                case ADD: {
                    textfield.setPromptText(Double.toString(engine.add(action.getData1(), action.getData2()))); }break;
                case SUBSTRACT:{
                    textfield.setPromptText(Double.toString(engine.minus(action.getData1(), action.getData2())));}break;
                case MULTIPLE:{
                    textfield.setPromptText(Double.toString(engine.multi(action.getData1(), action.getData2())));}break;
                case DIVIDE:{
                    textfield.setPromptText(Double.toString(engine.divide(action.getData1(), action.getData2())));}break;
            }
        });

    }
    public void buttonDeffinition(){

    }

}
