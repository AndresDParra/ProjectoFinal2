package com.example.projectofinal2.controllers;

import com.example.projectofinal2.model.BilleteraVirtual;
import com.example.projectofinal2.model.CuentaBanco;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class PaginaVerificacionPINController {
    public Button Button1;
    public Button Button2;
    public Button Button3;
    public Button Button4;
    public Button Button5;
    public Button Button6;
    public Button Button7;
    public Button Button8;
    public Button Button9;
    public Button Button0;
    public Button ButtonSubmit;
    public TextArea PinArea;

    public PaginaVerificacionPINController(Button button1, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button0, Button buttonSubmit, TextArea pinArea) {
        Button1 = button1;
        Button2 = button2;
        Button3 = button3;
        Button4 = button4;
        Button5 = button5;
        Button6 = button6;
        Button7 = button7;
        Button8 = button8;
        Button9 = button9;
        Button0 = button0;
        ButtonSubmit = buttonSubmit;
        PinArea = pinArea;
    }

    public PaginaVerificacionPINController() {
    }

    public Button getButton1() {
        return Button1;
    }

    public void setButton1(Button button1) {
        Button1 = button1;
    }

    public Button getButton2() {
        return Button2;
    }

    public void setButton2(Button button2) {
        Button2 = button2;
    }

    public Button getButton3() {
        return Button3;
    }

    public void setButton3(Button button3) {
        Button3 = button3;
    }

    public Button getButton4() {
        return Button4;
    }

    public void setButton4(Button button4) {
        Button4 = button4;
    }

    public Button getButton5() {
        return Button5;
    }

    public void setButton5(Button button5) {
        Button5 = button5;
    }

    public Button getButton6() {
        return Button6;
    }

    public void setButton6(Button button6) {
        Button6 = button6;
    }

    public Button getButton7() {
        return Button7;
    }

    public void setButton7(Button button7) {
        Button7 = button7;
    }

    public Button getButton8() {
        return Button8;
    }

    public void setButton8(Button button8) {
        Button8 = button8;
    }

    public Button getButton9() {
        return Button9;
    }

    public void setButton9(Button button9) {
        Button9 = button9;
    }

    public Button getButton0() {
        return Button0;
    }

    public void setButton0(Button button0) {
        Button0 = button0;
    }

    public Button getButtonSubmit() {
        return ButtonSubmit;
    }

    public void setButtonSubmit(Button buttonSubmit) {
        ButtonSubmit = buttonSubmit;
    }

    public TextArea getPinArea() {
        return PinArea;
    }
    public void setPinArea(TextArea pinArea) {
        PinArea = pinArea;
    }

    private void appendDigit(String digit) {
        if (PinArea.getText() != null) {
            PinArea.appendText(digit);
        }
    }

    public void Presionar1(ActionEvent actionEvent) {
        appendDigit("1");
    }

    public void Presionar2(ActionEvent actionEvent) {
        appendDigit("2");
    }

    public void Presionar3(ActionEvent actionEvent) {
        appendDigit("3");
    }

    public void Presionar4(ActionEvent actionEvent) {
        appendDigit("4");
    }

    public void Presionar5(ActionEvent actionEvent) {
        appendDigit("5");
    }

    public void Presionar6(ActionEvent actionEvent) {
        appendDigit("6");
    }

    public void Presionar7(ActionEvent actionEvent) {
        appendDigit("7");
    }

    public void Presionar8(ActionEvent actionEvent) {
        appendDigit("8");
    }

    public void Presionar9(ActionEvent actionEvent) {
        appendDigit("9");
    }

    public void Presionar0(ActionEvent actionEvent) {
        appendDigit("0");
    }

    public void Submit(ActionEvent actionEvent) {
        String pin = PinArea.getText();
        if (pin.length() == 4) {
            for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
                if (pin.equals(cuentaBanco.getContrasena())) {
                    System.out.println("PIN correcto.");

                    return;
                }
            }
        } else {
            System.out.println("El PIN debe tener 4 dígitos.");
        }
        PinArea.clear();
    }
}
