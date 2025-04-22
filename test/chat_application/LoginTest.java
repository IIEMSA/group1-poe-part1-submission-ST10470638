

package chat_application;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kiran
 */
public class LoginTest {
    
    public LoginTest() {
    }

     @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        boolean expResult = true;
        boolean result = Login.checkUserName(username);
        assertEquals(expResult, result);
      
      
    }
    @Test
    public void test2CheckUserName() {
        System.out.println("checkUserName");
        String username = "kyle!!!!!!!!!";
        boolean expResult = false;
        boolean result = Login.checkUserName(username);
        assertEquals(expResult, result);
      
      
    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = Login.checkPasswordComplexity(password);
        assertEquals(expResult, result);

       
    }
        @Test
    public void test2CheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        boolean expResult = false;
        boolean result = Login.checkPasswordComplexity(password);
        assertEquals(expResult, result);

       
    }

    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNum = "+27838968976";
        boolean expResult = true;
        boolean result = Login.checkCellPhoneNumber(cellNum);
        assertEquals(expResult, result);
       
      
    }
    @Test
    public void test2CheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNum = "08966553";
        boolean expResult = false;
        boolean result = Login.checkCellPhoneNumber(cellNum);
        assertEquals(expResult, result);
       
      
    }
        
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String loginUsername = "kyl_1";
        String loginPassword = "Ch&&sec@ke99!";
        
        Register.username = "kyl_1";
        Register.password = "Ch&&sec@ke99!";
        
        boolean result = Login.loginUser(loginUsername, loginPassword);
        assertTrue(result);
      
    }
        @Test
    public void test2LoginUser() {
        System.out.println("loginUser");
        String loginUsername = "kyle!!!!!!!";
        String loginPassword = "Kiran";
        boolean result = Login.loginUser(loginUsername, loginPassword);
        assertFalse(result);
      
    }
        @Test
    public void test3CheckUserName() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        boolean result = Login.checkUserName(username);
        assertTrue(result);
      
      
    }
     @Test
    public void test4CheckUserName() {
        System.out.println("checkUserName");
        String username = "kyl!!!!!!!!!";
        boolean result = Login.checkUserName(username);
        assertFalse(result);
      
      
    }
         @Test
    public void test3CheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        boolean result = Login.checkPasswordComplexity(password);
        assertTrue(result);

       
    }   
    
            @Test
    public void test4CheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        boolean result = Login.checkPasswordComplexity(password);
        assertFalse(result);

       
    }
      @Test
    public void test3CheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNum = "+27838968976";
        boolean result = Login.checkCellPhoneNumber(cellNum);
        assertTrue(result);
       
      
    }
    @Test
    public void test4CheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String cellNum = "08966553";
        boolean result = Login.checkCellPhoneNumber(cellNum);
        assertFalse(result);
       
      
    }  
    
}
