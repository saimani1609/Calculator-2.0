package calc;

import java.util.ArrayList;

public class Calculator {
  
  private ArrayList<String> formula;
  private double sum;
  private String display;
  private boolean output;
  private boolean degrees;
  private int charLimit;
  
  private int pos;
  
  public Calculator(int charLimit) {
    formula = new ArrayList<String>();
    display = "0";
    output = true;
    degrees = true;
    this.charLimit = charLimit;
  }
  
  /**
   * Sets the maximum number of characters that can be displayed on the screen.
   * 
   * @param limit the number of characters that can be displayed on the screen
   */
  public void setLimit(int limit) {
    charLimit = limit;
  }
  
  /**
   * Sets the format for what should be displayed to screen, degrees or radians.
   * 
   * @param degrees true if displaying degrees, false if displaying radians
   */
  public void setFormat(boolean degrees) {
    this.degrees = degrees;
  }
  
  /**
   * Creates the formula that is being calculated.
   * 
   * @return the formula being calculated
   */
  public String getDisplayFormula() {
    StringBuilder sb = new StringBuilder();
    for (String s : formula) {
      sb.append(s);
      sb.append("  ");
    }
    if (sb.length() > charLimit * 1.5)
      return "... " + sb.toString().substring(sb.length() - (int)(charLimit * 1.5));
    else
      return sb.toString();
  }
  
  /**
   * Gets the string to be displayed on-screen. Can be either input or output data.
   * 
   * @return the input/output to be displayed on-screen
   */
  public String getDisplay() {
    return display;
  }
  
  /**
   * Sets the input to a number.
   * 
   * @param number the input value
   */
  public void setPi() {
    display = Math.PI + "";
    output = true;
  }
  
  /**
   * Updates the input with the latest typed number.
   * 
   * @param number the number to place at the end of the input value
   */
  public void updateInput(String number) {
    if (output) {
      display = number;
      output = false;
    } else if (display.length() < charLimit)
      display += number;
    else
      ding();
  }
  
  /**
   * Inserts a decimal into the input value. A decimal can not be inserted if one
   * already exists in the input value.
   */
  public void insertDecimal() {
    if (output)
      updateInput("0.");
    else if (!display.contains("."))
      updateInput(".");
    else
      ding();
  }
  
  /**
   * Negates the current display value. A negative becomes a positive and vice-versa.
   * Can not negate zero.
   */
  public void negate() {
    if (checkZero()) 
      if (display.contains("-"))
        display = display.substring(1, display.length());
      else
        display = "-" + display;
  }
  
  /**
   * Takes the reciprocal of the current display value. Can not take the reciprocal of zero.
   */
  public void reciprocal() {
    if (checkZero()) {
      display = (1 / Double.parseDouble(display)) + "";
      validateFormat();
    }
  }
  
  /**
   * Takes the square root of the current display value. Can not take the square root of zero.
   */
  public void sqroot() {
    if (checkZero()) {
      display = Math.sqrt(Double.parseDouble(display)) + "";
      validateFormat();
    }
  }
  
  /**
   * Takes the cubed root of the current display value. Can not take the cubed root of zero.
   */
  public void cuberoot() {
    if (checkZero()) {
      display = Math.cbrt(Double.parseDouble(display)) + "";
      validateFormat();
    }
  }
  
  /**
   * Squares the current display value.
   */
  public void square() {
    display = Math.pow(Double.parseDouble(display), 2) + "";
    validateFormat();
  }
  
  /**
   * Cubes the current display value.
   */
  public void cube() {
    display = Math.pow(Double.parseDouble(display), 3) + "";
    validateFormat();
  }
  
  /**
   * Takes 10 up to the current display value.
   */
  public void tenX() {
    display = Math.pow(10, Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the log of the current display value.
   */
  public void log() {
    display = Math.log10(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes e up to the current display value.
   */
  public void exp() {
    display = Math.exp(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the ln of the current display value.
   */
  public void ln() {
    display = Math.log(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the factorial of the current display value.
   */
  public void factorial() {
    if (display.equals("0")) {
      display = 1 + "";
    } else if (display.contains(".")){
      ding();
    } else {
      int sum = 1;
      for (int c = (int)Double.parseDouble(display); c > 0; c--)
        sum *= c;
      display = sum + "";
      validateFormat();
    }
  }
  
  /**
   * Takes the cos of the current display value.
   */
  public void cos() {
    if (degrees)
      display = Math.cos(Double.parseDouble(display) * Math.PI / 180) + "";
    else
      display = Math.cos(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the cos inverse of the current display value.
   */
  public void acos() {
    if (degrees)
      display = Math.acos(Double.parseDouble(display)) * 180 / Math.PI + "";
    else
      display = Math.acos(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the sin of the current display value.
   */
  public void sin() {
    if (degrees)
      display = Math.sin(Double.parseDouble(display) * Math.PI / 180) + "";
    else
      display = Math.sin(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the sin inverse of the current display value.
   */
  public void asin() {
    if (degrees)
      display = Math.asin(Double.parseDouble(display)) * 180 / Math.PI + "";
    else
      display = Math.asin(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the tan of the current display value.
   */
  public void tan() {
    if (degrees)
      display = Math.tan(Double.parseDouble(display) * Math.PI / 180) + "";
    else
      display = Math.tan(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Takes the tan inverse of the current display value.
   */
  public void atan() {
    if (degrees)
      display = Math.atan(Double.parseDouble(display)) * 180 / Math.PI + "";
    else
      display = Math.atan(Double.parseDouble(display)) + "";
    validateFormat();
  }
  
  /**
   * Checks if the current display value is equal to zero.
   * 
   * @return true if display does not equal zero, false otherwise
   */
  private boolean checkZero() {
    if (display.equals("0")) {
      ding();
      return false;
    } else
      return true;
  }
  
  /**
   * Implements a backspace on the current display value. Removes the rightmost digit.
   */
  public void backspace() {
    if (output) {
      display = "0";
    }else if(display.length() > 0) {
      display = display.substring(0, display.length() - 1);
      if (display.length() == 0) {
        display = "0";
        output = true;
      }
    } else
      ding();
  }
  
  /**
   * Performs addition.
   */
  public void add() {
    functionUpdate("+");
  }
  
  /**
   * Performs subtraction.
   */
  public void subtract() {
    functionUpdate("-");
  }
  
  /**
   * Performs multiplication.
   */
  public void multiply() {
    functionUpdate("*");
  }
  
  /**
   * Performs division.
   */
  public void divide() {
    functionUpdate("/");
  }
  
  /**
   * Performs division and gets only the remainder.
   */
  public void mod() {
    functionUpdate("mod");
  }
  
  /**
   * Performs the yth root of x.
   */
  public void yroot() {
    functionUpdate("^ 1 /");
  }
  
  /**
   * Performs the yth root of x.
   */
  public void xy() {
    functionUpdate("^");
  }
  
  /**
   * Adds the currently entered value as well as the function to the formula.
   * 
   * @param function the next function to be performed
   */
  private void functionUpdate(String function) {
    validateFormat();
    formula.add(display);
    formula.add(function);
  }
  
  /**
   * Calculates the formula.
   */
  public void equal() {
    validateFormat();
    formula.add(display);
    calculate();
    output = true;
    formula = new ArrayList<String>();
  }
  
  /**
   * Ensures that the display does not end with a "." or ".0".
   */
  private void validateFormat() {
    if (display.endsWith("."))
      display = display.substring(0, display.length() - 1);
    else if (display.endsWith(".0"))
      display = display.substring(0, display.length() - 2);
    output = true;
  }
  
  /**
   * Clears the current display value, but not the formula.
   */
  public void clearInput() {
    display = "0";
    output = true;
  }
  
  /**
   * Clears the current display value and the formula.
   */
  public void clearAll() {
    display = "0";
    output = true;
    formula = new ArrayList<String>();
  }
  
  /**
   * Creates a sound when a user performs an illegal action.
   */
  private void ding() {
    java.awt.Toolkit.getDefaultToolkit().beep();
  }
   
  /**
   * Cycles through the formula array and calculates a value. Uses the recursive function
   * calc to ensure that the order of operations is performed correctly.
   */
  private void calculate() {
    if (formula.size() > 1) {
      sum = Double.parseDouble(formula.get(0));
      pos = 1;
      while (pos <= formula.size() - 1) {
        if (pos + 1 <= formula.size() - 1) {
          if (formula.get(pos).equals("+"))
            sum += calc();
          else if (formula.get(pos).equals("-"))
            sum -= calc();
          else if (formula.get(pos).equals("*"))
            sum *= calc();
          else if (formula.get(pos).equals("/"))
            sum /= calc();
          else if (formula.get(pos).equals("^ 1 /")) {
            sum =  Math.pow(sum, 1/ Double.parseDouble(formula.get(pos + 1)));
            pos += 2;
          } else if (formula.get(pos).equals("^")) {
            sum =  Math.pow(sum, Double.parseDouble(formula.get(pos + 1)));
            pos += 2;
          } else if (formula.get(pos).equals("mod")) {
            int multiplier = (int)(sum / Double.parseDouble(formula.get(pos + 1)));
            sum -= (multiplier * Double.parseDouble(formula.get(pos + 1)));
            pos += 2;
          }
        } else
          break;
      }
      display = sum + "";
      validateFormat();
    } else
      sum = Double.parseDouble(display);
  }
  
  /**
   * The recursive function that performs calculations following the order of operations.
   * 
   * @return the calculated subtotal
   */
  private double calc() {
    pos += 2; // always increment by 2 to sit on a function, not a numberical value
    if (pos >= formula.size() || pos + 1 >= formula.size() || formula.get(pos).equals("+") || formula.get(pos).equals("-"))
      return Double.parseDouble(formula.get(pos - 1));
    else if (formula.get(pos).equals("*"))
      return Double.parseDouble(formula.get(pos - 1)) * calc();
    else if (formula.get(pos).equals("/"))
      return Double.parseDouble(formula.get(pos - 1)) / calc();
    else if (formula.get(pos).equals("^ 1 /")) {
      double root = Math.pow(Double.parseDouble(formula.get(pos - 1)), 1/ Double.parseDouble(formula.get(pos + 1)));
      pos += 2;
      return root;
    } else if (formula.get(pos).equals("^")) {
      double exp = Math.pow(Double.parseDouble(formula.get(pos - 1)), Double.parseDouble(formula.get(pos + 1)));
      pos += 2;
      return exp;
    } else if (formula.get(pos).equals("mod")) {
      int multiplier = (int)(Double.parseDouble(formula.get(pos - 1)) / Double.parseDouble(formula.get(pos + 1)));
      double mod = Double.parseDouble(formula.get(pos - 1)) - (multiplier * Double.parseDouble(formula.get(pos + 1)));
      pos += 2;
      return  mod;
    }
    return 0.0; // this should never be reached
  }
}










