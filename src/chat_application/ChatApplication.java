package chat_application;

import java.util.Scanner;

public class ChatApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to QuickChat");

        Register userRegister = new Register();

        userRegister.userName(input);
        while (!Login.checkUserName(userRegister.getUsername())) {
            System.out.println("Please enter a valid username:");
            userRegister.userName(input);
        }

        userRegister.password(input);
        while (!Login.checkPasswordComplexity(userRegister.getPassword())) {
            System.out.println("Please enter a valid password:");
            userRegister.password(input);
        }

        userRegister.cellPhoneNum(input);
        while (!Login.checkCellPhoneNumber(userRegister.getCellNum())) {
            System.out.println("Please enter a valid cell phone number:");
            userRegister.cellPhoneNum(input);
        }

        if (!Login.registerUser(userRegister.getUsername(), userRegister.getPassword())) {
            System.out.println("Registration failed. Exiting program.");
            input.close();
            return;
        }

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Please enter your username:");
            String loginUser = input.nextLine();

            System.out.println("Please enter your password:");
            String loginPass = input.nextLine();

            loggedIn = Login.loginUser(loginUser, loginPass);
        }
        Login.returnLoginStatus();

        Message[] messages = new Message[100];
        int messageCount = 0;

        while (true) {
            System.out.println("\nChoose an option:\n1) Send Message\n2) Show recently sent messages\n3) Quit");
            String choice = input.nextLine();

            if ("1".equals(choice)) {
                int maxToSend = 0;
                while (true) {
                    System.out.println("How many messages do you wish to send?");
                    try {
                        maxToSend = Integer.parseInt(input.nextLine());
                        if (maxToSend > 0) break;
                        else System.out.println("Please enter a positive number.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }

                for (int i = 0; i < maxToSend; i++) {
                    if (messageCount >= messages.length) {
                        System.out.println("Cannot add message. Limit reached.");
                        break;
                    }

                    System.out.println("\nEnter message #" + (messageCount + 1));
                    String msgID = generateRandomMessageID();
                    System.out.println("Generated Message ID: " + msgID);

                    String recipient;
                    while (true) {
                        System.out.println("Enter recipient cell number (Format: +27662673485):");
                        recipient = input.nextLine();
                        Message temp = new Message("0000000000", recipient, "temp", 0);
                        if (temp.checkRecipientCell()) break;
                        else System.out.println("Invalid recipient number format.");
                    }

                    String content;
                    while (true) {
                        System.out.println("Enter your message (max 250 characters):");
                        content = input.nextLine();
                        if (content.length() <= 250) break;
                        else System.out.println("Please enter a message of less than 250 characters.");
                    }

                    Message newMessage = new Message(msgID, recipient, content, messageCount);

                    if (!newMessage.checkMessageID()) {
                        System.out.println("Invalid Message ID.");
                        continue;
                    }

                    System.out.println("Choose an option:\n1) Send Message\n2) Store Message\n3) Disregard Message");
                    String action = input.nextLine();

                    if ("1".equals(action)) {
                        messages[messageCount++] = newMessage;
                        System.out.println("Message sent.");
                        System.out.println(newMessage.sendMessage());
                    } else if ("2".equals(action)) {
                        messages[messageCount++] = newMessage;
                        System.out.println("Message stored for later.");
                    } else {
                        System.out.println("Message disregarded.");
                    }
                }

            } else if ("2".equals(choice)) {
                System.out.println("\n--- Recently Sent Messages ---");
                System.out.println(Message.printMessages(messages, messageCount));

            } else if ("3".equals(choice)) {
                System.out.println("Total number of messages sent: " + messageCount);
                System.out.println("Exiting. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }

        input.close();
    }

    private static String generateRandomMessageID() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }
}
