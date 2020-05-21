package it.unicam.cs.pa.pacal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class JavaFxPaCalController {

    private BasicCalcStateController controller = new BasicCalcStateController();

    @FXML
    TextField value1;

    @FXML
    TextField value2;

    @FXML
    TextField input;

    private boolean commaFlag = false;
    private boolean isZero = true;

    private void addDigit(int d) {
        if (isZero) {
            if (d != 0) {
                input.setText(""+d);
                isZero = false;
            } else {
                input.setText("0");
            }
        } else {
            input.setText(input.getText()+d);
        }
    }

    @FXML
    public void onePressed(ActionEvent actionEvent) {
        addDigit(1);
    }

    @FXML
    public void twoPressed(ActionEvent actionEvent) {
        addDigit(2);
    }

    @FXML
    public void threePressed(ActionEvent actionEvent) {
        addDigit(3);
    }

    @FXML
    public void additionAction(ActionEvent actionEvent) {
        controller.addition();
        refreshValues();
    }

    private void refreshValues() {
        this.value1.setText(controller.getValue1()+"");
        this.value2.setText(controller.getValue2()+"");
    }

    @FXML
    public void fourPressed(ActionEvent actionEvent) {
        addDigit(4);
    }

    @FXML
    public void fivePressed(ActionEvent actionEvent) {
        addDigit(5);
    }

    @FXML
    public void sixPressed(ActionEvent actionEvent) {
        addDigit(6);
    }

    @FXML
    public void subtractionAction(ActionEvent actionEvent) {
        controller.subtraction();
        refreshValues();
    }

    @FXML
    public void sevenPressed(ActionEvent actionEvent) {
        addDigit(7);
    }

    @FXML
    public void eightPressed(ActionEvent actionEvent) {
        addDigit(8);
    }

    @FXML
    public void ninePressed(ActionEvent actionEvent) {
        addDigit(9);
    }

    @FXML
    public void multiplicationAction(ActionEvent actionEvent) {
        controller.multiplication();
        refreshValues();
    }

    @FXML
    public void enterAction(ActionEvent actionEvent) {
        sendValueToController();
    }

    private void sendValueToController() {
        controller.setVaue(Double.parseDouble(input.getText()));
        resetInputValue();
        refreshValues();
    }

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        resetInputValue();
    }

    private void resetInputValue() {
        this.input.setText("0");
        this.isZero = true;
        this.commaFlag = false;
    }

    @FXML
    public void resetAction(ActionEvent actionEvent) {
        resetInputValue();
        controller.reset();
        refreshValues();
    }

    @FXML
    public void zeroPressed(ActionEvent actionEvent) {
        addDigit(0);
    }

    @FXML
    public void commaAction(ActionEvent actionEvent) {
        if (!commaFlag) {
            input.setText(input.getText()+".");
            commaFlag = true;
            isZero = false;
        }
    }

    @FXML
    public void divisionAction(ActionEvent actionEvent) {
        controller.division();
        refreshValues();
    }

    @FXML
    public void handleKeyboardInput(KeyEvent event) {
        switch (event.getCode()) {
            case DIGIT0:
                addDigit(0);
                break;
            case DIGIT1:
                addDigit(1);
                break;
            case DIGIT2:
                addDigit(2);
                break;
            case DIGIT3:
                addDigit(3);
                break;
            case DIGIT4:
                addDigit(4);
                break;
            case DIGIT5:
                addDigit(5);
                break;
            case DIGIT6:
                addDigit(6);
                break;
            case DIGIT7:
                addDigit(7);
                break;
            case DIGIT8:
                addDigit(8);
                break;
            case DIGIT9:
                addDigit(9);
                break;
            case ENTER:
                sendValueToController();
                break;

        }

    }
}
