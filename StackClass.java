/* Project 2 using the stack class to use postfix calculator*/
/*Ivaan Shrestha*/
/*October 14 2014*/
/* This roject will communicate with user through JOptionPane windows to
 ask for values and showing results and error. This uses the postfix calculator*/
import javax.swing.*;
public class StackClass {
   
   //constants
   public static final boolean DEBUG = true; //devlaring the boolean constant
   public static final double ERROR_VALUE = -99.99; // declaring the error value constant 
   private int size; // declaring the int variable size which holds the size of stack
   private int top; // declaring the int top variable
   private double [] data; // declaring the double variable data which holds array of values
   
   
   //constructor
   
  public StackClass(int newSize) { // constructor StackClass with one parameter int newSize that will be passed from main
  
   size = newSize; // size of stack equalling the passed value from constructor
   top = -1; // initializing the variable top as -1
   data = new double[size]; // adding the size of the double array
   //initialzing the array manually 
   for (int i = 0; i < size; i++) {
         data[i] = 0; //initializing each data array with value 0
           
   }
   
  }
  //push method
  public Boolean push(double newNum){ // Boolean push method with one parameter which takes value from main and stores it in data array
   if (top == size-1) { //checking if value of top is equal to size -1
      return false; // returning value false as passed paramter was not stored in the stack

   }
   
   else { //otherwise
   
      top = top +1; // increasing the value of top 
      data[top] = newNum; // storing the value of passed parameter in data array
      return true; // returning value true as passed paramter was stored in the stack
   }   //end else and if statements
   
  
  }//end push method
  //pop method
  public double pop(){ // pop method that returns the value from the stack one each at a time
   if (top == -1) { // if top is equal to -1, which means stack is empty
      return ERROR_VALUE; //return error value
   }   
   else { //when stack is not empty
      int newNum = top; //declaring new integer newNum and intializing its value to top
      top = top-1; // decreasing the value of top
      return data[newNum]; //retrung the data from the stack 
   }   //end else and if statements
   
  
  }
 
 
  // to String method
  public String toString() { // converts to string
   return " value of top "+ top + " \n value of stack:" + data[0]; // returns and prints the top value and final data at bottom of stack
  }
  
  public static void main (String[] args) { //main class
   
   boolean work = true; // setting boolean value as true
      
   while (work = true){ //when boolean value is true
      int size = 25; // intitializing the int variable size
      StackClass myStack = new StackClass(size); // creating an object called myStack with size value of 25
      double[] number = new double[50];// declaring and initializing the double array number with size 50 as we need to let input 50 digits
      String input = new String(); // declaring new string as input to store the value input by user
      input = JOptionPane.showInputDialog(null, "Please input numbers and operator:");// Asks for numbers and operators in JOptionPane window and stores it in variable input
      if(input == null) { // when input is null
         JOptionPane.showMessageDialog(null, "User hit 'cancel'", "Null value", 
         JOptionPane.WARNING_MESSAGE, null); // displays user hit null throught JOptionPane window
         System.exit(0); // exits the system
         work = false; // sets boolean value to false
      }
      if (input .equals("exit")) { // when user enter "exit"
         System.exit(0); // exits the system
         work = false; // sets boolean value to false
      }   
      int len = input.length(); // getting a length of input string and decalring and storing it in int variable len
      if (len >51){ // if statement to check the total length of the string
       work = false; //sets boolean value to false
       JOptionPane.showMessageDialog(null, "Too many strings");  // JOptionPane window shows too many strings
      }  
      String cutSpace = ""; //declaring string varibale cutSpace
      String getInput = " ";//declaring string variable getInput
      getInput = input.substring( 0, len); // storing input value in getInput
      // for loop to remove all the spaces
      for (int i =0; i <len; i ++) { // loops until the value of len
         String store = input.substring(i,i+1); //stores each string in variable store
         if (store .equals(" ")) { //checks if the string is space
            getInput = getInput.substring(0, i) + getInput.substring( i+1, len);//removes the space and adds the string together without space  
            len = len-1; //decreases the value of len as one space is removed
            i=i-1;// decreases the value of i as one space is removed and again have to check the string right after it
           
         }  
         cutSpace= getInput; //stores the input without the space in cutSpace

      }   
      double total = 0; // this is just check variable declared as double total
      int len1 = cutSpace.length(); // length of string after space was removed is stored in varibale integer len1
      if (work == true) { //when work is true
         for (int i=0; i <len1; i++) { // loops until the length of strings of cutSpace
            if ( work == true) { // when work is true
               
               String var = cutSpace.substring(i,i+1); // takes each string and stores it in String variable called var
               if (var .equals("0") || var .equals("1") ||  var .equals("2") ||  var .equals("3") ||  var .equals("4") ||  var .equals("5") ||  var .equals("6")||  var .equals("7")||  var .equals("8")||  var .equals("9")){// evaluates to check if the string is a number from 0-9
                  double num = Integer.parseInt(var); //when true, converts the string to double
                  number[i] = num;// stores the number in array number[i]
                  myStack.push(number[i]);  //pushes the number up in the stack
               }
               else if (var .equals("+")) { // when value is equal to +
                  double a = myStack.pop(); //pops of the value from stack
                  if ( a == ERROR_VALUE) { // if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;
                  }
                  double b = myStack.pop();//pops of the value from stack
                  if ( b == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false; // works is set to false
                  }

                  double newTotal = a + b; // adds the numbers
                  myStack.push(newTotal);//pushes the result newTotal up in the stack
                  total = newTotal; // setting up the total value to the result
                  System.out.println(newTotal);// check if right value was passed
               }  
               else if (var.equals("-")) { // when value is equal to +
                  double a = myStack.pop();//pops of the value from stack
                  if ( a == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }
                  double b = myStack.pop();//pops of the value from stack
                  if ( b == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }

                  double newTotal = b-a;//subtracts the number
                  myStack.push(newTotal);
                  total = newTotal;// setting up the total value to the result
                  System.out.println(newTotal);// check if right value was passed
                  
               }
               else if (var.equals("*")) { // when value is equal to +
                  double a = myStack.pop();//pops of the value from stack
                  if ( a == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }
                  double b = myStack.pop();//pops of the value from stack
                  if ( b == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }

                  double newTotal = a * b;//multiplies the number
                  myStack.push(newTotal);//pushes the result newTotal up in the stack
                  total = newTotal;// setting up the total value to the result
                  System.out.println(newTotal);// check if right value was passed
               }
               else if (var.equals("/")) {// when value is equal to +
                  double a = myStack.pop();//pops of the value from stack
                  if ( a == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }
                  double b = myStack.pop();//pops of the value from stack
                  if ( b == ERROR_VALUE) {// if stack is empty
                     JOptionPane.showMessageDialog(null, "There is extra operator", "Error Message", JOptionPane.WARNING_MESSAGE, null); //shows in Joption pane that stack is empty or there is extra operator
                     work = false;// works is set to false
                  }

                  double newTotal = b/a;//divides the number
                  myStack.push(newTotal);//pushes the result newTotal up in the stack
                  total = newTotal;// check for total as a whole
                  System.out.println(newTotal);// check if right value was passed
               } 
               else { // when invalid string such as a, c, (, &, g and etc are found
                  JOptionPane.showMessageDialog(null, "There are invalid strings"); // prints there are invalid strings
                  work = false; // setting work value to false
               }
             } //ends if  
            
           } //ends for loop 
         } //ends if
         
         if (work == true) {// when work is true
            JOptionPane.showMessageDialog(null, "The result of the operation is " + myStack.pop() + "."); // printing the final value and emptying the myStack 
         
         } 
         if(work == false) { //while something wrong happens like invalid strings
            while ( myStack.pop() != ERROR_VALUE) { // when even something wrong happens like invalid strings, this will empty the stack 
               myStack.pop();   //pops up stack until the stack is empty by checking the ERROR_VALUE
            }
         } //ends if
          work = true; // seeting up while loop to work, as setting boolean variable work to true   
          System.out.println(myStack); // prints out the stack (to check the top value so the stack is empty when top = -1
         
                    

      }// ends while loop
   
  
  
  
  } //ends main
  
}  //ends class