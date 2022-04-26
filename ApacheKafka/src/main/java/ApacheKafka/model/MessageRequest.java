package ApacheKafka.model;

public class MessageRequest {
    private String message;
    private String messageSenderName;
    private String messageRecieverName;

    public MessageRequest() {
    }

    public MessageRequest(String message, String messageSenderName, String messageRecieverName) {
        this.message = message;
        this.messageSenderName = messageSenderName;
        this.messageRecieverName = messageRecieverName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageSenderName() {
        return messageSenderName;
    }

    public void setMessageSenderName(String messageSenderName) {
        this.messageSenderName = messageSenderName;
    }

    public String getMessageRecieverName() {
        return messageRecieverName;
    }

    public void setMessageRecieverName(String messageRecieverName) {
        this.messageRecieverName = messageRecieverName;
    }
}
