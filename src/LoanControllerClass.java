/* CMSC 255 - Final Project

 * Group 1 - Loan Calculator - Controller Class for GUI

 * Members: David Kuforiji
 *          Mudassir Lodi
 *          Reid Spalding
 *          Justin Le

 * Interest rate calculator: User inputs approximate
 * credit score, total amount, down-payment, or monthly
 * payments for 48 month, 60 month, and 72 month loans.
 * Program will calculate missing values.
 *
 * Version 0.3.1
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;


public class LoanControllerClass {

    @FXML
    private TextField creditScoreField;

    @FXML
    private TextField totalAmountFinancedField;

    @FXML
    private TextField downPaymentField;

    @FXML
    private TextField monthlyPaymentField;

    @FXML
    private Text resultsTextField;

    @FXML
    private Button loanButton;

    @FXML
    private Button creditScoreButton;

    @FXML
    private Button downPaymentButton;

    @FXML
    private Button maxAmountFinance;

    @FXML
    private Button resetButton;

    /*
    Calculates monthly payments for a loan
    This function is triggered when the user presses the loanButton in the GUI
     */
    public void calculateMonthlyPayments(ActionEvent event) throws IOException {

        try{

            /* calculate principal amount */
            double userPrincipal = Double.parseDouble(totalAmountFinancedField.getText()) - Double.parseDouble(downPaymentField.getText());

            /* call method to get rates */
            double[] newRates = LoanCalculator.getRates(Double.parseDouble(creditScoreField.getText()));

            /* call method to calculate payments */
            double[] newPayments = LoanCalculator.getPayments(userPrincipal, newRates);

            /* months counter for display */
            int months = 48;
            String results = "";

            /* display results with loop */
            for (int i = 0; i < 3; i++){

                results += String.format("Monthly payments for a %d month loan would be $%,.2f /mo.%n", months, newPayments[i]);
                months += 12;

            }
            resultsTextField.setText(results);

        }catch(Exception e){

            resultsTextField.setText("Err: Invalid or Missing Values.");

        }

    }

    /*
    Calculates Credit Score
    This function is triggered when the user presses the creditScoreButton in the GUI
     */
    public void calculateCreditScore(ActionEvent event) throws IOException {

        try{

            /* calculate principal amount */
            double userPrincipal = Double.parseDouble(totalAmountFinancedField.getText()) - Double.parseDouble(downPaymentField.getText());

            /* Call method to calculate credit scores */
            String[] newScores = LoanCalculator.getScores(userPrincipal, Double.parseDouble(monthlyPaymentField.getText()));

            /* months counter for display */
            int months = 48;
            String results = "";

            /* display results with loop */
            for (int i = 0; i < 3; i++){

                results += String.format("An ideal credit score for a %d mo. loan would be at least %s.%n", months, newScores[i]);
                months += 12;

            }
            resultsTextField.setText(results);

        }catch(Exception e){

            resultsTextField.setText("Err: Invalid or Missing Values.");

        }

    }

    /*
    Calculates Down Payment
    This function is triggered when the user presses the downPaymentButton in the GUI
     */
    public void calculateDownPayment(ActionEvent event) throws IOException {

        try{

            /* get principal amount */
            double userPrincipal = Double.parseDouble(totalAmountFinancedField.getText());

            /* call method to get rates */
            double[] newRates = LoanCalculator.getRates(Double.parseDouble(creditScoreField.getText()));

            /* Call method to get principal */
            double[] newPrincipal = LoanCalculator.getPrincipal(newRates, Double.parseDouble(monthlyPaymentField.getText()));

            /* months counter for display */
            int months = 48;
            String results = "";

            /* display results with loop */
            for (int i = 0; i < 3; i++) {

                results += String.format("Your down payment would need to be $%,.2f for a %d month loan.%n", (userPrincipal - newPrincipal[i]), months);
                months += 12;

            }

            resultsTextField.setText(results);

        }catch(Exception e){

        resultsTextField.setText("Err: Invalid or Missing Values.");

        }

    }

    /*
    Calculates maximum amount that can be financed
    This function is triggered when the user presses the downPaymentButton in the GUI
     */
    public void calculateMaxAmountFinance(ActionEvent event) throws IOException {

        try{
            /* get down payment amount */
            double userDown = Double.parseDouble(downPaymentField.getText());

            /* call method to get rates */
            double[] newRates = LoanCalculator.getRates(Double.parseDouble(creditScoreField.getText()));

            /* Call method to get principal */
            double[] newPrincipal = LoanCalculator.getPrincipal(newRates, Double.parseDouble(monthlyPaymentField.getText()));

            /* months counter for display */
            int months = 48;
            String results = "";

            /* display results with loop */
            for (int i = 0; i < 3; i++) {

                results += String.format("Principal for a %d month loan could be up to $%,.2f /mo.%n", months, (newPrincipal[i] + userDown));
                months += 12;

            }

            resultsTextField.setText(results);

        }catch(Exception e){

            resultsTextField.setText("Err: Invalid or Missing Values.");

        }

    }

    /*
    resets all input values and results value to default
     */
    public void clearAllPressed(ActionEvent event) throws IOException {

        /* set results field to values reset and default */
        resultsTextField.setText("Values Reset.\n\nResults Will Be Displayed Here");

        /* clear all input fields */
        creditScoreField.clear();
        totalAmountFinancedField.clear();
        downPaymentField.clear();
        monthlyPaymentField.clear();

    }

}
