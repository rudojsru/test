package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    String operator = "";
    Model model = new Model();
    @FXML
    private TextField textField1;
    private TextField textField2;
    private double numer;
    private boolean start = true;
    private boolean znaki = true;


    public void numbers(ActionEvent evt) {
        if (start) {
            textField1.setText("");
            String num = ((Button) evt.getSource()).getText();
            textField1.setText(textField1.getText() + num);
            start = false;
        } else {
            String num = ((Button) evt.getSource()).getText();
            textField1.setText(textField1.getText() + num);
        }
    }

    public void operator(ActionEvent evt) {
        String value = ((Button) evt.getSource()).getText();
        if (!"=".equals(value)) {
            if (value.isEmpty()) return;
            // zeby mozna byla nabierac bez znaka =
            if (!znaki) {
                numer = (model.operation(numer, Double.parseDouble(textField1.getText()), operator));
                textField1.setText(String.valueOf(numer));
            }
            //------------------------------------------------
            numer = Double.parseDouble(textField1.getText());
            operator = value;
            textField1.setText(value);
            start = true;
            znaki = false;
        } else {
            if (operator.isEmpty()) return;
            numer = (model.operation(numer, Double.parseDouble(textField1.getText()), operator));
            textField1.setText(String.valueOf(numer));
            znaki = true;
        }
    }


    public void alltoZero(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        String tab[] = textField1.getText().split("");
        if ("C".equals(value)) {
            numer = 0;
            operator = "";
            textField1.setText("0");
            start = true;
        } else if (".".equals(value)) {
            String comma = textField1.getText();
            for (int i = 0; i < tab.length; i++) {  // jesli spotykamy "." drugi raz to nie wywodimy ja.
                if (".".equals(tab[i])) {
                    return;
                }
            }
            textField1.setText(comma + ".");
        } else if ("<-".equals(value)) { // BEKSPASE
            String newText = "";
            for (int i = 0; i < tab.length - 1; i++) {
                System.out.println(newText += tab[i]);
            }
            textField1.setText(newText);
        } else if (("+ -").equals(value)) {
            if (tab[0].equals("-")) {
             textField1.setText(textField1.getText().substring(1));
            }else {
                textField1.setText("-" + textField1.getText());
            }

        }

    }

}
