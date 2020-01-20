package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import javax.swing.text.html.parser.Parser;


public class Controller {
    Action action = new Action();
    Engine engine = new Engine();


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
        add.setOnAction(event -> {

            try {
                action.setData1(Double.parseDouble(textfield.getText()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No value provided");
            }
            action.setAction(MathematicAction.ADD);
            textfield.clear();
        });
        result.setOnAction(event -> {
            try {
                action.setData2(Double.parseDouble(textfield.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No value provided");
            }
            textfield.clear();
            switch (action.getAction()) {
                case ADD: {
                    textfield.setPromptText(Double.toString(engine.add(action.getData1(), action.getData2()))); }
                case SUBSTRACT:
                    engine.minus(action.getData1(), action.getData2());
                case MULTIPLE:
                    engine.multi(action.getData1(), action.getData2());
                case DIVIDE:
                    engine.divide(action.getData1(), action.getData2());
            }


        });

    }


}
