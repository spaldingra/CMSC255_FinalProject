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
 * Version 0.1.0
 *
 * Change Log:
 * V0.1.0 - framework of methods added, algorithm added as comments, began new algorithms/changes to methods. -Reid
 */

public class LoanCalculator {

    /* Declares and initializes constants */
    private static final double[] GOOD_RATE = {0.03, 0.045, 0.06};
    private static final double[] OK_RATE = {0.045, 0.060, 0.075};
    private static final double[] BAD_RATE = {0.08, 0.095, 0.1};

    /* Main Argument */
    public static void main(String[] args) {

        /* Set boolean variable for when to exit application, set orQuit to false, boolean orQuit = false; */

        /*Set scanner input, Scanner userInput = new Scanner(System.in); */

        /* Set up Do-While Loop for quit, do {...} while (orQuit != true); */

        /* Call method for inputs*/

        /* if credit score is given and principal is given, */

        /* Call method to get credit score rates */

        /* Call method to calculate payments */

        /* else, if credit score is given and payments are given, */

        /* Call method to get principal */

        /* else, if payments are given and principal is given, */

        /* Call method to calculate credit scores */

            /* else, if credic score is n
            /* else, */

        /* error */

        /* end do while */

    }

    /* method for gathering inputs */
    public static String[] getInput() {

        /* Declare userScore, int userScore; Declare userAmount, double userAmount;
        /* Declare userDownPay, double userDownPay; */

        /* Prompt user input for credit score and set userScore equal to input value, userScore = userInput.nextInt(); */

        /* Prompt user input for total amount financed and set userAmount to input value, userAmount = userInput.nextDouble(); */

        /* Prompt user input for down payment and set userDownPay to input value, userDownPay = userInput.nextDouble(); */

        /* Set userPrincipal to total amount minus down payment, double userPrincipal = userAmount - userDownPay; */

        /* return user values as array of strings*/

    }

    /* method to get credit score rates */
    public static double[] getRates(){

        /* If statement for good rates, If (userScore >= 720 && userScore <= 850){...} */

            /* Set userRate equal to goodRate values, double[] userRate = goodRate; */

        /* Else if statement for ok rates, elif (userScore < 720 && userScore >= 650) {...} */

            /* Set userRate equal to okRate values, double[] userRate = okRate; */

        /* Else if statement for bad rates, elif (userScore < 650 && >= 300) {...} */

            /* Set userRate equal to badRate values, double[] userRate = badRate; */

        /* Else statement for score not in range/invalid entry, else{...} */

            /* Print prompt “Invalid Credit Score” */

            /* Break; */

        /* Return userRate */

    }

    /* method to calculate payments, returns array of doubles for payments at different lengths */
    public static double[] getPayments(){

        /* Calculate payment for 48 months, payment[1] = ( userPrincipal * ( 1 + userRate[0] ) ) / 48; */

        /* Calculate payment for 60 months, payment[2] = ( userPrincipal * ( 1 + userRate[1] ) ) / 60; */

        /* Calculate payment for 72 months, payment[3] = ( userPrincipal * ( 1 + userRate[2] ) ) / 72; */

        /* returns payments in array */

    }

    /* method to get principal, returns double for principal value*/
    public static double getPrincipal(){

        /* incomplete */

    }

    /* method to get credit scores, returns string for score range */
    public static String getScores(){

        /* incomplete */

    }

}
/* end code */