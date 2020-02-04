package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Controller {

    private HashMap<String, MathActionStrategy> mathActionChose = new HashMap<>();
    private ArrayList<NumberMemory> numbersList = new ArrayList();
    private Map<KeyCode, String> numpadKeysMap = new HashMap<>();

    @FXML
    private Button add, result, minus, multi, divide, one, two, three, four, five, six, seven, eigth, nine, zero, c, CE, dot;
    @FXML
    private TextField text;


    public Controller() {
        mathActionChose.put("add", new Add());
        mathActionChose.put("min", new Substract());
        mathActionChose.put("mul", new Multiply());
        mathActionChose.put("div", new Divide());

        numpadKeysMap.put(KeyCode.NUMPAD0, "0");
        numpadKeysMap.put(KeyCode.NUMPAD1, "1");
        numpadKeysMap.put(KeyCode.NUMPAD2, "2");
        numpadKeysMap.put(KeyCode.NUMPAD3, "3");
        numpadKeysMap.put(KeyCode.NUMPAD4, "4");
        numpadKeysMap.put(KeyCode.NUMPAD5, "5");
        numpadKeysMap.put(KeyCode.NUMPAD6, "6");
        numpadKeysMap.put(KeyCode.NUMPAD7, "7");
        numpadKeysMap.put(KeyCode.NUMPAD8, "8");
        numpadKeysMap.put(KeyCode.NUMPAD9, "9");

    }

    @FXML
    void initialize() {

    }

    @FXML
    private void mathAction(ActionEvent event) {
        listInitializerMethod(doubleParser(text.getText()), returnButtonId(event.getSource().toString()));
        text.clear();

    }

    @FXML
    private void mathAction(String action) {
        listInitializerMethod(doubleParser(text.getText()), action);
        text.clear();

    }

    private void listInitializerMethod(double number, String mathematicAction) {
        numbersList.add(new NumberMemory(number, mathematicAction));

    }

    @FXML
    void numButtons() {

        one.setOnAction(event -> text.setText(text.getText() + "1"));
        two.setOnAction(event -> text.setText(text.getText() + "2"));
        three.setOnAction(event -> text.setText(text.getText() + "3"));
        four.setOnAction(event -> text.setText(text.getText() + "4"));
        five.setOnAction(event -> text.setText(text.getText() + "5"));
        six.setOnAction(event -> text.setText(text.getText() + "6"));
        seven.setOnAction(event -> text.setText(text.getText() + "7"));
        eigth.setOnAction(event -> text.setText(text.getText() + "8"));
        nine.setOnAction(event -> text.setText(text.getText() + "9"));
        zero.setOnAction(event -> text.setText(text.getText() + "0"));
        dot.setOnAction(event -> text.setText(text.getText() + "."));

    }

    @FXML
    void clear() {
    }

    @FXML
    void resultMethod(ActionEvent event) {
        listInitializerMethod(doubleParser(text.getText()), returnButtonId(event.getSource().toString()));
        double resultDouble = numbersList.get(0).getNumberValue();
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i).getAction().equals("res")) {
                break;
            }

            resultDouble = mathActionChose.get(numbersList.get(i).getAction()).calculate(resultDouble, numbersList.get(i + 1).getNumberValue());
        }


        text.setText(String.valueOf(resultDouble));
    }

    @FXML
    void resultMethod(String result) {
        listInitializerMethod(doubleParser(text.getText()), result);
        double resultDouble = numbersList.get(0).getNumberValue();
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i).getAction().equals("res")) {
                break;
            }

            resultDouble = mathActionChose.get(numbersList.get(i).getAction()).calculate(resultDouble, numbersList.get(i + 1).getNumberValue());
        }


        text.setText(String.valueOf(resultDouble));
    }


    double doubleParser(String stringForParseToDouble) {
        return Double.parseDouble(stringForParseToDouble);
    }

    String returnButtonId(String buttonGetSource) {
        String newString = buttonGetSource.substring(10, 13);
        return newString;
    }


    @FXML
    void keyPressed(KeyEvent event) {
        if (event.getCode().isDigitKey()) {
            text.setText(text.getText() + event.getText());
        }
        if (event.getCode() == KeyCode.ADD) {
            mathAction("add");
        }
        if (event.getCode() == KeyCode.MINUS) {
            mathAction("min");
        }
        if (event.getCode() == KeyCode.MULTIPLY) {
            mathAction("mul");
        }
        if (event.getCode() == KeyCode.DIVIDE) {
            mathAction("div");
        }
        if (event.getCode() == KeyCode.ENTER) {
            resultMethod("res");
        }


    }


}
