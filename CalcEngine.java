/**
 * The main part of the calculator doing the calculations.
 * 
 * @author: (none yet)
 * @version 0.1 (incomplete)
 */
public class CalcEngine
{
    // Put instance variables here.
    //The current diplay value
    private int displayValue;
    //The previous operator typed (+ or -)
    private char previousOperator;
    //The left operand to previousOperator
    private int leftOperand;
    //Signal for numberPressed method to reset the diplay value after plus or minus
    private boolean resetDisplayValue;

    /**
     * Create a CalcEngine.
     */
    //Initializes the calculator's internal state
    public CalcEngine()
    {
        displayValue = 0;
        previousOperator = ' ';
        leftOperand = 0;
        resetDisplayValue = false;
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    //Returns the current value shown on the calculator's display
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    //Updates the display value by appending the pressed number. Resets the display if needed
    public void numberPressed(int number)
    {
        //If previous press was plus or minus reset dispay value
        if(resetDisplayValue) {
            displayValue = 0;
        }
        displayValue = displayValue * 10 + number;
        resetDisplayValue = false;
    }

    /**
     * The 'plus' button was pressed. 
     */
    //Stores the '+' operator and prepares for the next operand
    public void plus()
    {
        applyPreviousOperator();
        previousOperator = '+';
        resetDisplayValue = true;
    }

    /**
     * The 'minus' button was pressed.
     */
    //Stores the '-' operator and prepares for the next operand
    public void minus()
    {
        applyPreviousOperator();
        previousOperator = '-';
        resetDisplayValue = true;
    }

    /**
     * The '=' button was pressed.
     */
    //Performs the calculation based on the previous operator and displays the result
    public void equals()
    {
        if(previousOperator == '+') {
            displayValue = leftOperand + displayValue;
        } else {
            displayValue = leftOperand - displayValue;
        }
        leftOperand = 0;
        //Reset the operator after a finiched calculation
        previousOperator = ' ';
    }
    
    //Applies the previously stored operator to the left operand
    //This method is used internally to perform intermediate calculations
    private void applyPreviousOperator() {
        if(previousOperator == '+') {
            leftOperand += displayValue;
        } else if(previousOperator == '-') {
            leftOperand -= displayValue;
        } else {
            //There was no preceding operator
            leftOperand = displayValue;
        }
    }
    
    /**
     * The 'C' (clear) button was pressed.
     */
    //Resets the calculator to its initial state
    public void clear()
    {
        displayValue = 0;
        //True reset the calculation by resetting the operator
        previousOperator = ' ';
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return "";
    }

    /**
     * @return The version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return "";
    }
}
