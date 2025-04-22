//st10470638 POE Assignment 

package chat_application;

import java.util.Scanner;

public class Register
{
    public static String username;
    public static String password;
    public static String cellNum;
    
    public static boolean Checkreg;
    public static boolean Checklogin;

    public void userName()
    {
        Scanner input = new Scanner(System.in);// declares input as a scanner variable
        
        System.out.println("REGISTRATION:");
        System.out.println("Enter a username" + "\n" + "Note: Username must contain an underscore"
                        + " and must be no more than 5 characters");
        
        username = input.nextLine(); //inputs the user input into the variable username
    }
    
    public void password()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a password\nNote:\n" +
                "Password must contain a capital letter\n" +
                "Password must contain a number\n" +
                "Password must contain a special character\n" +
                "Password must be at least 8 characters long");
        
        password = input.nextLine(); //inputs the user input into the variable password
    }
    
    public void cellPhoneNum()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter cellphone number with international country code");
        System.out.println("Format: +27662673485");
        
        cellNum = input.nextLine();//inputs the user input into the variable cellNum
    }
    
    public static void main(String[] args)
    {
        Register user1 = new Register();//creas user1 variable
        Scanner input = new Scanner(System.in);
        
        // Username input and validation
        user1.userName();
        while (!Login.checkUserName(username))
        {
            System.out.println("Please enter a valid username:");
            username = input.nextLine();
        }
        
        // Password input and validation
        user1.password();
        while (!Login.checkPasswordComplexity(password)) 
        {
            System.out.println("Please enter a valid password:");
            password = input.nextLine();
        }
        
        // Cellphone number input and validation
        user1.cellPhoneNum();
        while (!Login.checkCellPhoneNumber(cellNum)) 
        {
            System.out.println("Please enter a valid cell phone number:");
            cellNum = input.nextLine();
        }
        
        // Now register the user using parameters
        if (Login.registerUser(username, password)) 
        {
            // If registration successful, ask user to login
            boolean loginSuccess = false;
            while (!loginSuccess)
            {
                System.out.println("Please enter your username:");
                String loginUsername = input.nextLine();
                
                System.out.println("Please enter your password:");
                String loginPassword = input.nextLine();
                
                loginSuccess = Login.loginUser(loginUsername, loginPassword);
            }
            
            Login.returnLoginStatus();
        }
        else
        {
            System.out.println("Registration failed. Please restart the program.");
        }
    }
}
