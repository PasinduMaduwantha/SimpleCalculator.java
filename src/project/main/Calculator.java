package project.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class Calculator {
    // Declare all the buttons
    public Button cosBtn;
    public Button squarBtn;
    public Button tanBtn;
    public Button sinBtn;
    public Button delBtn;
    public Button clearBtn;
    public Button openBracketBtn;
    public Button num7Btn;
    public Button multipleBtn;
    public Button divideBtn;
    public Button num8Btn;
    public Button num9Btn;
    public Button num4Btn;
    public Button num5Btn;
    public Button additonBtn;
    public Button subtractBtn;
    public Button numBtn;
    public Button num6Btn;
    public Button num1Btn;
    public Button modulesBtn;
    public Button plusOrMinusBtn;
    public Button num2Btn;
    public Button num3Btn;
    public Button logBtn;
    public Button equalBtn;
    public Button num0btn;
    public Button decimalBtn;
    public Button expBtn;
    public Button cubicBtn;
    public TextField txtAns;
    public Button closeBracketBtn;
    public Button squareRootBtn;
    public Button cosinInvBtn;
    public Button tanInvBtn;
    public Button sinInvBtn;


    // Declare variables
    private double value1=0;
    private double value2=0;
    private double result=0;
    String operation=null;
    String  answer=null;
    int plusOrMinusCount = 0;
    Stack<String> operators = new Stack<>(); // Vector for storing the operations
    Stack<Double> values = new Stack<>(); // Vector for storing the values

    //delete charcter
    public void delBtnOnAction(ActionEvent actionEvent) {
        String backspace = null;
        if(txtAns.getText().length() > 0){
            StringBuilder strB = new StringBuilder(txtAns.getText());
            strB.deleteCharAt(txtAns.getText().length() - 1);
            backspace = strB.toString();
            txtAns.setText(backspace);
        }
    }
    //clear all
    public void clearBtnOnAtion(ActionEvent actionEvent) {
        txtAns.setText("");   //text field is cleared
    }
    //trigonometric functions
    public void cosBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0) {   //error handling
            result = postfixValue(txtAns.getText());
            result = Math.cos(Math.toRadians(Double.parseDouble(txtAns.getText())));
            answer = String.format("%.2f", result);
            txtAns.setText("cos("+txtAns.getText()+") = "+answer);
            operation="cos";
        }
        else {
            txtAns.setText("");
        }
    }

    public void tanBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0) {   //error handling
            value1 = Double.parseDouble(txtAns.getText());
            if (value1 == 90 || value1 == 270) {
                txtAns.setText("Infinity!!");
            } else {
                result = Math.tan(Math.toRadians(value1));
                answer = String.format("%.2f", result);
                txtAns.setText("tan("+txtAns.getText()+") = "+answer);
            }
        }
        else {
            txtAns.setText("");
        }
    }

    public void sinBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0) {   //error handling
            result = Math.sin(Math.toRadians(Double.parseDouble(txtAns.getText())));
            answer = String.format("%.2f", result);
            txtAns.setText("sin("+txtAns.getText()+") = "+answer);
        }
        else {
            txtAns.setText("");
        }
    }

    public void cosinInvBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0) {   //error handling
            result = Math.acos(Double.parseDouble(txtAns.getText()));
            //convert result into degrees
            result = Math.toDegrees(result);
            answer = String.format("%.2f", result);
            txtAns.setText("cosInv("+txtAns.getText()+") = "+answer);
        }
        else {
            txtAns.setText("");
        }
    }

    public void tanInvtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0) {   //error handling
            result = Math.atan(Double.parseDouble(txtAns.getText()));
            //convert result into degrees
            result = Math.toDegrees(result);
            answer = String.format("%.2f", result);
            txtAns.setText("tanInv("+txtAns.getText()+") = "+answer);
        }
        else {
            txtAns.setText("");
        }
    }

    public void sinvBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length()>0 ) {   //error handling
            result = Math.asin(Double.parseDouble(txtAns.getText()));
            //convert result into degrees
            result = Math.toDegrees(result);
            answer = String.format("%.2f", result);
            txtAns.setText("sinInv("+txtAns.getText()+") = "+answer);
        }
        else {
            txtAns.setText("");
        }
    }
    //number pad
    public void num9BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num9Btn.getText();
        txtAns.setText(number);
    }

    public void num8BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num8Btn.getText();
        txtAns.setText(number);
    }

    public void num7BtnOnActrion(ActionEvent actionEvent) {
        String number = txtAns.getText()+num7Btn.getText();
        txtAns.setText(number);
    }

    public void num6BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num6Btn.getText();
        txtAns.setText(number);
    }

    public void num5BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num5Btn.getText();
        txtAns.setText(number);
    }

    public void num4BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num4Btn.getText();
        txtAns.setText(number);
    }

    public void num3BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num3Btn.getText();
        txtAns.setText(number);
    }

    public void num2BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num2Btn.getText();
        txtAns.setText(number);
    }

    public void num1BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num1Btn.getText();
        txtAns.setText(number);
    }

    public void num0BtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+num0btn.getText();
        txtAns.setText(number);
    }

    public void decimalBtnOnAction(ActionEvent actionEvent) {
        String number = txtAns.getText()+decimalBtn.getText();
        txtAns.setText(number);
    }
    //operators
    public void multipleBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0){ //error handling
//            value1 = Double.parseDouble(txtAns.getText());
            txtAns.setText(txtAns.getText()+"*");
            operation = "*";
//            values.push(value1);
            operators.push(operation);
        }
        else {
            txtAns.setText("");
        }
    }
    public void divideBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0){ //error handling
//            value1 = Double.parseDouble(txtAns.getText());
            txtAns.setText(txtAns.getText()+"/");
            operation = "/";
//            values.push(value1);
            operators.push(operation);
        }
        else {
            txtAns.setText("");
        }
    }

    public void additionBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0){ //error handling
//            value1 = Double.parseDouble(txtAns.getText());
            txtAns.setText(txtAns.getText()+"+");
            operation = "+";
//            values.push(value1);
            operators.push(operation);
        }
        else {
            txtAns.setText("");
        }
    }

    public void subtractBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0) { //error handling
//            value1 = Double.parseDouble(txtAns.getText());
            txtAns.setText(txtAns.getText()+"-");
            operation = "-";
//            values.push(value1);
            operators.push(operation);
        }
        else {
            txtAns.setText("");
        }
    }

    public void modulasBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0) { //error handling
//            value1 = Double.parseDouble(txtAns.getText());
            txtAns.setText(txtAns.getText()+"%");
            operation = "%";
//            values.push(value1);
            operators.push(operation);
        }
        else {
            txtAns.setText("");
        }
    }

    public void equalBtnOnAction(ActionEvent actionEvent) {

        if (txtAns.getText().length() > 0) { //error handling
            //when use only two operands
            /*
            value2 = Double.parseDouble(txtAns.getText());
            if (operation == "+") {   //check the operation and perform the arithematic operation
                result = value1 + value2;
                answer = String.format("%.2f", result);
                txtAns.setText(answer);
            } else if (operation == "-") {
                result = value1 - value2;
                answer = String.format("%.2f", result);
                txtAns.setText(answer);
            } else if (operation == "*") {
                result = value1 * value2;
                answer = String.format("%.2f", result);
                txtAns.setText(answer);
            } else if (operation == "/") {
                result = value1 / value2;
                answer = String.format("%.2f", result);
                txtAns.setText(answer);
            } else if (operation == "%") {
                result = value1 % value2;
                answer = String.format("%.2f", result);
                txtAns.setText(answer);
            }
             */

            //first need to generate postfix expression, and evaluate the expression when generating postfix expression
            String expression = txtAns.getText();
            System.out.println(expression);
            //validate the expression
            if(isValid(expression)){
                //generate postfix expression
                System.out.println("valid expression");
                double finalValue = postfixValue(expression);
                txtAns.setText(expression+"="+finalValue);
            }
            else{
                System.out.println("SYNTAX ERROR");
                txtAns.setText("SYNTAX ERROR");
            }
            value1 = 0;
            value2 = 0;
            operation = "";
        }
        else {
            txtAns.setText("");
        }
    }

    private double postfixValue(String expression) {
        //generate postfix expression
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        Vector<String> postfix = new Vector<>();
        Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+|[+-/*%()]");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            postfix.add(matcher.group());
        }
        System.out.println(postfix);
        for (int i = 0;  postfix.size() > i; ) {
            String token = postfix.get(i);
            i++;
            if (token.equals("(")) {
                operators.push(token);
            }
            else if (isNumber(token)) {
                values.push(Double.parseDouble(token));
            }
            else if (token.equals(")")) {
                while ( !operators.peek().equals("(") && values.size() >=2) {
                    double value2 = values.pop();
                    double value1 = values.pop();
                    String operator = operators.pop();
                    System.out.println("1   : "+value1+" "+operator+" "+value2);
                    values.push(applyOperator(value1, value2, operator));
                }
                operators.pop();
            }
            else {
                if (!operators.isEmpty() && !
                        operators.peek().equals("(") && BODMAS(operators.peek()) >= BODMAS(token) && values.size() >=2) {
                    double value2 = values.pop();
                    double value1 = values.pop();
                    String operator = operators.pop();
                    System.out.println("2   : "+value1+" "+operator+" "+value2);
                    values.push(applyOperator(value1, value2, operator));
                }
                operators.push(token);
            }
        }
        while (!operators.isEmpty() && values.size() >=2) {
            double value2 = values.pop();
            double value1 = values.pop();
            String operator = operators.pop();
            System.out.println("3   : "+value1+" "+operator+" "+value2);
            values.push(applyOperator(value1, value2, operator));
        }
        double result = values.peek();
        System.out.println("final value:" + values.peek());
        return result;
    }

    int BODMAS(String token){   //return BODMAS value
        switch (token){
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "%":
                return 3;
            default: {
                System.out.println("BODMAS default");
                return 0;
            }
        }
    }

    double applyOperator (double value1, double value2, String operator){
        switch (operator){
            case "+":
                return value1+value2;
            case "-":
                return value1-value2;
            case "*":
                return value1*value2;
            case "/":
            {
                try {
                    Exception exception=new Exception();

                    return value1/value2;
                }
                catch (ArithmeticException e){

                    return 0;
                }
           }
            case "%":
            {
                try {
                    return value1%value2;
                }
                catch (ArithmeticException e){
                    return 0;
                }
            }
            default: {
                System.out.println("operator default");
                return 0;
            }
        }
    }

    public void plusOrMinusBtnOnAction(ActionEvent actionEvent) {
        plusOrMinusCount++;
    }
    //logarithmic values for base 10
    public void logBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0) { //error handling
            value1 = Double.parseDouble(txtAns.getText());
            result = Math.log10(value1);
            answer = String.format("%.2f", result);
            txtAns.setText(answer);
        }
        else {
            txtAns.setText("");
        }
    }
    //exponential values
    public void expBtnOnAction(ActionEvent actionEvent) {
        //exponential value
        if (txtAns.getText().length() > 0) { //error handling
            value1 = Double.parseDouble(txtAns.getText());
            result = Math.exp(value1);
            answer = String.format("%.2f", result);
            txtAns.setText(answer);
        }
        else {
            txtAns.setText("");
        }
    }
    //square of the number
    public void squarBtnOnAction(ActionEvent actionEvent) {
        //square valule
        if (txtAns.getText().length() > 0) { //error handling
            value1 = Double.parseDouble(txtAns.getText());
            result = Math.pow(value1, 2);
            answer = String.format("%.2f", result);
            txtAns.setText(answer);
        }
        else {
            txtAns.setText("");
        }
    }
    //cubic value of the number
    public void cubicBtnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0) { //error handling
            value1 = Double.parseDouble(txtAns.getText());
            result = Math.pow(value1, 3);
            answer = String.format("%.2f", result);
            txtAns.setText(answer);
        }
        else {
            txtAns.setText("");
        }
    }
    //square root of the number
    public void squareRootBtntnOnAction(ActionEvent actionEvent) {
        if (txtAns.getText().length() > 0) { //error handling
            value1 = Double.parseDouble(txtAns.getText());
            result = Math.sqrt(value1);
            answer = String.format("%.2f", result);
            txtAns.setText(answer);
        }
        else {
            txtAns.setText("");
        }
    }

    //bracket handling
    public void closeBracketOnAction(ActionEvent actionEvent) {
        operation = ")";
        txtAns.setText(txtAns.getText() + operation);
    }

    public void openBracketOnAction(ActionEvent actionEvent) {
        operation = "(";
        txtAns.setText(txtAns.getText() + operation);
    }

    boolean isValid(String expression){
        //check if the expression is valid
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            char afterDigit=' ';
            if (expression.length() > i + 1) {  //chek whether there is a next character
                afterDigit = expression.charAt(i + 1);
            }
            //if the character is an operand
            if (!Character.isLetterOrDigit(ch)){
                //validate for brackets
                if(ch=='('){
                    stack.push(ch);
                }
                else if(ch=='%' || ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch == '.'){
                    //after an operator, there should be an operand
                    if (expression.length() > i + 1) {  //chek whether there is a next character
                        char afterOperator = expression.charAt(i + 1);
                        if (Character.isDigit(afterOperator)) { //check if the next character is a digit, after an operator appear
                            i++;
                            continue;
                        }
                        else if (afterOperator == '(') { //check if the next character is a bracket, after an operator appear
                            stack.push(afterOperator);
                            i++;
                            continue;
                        }
                        else if (ch=='.' && afterOperator == '.') { //check if the next character is a decimal point, after an operator appear
                            return false;
                        }
                        else {  //if not digit after an operator, then it is invalid
                            return false;
                        }
                    }
                    else{   //if no operand after an operator, the expression end after operator so the expression is invalid
                        return false;
                    }
                }
                else if(!stack.isEmpty()){
                    if(ch==')' && stack.peek()=='('){
                        stack.pop();
                    }
                }
                else
                    return false;
            }
            else if(Character.isDigit(ch)){
                if(afterDigit=='('){    //if the next character after to a digit is a bracket, then it is invalid
                    return false;
                }
            }
            //if character either not a digit or an operator, that means character is an alphabetical character
            else if(!Character.isDigit(ch)){
                return false;
            }
        }
        //if the expression is valid, then stack should be empty
        return stack.isEmpty();
    }

}
