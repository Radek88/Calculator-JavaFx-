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


public class Controller {

    private final HashMap<String, MathActionStrategy> mathematicStrategy = new HashMap<>();
    private final ArrayList<NumberMemory> numberAndMathActionObjectsMap = new ArrayList<>();


    @FXML
    private Button one, two, three, four, five, six, seven, eigth, nine, zero, c, CE, dot;
    @FXML
    private TextField text;


    public Controller() {
        mathematicStrategy.put("add", new Add());
        mathematicStrategy.put("min", new Substract());
        mathematicStrategy.put("mul", new Multiply());
        mathematicStrategy.put("div", new Divide());

    }

    @FXML
    void initialize() {

    }

    @FXML
    private void listnerForVirtualMathematicActionButtons(ActionEvent event) {
        if (text.getText().isEmpty()){
            return;
        }
        createListWithNumbersAndMathAction(doubleParser(text.getText()), returnButtonId(event.getSource().toString()));
        text.clear();

    }

    @FXML
    private void listnerForVirtualMathematicActionButtons(String action) {
        if (text.getText().isEmpty()){
            return;
        }
        createListWithNumbersAndMathAction(doubleParser(text.getText()), action);
        text.clear();

    }

    private void createListWithNumbersAndMathAction(double number, String mathematicAction) {

        numberAndMathActionObjectsMap.add(new NumberMemory(number, mathematicAction));

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
        text.clear();
        numberAndMathActionObjectsMap.clear();
    }

    @FXML
    void resultMethod(ActionEvent event) {

        createListWithNumbersAndMathAction(doubleParser(text.getText()), returnButtonId(event.getSource().toString()));
        double resultDouble = numberAndMathActionObjectsMap.get(0).getNumberValue();
        for (int i = 0; i < numberAndMathActionObjectsMap.size(); i++) {
            if (numberAndMathActionObjectsMap.get(i).getAction().equals("res")) {
                break;
            }
            resultDouble = mathematicStrategy.get(numberAndMathActionObjectsMap.get(i).getAction()).calculate(resultDouble, numberAndMathActionObjectsMap.get(i + 1).getNumberValue());

        }
        text.setText(String.valueOf(resultDouble));

        numberAndMathActionObjectsMap.clear();

    }

    @FXML
    private void resultMethod(String result) {
        createListWithNumbersAndMathAction(doubleParser(text.getText()), result);
        double resultDouble = numberAndMathActionObjectsMap.get(0).getNumberValue();
        for (int i = 0; i < numberAndMathActionObjectsMap.size(); i++) {
            if (numberAndMathActionObjectsMap.get(i).getAction().equals("res")) {
                break;
            }

            resultDouble = mathematicStrategy.get(numberAndMathActionObjectsMap.get(i).getAction()).calculate(resultDouble, numberAndMathActionObjectsMap.get(i + 1).getNumberValue());

        }


        text.setText(String.valueOf(resultDouble));
        numberAndMathActionObjectsMap.clear();
    }


    private double doubleParser(String stringForParseToDouble) {
        return Double.parseDouble(stringForParseToDouble);
    }

    private String returnButtonId(String buttonGetSource) {
        return buttonGetSource.substring(10, 13);
    }


    @FXML
    void keyPressed(KeyEvent event) {
        if (event.getCode().isDigitKey()) {
            text.setText(text.getText() + event.getText());
        }
        if (event.getCode() == KeyCode.ADD) {
            listnerForVirtualMathematicActionButtons("add");
        }
        if (event.getCode() == KeyCode.MINUS) {
            listnerForVirtualMathematicActionButtons("min");
        }
        if (event.getCode() == KeyCode.MULTIPLY) {
            listnerForVirtualMathematicActionButtons("mul");
        }
        if (event.getCode() == KeyCode.DIVIDE) {
            listnerForVirtualMathematicActionButtons("div");
        }
        if (event.getCode() == KeyCode.DELETE) {
            clear();
        }
        if (event.getCode() == KeyCode.ENTER) {
            resultMethod("res");
        }
        if (event.getCode() == KeyCode.DECIMAL) {
            text.setText(text.getText() + ".");
        }



    }


}
