package ApacheKafka.model;

public class NewChatModel {

    private String messageSenderName;
    private String messageRecieverName;

    public NewChatModel(String messageSenderName, String messageRecieverName) {
        this.messageSenderName = messageSenderName;
        this.messageRecieverName = messageRecieverName;
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
