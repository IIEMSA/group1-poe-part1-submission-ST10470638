//st10470638 POE Assignment 
package chat_application;


public class Login // "=" used to divide code into sections
{

   public static boolean checkUserName(String username) //Start username check ==================
{
    if (username.length() <= 5 && username.contains("_")) //if loop useing and to ensure it meets both conditions
    {
        System.out.println(" ");
        System.out.println("Username successfully captured");
        System.out.println(" ");
        return true;//confirms it works 
    } 
    else 
    {
        System.out.println(" ");
        System.out.println("Username is not correctly formatted," + "\n" + "please"
                + " ensure that your username contains" + "\n" + "an underscore and is "
                + "no more than 5 characters in length");
        return false;//confirms it doesnt 
    }
}
 //End of Username Check==================================================================================
    
    
    
    public static boolean checkPasswordComplexity(String password)  //Password check start =====================
{
    boolean hasLength = false; //declares it as false so it keeps running until it meets requirements
    boolean hasCapital = false;
    boolean hasLowerCase = false;
    boolean hasNumber = false;
    boolean hasSpecialChar = false;

    if (password.length() >= 8) {
        hasLength = true;
    }

    for (int i = 0; i < password.length(); i++)  //nested loop 
    {
        char ch = password.charAt(i);

        if (Character.isUpperCase(ch)) {
            hasCapital = true;
        }
        if (Character.isLowerCase(ch)) {
            hasLowerCase = true;
        }
        if (Character.isDigit(ch)) {
            hasNumber = true;
        }
        if (!Character.isLetterOrDigit(ch)) {
            hasSpecialChar = true;
        }
    }

    if (hasLength && hasCapital && hasLowerCase && hasNumber && hasSpecialChar) 
    {
        System.out.println(" ");
        System.out.println("Password successfully captured.");
        System.out.println(" ");
        return true;
    } 
    else 
    {
        System.out.println("Password is not correctly formatted," + "\n" + "please ensure that the password "
                + "contains \nat least 8 characters,a capital letter, a number and a special character.");
        System.out.println(" ");
        return false;
    }
}
 //Password Check end  =======================================================================
    
    
    
    public static boolean checkCellPhoneNumber(String cellNum)  // cell num start ================================
{
    
    if (cellNum.contains("+") && cellNum.length() == 12) //. contains checks if it had a + and .length checks the length
    {
        System.out.println(" ");
        System.out.println("Cell phone number successfully added.");
        System.out.println(" ");
        return true;
    } 
    else 
    {
        System.out.println("Cell phone number invalid, insert correct formatting or enter international code.");
        System.out.println(" ");
        return false;
    }
}
//Cellnum check end =============================================================================================
    
    
    
    
    
    public static boolean registerUser(String username, String password)
{
    boolean validUsername = Login.checkUserName(username);
    boolean validPassword = Login.checkPasswordComplexity(password);

    if (!validUsername) //checks if it isnt formated correctly and outputs println
    {
        System.out.println(" ");
        System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and no more than five characters in length.");
        Register.Checkreg = false;
        return false;
    } 
    else if (!validPassword) 
    {
        System.out.println(" ");
        System.out.println("Password is not correctly formatted. Please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        Register.Checkreg = false;
        return false;
    } 
    else 
    {
        System.out.println(" ");
        System.out.println("Both your username and password meet requirements. You have been registered successfully!");
        Register.Checkreg = true;
        return true;
    }
}


    
    public static boolean loginUser(String loginUsername, String loginPassword) 
{
    if (loginUsername.equals(Register.username) && loginPassword.equals(Register.password)) 
    { //cross checks if the login username variable is the same as the one entered as well as the password
        System.out.println("Welcome " + Register.username + ", it is great to see you again.");
        Register.Checklogin = true;
        return true;
    } 
    else 
    {
        System.out.println("Username or password invalid, please try again.");
        Register.Checklogin = false;
        return false;
    }
}

    
    public static void returnLoginStatus()
    {
        if(Register.Checklogin == false)// if the login false prints failed login attemp
        {
            System.out.println("Failed login attempt");
        } else // if it works print successful login attempt
        {
            System.out.println("Successful login attempt");
        }
        
    } 

 
} 
