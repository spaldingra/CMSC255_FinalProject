import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private Button loanButton;

    @FXML
    private Button creditScoreButton;

    @FXML
    private Button downPaymentButton;

    @FXML
    private Button monthlyPaymentButton;

    /**
     * Note that the logic should be here, simply copy and paste functions and variables as appropriate.
     * Note that System.out.print() may not work here
     */


    /*
    Calculates Loan
    This function is triggered when the user presses the loanButton in the GUI
     */
    public void calculateLoan(ActionEvent event) throws IOException {

        /*
        Use "TextField".getText() to get user inout and "TextField".clear() to clear user input
         */
    }

    /*
    Calculates Credit Score
    This function is triggered when the user presses the downPaymentButton in the GUI
     */
    public void calculateCreditScore(ActionEvent event) throws IOException {

        /*
        Use "TextField".getText() to get user inout and "TextField".clear() to clear user input
         */
    }

    /*
    Calculates Down Payment
    This function is triggered when the user presses the creditScoreButton in the GUI
     */
    public void calculateDownPayment(ActionEvent event) throws IOException {

        /*
        Use "TextField".getText() to get user inout and "TextField".clear() to clear user input
         */
    }

    /*
    Calculates Credit Score
    This function is triggered when the user presses the monthlyPaymentButton in the GUI
     */
    public void calculateMonthlyPayment(ActionEvent event) throws IOException {

        /*
        Use "TextField".getText() to get user inout and "TextField".clear() to clear user input
         */
    }


}
