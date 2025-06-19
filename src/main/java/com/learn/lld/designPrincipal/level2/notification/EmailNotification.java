package com.learn.lld.designPrincipal.level2.notification;

public class EmailNotification implements NotificationInterface {
    private String senderEmailAddress;
    private String receiverEmailAddress;

    public EmailNotification(String senderEmailAddress, String receiverEmailAddress) {
        this.receiverEmailAddress = receiverEmailAddress;
        this.senderEmailAddress = senderEmailAddress;
    }

    private String processNotification(String message) {
        return "This is dummy text of processed message" + message;
    }

    @Override
    public String sendNotification(String message) {
        String processedMessage = processNotification(message);
        // email notification sending implementation
        return "Message send successfully";
    }
}
