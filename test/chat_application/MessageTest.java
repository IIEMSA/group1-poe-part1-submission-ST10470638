package chat_application;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    
    public MessageTest() {
    }

    private String validateMessageLength(String message) {
        int maxLength = 250;
        int length = message.length();
        if (length <= maxLength) {
            return "Message ready to send.";
        } else {
            int excess = length - maxLength;
            return "Message exceeds 250 characters by " + excess + ", please reduce size.";
        }
    }

    @Test
    public void testMessageLengthSuccess() {
        String message = "This is a valid message with less than 250 characters.";
        String expected = "Message ready to send.";
        String actual = validateMessageLength(message);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageLengthFailure() {
        StringBuilder longMessage = new StringBuilder();
        for (int i = 0; i < 260; i++) {
            longMessage.append("a");
        }
        String expected = "Message exceeds 250 characters by 10, please reduce size.";
        String actual = validateMessageLength(longMessage.toString());
        assertEquals(expected, actual);
    }

    private String validateRecipientNumber(String number) {
        if (number.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does\n"
                 + "not contain an international code. Please correct\n"
                 + "the number and try again.";
        }
    }

    @Test
    public void testRecipientNumberSuccess() {
        String validNumber = "+27718693002";
        String expected = "Cell phone number successfully captured.";
        String actual = validateRecipientNumber(validNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testRecipientNumberFailure() {
        String invalidNumber = "08575975889";
        String expected = "Cell phone number is incorrectly formatted or does\n"
                        + "not contain an international code. Please correct\n"
                        + "the number and try again.";
        String actual = validateRecipientNumber(invalidNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageHashCorrectness() {
        String messageId = "0012345678";
        String recipient = "+27718693002";
        String content = "Hi Tonight";
        int index = 0;

        Message msg = new Message(messageId, recipient, content, index);

        String expectedHash = "00:0:HITONIGHT";
        String actualHash = msg.createMessageHash();

        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testMessageIDGenerationFormat() {
        String generatedID = generateRandomMessageID();
        assertNotNull(generatedID);
        assertEquals(10, generatedID.length());
        assertTrue(generatedID.matches("\\d{10}"));
    }

    @Test
    public void testMessageSentResponses() {
        assertEquals("Message successfully sent.", getResponseMessage("Send Message"));
        assertEquals("Press 0 to delete message.", getResponseMessage("Disregard Message"));
        assertEquals("Message successfully stored.", getResponseMessage("Store Message"));
    }

    private String generateRandomMessageID() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }

    private String getResponseMessage(String userSelection) {
        switch (userSelection) {
            case "Send Message":
                return "Message successfully sent.";
            case "Disregard Message":
                return "Press 0 to delete message.";
            case "Store Message":
                return "Message successfully stored.";
            default:
                return "Invalid selection.";
        }
    }
}
