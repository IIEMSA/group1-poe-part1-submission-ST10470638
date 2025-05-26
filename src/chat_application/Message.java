package chat_application;

public class Message {
    private String messageId;
    private String recipientCell;
    private String content;
    private int index;

    public Message(String messageId, String recipientCell, String content, int index) {
        this.messageId = messageId;
        this.recipientCell = recipientCell;
        this.content = content;
        this.index = index;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getRecipientCell() {
        return recipientCell;
    }

    public String getContent() {
        return content;
    }

    public boolean checkMessageID() {
        return messageId.matches("\\d{10}");
    }

    public boolean checkRecipientCell() {
        return recipientCell.matches("^\\+27\\d{9}$");
    }

    public String createMessageHash() {
        String idPrefix = messageId.substring(0, 2);
        String[] words = content.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0].toUpperCase() : "";
        String lastWord = words.length > 1 ? words[words.length - 1].toUpperCase() : firstWord;
        return idPrefix + ":" + index + ":" + firstWord + lastWord;
    }

    public String sendMessage() {
        return "Message ID: " + messageId + "\n"
             + "Message Hash: " + createMessageHash() + "\n"
             + "To: " + recipientCell + "\n"
             + "Content: " + content + "\n"
             + "--------------------------";
    }

    public static String printMessages(Message[] messages, int count) {
        if (count == 0) return "No messages sent.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(messages[i].sendMessage()).append("\n");
        }
        return sb.toString();
    }
}
