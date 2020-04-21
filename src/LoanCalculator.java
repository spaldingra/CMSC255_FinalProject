/* CMSC 255 - Final Project

 * Group 1 - Loan Calculator

 * Members: David Kuforiji
 *          Mudassir Lodi
 *          Reid Spalding
 *          Justin Le

 * Interest rate calculator: User inputs approximate
 * credit score, total amount, down-payment, or monthly
 * payments for 48 month, 60 month, and 72 month loans.
 * Program will calculate missing values.
 *
 * Version 0.2.1
 *
 * Change Log:
 * V0.1.1 - framework of methods added, algorithm added as comments, began new algorithms/changes to methods. -Reid
 * V0.1.2 - updated with global constants and getPayments method by David, added front end by David, 4/2/20 - Reid
 * v0.1.3 - added getRates by Mudassir, 4/2/20 - Reid
 * V0.2.0 - completed main method, getInput, getPrincipal, getScores methods. Minor changes across whole file.
 *          Finished logic for unfinished areas, added error catches, and tested code. 4/2/20 - Reid
 * V0.2.1 - Fixed wording in instruction prompts for clarity.
 *          Final version for Milestone 2. 4/2/20 - Reid
 */

/* imports */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class LoanCalculator extends Application {

    /* Main Argument */
    public static void main(String[] args) {

        /*
        Launches the GUI
         */
        launch(args);



        /* Set boolean variable for when to exit application, set orQuit to false, boolean orQuit = false; */
        boolean orQuit = false;

        /*Set scanner input, Scanner userInput = new Scanner(System.in); */
        Scanner userInput = new Scanner(System.in);

        /* Set up Do-While Loop for quit, do {...} while (orQuit != true); */
        do {

            /* instruction prompt */
            System.out.println();
            System.out.println("Input all of the following values to calculate a loan. Enter '-99' for the value you wish to be calculated.");
            System.out.println();

            /* Call method for inputs*/
            double[] inputs = getInput(userInput);

            /* if credit score is given and principal is given, to find payments */
            if ((inputs[0] != -99) && (inputs[1] != -99) && (inputs[2] == -99)) {

                /* Call method to get credit score based interest rates */
                double[] newRates = getRates(inputs[0]);

                /* Call method to calculate payments */
                double[] newPayments = getPayments(inputs[1], newRates);

                /* months counter for display */
                int months = 48;

                /* display results with loop */
                for (int i = 0; i < 3; i++){

                    System.out.printf("%nMonthly payments for a %d month loan would be $%,.2f /mo.", months, newPayments[i]);
                    months += 12;

                }

            }

            /* else, if credit score is given and payments are given, to find principal */
            else if ((inputs[0] != -99) && (inputs[1] == -99) && (inputs[2] != -99)) {

                /* Call method to get credit score based interest rates */
                double[] newRates = getRates(inputs[0]);

                /* Call method to get principal */
                double[] newPrincipal = getPrincipal(newRates, inputs[2]);

                /* months counter for display */
                int months = 48;

                /* display results with loop */
                for (int i = 0; i < 3; i++){

                    System.out.printf("%nPrincipal for a %d month loan could be up to $%,.2f /mo.", months, newPrincipal[i]);
                    months += 12;

                }

            }
            /* else, if payments are given and principal is given, to find credit score needed */
            else if ((inputs[0] == -99) && (inputs[1] != -99) && (inputs[2] != -99)) {

                /* Call method to calculate credit scores */
                String newScores = getScores(inputs[1], inputs[2]);

                /* display results, ideal score for 60 mo loan */
                System.out.printf("%nAn ideal credit score for a 60 mo. loan would be " + newScores + ".");

            }

            /* else, */
            else{

                /* error */
                System.out.printf("%nERR: Error with inputs, please only only enter -99 for one value, and 0 for down payment if no payment.");

            }

            /* print line to next */
            System.out.println();

            /* check for quit */
            System.out.println("Would you like to do another calculation? Type 'quit' to Exit.");
            if (userInput.next().equals("quit")){

                orQuit = true;

            }

            /* scanner reset */
            System.out.println();
            userInput.nextLine();

            /* end do while */
        } while (orQuit != true);

    }


    /* Declares and initializes constants */
    private static final double[] goodRate = {0.03, 0.045, 0.05};
    private static final double[] okRate = {0.045, 0.060, 0.065};
    private static final double[] badRate = {0.08, 0.095, 0.1};

    /*
    Loads the FXML and draws the GUI
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoanCalculator.fxml"));
        primaryStage.setTitle("Loan Calculator App");
        primaryStage.setScene(new Scene(root, 550, 450));
        primaryStage.show();
    }

    /* method for gathering inputs */
    public static double[] getInput(Scanner userInput) {

        /* Declare userScore, userAmount, userDownPay, userMonthly */
        double userScore = -99;
        double userAmount = -99;
        double userDownPay = 0;
        double userMonthly = -99;

        /* Prompt user input for credit score and set userScore equal to input value, userScore = userInput.nextInt(); */
        System.out.println("Input credit score, or enter -99 to calculate this value:");
        userScore = userInput.nextDouble();

        /* Prompt user input for total amount financed and set userAmount to input value, userAmount = userInput.nextDouble(); */
        System.out.println("Input total amount of loan, or enter -99 to calculate this value:");
        userAmount = userInput.nextDouble();

        /* Prompt user input for down payment and set userDownPay to input value, userDownPay = userInput.nextDouble(); */
        System.out.println("Input down payment (0 if no payment):");
        userDownPay = userInput.nextDouble();

        /* Prompt user input for monthly payment*/
        System.out.println("Input monthly payment, or enter -99 calculate this value:");
        userMonthly = userInput.nextDouble();

        /* Set userPrincipal to total amount minus down payment, double userPrincipal = userAmount - userDownPay; */
        double userPrincipal = userAmount - userDownPay;

        /* return user values as array */
        double[] userInputs = {userScore, userPrincipal, userMonthly};
        return userInputs;

    }

    /* method to get credit score rates */
    public static double[] getRates(double userScore){

        double[] userRate = new double[3];

        if (userScore >= 720 && userScore <= 850) {

            userRate = goodRate;

        }

        else if (userScore >= 650 && userScore < 720) {

            userRate = okRate;

        }

        else if (userScore >= 300 && userScore < 650) {

            userRate = badRate;

        }

        else {

            System.out.println("Err: Invalid credit score");

        }

        return userRate;

    }

    /* method to calculate payments, returns array of doubles for payments at different lengths */
    public static double[] getPayments(double userPrincipal, double[] userRate) {

        // Declares and initiates a new array
        double[] array = new double[3];

        // Calculates the payment for 48 months
        double payment1 = (userPrincipal * (1 + userRate[0])) / 48;
        array[0] = payment1;

        // Calculates the payment for 60 months
        double payment2 = (userPrincipal * (1 + userRate[1])) / 60;
        array[1] = payment2;

        // Calculates the payment for 72 months
        double payment3 = (userPrincipal * (1 + userRate[2])) / 72;
        array[2] = payment3;

        return array;

    }

    /* method to get principal, returns double for principal value*/
    public static double[] getPrincipal(double[] userRate, double userPay){

        /* create empty array for return */
        double[] userPrincipal = new double[3];

        /* calculate principal for 48 month */
        userPrincipal[0] = ((userPay * 48) / (1 + userRate[0]));

        /* calculate principal for 60 month */
        userPrincipal[1] = ((userPay * 60) / (1 + userRate[1]));

        /* calculate principal for 72 month */
        userPrincipal[2] = ((userPay * 48) / (1 + userRate[2]));

        /* return values */
        return userPrincipal;

    }

    /* method to get credit scores, returns string for score range needed for ideal 60 mo loan*/
    public static String getScores(double userPrincipal, double userPay){

        /* create new string value for return */
        String newScores;

        /* calculate rate needed */
        double needRate = (((userPay * 60) / userPrincipal) - 1);

        /* if rate is below 0.045, score needed is 720 - 850 */
        if(needRate <= 0.045){

            newScores = "720 - 850";

        }

        /* else, if rate is between 0.045 and 0.06, score needed is 650 - 720 */
        else if ((needRate > 0.045) && (needRate <= 0.06)){

            newScores = "650 - 720";

        }
        /* else, score needed is 300 - 650 */
        else {

            newScores = "300 - 650";

        }

        /* return value of scores */
        return newScores;

    }

}
/* end code */