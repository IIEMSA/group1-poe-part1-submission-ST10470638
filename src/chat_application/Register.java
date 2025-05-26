package chat_application;

import java.util.Scanner;

public class Register
{
    public static String username;
    public static String password; 
    public static boolean Checkreg; 
    public static boolean Checklogin; 
    private String cellNum;

    public void userName(Scanner input)
    {
        System.out.println("REGISTRATION:");
        System.out.println("Enter a username" + "\n" + "Note: Username must contain an underscore"
                        + " and must be no more than 5 characters");
        
        username = input.nextLine(); //inputs the user input into the variable username
    }
    
    public void password(Scanner input)
    {
        System.out.println("Enter a password\nNote:\n" +
                "Password must contain a capital letter\n" +
                "Password must contain a number\n" +
                "Password must contain a special character\n" +
                "Password must be at least 8 characters long");
        
        password = input.nextLine(); //inputs the user input into the variable password
    }
    
    public void cellPhoneNum(Scanner input)
    {
        System.out.println("Enter cellphone number with international country code");
        System.out.println("Format: +27662673485");
        
        cellNum = input.nextLine();//inputs the user input into the variable cellNum
    }
    
    // Getters for username, password, cellNum
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getCellNum() {
        return cellNum;
    }
}
