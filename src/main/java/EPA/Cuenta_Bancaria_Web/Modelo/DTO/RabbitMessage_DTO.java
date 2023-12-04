package EPA.Cuenta_Bancaria_Web.Modelo.DTO;

import org.springframework.stereotype.Component;

@Component
public class RabbitMessage_DTO {

    private String messageId;
    private String content;
    private String queueName;
    private String exchangeName;

    public RabbitMessage_DTO() {
    }

    public RabbitMessage_DTO(String messageId, String content, String queueName, String exchangeName) {
        this.messageId = messageId;
        this.content = content;
        this.queueName = queueName;
        this.exchangeName = exchangeName;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    @Override
    public String toString() {
        return "RabbitMessage_DTO{" +
                "messageId='" + messageId + '\'' +
                ", content='" + content + '\'' +
                ", queueName='" + queueName + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                '}';
    }
}
